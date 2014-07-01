package com.tk.service.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if ("jingyingshe".equals(userName) && "2008322".equals(password)) {
            request.getSession().setAttribute("userName", userName);
            response.sendRedirect("admin/backstage.jsp");
        } else {
            out.print("<script>alert(\"��¼ʧ�ܣ������û�������룡\");location=\"index.jsp\";</script>");
        }
        out.flush();
        out.close();
    }

}
