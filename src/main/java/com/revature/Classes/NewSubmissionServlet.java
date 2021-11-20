package com.revature.Classes;

import com.revature.Data.DaoFactory;
import com.revature.Data.EmployeeDAO;
import com.revature.Data.ExpenseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewSubmissionServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get employee id from session
        int id = (Integer) request.getSession().getAttribute("userId");

        // Get the claim amount and memo as params
        Double amount = Double.parseDouble(request.getParameter("amount"));
        String memo = request.getParameter("memo");

        // Initialize an expense object
        ExpenseDAO exdao = DaoFactory.getExpenseDAO();
        Expense expense = new Expense(amount, memo, id);

        // Save the expense
        exdao.saveExpense(expense);

        // Send user back to claims submission page
        RequestDispatcher rd = request.getRequestDispatcher("/submission_form.jsp");
        rd.include(request, response);



    }
}
