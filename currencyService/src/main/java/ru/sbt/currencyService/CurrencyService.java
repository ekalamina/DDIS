package ru.sbt.currencyService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.currencyService.DAO.CurrencyDAO;
import ru.sbt.currencyService.DTO.DollarListResponse;
import ru.sbt.currencyService.DTO.DollarRequest;
import ru.sbt.currencyService.DTO.DollarListRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CurrencyService {

    private CurrencyDAO currencyDAO;

    public CurrencyService(CurrencyDAO currencyDAO){
        this.currencyDAO = currencyDAO;
    }

    public DollarListResponse getCurrencysForLastNDays(int countDays) throws Exception {
        checkCountDays(countDays);
        DollarListRequest response = new RestTemplate().getForObject(getCbrUrl(countDays), DollarListRequest.class);
        DollarListResponse dollarListResponse = new DollarListResponse();
        dollarListResponse.setDollarResponse(response.getDollarRequests());
        currencyDAO.saveDollars(dollarListResponse);
        return dollarListResponse;
    }

    //Можно выделить в отдельный класс ParametersChecker,
    //но кроме даты тут нечего проверять, поэтому оставила тут.
    private void checkCountDays(int countDays) throws Exception {
        if (countDays < 0) {
            throw new Exception();
        }
    }

    private String getCbrUrl(int countDays) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Long callTime = System.currentTimeMillis();
        String date2 = simpleDateFormat.format(new Date(callTime));
        String date1 = simpleDateFormat.format(new Date(callTime - countDays * 1000 * 60 * 60 * 24));
        return "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=" + date1 + "&date_req2=" + date2 + "&VAL_NM_RQ=R01235";
    }

}
