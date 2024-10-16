package main.java.com.todoapp;

import main.java.com.todoapp.factories.TaskFactory;
import main.java.com.todoapp.models.Task;
import main.java.com.todoapp.observers.NotificationService;

public class TodoApp {
    public static void main(String[] args) {
        Task standardTask = TaskFactory.getTask("standard", "DO SOMETHING --STANDARD");
        NotificationService notificationService = new NotificationService();

        standardTask.addObserver(notificationService);
        standardTask.markAsDone();

//        Task highPriorityTask = TaskFactory.getTask("highPriority", "DO SOMETHING --HIGH PRIORITY");
//        Task reminderTask = TaskFactory.getTask("reminder", "DO SOMETHING --REMINDER");
//
//        System.out.println(standardTask.getDescription());
//        System.out.println(highPriorityTask.getDescription());
//        System.out.println(reminderTask.getDescription());
    }
}