package pl.coderslab.twitter.pl.coderslab.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.twitter.Entity.Tweet;
import pl.coderslab.twitter.Entity.User;
import pl.coderslab.twitter.repository.TweetRepository;
import pl.coderslab.twitter.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getTweet(Model model, HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        request.getAttribute("test");
        Tweet tweet = new Tweet();
        model.addAttribute("tweet", tweet);
        return "addTweet";
    }

    @PostMapping("/add")
    public String postTweet(@ModelAttribute Tweet tweet, HttpServletRequest request, HttpServletResponse response,
                            HttpSession session) {


        User user = (User) session.getAttribute("ses");

        User loggedUser = userRepository.findByUsername(user.getUsername());
//        System.out.println(loggedUser);

        tweetRepository.save(tweet);
        tweet.setUser(loggedUser);
        loggedUser.getTweets().add(tweet);
        userRepository.save(loggedUser);

        return "redirect:/tweet/add";

    }

    @ModelAttribute("listOfTweets")
    public List<Tweet> listOfTweetsWithUsers() {
        List<Tweet> list = tweetRepository.findAll();
        return list;
    }

    @RequestMapping(value = "/edit/{tweetId}", method = RequestMethod.GET)

        public String editTweet (@PathVariable Long tweetId, Model model) {
        Tweet tweet = tweetRepository.getOne(tweetId);

        model.addAttribute("edit", tweet);

            return "editTweet";
    }

    @RequestMapping(value = "/edit/{tweetId}", method = RequestMethod.POST)
    public String editGettedTweet (@ModelAttribute Tweet tweet, @PathVariable Long tweetId) {
        Tweet tweet1 = tweetRepository.getOne(tweetId);
        tweet1.setText(tweet.getText());
        tweetRepository.save(tweet1);
        return "addTweet";
    }

    @RequestMapping(value = "/delete/{tweetId}/{userId}", method = RequestMethod.GET)
    public String deleteTweet (@PathVariable Long tweetId, @PathVariable Long userId) {
        Tweet tweet = tweetRepository.getOne(tweetId);
        User user = userRepository.getOne(userId);
        user.getTweets().remove(tweet);
        tweetRepository.delete(tweet);
        return "redirect:/tweet/add";
//        System.out.println(user.getId());
//      List <Tweet> listOfTweets = user.getTweets();
//      for (int i = 0; i < listOfTweets.size(); i++) {
//          if (listOfTweets.get(i).getId() == tweetId) {
//              listOfTweets.remove(i);
//          } else {
//              return "dupa";
//
//          }
//
//      }
//        System.out.println(tweet);
//         //not yet
//        return "ddaad";
    }


}