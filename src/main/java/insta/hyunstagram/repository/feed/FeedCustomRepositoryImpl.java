package insta.hyunstagram.repository.feed;

import com.querydsl.jpa.impl.JPAQueryFactory;
import insta.hyunstagram.domain.Feed;
import insta.hyunstagram.domain.QFeed;
import insta.hyunstagram.domain.QUser;
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
        QFeed feed=QFeed.feed;
        QUser user=QUser.user;
        return queryFactory.selectFrom(feed)
                .where(feed.user.id.eq(id))
                .leftJoin(feed.user, user)
                .fetchJoin()
                .orderBy(feed.id.desc())
                .fetch();
    }

}
