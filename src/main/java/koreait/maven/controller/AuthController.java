package koreait.maven.controller;

import koreait.maven.dto.SigninRequestDto;
import koreait.maven.dto.SignupRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/get")
    public String getUser(@RequestParam(name = "memberId") String userId) {
        System.out.println("RequestParam으로 들어온 값: " + userId);
        return "RequestParam: " + userId;
    }

    @GetMapping("/search")
    public String info(@RequestParam(defaultValue = "no-email") String email,
                       @RequestParam(required = false) String name) {

        return "검색 조건 - 이름: " + name + ", 이메일: " + email;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDto signupRequestDto) {
        return ResponseEntity.ok().body(signupRequestDto.toString());
    }

    /**
     * Method: Post
     * Parameter: SigninRequestDto(email, password)
     * return "로그인 완료 : " + signinReqDto.getEmail() + "님 반갑습니다."
     */
    @PostMapping("/signin")
    public String signin(@RequestBody SigninRequestDto signinRequestDto) {
        return "로그인 완료 : " + signinRequestDto.getEmail() + "님 반갑습니다.";
    }
}
