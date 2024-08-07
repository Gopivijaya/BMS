package vijaya.com.bms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity (name = "shows")
@Getter
@Setter


public class Show extends Base{
    @ManyToOne
    private Movie movie;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> feature;

    @ManyToOne
    private Screen screen;

    private Date startTime;

    private Date endTime;

}
