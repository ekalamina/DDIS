package ru.sbt.currencyService.DAO;

import org.hibernate.hql.internal.ast.SqlASTFactory;
import org.springframework.jdbc.support.SQLErrorCodes;
import org.springframework.stereotype.Component;
import ru.sbt.currencyService.DAO.Entity.Dollar;
import ru.sbt.currencyService.DTO.DollarListResponse;

import javax.annotation.Resource;
import java.sql.SQLException;

@Component
public class CurrencyDAO {

    @Resource
    public CurrencyCrudRepository currencyCrudRepository;

    public void saveDollars(DollarListResponse dollarListResponse) {
        dollarListResponse.getDollarResponses().forEach(dollarResponse -> {
                try {
                    currencyCrudRepository.save(new Dollar(dollarResponse));
                } catch (Exception e){
                    System.out.println("Line already exist in database");
                }
        });
    }

}
