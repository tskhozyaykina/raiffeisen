package ru.tkhozyaykina.steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SendRequestDefs {

    private Response response;

    @Тогда("^делаю GET запрос по path: \"([^\"]*)\" c params")
    public void sendPathParams(String path, Map<String, String> params) {
        String url = RestAssured.baseURI + path;

        RequestSpecification requestSpecification = given().relaxedHTTPSValidation();

        for (String key : params.keySet()) {
            requestSpecification.param(key, params.get(key));
        }

        response = requestSpecification.get(url);
    }


    @И("^прверяю что код ответа (\\d+)")
    public void checkStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @И("^прверяю что json содержит:$")
    public void checkJsonParam(Map<String, String> params) throws Throwable {
        for (String key : params.keySet()) {
            response.then().body(
                    key, equalTo(params.get(key))
            );
        }

    }

//
//    @Тогда("^делаю GET запрос по path: <дата> c params$")
//    public void делаюGETЗапросПоPathДатаCParams() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
