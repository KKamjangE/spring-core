package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 메모리에 저장하기 때문에 Map으로 생성
    @Override
    public void save(Member member) {
        store.put(member.getId(), member); // Map에 member id와 member객체 추가
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); // member id를 통해 검색
    }
}
