package com.fitogram.org.stepdefinitions;

import com.fitogram.org.tasks.GetCommentsUserTask;
import com.fitogram.org.tasks.GetFetchDataUserTask;
import com.fitogram.org.tasks.GetPostsUserTask;
import com.fitogram.org.tasks.ValidateEmailFormatTask;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import net.serenitybdd.screenplay.actors.OnStage;

public class emailFormatValidationStepsDefinitions {


  @Given("that {word} is a user registered")
  public void isAUserRegistered(String actorName) {
    OnStage.theActorCalled(actorName).describedAs("A user from jsonplaceholder");
  }

  @When("the system fetch the user data")
  public void sheMadeCommentInApplication(List<String> userData) {
    OnStage.withCurrentActor(GetFetchDataUserTask.withData(userData));
  }

  @When("she wants to get all their posts and comments")
  public void elIntentaConsultarAlUsuarioEnLaTiendaPorUsername() {
    OnStage.withCurrentActor(GetPostsUserTask
        .withData());
    OnStage.withCurrentActor(GetCommentsUserTask
            .withData());
  }

  @Then("should be validated the e-mail format from the comments")
  public void elDeberiaPoderVerLosDatosDeLosUsuariosCorrectamente() {
    OnStage.withCurrentActor(ValidateEmailFormatTask
        .validate());
  }
}
