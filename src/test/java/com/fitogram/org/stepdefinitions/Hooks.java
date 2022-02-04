package com.fitogram.org.stepdefinitions;


import com.fitogram.org.actors.ApiCast;
import com.fitogram.org.constans.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Hooks {
    private EnvironmentVariables environmentVariables;

    @Before(value = "@jsonPlaceHolder", order = 0)
    public void settingTheStage() {
        SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();

        SerenityRest.filters(
            (filterableRequestSpecification, filterableResponseSpecification, filterContext) -> {
                Actor actor = OnStage.theActorInTheSpotlight();
                String header = actor.recall(Constants.COOKIE_FOR_HEADERS);
                if (header == null) {
                    filterableRequestSpecification.header("Cache-Control", "no-cache");
                    Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
                    Map<String, String> cookies = response.cookies();
                    List<String> l = cookies.entrySet().stream().map(entries -> entries.getKey() + "=" + entries.getValue()).map(String::trim).collect(Collectors.toList());
                    String cookie = String.join(";", l);
                    actor.remember(Constants.COOKIE_FOR_HEADERS, cookie);
                    return response;
                } else {
                    filterableRequestSpecification.header("Cookie", header).header("Cache-Control", "no-cache");
                    return filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
                }
            }
        );

        OnStage.setTheStage(
            new ApiCast(environmentVariables));
    }

    @After
    public void tearDown() {
        SerenityRest.reset();
    }
}
