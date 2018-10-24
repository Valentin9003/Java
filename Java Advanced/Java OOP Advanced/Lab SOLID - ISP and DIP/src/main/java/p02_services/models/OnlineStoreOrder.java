package p02_services.models;

import p02_services.contracts.NotificationService;
import p02_services.contracts.Notificatable;

public class OnlineStoreOrder implements Notificatable {

    private NotificationService[] notificationServices;

    public OnlineStoreOrder(NotificationService... services) {
        this.setNotificationServices(services);
    }

    private void setNotificationServices(NotificationService[] services) {
        if (services == null) {
            throw new IllegalStateException();
        }
        this.notificationServices = services;
    }

    @Override
    public void process() {
        for (NotificationService service : this.notificationServices) {
            if (service.isActive()) {
                service.sendNotification();
            }
        }
    }
}
