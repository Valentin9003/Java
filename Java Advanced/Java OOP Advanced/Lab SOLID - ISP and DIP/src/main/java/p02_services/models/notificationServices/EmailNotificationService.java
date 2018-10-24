package p02_services.models.notificationServices;

public class EmailNotificationService extends BaseNotificationService {

    public EmailNotificationService(boolean isActive) {
        super(isActive);
    }

    @Override
    public void sendNotification() {
        //Writing just for test
        System.out.println("Email sending...");
    }
}
