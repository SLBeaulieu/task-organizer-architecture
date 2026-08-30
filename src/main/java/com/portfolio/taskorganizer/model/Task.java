package com.portfolio.taskorganizer.model;

public class Task {
    private String id;
    private String title;
    private TaskStatus status;

    public Task(String id, String title) {
        this.id = id;
        this.title = title;
        this.status = TaskStatus.TODO;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // Shift logic for state transitions
    public void advanceStatus() {
        if (this.status == TaskStatus.TODO) {
            this.status = TaskStatus.IN_PROGRESS;
        } else if (this.status == TaskStatus.IN_PROGRESS) {
            this.status = TaskStatus.COMPLETED;
        }
    }
}