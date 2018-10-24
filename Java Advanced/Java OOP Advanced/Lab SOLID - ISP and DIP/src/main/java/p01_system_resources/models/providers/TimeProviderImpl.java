package p01_system_resources.models.providers;

import p01_system_resources.contracts.TimeProvider;

import java.time.LocalTime;

public class TimeProviderImpl implements TimeProvider {

    public TimeProviderImpl() {
    }

    @Override
    public int getHour() {
        return LocalTime.now().getHour();
    }
}
