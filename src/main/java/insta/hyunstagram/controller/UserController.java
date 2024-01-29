package insta.hyunstagram.controller;

import insta.hyunstagram.domain.User;

import insta.hyunstagram.dto.userdto.UserRequestDto;
import insta.hyunstagram.dto.userdto.UserResponseDto;
import insta.hyunstagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/api/save")
    public ResponseEntity<UserRequestDto> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/list")
    public ResponseEntity<List<UserResponseDto>> list(){
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        return new ResponseEntity<>(userService.findOne(id),HttpStatus.OK);
    }

    @PutMapping("/api")
    public ResponseEntity<?> update(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user),HttpStatus.OK);
    }

    @DeleteMapping("/api/{id}")
    public void delete(@PathVariable Long id){
       userService.delete(id);
    }
}
