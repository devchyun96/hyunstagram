package insta.hyunstagram.controller;

import insta.hyunstagram.domain.Like;
import insta.hyunstagram.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/like")
public class LikeController {
    private LikeService likeService;

    public ResponseEntity<?> saveLike(@RequestBody Like like) {
        return new ResponseEntity<>(likeService.likeSave(like), HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> count(@PathVariable Long id) {
        return new ResponseEntity<>(likeService.likeCount(id),HttpStatus.OK);
    }
}
