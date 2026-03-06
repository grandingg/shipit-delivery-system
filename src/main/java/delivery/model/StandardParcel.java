package delivery.model;

public class StandardParcel extends Parcel {
    private static final int BASE_RATE = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem(){
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
}

