package abdul.com.controller;

import abdul.com.dto.UserDto;
import abdul.com.dto.UserResponseDto;
import abdul.com.model.User;
import abdul.com.repositories.UserRepository;
import abdul.com.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/users/")

public class UserController {
    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserDto userDto){
        UserResponseDto userResponseDto = new UserResponseDto();
        userService.signup(userDto);
        BeanUtils.copyProperties(userDto, userResponseDto);
        return  new ResponseEntity<>(userResponseDto , HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserDto userDto){
        UserResponseDto userDetails = userService.login(userDto.getEmail(), userDto.getPassword());
     return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        userService.logout();
        return new ResponseEntity<>("Logout successful", HttpStatus.OK);
    }

    @GetMapping("/viewUsers")
    public ResponseEntity<List<UserResponseDto>> viewUSers(){
        List<User> user = userService.viewUsers();
        List<UserResponseDto> userResponseDto = new ArrayList<>();
        for(User users : user){
            UserResponseDto userResponseDto1 = new UserResponseDto();
            BeanUtils.copyProperties(users,userResponseDto1);
            userResponseDto.add(userResponseDto1);
        }
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

}
