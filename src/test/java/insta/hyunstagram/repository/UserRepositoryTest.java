package insta.hyunstagram.repository;

import insta.hyunstagram.domain.Role;
import insta.hyunstagram.domain.User;
import insta.hyunstagram.repository.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void clean() {
        userRepository.deleteAll();
    }

    @Test
    @Transactional
    void saveTest() throws Exception {
         //given
        String username="hyun96";
        String password="1234";
        String nickname="강현";
        String email="devchyun96@naver.com";

        userRepository.save(User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .role(Role.USER)
                .build());

        //when
        List<User> list = userRepository.findAll();
        User user=list.get(0);
        System.out.println(user.getCreatedDate());

        //then
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getNickname()).isEqualTo(nickname);
        assertThat(user.getEmail()).isEqualTo(email);
    }
}
