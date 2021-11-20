package com.revature.Data;

import com.revature.Classes.Employee;
import com.revature.Classes.Expense;
import com.revature.Classes.Manager;

import java.util.List;

public interface ExpenseDAO {
    List<Expense> getExpenses();

    List<Expense> getExpenses(Employee employee);

    List<Expense> getDeclinedExpenses(Employee employee);

    List<Expense> getPendingExpenses(Employee employee);

    List<Expense> getPendingExpenses();

    List<Expense> getExpensesProcessedBy(Manager manager);

    Expense getExpense(int id);

    void saveExpense(Expense expense);

    void updateExpense(Expense expense);

    void saveExpenses(List<Expense> expenses);

    void updateExpenses(List<Expense> expenses);

    void close();
}
