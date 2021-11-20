package com.revature.Classes;

import com.revature.Data.DaoFactory;
import com.revature.Data.EmployeeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet  extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("The servlet is active");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        EmployeeDAO edao = DaoFactory.getEmployeeDAO();
        Employee employee = edao.getEmployee(username);

        if(employee == null){
            RequestDispatcher rd = request.getRequestDispatcher("/unsuccessfulLogin.html");
            rd.include(request, response);
        }else{
            if(employee.checkPassword(password)){
                HttpSession session = request.getSession();
                session.setAttribute("userId", employee.getId());
                session.setAttribute("name", employee.getName());
                session.setAttribute("username", username);

                RequestDispatcher rd;

                String testval = employee.getUserRole().name();
                if(testval.equals("MANAGER")) {
                    rd = request.getRequestDispatcher("/submissions_approval.jsp");
                } else{
                    rd = request.getRequestDispatcher("/submission_form.jsp");
                }
                rd.include(request, response);

            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/unsuccessfulLogin.html");
                rd.include(request, response);
            }



        }




    }

}
