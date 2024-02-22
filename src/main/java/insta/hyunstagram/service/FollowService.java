package insta.hyunstagram.service;

import insta.hyunstagram.domain.Follow;
import insta.hyunstagram.domain.User;
import insta.hyunstagram.repository.follow.FollowRepository;
import insta.hyunstagram.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;
    public Follow saveFollow(Follow follow){
       return followRepository.save(follow);
    }
    public void deleteFollow(Follow follow){
        followRepository.deleteById(follow.getFollower().getId());
    }

    @Transactional
    public int followCount(Long id){
        User user = userRepository.findById(id).orElseThrow(null);
        return followRepository.countByFollower(user);
    }
}
