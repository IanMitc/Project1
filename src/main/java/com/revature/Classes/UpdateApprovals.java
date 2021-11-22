package com.revature.Classes;

import com.revature.Data.DaoFactory;
import com.revature.Data.EmployeeDAO;
import com.revature.Data.ExpenseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateApprovals extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("Servlet called from form");

        // Testing info assembly
        HttpSession session = request.getSession();

        int id = (Integer)session.getAttribute("userId");
        String name = (String)session.getAttribute("name");
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");

        System.out.println("Name: " + name);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        String memo = request.getParameter("memo");
        int expenseId = Integer.parseInt(request.getParameter("expenseId"));
        Boolean approved = Boolean.parseBoolean(request.getParameter("approved"));

        System.out.println("Memo: " + memo);
        System.out.println("Expense ID: " + expenseId);
        System.out.println("Approval status: " + approved);

        ExpenseDAO exdao = DaoFactory.getExpenseDAO();
        EmployeeDAO edao = DaoFactory.getEmployeeDAO();
        Manager manager = (Manager)edao.getEmployee(id);
        Expense expense = exdao.getExpense(expenseId);

        if(approved){
            expense.approveExpense(manager, memo);
        }else{
            expense.denyExpense(manager, memo);
        }

        exdao.updateExpense(expense);
        //response.sendRedirect("SubmissionsPendingAll");
    }
}
