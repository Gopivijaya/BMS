package vijaya.com.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vijaya.com.bms.model.ShowSeat;

import java.util.List;
import java.util.Optional;

@Repository

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {



      @Override
      List<ShowSeat> findAllById(Iterable<Long> showSeats);

      ShowSeat save(ShowSeat showSeat);
}
