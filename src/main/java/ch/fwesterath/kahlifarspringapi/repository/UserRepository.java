package ch.fwesterath.kahlifarspringapi.repository;

import ch.fwesterath.kahlifarspringapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
