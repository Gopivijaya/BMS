package vijaya.com.bms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vijaya.com.bms.DTO.SignUpRequestDTO;
import vijaya.com.bms.DTO.SignUpResponseDTO;
import vijaya.com.bms.controller.UserController;
import vijaya.com.bms.model.User;
import vijaya.com.bms.repository.UserRepository;

@SpringBootApplication
public class BmsApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(BmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       User user = new User();
       user.setName("Vijaya");
       user.setEmail("vijaya@gmail.com");
       user.setPassword("password");

        userRepository.save(user);

    }
}
