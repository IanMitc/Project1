package com.revature.Classes;

import com.revature.Data.DaoFactory;
import com.revature.Data.EmployeeDAO;

import javax.persistence.*;
import java.util.Date;

@Table(name = "expense")
@Entity
public class Expense {
    @Column(name = "amount")
    private double amount;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_initiated")
    private Date dateInitiated;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "initiated_by_id", nullable = false)
    private Employee initiatedBy;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "memo")
    private String memo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_processed")
    private Date dateProcessed;
    @Column(name = "processor_memo")
    private String processorMemo;
    @Column(name = "approved")
    private boolean approved;
    @Column(name = "pending", nullable = false)
    private boolean pending;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "processed_by_id")
    private Manager processedBy;

    public Expense() {
    }

    public Expense(double amount, String memo, Employee initiatedBy) {
        this.amount = amount;
        this.memo = memo;
        this.initiatedBy = initiatedBy;
        this.pending = true;
        dateInitiated = new Date();
    }

    public Expense(double amount, String memo, int employeeID) {
        EmployeeDAO employeeDAO = DaoFactory.getEmployeeDAO();
        this.amount = amount;
        this.memo = memo;
        this.initiatedBy = employeeDAO.getEmployee(employeeID);
        this.pending = true;
        dateInitiated = new Date();
    }

    public Manager getProcessedBy() {
        return processedBy;
    }

    public Employee getInitiatedBy() {
        return initiatedBy;
    }

    public boolean isPending() {
        return pending;
    }

    public boolean isApproved() {
        return approved;
    }

    public String getProcessorMemo() {
        return processorMemo;
    }

    public void setProcessorMemo(String processorMemo) {
        this.processorMemo = processorMemo;
    }

    public Date getDateProcessed() {
        return dateProcessed;
    }

    public Date getDateInitiated() {
        return dateInitiated;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public void approveExpense(Manager processedBy, String processorMemo) {
        this.approved = true;
        this.pending = false;
        this.processorMemo = processorMemo;
        this.processedBy = processedBy;
        this.dateProcessed = new Date();
    }

    public void denyExpense(Manager processedBy, String processorMemo) {
        this.approved = false;
        this.pending = false;
        this.processorMemo = processorMemo;
        this.processedBy = processedBy;
        this.dateProcessed = new Date();
    }

}