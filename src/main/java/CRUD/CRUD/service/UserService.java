package CRUD.CRUD.service;

import CRUD.CRUD.model.User;
import CRUD.CRUD.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }
}
