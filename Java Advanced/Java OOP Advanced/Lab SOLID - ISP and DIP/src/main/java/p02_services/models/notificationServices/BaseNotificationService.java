package p02_services.models.notificationServices;

import p02_services.contracts.NotificationService;

public abstract class BaseNotificationService implements NotificationService {

    private boolean isActive;

    public BaseNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void activate() {
        this.isActive = true;
    }
}
