package insta.hyunstagram.repository.feed;

import insta.hyunstagram.domain.Feed;

import java.util.List;

public interface FeedCustomRepository {
    List<Feed> findAllFeed();  // 모든 1000개의 피드 찾기

    List<Feed> findByUser(Long id);
}
