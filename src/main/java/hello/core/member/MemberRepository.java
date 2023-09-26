package hello.core.member;

public interface MemberRepository { // 회원 저장소 인터페이스
    void save(Member member); // 저장

    Member findById(Long memberId); // ID로 검색
}
