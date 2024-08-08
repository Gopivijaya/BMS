package vijaya.com.bms.controller;

import com.sun.net.httpserver.Authenticator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseStatus;
import vijaya.com.bms.DTO.SignUpRequestDTO;
import vijaya.com.bms.DTO.SignUpResponseDTO;
import vijaya.com.bms.model.User;
import vijaya.com.bms.service.UserService;

@Controller

public class UserController {

    private UserService userService;
    private org.springframework.web.bind.annotation.ResponseStatus ResponseStatus;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO signUprequest){
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();
        try{
            User user = userService.SignUp(signUprequest.getName(),
                                              signUprequest.getEmail(),
                                              signUprequest.getPassword());

            signUpResponseDTO.setUser(user);
            //signUpResponseDTO.setStatus;
        }catch(Exception e){

        }
        return signUpResponseDTO;
    }
}
