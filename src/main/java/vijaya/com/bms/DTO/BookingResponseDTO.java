package vijaya.com.bms.DTO;

import lombok.Getter;
import lombok.Setter;
import vijaya.com.bms.model.Booking;

@Getter
@Setter
public class BookingResponseDTO {
        private Booking booking;
        private BookingResponseStatus status;
}
