package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AutowiredTest { // 빈이 없어도 동작해야 하는 경우

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    @Component
    static class TestBean {
        // Member는 스프링 빈이 아니다

        @Autowired(required = false) // 빈 주입 필수 유무 옵션
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1); // 의존관계가 없으므로 메서드 자체가 호출되지 않는다
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { // 주입할 대상이 없다면 null 입력
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) { // 주입할 대상이 없다면 Optional.empty 입력
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
