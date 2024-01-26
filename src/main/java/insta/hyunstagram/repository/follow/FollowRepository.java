package insta.hyunstagram.repository.follow;

import insta.hyunstagram.domain.Follow;
import insta.hyunstagram.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow,Long> {
    int countByFollower(User user);
}
