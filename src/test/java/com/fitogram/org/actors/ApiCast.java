package com.fitogram.org.actors;

import com.fitogram.org.TestEnvironments;
import com.fitogram.org.constans.Constants;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class ApiCast extends Cast {
    private final TestEnvironments testEnvironments;

    public ApiCast(EnvironmentVariables environmentVariables) {
        this.testEnvironments = new TestEnvironments(environmentVariables);
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        Actor theActor = null;
        theActor = super.actorNamed(actorName, CallAnApi.at(testEnvironments.getRestBaseUrl())).describedAs("User registered in the platform");
        theActor.remember(Constants.CACHE_FOR_HEADERS, testEnvironments.getCacheForHeaders());
        theActor.remember(Constants.REST_BASE_URL, testEnvironments.getRestBaseUrl());
        theActor.remember(Constants.HOST_FOR_HEADERS, testEnvironments.getHostForHeaders());

        return theActor;
    }
}
