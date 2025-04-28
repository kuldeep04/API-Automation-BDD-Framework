package org.fancode.service;

import io.qameta.allure.Step;
import org.fancode.client.ApiClient;
import org.fancode.config.ApiEndpoints;
import org.fancode.models.todos.Todo;
import org.fancode.utilities.logging.LoggingUtils;
import org.slf4j.Logger;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TodoRequest implements Service<Todo> {

    private static final Logger logger = LoggingUtils.getLogger(TodoRequest.class);
    private final ApiClient apiClient;

    public TodoRequest() throws IOException {
        this.apiClient = new ApiClient();
    }

    @Override
    @Step("Fetching all todos from /todos API")
    public Todo[] getAll() {
        logger.info("Fetching all todos from endpoint: {}", ApiEndpoints.valueOf("todo").getPath());
        return apiClient.get(ApiEndpoints.valueOf("todo").getPath(), Todo[].class);
    }

    @Step("Grouping todos by userId")
    public Map<Integer, List<Todo>> getTodosGroupedByUser() {
        logger.info("Grouping all todos based on userId...");
        Todo[] allTodos = getAll();

        Map<Integer, List<Todo>> todosGroupedByUser = Arrays.stream(allTodos)
                .collect(Collectors.groupingBy(Todo::getUserId));

        logger.info("Total users found with todos: {}", todosGroupedByUser.size());
        return todosGroupedByUser;
    }

    @Step("Calculating if userId {0} has completed more than 50% todos")
    public boolean isUserCompletionAbove50(int userId, List<Todo> todos) {
        if (todos == null || todos.isEmpty()) {
            logger.warn("No todos found for userId: {}", userId);
            return false;
        }

        long completedCount = todos.stream().filter(Todo::isCompleted).count();
        double completionPercentage = (completedCount * 100.0) / todos.size();

        logger.info("UserId: {}, Completed: {}, Total: {}, Completion %: {}",
                userId, completedCount, todos.size(), completionPercentage);

        return completionPercentage > 50.0;
    }
}
