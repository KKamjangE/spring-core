package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{ // 회원 서비스 구현체

    private final MemberRepository memberRepository;

    @Autowired // 자동 의존관계 주입
    public MemberServiceImpl(MemberRepository memberRepository) { // 생성자
        this.memberRepository = memberRepository; // 의존성 주입
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
