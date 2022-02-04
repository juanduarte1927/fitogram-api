package com.fitogram.org.tasks;

import com.fitogram.org.models.posts.PostsResponseItem;
import com.fitogram.org.constans.Constants;
import com.fitogram.org.models.comments.CommentsResponseItem;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetCommentsUserTask implements Task {


  public static GetCommentsUserTask withData() {
   return instrumented(GetCommentsUserTask.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    PostsResponseItem[] posts =  actor.recall(Constants.POSTS_RESPONSE);
    for(PostsResponseItem model : posts) {
      actor.attemptsTo(
              Get.resource("comments?postId=" + model.getId()).with(request -> request
                      .contentType(ContentType.JSON)
              )
      );
    }
    actor
        .should(seeThatResponse("The response should be 200", response -> response.statusCode(200)));
    actor.remember(Constants.COMMENTS_RESPONSE,actor.asksFor(LastResponse.received()).as(CommentsResponseItem[].class));

  }
}
