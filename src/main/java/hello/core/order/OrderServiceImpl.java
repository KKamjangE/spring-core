package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // lombok에서 final이 붙은 객체를 참고해서 생성자를 자동으로 만들어준다
public class OrderServiceImpl implements OrderService{ // 주문 서비스 구현체

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // lombok이 자동으로 생성자를 만들어주기 때문에 주석처리
    @Autowired // 생성자가 하나일 때에는 @Autowired를 생략해도 자동 주입 된다. (스프링 빈에만 해당)
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice);// 할인 가격

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
