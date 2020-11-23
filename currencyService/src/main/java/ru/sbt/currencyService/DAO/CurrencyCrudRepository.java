package ru.sbt.currencyService.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbt.currencyService.DAO.Entity.Dollar;

@Repository
public interface CurrencyCrudRepository extends CrudRepository<Dollar, Long> {
}
