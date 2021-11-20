package com.revature.Classes;

import com.revature.Data.DaoFactory;
import com.revature.Data.EmployeeDAO;
import com.revature.Data.ExpenseDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubmissionsPendingAll extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get all submissions
        ExpenseDAO exdao = DaoFactory.getExpenseDAO();
        List<Expense> results = exdao.getPendingExpenses();
        System.out.println(results.size());

        // Filter for any expenses not pending
        ArrayList<Expense> allpendingclaims = (ArrayList<Expense>) results;

        // TODO ADD CONDITION IF LIST EMPTY
        // Forward list of expenses to submissions_history page
        request.setAttribute("allpendingclaims", allpendingclaims);
        request.getRequestDispatcher("submissions_approval.jsp").forward(request, response);

    }

}
