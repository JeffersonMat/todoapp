package main.java.com.todoapp.models;

import main.java.com.todoapp.observers.Observer;

import java.util.ArrayList;
import java.util.List;

public  class StandardTask implements Task  {
private String description;
private boolean done;
private final List<Observer> observers = new ArrayList<Observer>();

public StandardTask(String description, boolean done) {
    this.description = description;
    this.done = false;
}

@Override
public String getDescription(){
    return description;
}

@Override
    public boolean isDone(){
    return done;
}

@Override
    public void markAsDone(){
    this.done = true;
    notifyObservers("Task '" + description + "' has been marked as done") ;
}

@Override
    public  void addObserver(Observer observer) {
    observers.add(observer);
}

@Override
    public void removeObserver(Observer observer) {
    observers.remove(observer);
}

@Override
    public void notifyObservers(String Message){
    for (Observer observer : observers) {
        observer.update(Message);
    }
}
}