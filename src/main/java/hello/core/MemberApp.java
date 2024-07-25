package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp { //순수한 자바 코드, 메서드를 가지고 확인하는 코드
    public static void main(String[] args) {

//      MemberService memberService = new MemberServiceImpl();
        AppConfig appconfig = new AppConfig();
        MemberService memberService = appconfig.memberService();


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
