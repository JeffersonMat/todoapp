package main.java.com.todoapp.observers;

public interface TaskObservable {
    void  addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}