package insta.hyunstagram.service;

import insta.hyunstagram.domain.Feed;
import insta.hyunstagram.domain.Like;
import insta.hyunstagram.domain.User;
import insta.hyunstagram.repository.feed.FeedRepository;
import insta.hyunstagram.repository.like.LikeRepository;
import insta.hyunstagram.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {

    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final FeedRepository feedRepository;

    public Like likeSave(Like like){
            return likeRepository.save(like);
    }

    @Transactional
    public int likeCount(Long id){
        Feed feed = feedRepository.findById(id).orElse(null);
        return likeRepository.countAllByFeed(feed.getId());
    }

//    @Transactional
//    public int deleteLike(Long id){
//        User user = userRepository.findById(id).orElseThrow(null);
//        Like like = likeRepository.findByUser(user.getId());
//        if(like!=null){
//            likeRepository.deleteByUser(id);
//            return 1;
//        }
//        else return 0;
//    }
}
