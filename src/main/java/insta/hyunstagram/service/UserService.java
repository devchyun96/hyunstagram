package insta.hyunstagram.service;

import insta.hyunstagram.domain.User;
import insta.hyunstagram.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findOne(Long id){
        return userRepository.findById(id).orElseThrow(null);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<User> findLikeUsernameOrNickname(String query){
        return userRepository.findByUsernameLikeOrNicknameLike(query);
    }

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
