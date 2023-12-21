package ch.bbw.userservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private DBService dbService;
    @GetMapping("api/users")
    public List<User> getUsers() {
        return dbService.getUsers();
    }
    @DeleteMapping("api/user")
    public void deleteUser(User user) {
        dbService.deleteUser(user);
    }
    @PostMapping("api/user")
    public User createUser(User user) {
        return dbService.createUser(user);
    }
}
