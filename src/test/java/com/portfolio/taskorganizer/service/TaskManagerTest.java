package com.portfolio.taskorganizer.service;

import com.portfolio.taskorganizer.model.Task;
import com.portfolio.taskorganizer.model.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Phase 1.4: State Machine Unit Testing")
class TaskManagerTest {

    private TaskManager taskManager;
    private Task task;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        task = new Task("TASK-101", "Shift Handover", "Complete daily shift log report");
    }

    @Test
    @DisplayName("New task initializes with TODO status")
    void testInitialStatusIsTodo() {
        assertEquals(TaskStatus.TODO, task.getStatus());
    }

    @Nested
    @DisplayName("Valid Transitions (Happy Path)")
    class ValidTransitions {

        @Test
        @DisplayName("startTask transitions TODO -> IN_PROGRESS")
        void testStartTaskFromTodo() {
            taskManager.startTask(task);
            assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        }

        @Test
        @DisplayName("completeTask transitions IN_PROGRESS -> COMPLETED")
        void testCompleteTaskFromInProgress() {
            taskManager.startTask(task);
            taskManager.completeTask(task);
            assertEquals(TaskStatus.COMPLETED, task.getStatus());
        }

        @Test
        @DisplayName("reopenTask transitions COMPLETED -> IN_PROGRESS")
        void testReopenCompletedTask() {
            taskManager.startTask(task);
            taskManager.completeTask(task);
            
            taskManager.reopenTask(task);
            assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        }

        @Test
        @DisplayName("startTask on an IN_PROGRESS task remains IN_PROGRESS")
        void testStartTaskIdempotency() {
            taskManager.startTask(task);
            taskManager.startTask(task);
            assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        }

        @Test
        @DisplayName("completeTask on a COMPLETED task remains COMPLETED")
        void testCompleteTaskIdempotency() {
            taskManager.startTask(task);
            taskManager.completeTask(task);
            taskManager.completeTask(task);
            assertEquals(TaskStatus.COMPLETED, task.getStatus());
        }
    }

    @Nested
    @DisplayName("Invalid Transitions (Guardrail Enforcement)")
    class InvalidTransitions {

        @Test
        @DisplayName("Cannot complete a task directly from TODO")
        void testCannotCompleteFromTodo() {
            IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> taskManager.completeTask(task)
            );
            assertTrue(exception.getMessage().contains("must be set to IN_PROGRESS"));
        }

        @Test
        @DisplayName("Cannot start a task that is already COMPLETED")
        void testCannotStartFromCompleted() {
            taskManager.startTask(task);
            taskManager.completeTask(task);

            IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> taskManager.startTask(task)
            );
            assertTrue(exception.getMessage().contains("already COMPLETED"));
        }

        @Test
        @DisplayName("Cannot reopen a task in TODO status")
        void testCannotReopenFromTodo() {
            IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> taskManager.reopenTask(task)
            );
            assertTrue(exception.getMessage().contains("Only COMPLETED tasks"));
        }

        @Test
        @DisplayName("Cannot reopen a task currently IN_PROGRESS")
        void testCannotReopenFromInProgress() {
            taskManager.startTask(task);

            IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> taskManager.reopenTask(task)
            );
            assertTrue(exception.getMessage().contains("Only COMPLETED tasks"));
        }
    }
}