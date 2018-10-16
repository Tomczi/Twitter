//package pl.coderslab.twitter.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import pl.coderslab.twitter.Entity.User;
//import pl.coderslab.twitter.repository.UserRepository;
//
//import java.util.List;
//
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public boolean isEmailUnique(String email) {
//
//        try {
//
//            List<User> listOfUsers = userRepository.findAll();
//            if (listOfUsers == null) {
//                return true;
//            }
//
//            for (int i = 0; i < listOfUsers.size(); i++) {
//                if (listOfUsers.get(i).getEmail().equals(email)) {
//                    return false;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return true;
//    }
//
//}
