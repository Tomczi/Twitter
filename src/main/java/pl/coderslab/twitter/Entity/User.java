package pl.coderslab.twitter.Entity;


import org.hibernate.validator.constraints.UniqueElements;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.twitter.validation.DoubleUser;
import pl.coderslab.twitter.validation.DoubleUsername;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Empty field")
    @DoubleUsername(message = "username already exists")
    private String username;

    @NotEmpty(message = "Empty field")
    private String password;

    @NotEmpty(message = "Empty field")
    @Email(message = "Incorrect Email")
    @DoubleUser(message = "email already exists")
    private String email;

    @OneToMany
    private List<Tweet> tweets =
            new ArrayList<>();

    private String matchingPassword;

    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<pl.coderslab.twitter.Entity.Role> roles;

    public User() {
    }


    public User(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.id = user.getId();
        this.tweets = user.getTweets();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.matchingPassword = user.getMatchingPassword();
        this.active = user.isActive();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public Set<pl.coderslab.twitter.Entity.Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<pl.coderslab.twitter.Entity.Role> roles) {
        this.roles = roles;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}