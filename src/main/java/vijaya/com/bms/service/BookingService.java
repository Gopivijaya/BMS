package vijaya.com.bms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import vijaya.com.bms.exception.ShowNotFoundException;
import vijaya.com.bms.exception.UserNotFoundException;
import vijaya.com.bms.model.*;
import vijaya.com.bms.repository.ShowRepository;
import vijaya.com.bms.repository.ShowSeatRepository;
import vijaya.com.bms.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;
    public BookingService(UserRepository userRepository,ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,PriceCalculatorService priceCalculatorService){
        this.userRepository=userRepository;
        this.showRepository=showRepository;
        this.showSeatRepository=showSeatRepository;
        this.priceCalculatorService=priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking BookMovie(Long userId, Long showid, List<Long> showSeatid) throws UserNotFoundException, ShowNotFoundException {

        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user with this "+userId+" id doesnt exist");
        }

        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showid);

        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("show with this"+ showid +" id doesnt exist");
        }

        Show shw = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatid);

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getStatus().equals(ShowSeatStatus.Available)){
                throw new RuntimeException("Show seat "+showSeat.getId()+" is not available");
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setStatus(ShowSeatStatus.Booked);
            showSeatRepository.save(showSeat);
        }



        Booking booking = new Booking();
        booking.setUser(user);
        booking.setSeat(showSeats);
        booking.setBookingStatus(BookingStatus.Pending);
        booking.setCreatedAt(new Date());
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats,shw));

        return booking;

    }
}
