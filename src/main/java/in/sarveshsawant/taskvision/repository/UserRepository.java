package in.sarveshsawant.taskvision.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sarveshsawant.taskvision.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameOrEmail(String username, String email);
}
