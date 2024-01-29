package insta.hyunstagram.dto.userdto;

import insta.hyunstagram.domain.Gender;
import insta.hyunstagram.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String nickname;
    private String password;
    private String email;
    private Gender gender;
    private Role role;
}
