package main.java.com.todoapp.models;

import main.java.com.todoapp.observers.Observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReminderTask implements Task {
    private String description;
    private boolean done;
    private LocalDateTime reminderTime;
    private List<Observer> observers = new ArrayList<>();
    public ReminderTask(String description, boolean done, LocalDateTime reminderTime) {
        this.description = description;
        this.done = false;
        this.reminderTime = reminderTime;
    }

    @Override
    public String getDescription() {
        return description + " [Reminder " + reminderTime + "]";
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void markAsDone() {
        this.done = true;
        notifyObservers("Task '" + description + "' has been marked as done at " + reminderTime ) ;

    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}