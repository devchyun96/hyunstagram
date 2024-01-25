package insta.hyunstagram.repository.feed;

import com.querydsl.jpa.impl.JPAQueryFactory;
import insta.hyunstagram.domain.Feed;
import insta.hyunstagram.domain.QFeed;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FeedCustomRepositoryImpl implements FeedCustomRepository{

    // 피드에 필요한 정보
    /*
      username, photo, following, follower, feed, comment, like, profilePhoto
     */

    private final JPAQueryFactory queryFactory;

    public List<Feed> findAllFeed(){
        return queryFactory.selectFrom(QFeed.feed)
                .innerJoin(QFeed.feed.user)
//                .innerJoin(QFeed.feed.comment)
                .fetchJoin().fetch();
    }

}
