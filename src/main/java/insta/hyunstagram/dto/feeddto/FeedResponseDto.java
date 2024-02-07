package insta.hyunstagram.dto.feeddto;

import insta.hyunstagram.domain.Feed;
import insta.hyunstagram.dto.userdto.UserResponseDto;
import lombok.*;

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

    public FeedResponseDto(Feed entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.userId=entity.getUser().getId();
    }

}
