package com.rheydne.monitoringspending.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rheydne.monitoringspending.models.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {
    
}
