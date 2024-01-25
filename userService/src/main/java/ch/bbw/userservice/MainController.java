package ch.bbw.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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
