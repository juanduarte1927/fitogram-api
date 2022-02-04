package com.fitogram.org.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.junit.Assert.assertTrue;
import com.fitogram.org.constans.Constants;
import org.apache.commons.validator.routines.EmailValidator;
import com.fitogram.org.models.comments.CommentsResponseItem;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ValidateEmailFormatTask implements Task {

  public static ValidateEmailFormatTask validate() {
    return instrumented(ValidateEmailFormatTask.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
      CommentsResponseItem[] posts =  actor.recall(Constants.COMMENTS_RESPONSE);

      EmailValidator validator = EmailValidator.getInstance();
      for(CommentsResponseItem model : posts) {
          assertTrue(validator.isValid(model.getEmail()));
      }
  }
}
