package main.java.com.todoapp.observers;

public class NotificationService implements Observer {

    @Override
    public void update(String message) {

        System.out.println("notification: " + message);
    }
}
