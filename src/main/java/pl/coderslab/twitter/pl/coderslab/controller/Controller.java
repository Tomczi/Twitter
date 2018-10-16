package pl.coderslab.twitter.pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import pl.coderslab.twitter.Entity.User;
import pl.coderslab.twitter.repository.RoleRepository;
import pl.coderslab.twitter.repository.UserRepository;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    UserRepository userRepository;


    @RequestMapping("/start")

    public String main() {
        return "welcomePage";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        User userDto = new User();
        model.addAttribute("user", userDto);
        return "registerPage";

        }
}