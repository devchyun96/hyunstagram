package insta.hyunstagram.repository.user;

import insta.hyunstagram.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUsernameLikeOrNicknameLike(String query);

}
