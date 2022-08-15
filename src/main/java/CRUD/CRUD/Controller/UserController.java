package CRUD.CRUD.Controller;

import CRUD.CRUD.model.User;
import CRUD.CRUD.service.UserService;
import org.springframework.web.bind.annotation.*;

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

}
