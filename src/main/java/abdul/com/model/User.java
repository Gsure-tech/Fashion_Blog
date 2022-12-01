package abdul.com.model;

import abdul.com.enums.Gender;
import abdul.com.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String firstName;
    @Column(nullable = false, length = 30)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private UserType userType;


}
