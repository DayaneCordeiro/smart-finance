package com.example.smartfinance.dataprovider.database.repository;

import com.example.smartfinance.dataprovider.database.entity.IncomeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IncomeRepository extends MongoRepository<IncomeEntity, String> {

    Optional<IncomeEntity> findByIdAndConsumerId(String id, String consumerId);

    Set<IncomeEntity> findByDateAndConsumerId(LocalDate date, String consumerId);
}
