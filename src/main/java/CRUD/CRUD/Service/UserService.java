package CRUD.CRUD.Service;

import CRUD.CRUD.Configuration.JavaFaker;
import CRUD.CRUD.Exception.DataExist;
import CRUD.CRUD.Model.User;
import CRUD.CRUD.Repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
   private final UserRepository userRepository;
   private final JavaFaker javaFaker;
    public UserService(UserRepository userRepository, JavaFaker javaFaker) {
        this.userRepository = userRepository;
        this.javaFaker = javaFaker;
    }
    public List<User> inti(){

        List<User> users = new ArrayList<User>();
        Faker faker = javaFaker.getFaker();
        for(int i=0; i<10; i++){
            User user = new User();
            user.setName(faker.name().fullName());
            saveUser(user);
            users.add(user);
        }
        return users;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public User deleteUser(Long id) throws DataExist {
            Optional<User> userOptional = Optional.ofNullable(userRepository.getById(id));
            User user = userOptional.orElse(new User());
            if(userOptional.isEmpty()){
                throw new DataExist("Error in data");
            }else{
                userRepository.deleteById(user.getId());
                return user;
            }
    }

    public List<User> deleteUser() throws DataExist {
            userRepository.deleteAll();
            return userRepository.findAll() ;
        }


    public User update(Long id, String name) {
        userRepository.update(name, id);
        return userRepository.getById(id);
    }
}