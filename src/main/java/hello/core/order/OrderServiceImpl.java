package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{ // 주문 서비스 구현체

    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 멤버 저장소
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice);// 할인 가격

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
