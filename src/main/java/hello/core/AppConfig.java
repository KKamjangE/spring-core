package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig { // 객체의 생성과 연결 담당

    public MemberService memberService() { // memberService 의존성 주입
        return new MemberServiceImpl(new MemoryMemberRepository()); // 메모리 회원 저장소로 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
