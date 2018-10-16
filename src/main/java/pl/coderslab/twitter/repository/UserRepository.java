package pl.coderslab.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.twitter.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
