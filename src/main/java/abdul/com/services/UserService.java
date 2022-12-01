package abdul.com.services;

import abdul.com.dto.UserDto;
import abdul.com.dto.UserResponseDto;
import abdul.com.model.User;

public interface UserService {
User signup(UserDto userDto);
UserResponseDto login(String email, String password);
String logout();
}
