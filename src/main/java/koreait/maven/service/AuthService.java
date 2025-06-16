package koreait.maven.service;

import koreait.maven.dto.req.SignupRequestDto;
import koreait.maven.dto.res.SigninResponseDto;
import koreait.maven.dto.res.SignupResponseDto;
import koreait.maven.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        if (signupRequestDto.getEmail().trim().isEmpty() || signupRequestDto.getEmail() == null) {
            return new SignupResponseDto("failed", "이메일을 입력하세요");
        } else if (signupRequestDto.getPassword() == null || signupRequestDto.getPassword().trim().isEmpty()) {
            return new SignupResponseDto("failed", "비밀번호를 입력하세요");
        } else if (signupRequestDto.getUsername() == null || signupRequestDto.getUsername().trim().isEmpty()) {
            return new SignupResponseDto("failed", "사용자 이름을 입력하세요");
        }

        int chkEmail = authRepository.findByEmail(signupRequestDto.getEmail());
        if (chkEmail == 1) {
            authRepository.addUser(signupRequestDto);
            return new SignupResponseDto("success", "회원가입 성공");
        }else if (chkEmail == 0){
            return new SignupResponseDto("fail", "이미 존재하는 이메일입니다.");
        }

        return new SignupResponseDto("fail", "회원가입 실패");
    }
}
