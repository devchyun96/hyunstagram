package insta.hyunstagram.controller;

import insta.hyunstagram.domain.Feed;
import insta.hyunstagram.dto.feeddto.FeedRequestDto;
import insta.hyunstagram.dto.feeddto.FeedResponseDto;
import insta.hyunstagram.service.FeedService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {
    private final FeedService feedService;

    @PostMapping("/api/save")
    public ResponseEntity<FeedRequestDto> save(@RequestBody FeedRequestDto feed){
        return new ResponseEntity<>(feedService.saveFeed(feed), HttpStatus.CREATED);
    }

    @GetMapping("/api/list")
    public ResponseEntity<List<FeedResponseDto>> findAll(){
        return new ResponseEntity<>(feedService.find1000(),HttpStatus.OK);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<FeedResponseDto> findOne(@PathVariable Long id){
        return new ResponseEntity<>(feedService.detailFeed(id),HttpStatus.OK);
    }

    @PutMapping("/api/update")
    public ResponseEntity<?> update(@RequestBody Feed feed){
        return new ResponseEntity<>(feedService.updateFeed(feed),HttpStatus.OK);
    }

    @DeleteMapping("/api/{id}")
    public void delete(@PathVariable Long id){
         feedService.deleteFeed(id);
    }
}
