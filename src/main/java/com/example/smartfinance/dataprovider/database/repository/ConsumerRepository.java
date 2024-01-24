package com.example.smartfinance.dataprovider.database.repository;

import com.example.smartfinance.dataprovider.database.entity.ConsumerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends MongoRepository<ConsumerEntity, String> {
}
