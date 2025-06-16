package koreait.maven.controller;

import koreait.maven.repository.AuthRepository;
import koreait.maven.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
class UserDto {
    private int userId;
    private String name;
    private int age;
}


@Slf4j
@Controller
public class MainController {

    private List<UserDto> users = new ArrayList<>();

    private final AuthService authService;

    public MainController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/view")
    public String view() {
        return "hello";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("username", "<b>이준우</b>");
        model.addAttribute("isAdult", true);
        model.addAttribute("age", 26);
        Map<String, Integer> map = new HashMap<>();
        map.put("이준우1", 26);
        map.put("이준우", 26);

        map.put("이준우2", 26);

        model.addAttribute("userList", map);
        return "profile";
    }

    @GetMapping("/search")
    public String getSearch(@RequestParam String keyword, Model model) {
        model.addAttribute("keyword", keyword);
        return "search";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String name, @RequestParam int age, Model model) {
        users.add(new UserDto(users.size() + 1, name, age));
        model.addAttribute("message", name + "님 가입을 환영합니다.");
        return "signupresult";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", users);
        return "users";
    }
}
