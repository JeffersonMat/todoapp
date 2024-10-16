package main.java.com.todoapp.models;
import main.java.com.todoapp.observers.TaskObservable;
public interface Task  extends TaskObservable {
    String getDescription();
    boolean isDone();
    void markAsDone();
}