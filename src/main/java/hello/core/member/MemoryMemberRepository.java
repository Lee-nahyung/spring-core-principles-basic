package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{


    private static Map<Long, Member> stort = new HashMap<>(); //동시성 이슈가 있을 수 있음.  실무에서는 ConcurrentHashMap 사용

    @Override
    public void save(Member member) {
        stort.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return stort.get(memberId);
    }
}
