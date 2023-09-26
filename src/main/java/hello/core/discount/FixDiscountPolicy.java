package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{ // 고정 할인 정책 구현체

    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) { // enum 은 == 사용
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}