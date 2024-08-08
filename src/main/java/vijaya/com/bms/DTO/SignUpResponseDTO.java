package vijaya.com.bms.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;
import vijaya.com.bms.model.User;

@Getter
@Setter

public class SignUpResponseDTO {
    private ResponseStatus status;
    private User user;

}
