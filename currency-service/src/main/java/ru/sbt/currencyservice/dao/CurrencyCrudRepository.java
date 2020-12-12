package ru.sbt.currencyservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbt.currencyservice.dao.entity.Dollar;

@Repository
public interface CurrencyCrudRepository extends CrudRepository<Dollar, Long> {
}
