package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); // 회원 서비스
        OrderService orderService = appConfig.orderService(); // 주문 서비스

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP); // 회원 객체 생성
        memberService.join(member); // 회원 가입

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
