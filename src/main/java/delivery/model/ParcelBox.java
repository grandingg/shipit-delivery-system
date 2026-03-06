package delivery.model;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox <T extends Parcel> {
    protected final int maxWeight;
    private final List<T> box = new ArrayList<>();
    private int currentWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.weight > maxWeight) {
            System.out.println("Максимальный вес " + maxWeight + " превышен");
        } else {
            box.add(parcel);
            currentWeight += parcel.weight;
            System.out.println("Посылка добавлена в коробку");
        }
    }

    public List<T> getAllParcels() {
        return new ArrayList<>(box);
    }

}

