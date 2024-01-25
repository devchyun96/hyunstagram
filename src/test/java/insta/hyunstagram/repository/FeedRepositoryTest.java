package insta.hyunstagram.repository;

import insta.hyunstagram.domain.*;
import insta.hyunstagram.repository.feed.FeedRepository;
import insta.hyunstagram.repository.like.LikeRepository;
import insta.hyunstagram.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class FeedRepositoryTest {

    @Autowired
    FeedRepository feedRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LikeRepository likeRepository;

    @Test
    @Transactional
    void 게시글수정() {
        User user1 = User.builder()
                .username("user1")
                .nickname("회원1")
                .email("user1@mail.com")
                .password("1234")
                .role(Role.USER)
                .gender(Gender.MALE)
                .build();

        User save = userRepository.save(user1);

        Feed feed1 = Feed.builder()
                .user(save)
                .title("이게 인스타다")
                .content("이게 내용이다")
                .build();

        Feed feed2 = Feed.builder()
                .user(save)
                .title("나는 돼지")
                .content("꿈을 꾸는 돼지")
                .build();

        Feed feed3 = Feed.builder()
                .user(save)
                .title("나는 바보")
                .content("꿈을 꾸는 바보")
                .build();

        feed1 = feedRepository.save(feed1);
        feed2 = feedRepository.save(feed2);
        feed3 = feedRepository.save(feed3);

        feed1.feedUpdate("나는 문어","꿈을 꾸는 문어");
        Feed feed = feedRepository.findById(feed1.getId()).orElseThrow(null);

        System.out.println(feed);
        assertThat(feed.getTitle()).isEqualTo("나는 문어");
        assertThat(feed.getContent()).isEqualTo("꿈을 꾸는 문어");

    }

}