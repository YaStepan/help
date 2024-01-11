package ru.springboot.pp312.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springboot.pp312.entity.User;
import ru.springboot.pp312.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/")
    public String getUser(@RequestParam(value = "id") int id, Model model) {//todo: codeStyle ..именование
        model.addAttribute("user", userService.getUser(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/")
    public String editUser(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/")
    public String updateUser(@ModelAttribute User user, @RequestParam("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestParam("id") int id) {//todo: отказываемся от примитивов
        userService.deleteUser(id);
        return "redirect:/users";
    }
}