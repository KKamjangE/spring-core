package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(); // 회원 서비스 구현체
        Member member = new Member(1L, "memberA", Grade.VIP); // 회원 객체 생성
        memberService.join(member); // 회원 가입

        Member findmember = memberService.findMember(1L);// ID를 통해 검색
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findmember.getName());
    }
}
