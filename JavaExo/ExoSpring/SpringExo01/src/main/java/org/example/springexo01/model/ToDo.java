package org.example.springexo01.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Getter, Setter & ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class ToDo {
    private String name;
    private String description;
    private boolean isDone;



}
