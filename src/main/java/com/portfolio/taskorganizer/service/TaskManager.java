package com.portfolio.taskorganizer.service;

import com.portfolio.taskorganizer.model.Task;
import com.portfolio.taskorganizer.model.TaskStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskManager {

    public void startTask(Task task) {
        if (task.getStatus() == TaskStatus.TODO) {
            task.setStatus(TaskStatus.IN_PROGRESS);
        } else if (task.getStatus() == TaskStatus.COMPLETED) {
            throw new IllegalStateException("Cannot start a task that is already COMPLETED.");
        } else {
            // Task is already IN_PROGRESS (idempotent / no-op)
        }
    }

    public void completeTask(Task task) {
        if (task.getStatus() == TaskStatus.IN_PROGRESS) {
            task.setStatus(TaskStatus.COMPLETED);
        } else if (task.getStatus() == TaskStatus.TODO) {
            throw new IllegalStateException("Task must be set to IN_PROGRESS before it can be COMPLETED.");
        } else {
            // Task is already COMPLETED (idempotent / no-op)
        }
    }

    public void reopenTask(Task task) {
        if (task.getStatus() == TaskStatus.COMPLETED) {
            task.setStatus(TaskStatus.IN_PROGRESS);
        } else {
            throw new IllegalStateException("Only COMPLETED tasks can be reopened.");
        }
    }
}