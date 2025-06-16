package koreait.maven.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SigninResponseDto {
    private String status;
    private String message;
}
