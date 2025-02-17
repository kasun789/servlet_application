package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if ("admin".equals(userName) && "password".equalsIgnoreCase(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userName);
            response.sendRedirect("dashboard.jsp");  // redirect to the dashboard
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
