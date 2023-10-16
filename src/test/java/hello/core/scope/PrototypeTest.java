package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class); // 컨테이너에 빈 등록
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2); // 서로 다른 빈이라는 것을 알 수 있다


        // 프로토타입 빈은 수동으로 종료해준다
        prototypeBean1.destroy();
        prototypeBean2.destroy();

        // 프로토타입은 종료 메서드가 호출되지 않는다
        ac.close();
    }

    // 프로토타입 빈
    @Scope("prototype") // 프로토타입 스코프
    static class PrototypeBean {

        @PostConstruct // 의존관계 주입 후 호출
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy // 빈이 종료될 때 호출
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
