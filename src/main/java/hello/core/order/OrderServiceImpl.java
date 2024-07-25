package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정할인금액. but 추상뿐만 아니라 구체(구현)클래스에도 의존함. OCP위반.
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //이것도 OCP 위반사례

    private final DiscountPolicy discountPolicy; //구체 의존하지 않고, 추상에만 의존하도록 변경.
    private final MemberRepository memberRepository;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 정책에 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
