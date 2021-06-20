package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListControllerV3 implements ControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        final List<Member> members = memberRepository.findAll();
        final ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
