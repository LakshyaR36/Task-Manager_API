package com.vishal.taskmanager.dto;

import com.vishal.taskmanager.entity.Priority;
import com.vishal.taskmanager.entity.Status;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskRequest {

    private String title;

    private String description;

    private Priority priority;

    private Status status;

    private LocalDate dueDate;
}