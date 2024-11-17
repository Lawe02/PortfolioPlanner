package org.example.stockapi.repository;

import org.example.stockapi.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends ListCrudRepository<Stock, String> {
    Stock findBySymbol(String s);
}
