package p02_services.contracts;

public interface NotificationService {

    boolean isActive();

    void sendNotification();

    void activate();
}
