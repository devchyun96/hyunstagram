package insta.hyunstagram.repository;

import insta.hyunstagram.domain.Feed;
import insta.hyunstagram.domain.Like;
import insta.hyunstagram.domain.Role;
import insta.hyunstagram.domain.User;
import insta.hyunstagram.repository.feed.FeedRepository;
import insta.hyunstagram.repository.like.LikeRepository;
import insta.hyunstagram.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class LikeRepositoryTest {

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FeedRepository feedRepository;


    @Test
    @Transactional
    void 카운팅테스트() throws Exception {
        User user1 = User.builder()
                .username("user1")
                .nickname("회원1")
                .email("user1@mail.com")
                .password("1234")
                .role(Role.USER)
                .build();

        User user2 = User.builder()
                .username("user2")
                .nickname("회원2")
                .email("user2@mail.com")
                .password("1234")
                .role(Role.USER)
                .build();

        User user3 = User.builder()
                .username("user3")
                .nickname("회원3")
                .email("user3@mail.com")
                .password("1234")
                .role(Role.USER)
                .build();
        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
        user3 = userRepository.save(user3);

        Feed feed1 = Feed.builder()
                .user(user1)
                .title("나는문어")
                .content("꿈을꾸는문어")
                .build();

        Feed feed2 = Feed.builder()
                .user(user2)
                .title("나는 돼지")
                .content("꿈을 꾸는 돼지")
                .build();

        Feed feed3 = Feed.builder()
                .user(user3)
                .title("나는 바보")
                .content("꿈을 꾸는 바보")
                .build();

        feed1 = feedRepository.save(feed1);
        feed2 = feedRepository.save(feed2);
        feed3 = feedRepository.save(feed3);

        Like like1 = Like.builder()
                .user(user1.getId())
                .feed(feed1.getId())
                .build();

        Like like2 = Like.builder()
                .user(user2.getId())
                .feed(feed1.getId())
                .build();
        Like like3 = Like.builder()
                .user(user3.getId())
                .feed(feed1.getId())
                .build();
        Like like4 = Like.builder()
                .user(user1.getId())
                .feed(feed2.getId())
                .build();

        Like like5 = Like.builder()
                .user(user2.getId())
                .feed(feed2.getId())
                .build();
        Like like6 = Like.builder()
                .user(user3.getId())
                .feed(feed3.getId())
                .build();

        likeRepository.save(like1);
        likeRepository.save(like2);
        likeRepository.save(like3);
        likeRepository.save(like4);
        likeRepository.save(like5);
        likeRepository.save(like6);

        int count1 = likeRepository.countAllByFeed(feed1.getId());
        int count2 = likeRepository.countAllByFeed(feed2.getId());
        int count3 = likeRepository.countAllByFeed(feed3.getId());

        feedRepository.findByUser(user2.getId()).forEach(System.out::println);

        System.out.println("1번 피드의 좋아요 개수: " + count1);
        System.out.println("2번 피드의 좋아요 개수: " + count2);
        System.out.println("3번 피드의 좋아요 개수: " + count3);
        assertThat(count1).isEqualTo(3);
        assertThat(count2).isEqualTo(2);
        assertThat(count3).isEqualTo(1);
    }
}