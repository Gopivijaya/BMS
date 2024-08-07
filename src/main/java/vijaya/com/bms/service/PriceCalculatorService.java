package vijaya.com.bms.service;

import org.springframework.stereotype.Service;
import vijaya.com.bms.model.Show;
import vijaya.com.bms.model.ShowSeat;
import vijaya.com.bms.model.ShowSeatType;
import vijaya.com.bms.repository.ShowSeatTypeRepository;

import java.util.List;

@Service

public class PriceCalculatorService {

        public ShowSeatTypeRepository showSeatTypeRepository;

        public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
            this.showSeatTypeRepository = showSeatTypeRepository;
        }

        public int calculatePrice(List<ShowSeat> showSeat, Show shw) {

            List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(shw);

            int price = 0;
            for(ShowSeat s : showSeat) {
                for(ShowSeatType t : showSeatTypes) {
                    if(s.getSeat().getSeatType().equals(t.getSeat().getSeatType())) {
                        price += showSeatTypes.get(0).getPrice();
                    }
                }
            }
            return price;
        }
}
