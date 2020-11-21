package ru.sbt.currencyService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.currencyService.DTO.DollarResponse;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping(value = "/getCurrencysForLastNDays/{countDays}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DollarResponse> getCurrencysForLastNDays(@PathVariable int countDays) throws Exception {
        return currencyService.getCurrencysForLastNDays(countDays).getDollarResponses();
    }

}
