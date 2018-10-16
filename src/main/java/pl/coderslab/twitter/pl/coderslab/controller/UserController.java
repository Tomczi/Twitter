package pl.coderslab.twitter.pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.twitter.Entity.Role;
import pl.coderslab.twitter.Entity.User;
import pl.coderslab.twitter.repository.UserRepository;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
@SessionAttributes("ses")
public class UserController {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registerPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAddUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registerPage";
        }

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRole("USER");
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setActive(true);
        userRepository.save(user);
        return "redirect:/start";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        User user = new User();
        model.addAttribute("login", user);
        return "loginPage";

    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response,
                            HttpSession session, Model model) throws IOException {

        List<User> users = userRepository.findAll();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        for (int i = 0; i < users.size(); i++) {

            boolean result = passwordEncoder.matches(user.getPassword(), users.get(i).getPassword());

            if (result && user.getUsername().equals(users.get(i).getUsername())) {

//                HttpSession session1 = request.getSession();
//                session1.setAttribute("user", user);
                model.addAttribute("ses", user);

                return "redirect:/tweet/add";
            }

        }
        return "redirect:/user/login";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }


    @ModelAttribute("users")
    public List<User> listOfUsers() {
        List<User> users = new ArrayList<User>();
        users = userRepository.findAll();
        return users;
    }


}





