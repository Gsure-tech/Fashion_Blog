package abdul.com.dto;

import abdul.com.enums.Gender;
import abdul.com.enums.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
    private UserType userType;
}
