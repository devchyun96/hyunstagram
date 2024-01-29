package insta.hyunstagram.service;

import insta.hyunstagram.domain.User;
import insta.hyunstagram.dto.userdto.UserRequestDto;
import insta.hyunstagram.dto.userdto.UserResponseDto;
import insta.hyunstagram.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserRequestDto save(User user){
        User save = userRepository.save(user);
        UserRequestDto dto=UserRequestDto
                .builder()
                .username(save.getUsername())
                .nickname(save.getNickname())
                .password(save.getPassword())
                .email(save.getEmail())
                .gender(save.getGender())
                .role(save.getRole())
                .build();
        return dto;
    }

    @Transactional(readOnly = true)
    public User findOne(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 유저가 없습니다."));
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

//    @Transactional(readOnly = true)
//    public List<User> findLikeUsernameOrNickname(String query){
//        return userRepository.findByUsernameLikeOrNicknameLike(query);
//    }

    @Transactional
    public User update(User user){
        User entity = userRepository.findById(user.getId()).orElse(null);
        entity.userUpdate(user.getNickname(), user.getPassword());

        return entity;
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }


}
