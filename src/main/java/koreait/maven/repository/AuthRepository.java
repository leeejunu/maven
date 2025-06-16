package koreait.maven.repository;

import koreait.maven.dto.req.SignupRequestDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AuthRepository {
    private final static Map<String, String> store = new HashMap<>();

    public AuthRepository() {
        store.put("test@example.com", "홍길동");
    }

    public int findByEmail(String email) {
        if (store.containsKey(email)) {
            return 0;
        }
        return 1;
    }

    public int addUser(SignupRequestDto signupRequestDto) {
        store.put(signupRequestDto.getEmail(), signupRequestDto.getUsername());
        return 1;
    }

}
