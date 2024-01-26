package ch.bbw.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MainController {
    @Autowired
    private DBService dbService;
    @GetMapping("user/users")
    public List<User> getUsers() {
        return dbService.getUsers();
    }
    @DeleteMapping("user/user")
    public void deleteUser(User user) {
        dbService.deleteUser(user);
    }
    @PostMapping("user/user")
    public User createUser(User user) {
        return dbService.createUser(user);
    }
}
