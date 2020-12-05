package ru.sbt.currencyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.currencyService.DAO.CurrencyCrudRepository;
import ru.sbt.currencyService.DAO.Entity.Dollar;
import ru.sbt.currencyService.DTO.DollarRequest;
import ru.sbt.currencyService.DTO.DollarResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CurrencyService {

    @Autowired
    private RestTemplate restTemplate;

    private static Logger logger;

    private CurrencyCrudRepository currencyCrudRepository;

    private static final String CURRENCY_URL = "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=%s&date_req2=%s&VAL_NM_RQ=R01235";

    public List<DollarResponse> getCurrencysForLastNDays(int countDays) {
        ArrayList<DollarRequest> requestList = restTemplate.getForObject(getCbrUrl(countDays), ArrayList.class);
        ArrayList<DollarResponse> responseList = new ArrayList<>();
        if (requestList != null) {
            requestList.forEach(dollarRequest -> {
                DollarResponse dollarResponse = new DollarResponse();
                dollarResponse.setValue(dollarRequest.getValue());
                dollarResponse.setDate(dollarRequest.getDate());
                responseList.add(dollarResponse);
            });
        }
        saveDollars(responseList);
        return responseList;
    }


    private String getCbrUrl(int countDays) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Long callTime = System.currentTimeMillis();
        String date2 = simpleDateFormat.format(new Date(callTime));
        String date1 = simpleDateFormat.format(new Date(callTime - countDays * 1000 * 60 * 60 * 24));
        return String.format(CURRENCY_URL, date1, date2);
    }

    private void saveDollars(Collection<DollarResponse> dollarListResponse) {
        dollarListResponse.forEach(dollarResponse -> {
            try {
                currencyCrudRepository.save(new Dollar(dollarResponse));
            } catch (Exception e) {
                logger.info("Line already exist in database");
            }
        });
    }

}
