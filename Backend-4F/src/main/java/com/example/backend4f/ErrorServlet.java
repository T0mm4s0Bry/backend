package com.example.backend4f;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "error", value = "/tuosito/errore")
public class ErrorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String sessionAttribute = (String) session.getAttribute("messaggioErrore");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Pagina di errore</title></head><body>");
        out.println("<h1>" + sessionAttribute + "</h1>");
        out.println("</body></html>");
    }
}
