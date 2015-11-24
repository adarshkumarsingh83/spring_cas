package com.espark.adarsh.cas;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Adarsh on 6/16/15.
 */
@Controller
public class ApplicationController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() {

        ModelAndView model = new ModelAndView();
        model.addObject("user", getUserName());

        model.setViewName("home");
        return model;

    }

    @RequestMapping(value = "/protected/{album}", method = RequestMethod.GET)
    public ModelAndView protectedPage(@PathVariable String album) {

        ModelAndView model = new ModelAndView();
        model.addObject("user", getUserName());

        switch (album) {
            case "parents":
                model.addObject("photos", Album.ride);
                break;
            case "friends":
                model.addObject("photos", Album.friends);
                break;
        }

        model.setViewName("protected");
        return model;

    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("user", getUserName());
        } else {
            model.addObject("user", "");
        }

        model.setViewName("403");
        return model;

    }

    protected String getUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String username = "";

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        return username;
    }

}
