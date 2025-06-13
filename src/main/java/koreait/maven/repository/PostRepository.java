package koreait.maven.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

    public String getPost() {

        return "레포지토리 post";
    }
}
