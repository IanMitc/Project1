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

public class SubmissionsHistoryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get employee object using session id
        EmployeeDAO edao = DaoFactory.getEmployeeDAO();
        Employee employee = edao.getEmployee((Integer) request.getSession().getAttribute("userId"));

        // Get all submissions using employee object
        ExpenseDAO exdao = DaoFactory.getExpenseDAO();
        List<Expense> results = exdao.getExpenses(employee);

        // Filter for any expenses not pending
        ArrayList<Expense> pastclaims = new ArrayList<Expense>();
        for(Expense result : results) {
            if (!result.isPending()) {
                pastclaims.add(result);
            }

        }

            // TODO ADD CONDITION IF LIST EMPTY
            // Forward list of expenses to submissions_history page
            request.setAttribute("pastclaims", pastclaims);
            request.getRequestDispatcher("submissions_history.jsp").forward(request, response);

    }

}



