package vijaya.com.bms.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class BookingRequestDTO {
    private Long userid;
    private Long showid;
    private List<Long> showSeatid;

}
