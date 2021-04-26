package weatherservice;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WeatherControllerTest {
    @Autowired
    private WeatherController weatherController;
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private ApplicationContext context;

    @Before
    public void beforeTest() {
        context.getBean("WeatherService");
    }

    @Test
    public void testGetWeathersForLastNDays() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/weather/getWeathersForLastNDays/{countDays}/{city}", 1, "U://U@[9U]:9{UUU}U?U#U", null);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.weatherController).build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

   // @Test
//    public void testGetWeathersForLastNDays2() throws Exception {
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get("/weather/getWeathersForLastNDays/{countDays}/{city}", 0, 0, null);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.weatherController).build()
//                .perform(requestBuilder);
//        ResultActions resultActions = actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk());
//        ResultActions resultActions1 = resultActions
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
//        Matcher<String> matcher = Matchers.containsString("[]");
//        resultActions1.andExpect(MockMvcResultMatchers.content().string(matcher));
//    }

//    @Test
//    public void testGetWeathersForLastNDays3() throws Exception {
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get("/weather/getWeathersForLastNDays/{countDays}/{city}", null, 0, null);
//        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.weatherController).build()
//                .perform(requestBuilder);
//        ResultActions resultActions = actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk());
//        ResultActions resultActions1 = resultActions
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
//        Matcher<String> matcher = Matchers.containsString("[]");
//        resultActions1.andExpect(MockMvcResultMatchers.content().string(matcher));
//    }
}

