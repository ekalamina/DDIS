package ru.sbt.currencyService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.currencyService.DAO.CurrencyCrudRepository;
import ru.sbt.currencyService.DAO.Entity.Dollar;
import ru.sbt.currencyService.DTO.DollarListRequest;
import ru.sbt.currencyService.DTO.DollarListResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CurrencyService {

    private CurrencyCrudRepository currencyCrudRepository;

    private static final String CURRENCY_URL = "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=%s&date_req2=%s&VAL_NM_RQ=R01235";

    public DollarListResponse getCurrencysForLastNDays(int countDays) throws Exception {
        DollarListRequest response = new RestTemplate().getForObject(getCbrUrl(countDays), DollarListRequest.class);
        DollarListResponse dollarListResponse = new DollarListResponse();
        dollarListResponse.setDollarResponse(response.getDollarRequests());
        saveDollars(dollarListResponse);
        return dollarListResponse;
    }

    private String getCbrUrl(int countDays) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Long callTime = System.currentTimeMillis();
        String date2 = simpleDateFormat.format(new Date(callTime));
        String date1 = simpleDateFormat.format(new Date(callTime - countDays * 1000 * 60 * 60 * 24));
        return String.format(CURRENCY_URL,date1,date2);
    }

    private void saveDollars(DollarListResponse dollarListResponse) {
        dollarListResponse.getDollarResponses().forEach(dollarResponse -> {
            try {
                currencyCrudRepository.save(new Dollar(dollarResponse));
            } catch (Exception e){
                System.out.println("Line already exist in database");
            }
        });
    }

}
