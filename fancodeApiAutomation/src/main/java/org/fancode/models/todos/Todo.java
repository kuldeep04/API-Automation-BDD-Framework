package org.fancode.models.todos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
