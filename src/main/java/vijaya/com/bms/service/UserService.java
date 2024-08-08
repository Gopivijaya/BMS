package vijaya.com.bms.service;


import org.springframework.stereotype.Service;
import vijaya.com.bms.model.User;
import vijaya.com.bms.repository.UserCreateRepository;
import vijaya.com.bms.repository.UserRepository;

import java.util.Optional;

@Service

public class UserService {

    private UserCreateRepository userRepository;
    public UserService(UserCreateRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User SignUp(String Name, String Email, String Password) {
        User user = new User();
        User savedUser = null;
        Optional<User> optionalUser = userRepository.findById(Email);
        if (optionalUser.isPresent()) {
//            user = optionalUser.get();
//            user.setName(Name);
//            user.setEmail(Email);
//            user.setPassword(Password);
        }else{
            user.setName(Name);
            user.setEmail(Email);
            user.setPassword(Password);
            savedUser=userRepository.save(user);
        }

        return savedUser;

    }
}
