package insta.hyunstagram.repository.follow;

import insta.hyunstagram.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow,Long> {

}
