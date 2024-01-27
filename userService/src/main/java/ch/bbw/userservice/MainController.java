package ch.bbw.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/user/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        dbService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON).body("Deleted User with id:" + id);
    }
    @DeleteMapping("user/user")
    public void deleteUser(User user) {
        dbService.deleteUser(user);
    }

    @PostMapping("/user/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.createUser(user));
    }
}
