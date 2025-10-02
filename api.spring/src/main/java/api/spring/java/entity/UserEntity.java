package api.spring.java.entity;
import api.spring.java.user.UserDataRecord;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user") // Specifies the table name in the database
@Getter // Generates getter methods for all fields
@Setter // Generates setter methods for all fields
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all arguments
@EqualsAndHashCode(of = "id")
@ToString // Generates a toString method for easy debugging and logging
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

    public UserEntity(UserDataRecord userData) {
        firstName = userData.firstName();
        lastName = userData.lastName();
        email = userData.email();
        age = userData.age();
    }
}