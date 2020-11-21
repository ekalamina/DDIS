package ru.sbt.currencyService.DAO;

import org.springframework.stereotype.Repository;
import ru.sbt.currencyService.DTO.DollarResponse;

@Repository
public class CurrencyCrudRepository extends CrudRepository<DollarResponse, Long> {
}
