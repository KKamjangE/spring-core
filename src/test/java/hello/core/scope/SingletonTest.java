package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class); // 컨테이너에 빈 등록

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);
        assertThat(singletonBean1).isSameAs(singletonBean2);

        ac.close();
    }

    // 싱글톤 빈
    @Scope("singleton") // 싱글톤 스코프
    static class SingletonBean {

        @PostConstruct // 의존관계 주입이 끝나면 호출
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy // 빈이 종료될 때 호출
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
