package koreait.maven.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SigninRequestDto {
    private String email;
    private String password;
}
