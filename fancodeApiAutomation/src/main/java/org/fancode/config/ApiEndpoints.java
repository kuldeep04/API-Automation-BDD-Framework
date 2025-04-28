package org.fancode.config;

import lombok.Getter;

@Getter
public enum ApiEndpoints {

    user("/users"),
    todo("/todos");
    private final String path;

    ApiEndpoints(String path) {
        this.path = path;
    }

}
