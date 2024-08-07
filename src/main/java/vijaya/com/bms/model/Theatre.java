package vijaya.com.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Theatre extends Base{
    private String theatre_name;
    @ManyToOne
    private City city;
    @OneToMany
    private List<Screen> screens;

}
