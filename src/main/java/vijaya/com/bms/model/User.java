package vijaya.com.bms.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class User extends Base{
    private String Name;
    private String Email;
    private String Password;

}
