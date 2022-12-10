package CRUD.CRUD.Controller;

import CRUD.CRUD.Exception.DataExist;
import CRUD.CRUD.Model.User;
import CRUD.CRUD.Service.UserService;
import org.springframework.data.domain.Page;
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
    public Page<User> getAllUsers(@RequestParam(value = "page", required = false, defaultValue ="0") int page,
                                  @RequestParam(value ="size", required = false, defaultValue ="10") int size)  {return userService.getAllUsers (page, size);}

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
    @GetMapping()
    public Page<User> getUserWithLetter(@RequestParam("letter") String letter,
                                        @RequestParam(value = "page", required = false, defaultValue ="0") int page,
                                        @RequestParam(value ="size", required = false, defaultValue ="10") int size){
        return userService.getUserWithLetter(letter, page, size);
    }
}