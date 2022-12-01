package abdul.com.dto;

import abdul.com.enums.Gender;
import abdul.com.enums.UserType;
import lombok.Data;

@Data
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private UserType userType;
}
