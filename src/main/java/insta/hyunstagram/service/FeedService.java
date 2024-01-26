package insta.hyunstagram.service;

import insta.hyunstagram.domain.Feed;
import insta.hyunstagram.repository.feed.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedRepository feedRepository;

    public Feed saveFeed(Feed feed){
        return feedRepository.save(feed);
    }

    @Transactional(readOnly = true)
    public Feed detailFeed(Long id){
        return feedRepository.findById(id)
                .orElseThrow(null);
    }

    @Transactional(readOnly = true)
    public List<Feed> find1000() {
        return feedRepository.findAllFeed();
    }

    @Transactional
    public Feed updateFeed(Feed feed){
        Feed entity = feedRepository.findById(feed.getId()).orElseThrow(null);
        entity.feedUpdate(feed.getTitle(), feed.getContent());
        return entity;
    }

    public void deleteFeed(Long id){
        feedRepository.deleteById(id);
    }

}
