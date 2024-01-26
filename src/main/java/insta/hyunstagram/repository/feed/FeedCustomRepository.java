package insta.hyunstagram.repository.feed;

import insta.hyunstagram.domain.Feed;

import java.util.List;

public interface FeedCustomRepository {
    List<Feed> findAllFeed();

    List<Feed> findByUser(Long id);
}
