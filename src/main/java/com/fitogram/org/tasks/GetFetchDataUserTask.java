package com.fitogram.org.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import com.fitogram.org.constans.Constants;
import com.fitogram.org.models.UserResponse.UserModelItem;
import io.restassured.http.ContentType;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class GetFetchDataUserTask implements Task {

  private final List<String> userData;

  public GetFetchDataUserTask(List<String> userData) {
    this.userData = userData;
  }

  public static GetFetchDataUserTask withData(List<String> userData) {
    return instrumented(GetFetchDataUserTask.class, userData);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            Get.resource("users?username="+userData.get(0)).with(request -> request
                    .contentType(ContentType.JSON)
            )
    );

    actor
          .should(seeThatResponse("Response should be 200", response -> response.statusCode(200)));
    actor.remember(Constants.USER_RESPONSE,actor.asksFor(LastResponse.received()).as(UserModelItem[].class));
  }
}
