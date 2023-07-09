package com.rheydne.monitoringspending.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rheydne.monitoringspending.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}
