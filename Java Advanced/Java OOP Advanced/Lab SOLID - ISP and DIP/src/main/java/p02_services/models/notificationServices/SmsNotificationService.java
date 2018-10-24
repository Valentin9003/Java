package p02_services.models.notificationServices;

public class SmsNotificationService extends BaseNotificationService {


    public SmsNotificationService(boolean isActive) {
        super(isActive);
    }

    @Override
    public void sendNotification() {
        //Writing just for test
        System.out.println("SMS sending...");
    }
}
