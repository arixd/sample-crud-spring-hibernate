/*
 */
package com.ari.j2ee.controller;

import com.ari.j2ee.entitas.Users;
import com.ari.j2ee.services.UserServices;
import com.ari.j2ee.validator.UserFormValidator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ari
 *
 */
@Controller
@RequestMapping(value = "/users")
public class UserController
{

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserFormValidator userFormValidator;

//    set form validator
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(userFormValidator);
    }

    @RequestMapping(value = "/all")
    public String index(Model m)
    {
        m.addAttribute("list", userServices.findAll());
        return "user";
    }

    @RequestMapping(value = "/find/{id}/view", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model)
    {
        logger.debug("show user id " + id);
        Users users = userServices.findById(id);
        System.out.println("user " + users.getId() + " += " + users.getName());
        model.addAttribute("user", users);
        return "show";
    }

    @RequestMapping(value = "/add")
    public String addUser(Model model)
    {
        logger.debug("showAddUserForm");
        Users user = new Users();
        user.setName("mkyong123");
        user.setEmail("test@gmail.com");
        user.setAddress("abc 88");
        user.setNewsletter(true);
        user.setSex("M");
        user.setFramework("Spring MVC,GWT");
        user.setSkill("Spring,Grails,Groovy");
        user.setCountry("SG");
        user.setNumber(2);
        model.addAttribute("userForm", user);
        model.addAttribute("isInsert", "New");
        populateDefaultModel(model);
        return "userform";
    }

    private void populateDefaultModel(Model model)
    {
        List<String> frameworksList = new ArrayList<>();
        frameworksList.add("Spring MVC");
        frameworksList.add("Struts 2");
        frameworksList.add("JSF 2");
        frameworksList.add("GWT");
        frameworksList.add("Play");
        frameworksList.add("Apache Wicket");
        model.addAttribute("frameworkList", frameworksList);

        Map<String, String> skill = new LinkedHashMap<String, String>();
        skill.put("Hibernate", "Hibernate");
        skill.put("Spring", "Spring");
        skill.put("Struts", "Struts");
        skill.put("Groovy", "Groovy");
        skill.put("Grails", "Grails");
        model.addAttribute("javaSkillList", skill);

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        model.addAttribute("numberList", numbers);

        Map<String, String> country = new LinkedHashMap<String, String>();
        country.put("US", "United Stated");
        country.put("CN", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");
        model.addAttribute("countryList", country);
    }

}
