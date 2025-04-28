package org.fancode.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.fancode.models.todos.Todo;
import org.fancode.models.users.User;
import org.fancode.service.TodoRequest;
import org.fancode.service.UserRequest;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ValidateUsersTodosTasks {

    private UserRequest userRequest;
    private TodoRequest todoRequest;
    private List<User> fanCodeUsers;
    private Map<Integer, List<Todo>> todosGrouped;

    @Given("I fetch all the users belonging to FanCode city")
    public void iFetchAllFanCodeUsers() throws IOException {
        userRequest = new UserRequest();
        fanCodeUsers = userRequest.getFanCodeUsers();
    }

    @Given("I fetch all todos grouped by userId")
    public void iFetchAllTodosGroupedByUser() throws IOException {
        todoRequest = new TodoRequest();
        todosGrouped = todoRequest.getTodosGroupedByUser();
    }

    @Then("I verify that each FanCode user has completed more than 50% of their todos")
    public void iVerifyFanCodeUserTodoCompletion() {
        for (User user : fanCodeUsers) {
            List<Todo> userTodos = todosGrouped.get(user.getId());
            Assert.assertTrue(
                    todoRequest.isUserCompletionAbove50(user.getId(), userTodos),
                    "User ID " + user.getId() + " has not completed more than 50% todos."
            );
        }
    }
}
