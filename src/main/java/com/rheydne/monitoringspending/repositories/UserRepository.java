package com.rheydne.monitoringspending.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rheydne.monitoringspending.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
