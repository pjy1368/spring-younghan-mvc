<%@ page import="hello.servlet.basic.domain.member.Member" %>
<%@ page import="hello.servlet.basic.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final MemberRepository memberRepository = MemberRepository.getInstance();
    final String username = request.getParameter("username");
    final int age = Integer.parseInt(request.getParameter("age"));
    final Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%>
    </li>
    <li>username=<%=member.getUsername()%>
    </li>
    <li>age=<%=member.getAge()%>
    </li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
