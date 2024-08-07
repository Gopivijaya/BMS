package vijaya.com.bms.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter

public class City extends Base{
    private String name;
    //private List<Theatre> theatreList;
}
