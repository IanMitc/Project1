package com.revature;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Manager extends Employee {
    @OneToMany(mappedBy = "processedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expensesProcessed;

    public List<Expense> getExpensesProcessed() {
        return expensesProcessed;
    }

    public void setExpensesProcessed(List<Expense> expensesProcessed) {
        this.expensesProcessed = expensesProcessed;
    }
}