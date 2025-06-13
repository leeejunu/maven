package koreait.maven.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SigninRequestDto {
    private String email;
    private String password;
}
