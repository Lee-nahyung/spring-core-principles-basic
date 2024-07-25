package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//AppConfig 등장으로 애플리케이션이 사용영역과,객체를 생성하고 구성하는 영역으로 분리.
public class AppConfig {

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository(); //이 부분 중복이 있었는데 리팩토링으로 해결
    }
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    //서비스가 바뀌면 위에만 바꾸면됨
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
