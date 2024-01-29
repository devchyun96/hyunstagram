package insta.hyunstagram.dto.userdto;

import insta.hyunstagram.domain.Gender;
import insta.hyunstagram.domain.Role;
import insta.hyunstagram.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String email;
    private Gender gender;
    private Role role;

    public UserResponseDto(User entity){
        this.id= entity.getId();
        this.username=entity.getUsername();
        this.nickname=entity.getNickname();
        this.password=entity.getPassword();
        this.email=entity.getEmail();
        this.gender=entity.getGender();
        this.role=entity.getRole();
    }
}
