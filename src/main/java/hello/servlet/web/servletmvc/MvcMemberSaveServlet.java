package hello.servlet.web.servletmvc;

import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final int age = Integer.parseInt(request.getParameter("age"));
        final Member member = new Member(username, age);
        memberRepository.save(member);

        request.setAttribute("member", member);
        final String viewPath = "/WEB-INF/views/save-result.jsp";
        final RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
