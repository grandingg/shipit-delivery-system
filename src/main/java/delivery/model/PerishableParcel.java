package delivery.model;

public class PerishableParcel extends Parcel {
    private int timeToLive;
    private static final int BASE_RATE = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public void packageItem() {
        super.packageItem();
    }

    @Override
    public void deliver() {
        super.deliver();
    }

    @Override
    protected int getBaseRate() {
        return BASE_RATE;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }

}

