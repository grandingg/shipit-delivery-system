package delivery.model;

import delivery.interfaces.*;

public class FragileParcel extends Parcel implements Trackable {
    private static final int BASE_RATE = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
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

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }
}

