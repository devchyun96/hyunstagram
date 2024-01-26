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
        users: username, profilePhoto
        feed: photo, feed
        follow:  following, follower
        like: like
        comment: List<comment> comment(id,userid,content)
     */

    private final JPAQueryFactory queryFactory;

    public List<Feed> findAllFeed(){
        return queryFactory.selectFrom(QFeed.feed)
                .limit(1000)
                .orderBy(QFeed.feed.id.desc())
                .fetch()
                ;
    }
    public List<Feed> findByUser(Long id){
        QFeed feed=new QFeed(QFeed.feed);
        return queryFactory.selectFrom(feed)
                .where(feed.user.id.eq(id))
                .orderBy(feed.id.desc())
                .fetch();
    }

}
