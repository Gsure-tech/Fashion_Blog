package abdul.com.services;

import abdul.com.dto.UserDto;
import abdul.com.dto.UserResponseDto;
import abdul.com.model.Post;
import abdul.com.model.User;
import java.util.List;


public interface UserService {
User signup(UserDto userDto);
UserResponseDto login(String email, String password);
List<User> viewUsers();

String logout();
}
