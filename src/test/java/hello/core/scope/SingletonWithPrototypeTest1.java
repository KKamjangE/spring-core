package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class); // 빈 등록
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class); // 빈 가져오기
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class); // 빈 가져오기
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class); // 빈 등록

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);
    }

    @Component
    @Scope("singleton") // 싱글톤 스코프
    static class ClientBean {

        @Autowired
        private Provider<PrototypeBean> provider;

        public int logic() {
            // Provider를 사용해서 PrototypeBean을 DL한다
            PrototypeBean prototypeBean = provider.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }


    @Component
    @Scope("prototype") // 프로토타입 스코프
    static class PrototypeBean {
        private int count = 0; // count 필드

        public void addCount() { // count +1 하는 메서드
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct // 의존관계 주입 후 호출
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy // 빈이 종료될 때 호출 (프로토타입이라 호출 안됨)
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
