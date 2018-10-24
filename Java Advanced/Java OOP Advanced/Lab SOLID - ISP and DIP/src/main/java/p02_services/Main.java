package p02_services;

import p02_services.contracts.Notificatable;
import p02_services.contracts.NotificationService;
import p02_services.models.OnlineStoreOrder;
import p02_services.models.notificationServices.EmailNotificationService;
import p02_services.models.notificationServices.SmsNotificationService;

public class Main {
    public static void main(String[] args) {

        NotificationService smsNotification = new SmsNotificationService(true);
        NotificationService emailNotification = new EmailNotificationService(true);

        Notificatable storeOrder = new OnlineStoreOrder(smsNotification, emailNotification);
        storeOrder.process();
    }
}
