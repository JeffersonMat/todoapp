package main.java.com.todoapp.factories;

import main.java.com.todoapp.models.Task;
import main.java.com.todoapp.models.StandardTask;
import main.java.com.todoapp.models.HighPriorityTask;
import main.java.com.todoapp.models.ReminderTask;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Supplier;
public class TaskFactory {
    private static final Map<String, Supplier<Task>> taskRegistry = new HashMap<>();

   static {
       taskRegistry.put("standard", () -> new StandardTask("Default Standard Task", false));
       taskRegistry.put("highpriority", ()-> new HighPriorityTask("Default High Priority"));
       taskRegistry.put("reminder", ()-> new ReminderTask("Default Reminder", false, LocalDateTime.now()));
   }

   public static Task getTask(String type, String description) {
       Supplier<Task> supplier = taskRegistry.get(type.toLowerCase());
       if (supplier != null) {
           Task task = supplier.get();
           task.getDescription();
           return task;
       }
       throw new IllegalArgumentException("Invalid task type:  " + type );
   }

}