package hello.servlet.web.servlet;

import hello.servlet.basic.domain.member.Member;
import hello.servlet.basic.domain.member.MemberRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        final List<Member> members = memberRepository.findAll();
        final PrintWriter printWriter = response.getWriter();
        printWriter.write("<html>");
        printWriter.write("<head>");
        printWriter.write(" <meta charset=\"UTF-8\">");
        printWriter.write(" <title>Title</title>");
        printWriter.write("</head>");
        printWriter.write("<body>");
        printWriter.write("<a href=\"/index.html\">메인</a>");
        printWriter.write("<table>");
        printWriter.write(" <thead>");
        printWriter.write(" <th>id</th>");
        printWriter.write(" <th>username</th>");
        printWriter.write(" <th>age</th>");
        printWriter.write(" </thead>");
        printWriter.write(" <tbody>");

        for (Member member : members) {
            printWriter.write(" <tr>");
            printWriter.write(" <td>" + member.getId() + "</td>");
            printWriter.write(" <td>" + member.getUsername() + "</td>");
            printWriter.write(" <td>" + member.getAge() + "</td>");
            printWriter.write(" </tr>");
        }
        printWriter.write(" </tbody>");
        printWriter.write("</table>");
        printWriter.write("</body>");
        printWriter.write("</html>");
    }
}