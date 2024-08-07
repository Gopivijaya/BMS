package vijaya.com.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Movie extends Base{
    private String name;
    @ManyToMany
    private List<Actor> actors;

}
