package main.java.com.todoapp.models;
import main.java.com.todoapp.observers.Observer;

import java.util.ArrayList;
import java.util.List;
public class HighPriorityTask implements Task {
    private String description;
    private boolean done;
    private final boolean highPriority = true;
    private List<Observer> observers = new ArrayList<Observer>();
    public HighPriorityTask(String description) {
        this.description = description;
        this.done = false;
    }

    @Override
    public String getDescription(){
        return description + " [High Priority]";
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void markAsDone(){
    this.done = true;
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
    public void  notifyObservers(String message){
        for(Observer observer : observers){
            observer.update(message);
        }
    }

}