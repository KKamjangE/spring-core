package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request") // request 스코프로 지정
public class MyLogger {
    private String uuid;
    private String requsetURL;

    public void setRequsetURL(String requsetURL) { // URL 외부에서 입력
        this.requsetURL = requsetURL;
    }

    public void log(String message) { // 로그를 찍는 함수
        System.out.println("[" + uuid + "]" + "[" + requsetURL + "] " + message);
    }

    @PostConstruct // 의존관계 주입 이후 바로 호출한다
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create: " + this);
    }

    @PreDestroy // 빈 종료시 호출
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
