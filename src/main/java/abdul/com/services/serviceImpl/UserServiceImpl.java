package abdul.com.services.serviceImpl;

import abdul.com.dto.UserDto;
import abdul.com.dto.UserResponseDto;
import abdul.com.enums.UserType;
import abdul.com.exceptions.ResourceNotFoundException;
import abdul.com.exceptions.UserExistException;
import abdul.com.model.Post;
import abdul.com.model.User;
import abdul.com.repositories.PostRepository;
import abdul.com.repositories.UserRepository;
import abdul.com.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final HttpSession httpSession;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public User signup(UserDto userDto) {
        User user = new User();
        boolean existByEmail = userRepository.findUsersByEmail(userDto.getEmail()).isPresent();
        if(existByEmail){
            throw  new UserExistException("The user with "+ userDto.getEmail() + "already exist, use another email");
        }
        BeanUtils.copyProperties(userDto,user);
        return userRepository.save(user);
    }

    @Override
    public UserResponseDto login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email,password)
                .orElseThrow(()-> new UserExistException("Incorrect credentials"));

        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user,userResponseDto);
        httpSession.setAttribute("loginUser", user.getUserId());
        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> viewUsers() {
        User loggedInUser = userRepository.findById((long)httpSession.getAttribute("loginUser"))
                .orElseThrow(()-> new UserExistException("Contact the admin"));
        // User user1 = new User();
        System.out.println(loggedInUser);
        // User user = userRepository.findUsersByUserType(user1.getUserType()).orElseThrow();
        if(loggedInUser.getUserType().equals(UserType.ADMIN)) {
           List <User> users = userRepository.findAll();
           List <UserResponseDto> userResponseDtoList = new ArrayList<>();
           for(User user: users){
               UserResponseDto userResponseDto = new UserResponseDto();
               BeanUtils.copyProperties(user,userResponseDto);
               userResponseDtoList.add(userResponseDto);
           }
           return userResponseDtoList;
        }
       throw new ResourceNotFoundException("Contact the admin");
    }


//    List<User> user = userService.viewUsers();
//    List<UserResponseDto> userResponseDto = new ArrayList<>();
//        for(User users : user){
//        UserResponseDto userResponseDto1 = new UserResponseDto();
//        BeanUtils.copyProperties(users,userResponseDto1);
//        userResponseDto.add(userResponseDto1);

    @Override
    public String logout() {
        httpSession.invalidate();
        return "logout success";
    }
}
