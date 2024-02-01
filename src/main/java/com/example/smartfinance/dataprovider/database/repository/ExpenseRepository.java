package com.example.smartfinance.dataprovider.database.repository;

import com.example.smartfinance.dataprovider.database.entity.ExpenseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends MongoRepository<ExpenseEntity, String> {

    Optional<ExpenseEntity> getByIdAndConsumerId(String id, String consumerId);
}
