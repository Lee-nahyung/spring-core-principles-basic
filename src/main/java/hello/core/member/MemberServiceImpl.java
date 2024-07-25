package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository(); //DIP 위반 예시.
    private MemberRepository memberRepository; //오로지 인터페이스만 존재. -> 추상화에만 의존.

    public MemberServiceImpl(MemberRepository memberRepository){ //생성자를 통해서 구현체가 뭐가 들어갈지 들어감.
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
