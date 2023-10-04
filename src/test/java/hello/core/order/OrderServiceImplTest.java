package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        // 생성자 주입을 사용한다면 개발자가 어떤 파라미터가 필요한지 쉽고 명확하게 알 수 있다.
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy()); // 임의의 의존관계를 생성하여 주입한다.
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}