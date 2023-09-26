package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService 객체가 MemberService.class의 인스턴스인지 확인
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class); // 이름을 제거하고 타입으로만 조회한다
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService 객체가 MemberService.class의 인스턴스인지 확인
    }

    @Test
    @DisplayName("구체 타입으로 조회") // 구체 타입으로 조회하면 유연성이 떨어진다 (같은 타입이 있을 수 있다)
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class); // 구체 타입을 넘겨준다
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService 객체가 MemberService.class의 인스턴스인지 확인
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
//        ac.getBean("xxxxx", MemberService.class);
        // xxxxx라는 이름으로 빈을 가져오려 했을 때 Exception이 발생해야 성공
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    }
}
