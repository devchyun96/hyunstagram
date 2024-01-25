package insta.hyunstagram.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "likes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long user;

    @Column(name = "feed_id")
    private Long feed;

}
