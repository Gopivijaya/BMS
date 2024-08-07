package vijaya.com.bms.controller;

import org.springframework.stereotype.Controller;
import vijaya.com.bms.DTO.BookingRequestDTO;
import vijaya.com.bms.DTO.BookingResponseDTO;
import vijaya.com.bms.DTO.BookingResponseStatus;
import vijaya.com.bms.exception.ShowNotFoundException;
import vijaya.com.bms.exception.UserNotFoundException;
import vijaya.com.bms.model.Booking;
import vijaya.com.bms.service.BookingService;

@Controller



public class BookingController {

    public BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookingResponseDTO BookMovie(BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        try {
        Booking booking = bookingService.BookMovie(
                bookingRequestDTO.getUserid(),
                bookingRequestDTO.getShowid(),
                bookingRequestDTO.getShowSeatid()

        );


            bookingResponseDTO.setBooking(booking);
            bookingResponseDTO.setStatus(BookingResponseStatus.Success);
        } catch (Exception e) {
            bookingResponseDTO.setStatus(BookingResponseStatus.Failure);
        }
        return bookingResponseDTO;
    }
}
