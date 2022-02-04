package com.fitogram.org.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import com.fitogram.org.constans.Constants;
import com.fitogram.org.models.UserResponse.UserModelItem;
import com.fitogram.org.models.posts.PostsResponseItem;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class GetPostsUserTask implements Task {

  public static GetPostsUserTask withData() {
   return instrumented(GetPostsUserTask.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
   UserModelItem[] user =  actor.recall(Constants.USER_RESPONSE);
    for(UserModelItem model : user) {
      actor.attemptsTo(
              Get.resource("posts?userId=" + model.getId()).with(request -> request
                      .contentType(ContentType.JSON)
              )
      );
    }

    actor
        .should(seeThatResponse("The response should be 200", response -> response.statusCode(200)));
    actor.remember(Constants.POSTS_RESPONSE,actor.asksFor(LastResponse.received()).as(PostsResponseItem[].class));

  }
}
