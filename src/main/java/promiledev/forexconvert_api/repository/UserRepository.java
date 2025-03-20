package promiledev.forexconvert_api.repository;

import promiledev.forexconvert_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}