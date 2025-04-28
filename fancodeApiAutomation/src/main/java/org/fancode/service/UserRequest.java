package org.fancode.service;

import io.qameta.allure.Step;
import org.fancode.client.ApiClient;
import org.fancode.config.ApiEndpoints;
import org.fancode.models.users.User;
import org.fancode.utilities.logging.LoggingUtils;
import org.slf4j.Logger;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserRequest implements Service<User> {

    private static final Logger logger = LoggingUtils.getLogger(UserRequest.class);
    private final ApiClient apiClient;

    public UserRequest() throws IOException {
        this.apiClient = new ApiClient();
    }

    @Override
    @Step("Fetching all users from /users API")
    public User[] getAll() {
        logger.info("Fetching all users from endpoint: {}", ApiEndpoints.valueOf("user").getPath());
        return apiClient.get(ApiEndpoints.valueOf("user").getPath(), User[].class);
    }

    @Step("Fetching users who belong to FanCode city")
    public List<User> getFanCodeUsers() {
        logger.info("Filtering FanCode users based on lat/lng criteria...");
        User[] allUsers = getAll();

        List<User> fanCodeUsers = Arrays.stream(allUsers)
                .filter(user -> {
                    double lat = Double.parseDouble(user.getAddress().getGeo().getLat());
                    double lng = Double.parseDouble(user.getAddress().getGeo().getLng());
                    return lat > -40 && lat < 5 && lng > 5 && lng < 100;
                })
                .collect(Collectors.toList());

        logger.info("Total FanCode users found: {}", fanCodeUsers.size());
        return fanCodeUsers;
    }
}
