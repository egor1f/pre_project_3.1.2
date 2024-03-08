package com.pre_project_312.web.controller;

import com.pre_project_312.web.entity.User;
import com.pre_project_312.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserController() {
    }

    @GetMapping("")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "mainPageAllUser";
    }

    @GetMapping("/add_user")
    public String showFormForAddUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/add_user")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addUser";
        } else {
            userService.addUser(user);
            return "redirect:/";
        }
    }

    @GetMapping("/edit_user")
    public String formEditUser(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/edit_user")
    public String submitEdit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "editUser";
        } else {
            userService.updateUser(user);
            return "redirect:/";
        }
    }

    @GetMapping("/delete_user")
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
