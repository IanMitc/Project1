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

public class SubmissionsPendingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get employee object using session id
        EmployeeDAO edao = DaoFactory.getEmployeeDAO();
        Employee employee = edao.getEmployee((Integer) request.getSession().getAttribute("userId"));

        // Get all submissions using employee object
        ExpenseDAO exdao = DaoFactory.getExpenseDAO();
        List<Expense> results = exdao.getPendingExpenses(employee);

        // Filter for any expenses not pending
        ArrayList<Expense> pendingclaims = (ArrayList<Expense>) results;

        // TODO ADD CONDITION IF LIST EMPTY
        // Forward list of expenses to submissions_history page
        request.setAttribute("pendingclaims", pendingclaims);
        request.getRequestDispatcher("submissions_pending.jsp").forward(request, response);

    }

}
