package com.revature.Classes;

import com.revature.Data.DaoFactory;
import com.revature.Data.ExpenseDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubmissionsAllServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get all submissions using employee object
        ExpenseDAO exdao = DaoFactory.getExpenseDAO();
        List<Expense> results = exdao.getExpenses();

        // Filter for any expenses not pending
        ArrayList<Expense> allclaims = new ArrayList<Expense>();
        for(Expense result : results) {
            if (!result.isPending()) {
                allclaims.add(result);
                //System.out.println(result.getInitiatedBy());
            }

        }

        // TODO ADD CONDITION IF LIST EMPTY
        // Forward list of expenses to submissions_history page
        request.setAttribute("allclaims", allclaims);
        request.getRequestDispatcher("submissions_all.jsp").forward(request, response);

    }


}
