# Phase 1.3: Task State & Transition Pseudocode
*Purpose: Reference guide for task state transitions and validation logic.*

## 1. Task Status Definitions (Enum)
```text
ENUM TaskStatus:
    TODO          // Newly created task, not yet started
    IN_PROGRESS   // Currently actively being worked on
    COMPLETED     // Finished task
```
## 2. Core Task Data Model
```text
    CLASS Task:
    ATTRIBUTES:
        id: String
        title: String
        description: String
        status: TaskStatus

    CONSTRUCTOR(id, title, description):
        this.id = id
        this.title = title
        this.description = description
        this.status = TaskStatus.TODO  // Default state on creation
``` 
# 3.Shift Logic & State Transition Rules
```text
        CLASS TaskManager:

    METHOD startTask(task):
        IF task.status EQUALS TaskStatus.TODO THEN
            task.status = TaskStatus.IN_PROGRESS
            PRINT "Task successfully updated to IN_PROGRESS."
        ELSE IF task.status EQUALS TaskStatus.COMPLETED THEN
            PRINT "Error: Cannot start a task that is already COMPLETED."
        ELSE
            PRINT "Info: Task is already IN_PROGRESS."

    METHOD completeTask(task):
        IF task.status EQUALS TaskStatus.IN_PROGRESS THEN
            task.status = TaskStatus.COMPLETED
            PRINT "Task successfully updated to COMPLETED."
        ELSE IF task.status EQUALS TaskStatus.TODO THEN
            PRINT "Error: Task must be set to IN_PROGRESS before it can be COMPLETED."
        ELSE
            PRINT "Info: Task is already COMPLETED."

    METHOD reopenTask(task):
        IF task.status EQUALS TaskStatus.COMPLETED THEN
            task.status = TaskStatus.IN_PROGRESS
            PRINT "Task reopened and set back to IN_PROGRESS."
        ELSE
            PRINT "Error: Only COMPLETED tasks can be reopened."

