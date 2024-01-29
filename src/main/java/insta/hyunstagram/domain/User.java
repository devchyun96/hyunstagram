package insta.hyunstagram.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString(callSuper = true)                // 화면에 상속받은 createdDate를 보이기 위함
@EqualsAndHashCode(callSuper = true)        // 이하 동문
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "username",unique = true,length = 50)
    private String username;

    @Column(nullable = false,name = "nickname",unique = true,length = 50)
    private String nickname;

    @Column(nullable = false,name = "password",length = 200)
    private String password;

    @Column(length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

//    @OneToMany(mappedBy = "user")
//    @ToString.Exclude
//    private List<Like> likes;

    public void userUpdate(String nickname, String password) {
        this.nickname=nickname;
        this.password=password;
    }

}
