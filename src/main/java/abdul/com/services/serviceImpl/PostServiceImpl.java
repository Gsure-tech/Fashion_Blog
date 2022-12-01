package abdul.com.services.serviceImpl;

import abdul.com.dto.PostDto;
import abdul.com.dto.UserDto;
import abdul.com.enums.UserType;
import abdul.com.exceptions.ResourceNotFoundException;
import abdul.com.exceptions.UserExistException;
import abdul.com.model.Post;
import abdul.com.model.User;
import abdul.com.repositories.PostRepository;
import abdul.com.repositories.UserRepository;
import abdul.com.services.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
 @AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final HttpSession httpSession;
    @Override
    public Post makePost(PostDto postDto) {
        User loggedInUser = userRepository.findById((long)httpSession.getAttribute("loginUser"))
                .orElseThrow(()-> new UserExistException("Contact the admin"));
       // User user1 = new User();
        System.out.println(loggedInUser);
       // User user = userRepository.findUsersByUserType(user1.getUserType()).orElseThrow();
        if(loggedInUser.getUserType().equals(UserType.ADMIN)) {
            Post post = new Post();
            BeanUtils.copyProperties(postDto, post);
            return postRepository.save(post);
        }
        else throw  new ResourceNotFoundException("Contact the Admin");
    }
}
