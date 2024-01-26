package insta.hyunstagram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedResponseDto {
    private Long id;
    private String title;
    private String content;
//    private List<Comment> comments;
    private Long userId;
    private long likeCount;

}
