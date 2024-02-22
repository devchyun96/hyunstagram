package insta.hyunstagram.dto.feeddto;


import insta.hyunstagram.domain.Feed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedRequestDto {
    private String title;
    private String content;
    private Long userId;
}
