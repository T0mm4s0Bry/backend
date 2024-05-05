package com.example.backend4f;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "home", value = "/home")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("User Agent:" + request.getHeader("User-Agent"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("Gino".equals(username) && "Pasquale".equals(password)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>WELCOME</h1>");
            out.println("</body></html>");
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("messaggioErrore", "Credenziali sbagliate");
            response.sendRedirect("/tuosito/errore");
        }
    }

    public void destroy() {
    }
}
