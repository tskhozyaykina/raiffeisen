package ru.tkhozyaykina.steps;

import cucumber.api.java.ru.Когда;
import io.restassured.RestAssured;
import ru.tkhozyaykina.utils.Log4jRestAssuredFilter;

public class EnableLogDefs {

    private static boolean enable = false;

    @Когда("^Указываю базовый url: \"([^\"]*)\" и включаю логирование$")
    public void beforeClass(String baseUrl) {
        if (!enable) {
            RestAssured.filters(
                    new Log4jRestAssuredFilter()
            );
            enable = true;
        }

        RestAssured.baseURI = baseUrl;
    }
}
