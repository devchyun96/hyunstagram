package insta.hyunstagram.service;

import insta.hyunstagram.domain.Feed;
import insta.hyunstagram.domain.User;
import insta.hyunstagram.dto.feeddto.FeedRequestDto;
import insta.hyunstagram.dto.feeddto.FeedResponseDto;
import insta.hyunstagram.repository.feed.FeedRepository;
import insta.hyunstagram.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    public FeedRequestDto saveFeed(FeedRequestDto feed) {
        User user = userRepository.findById(feed.getUserId()).orElseThrow(null);
        Feed save = Feed.builder()
                .content(feed.getContent())
                .title(feed.getTitle())
                .user(user)
                .build();
        save = feedRepository.save(save);
        FeedRequestDto dto = FeedRequestDto.builder()
                .title(save.getTitle())
                .content(save.getContent())
                .userId(save.getUser().getId())
                .build();
        return dto;
    }

    @Transactional(readOnly = true)
    public FeedResponseDto detailFeed(Long id) {
        Feed feed = feedRepository.findById(id).orElse(null);
        FeedResponseDto detail=FeedResponseDto.builder()
                .id(feed.getId())
                .title(feed.getTitle())
                .content(feed.getContent())
                .userId(feed.getUser().getId())
                .build();
        return detail;
    }

    @Transactional(readOnly = true)
    public List<FeedResponseDto> find1000() {
        return feedRepository.findAllFeed()
                .stream()
                .map(FeedResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Feed updateFeed(Feed feed) {
        Feed entity = feedRepository.findById(feed.getId()).orElseThrow(null);
        entity.feedUpdate(feed.getTitle(), feed.getContent());
        return entity;
    }

    public void deleteFeed(Long id) {
        feedRepository.deleteById(id);
    }

}
