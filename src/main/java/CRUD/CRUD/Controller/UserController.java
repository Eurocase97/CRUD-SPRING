package CRUD.CRUD.Controller;

import CRUD.CRUD.Exception.DataExist;
import CRUD.CRUD.Model.User;
import CRUD.CRUD.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(path="/user")
    public User addUser(@RequestBody User user)  {
        return userService.saveUser(user);
    }
    @DeleteMapping(path="/deleteUser/{id}")
    public User deleteUser(@PathVariable("id") Long id) throws DataExist {
         return userService.deleteUser(id);
    }
    @GetMapping(path="/user")
    public List<User> addUser()  {
        return userService.getAllUsers();
    }

    @PutMapping(path="/user/{id}")
    public User modifyUser(@PathVariable("id") Long id, @RequestBody User user)  {
        return userService.update(id, user.getName());
    }
    @GetMapping(path="/user/init")
    public List<User> init()  {
        return userService.inti();
    }
    @DeleteMapping(path="/deleteAllUser")
    public List<User> deleteUser() throws DataExist {
        return userService.deleteUser();
    }
}