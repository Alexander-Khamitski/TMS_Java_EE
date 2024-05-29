package com.TeachMeSkills.jsp.hw.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegisteredServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/save-request.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String amount = request.getParameter("amount");
        if (!isAnyValueNullOrEmpty(firstName, lastName, amount)) {
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("amount", amount);
            getServletContext().getRequestDispatcher("/WEB-INF/registered.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/save-request.jsp").forward(request, response);
        }
    }

    private boolean isAnyValueNullOrEmpty(String firstName, String lastName, String amount) {
        boolean flag = true;
        try {
            flag = firstName.isEmpty()
                    || lastName.isEmpty()
                    || amount.isEmpty()
                    || firstName == null
                    || lastName == null
                    || amount == null;
        } catch (NullPointerException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        return flag;
    }
}
