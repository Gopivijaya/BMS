package vijaya.com.bms.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Seat extends Base{
        private int seatNumber;
        @ManyToOne
        private SeatType seatType;
        private int rowVal;
        private int colVal;
}
