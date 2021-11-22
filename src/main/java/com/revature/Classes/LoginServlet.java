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
        //System.out.println("The servlet is active");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // fetch an employee obj from the database with login username
        EmployeeDAO edao = DaoFactory.getEmployeeDAO();
        Employee employee = edao.getEmployee(username);


        if(employee == null){
            // if no matching username found send to re-login page
            RequestDispatcher rd = request.getRequestDispatcher("/unsuccessfulLogin.html");
            rd.include(request, response);
        }else{
            // if a username matches check password
            if(employee.checkPassword(password)){

                // if password matches, set session info
                HttpSession session = request.getSession();
                session.setAttribute("userId", employee.getId());
                session.setAttribute("name", employee.getName());
                session.setAttribute("username", username);
                session.setAttribute("password", password);

                //RequestDispatcher rd;

                // test whether user is employee or manager
                String testval = employee.getUserRole().name();
                if(testval.equals("MANAGER")) {
                    session.setAttribute("role", "manager");
                    //if manager forward to expense submissions approval page
                    response.sendRedirect("SubmissionsPendingAll");
                } else{
                    session.setAttribute("role", "employee");
                    // if employee forward to expense submission page
                    RequestDispatcher rd;
                    rd = request.getRequestDispatcher("/submission_form.jsp");
                    rd.include(request, response);
                }


            }else{
                // if no match for password send to re-login page
                RequestDispatcher rd = request.getRequestDispatcher("/unsuccessfulLogin.html");
                rd.include(request, response);
            }

        }

    }

}
