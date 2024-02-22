package insta.hyunstagram.controller;

import insta.hyunstagram.domain.Follow;
import insta.hyunstagram.repository.follow.FollowRepository;
import insta.hyunstagram.service.FollowService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {
    private FollowService followService;

    @PostMapping("/api/save")
    public ResponseEntity<?> saveFollow(@RequestBody Follow follow){
        return new ResponseEntity<>(followService.saveFollow(follow),HttpStatus.CREATED);
    }

    @DeleteMapping("/api/delete")
    public void deleteFollow(@RequestBody Follow follow){
        followService.deleteFollow(follow);
    }

    @GetMapping
    public ResponseEntity<?> countFollow(@PathVariable Long id){
        return new ResponseEntity<>(followService.followCount(id),HttpStatus.OK);
    }

}
