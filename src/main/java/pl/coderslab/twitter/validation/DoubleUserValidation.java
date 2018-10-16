package pl.coderslab.twitter.validation;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.twitter.Entity.User;
import pl.coderslab.twitter.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class DoubleUserValidation implements ConstraintValidator<DoubleUser, String> {

    @Autowired
    UserRepository userRepository;


    @Override
    public void initialize(DoubleUser constraint) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        try {

            List<User> listOfUsers = userRepository.findAll();
            if (listOfUsers == null) {
                return true;
            }

            for (int i = 0; i < listOfUsers.size(); i++) {
                if (listOfUsers.get(i).getEmail().equals(email)) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    }

