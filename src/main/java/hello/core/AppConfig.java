package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 정보 어노테이션
public class AppConfig { // 객체의 생성과 연결 담당

    @Bean
    public MemberRepository memberRepository() { // 회원 저장소
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() { // 할인 정책
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() { // 회원 서비스
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() { // 주문 서비스
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
