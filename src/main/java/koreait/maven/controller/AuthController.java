package koreait.maven.controller;

import koreait.maven.dto.req.SignupRequestDto;
import koreait.maven.dto.res.SigninResponseDto;
import koreait.maven.dto.res.SignupResponseDto;
import koreait.maven.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;


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

//    @PostMapping("/signup")
//    public ResponseEntity<?> signup(@RequestBody SignupRequestDto signupRequestDto) {
//        return ResponseEntity.ok().body(signupRequestDto.toString());
//    }

    /**
     * Method: Post
     * Parameter: SigninRequestDto(email, password)
     * return "로그인 완료 : " + signinRequestDto.getEmail() + "님 반갑습니다."
     */
//    @PostMapping("/signin")
//    public String signin(@RequestBody SigninRequestDto signinRequestDto) {
//        return "로그인 완료 : " + signinRequestDto.getEmail() + "님 반갑습니다.";
//    }

    /**
     * - ResponseEntity
     * HTTP 응답 전체를 커스터마이징을 해서 보낼 수 있는 스프링 클래스
     * HTTP 상태코드, 응답바디, 응답헤더까지 모두 포함
     * <p>
     * - 상태코드
     * 400 Bad Request - 잘못된 요청
     * 401 Unauthorized - 인증 실패 (ex. 로그인 안됨, 토큰 없음)
     * 403 Forbidden - 접근 권한 없음 (ex. 관리자만 접근 가능)
     * 404 Not Found - 리소스 없음
     * 409 Conflict - 중복 등으로 인한 충돌 (ex. 이미 존재하는 이메일)
     * 500 Internal Server Error - 서버 내부 오류
     */
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignupRequestDto signupRequestDto) {
        if (signupRequestDto.getEmail() == null
                || signupRequestDto.getEmail().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(signupRequestDto);
        }
        SigninResponseDto signinResponseDto = new SigninResponseDto("success", "로그인 성공");
        return ResponseEntity.ok().body(signinResponseDto);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDto signupRequestDto) {

        return ResponseEntity.ok().body(authService.signup(signupRequestDto));
    }
}
