package vijaya.com.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vijaya.com.bms.model.User;

import java.util.Optional;

@Repository

public interface UserCreateRepository extends JpaRepository<User, String> {
    @Override
    Optional<User> findById(String s);
}