package com.revature;

import javax.persistence.*;
import java.util.Date;

@Table(name = "expense")
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "memo")
    private String memo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_initiated")
    private Date dateInitiated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_processed")
    private Date dateProcessed;

    @Column(name = "processor_memo")
    private String processorMemo;

    @Column(name = "approved", nullable = false)
    private boolean approved;

    @Column(name = "pending", nullable = false)
    private boolean pending;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "initiated_by_idx", nullable = false)
    private Employee initiatedBy;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "processed_by_idx")
    private Manager processedBy;

    public Manager getProcessedBy() {
        return processedBy;
    }

    public Employee getInitiatedBy() {
        return initiatedBy;
    }

    public boolean getPending() {
        return pending;
    }

    public boolean getApproved() {
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

}