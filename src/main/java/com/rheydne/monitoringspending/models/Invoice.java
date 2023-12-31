package com.rheydne.monitoringspending.models;

import java.time.LocalDate;

public class Invoice {

    private Long id;

    private LocalDate date;

    private String category;

    private String title;

    private double amount;

    private String type; // credit or debit

    private String operator; // bank or payment account
    
}
