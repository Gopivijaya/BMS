package vijaya.com.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vijaya.com.bms.model.Show;
import vijaya.com.bms.model.ShowSeatType;

import java.util.List;

@Repository

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Show show);
}
