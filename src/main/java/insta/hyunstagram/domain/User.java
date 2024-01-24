package insta.hyunstagram.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 20)
    private String username;

    @Column(nullable = false,unique = true,length = 20)
    private String nickname;

    @Column(nullable = false,length = 200)
    private String password;

    @Column(nullable = false,length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;


    public void userUpdate(String nickname, String password) {
        this.nickname=nickname;
        this.password=password;
    }
    public String getRoleKey() {
        return this.role.getKey();
    }


}
