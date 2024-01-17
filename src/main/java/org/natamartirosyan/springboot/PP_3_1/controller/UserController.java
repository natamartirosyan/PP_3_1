package org.natamartirosyan.springboot.PP_3_1.controller;

import javax.validation.Valid;
import org.natamartirosyan.springboot.PP_3_1.model.User;
import org.natamartirosyan.springboot.PP_3_1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/show")
    public String userById(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.findUser(id));
        return "userID";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUserById(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.findUser(id));
        return "edit";
    }

    @PostMapping("/{id}/save")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.editUserById(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
