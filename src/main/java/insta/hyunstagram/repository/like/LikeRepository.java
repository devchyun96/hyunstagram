package insta.hyunstagram.repository.like;

import insta.hyunstagram.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
    int countAllByFeed(Long id);
//    int deleteByUser(Long id);
//    Like findByUser(Long id);
}
