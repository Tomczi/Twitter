package pl.coderslab.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.twitter.Entity.Tweet;
import pl.coderslab.twitter.Entity.User;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    public Tweet findByUser(User user);
}
