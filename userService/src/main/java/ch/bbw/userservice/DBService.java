package ch.bbw.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {
    private final UserRepository userRepository;

    @Autowired
    public DBService(UserRepository userRepository) {this.userRepository = userRepository;}

    public List<User> getUsers() {return (List<User>)userRepository.findAll(); }

    public User createUser(User user) {return userRepository.save(user);}

    public void deleteUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            userRepository.delete(user);
        }
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


    public User getUser(long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        return null;
    }

    public User updateUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            return userRepository.save(user);
        }
        return null;
    }
}
