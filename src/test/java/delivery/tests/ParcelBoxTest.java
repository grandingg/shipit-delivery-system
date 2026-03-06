package delivery.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import delivery.model.*;

public class ParcelBoxTest {

    @Test
    public void shouldAddParcelIfWeightOk() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);
        StandardParcel parcel = new StandardParcel("Book", 5, "Vienna", 1);

        box.addParcel(parcel);
        assertEquals(1, box.getAllParcels().size());
    }

    @Test
    public void shouldNotAddParcelIfOverWeight() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5);
        StandardParcel parcel1 = new StandardParcel("Book", 3, "Vienna", 1);
        StandardParcel parcel2 = new StandardParcel("Stone", 4, "Paris", 2);

        box.addParcel(parcel1);
        box.addParcel(parcel2);
        assertEquals(1, box.getAllParcels().size());
    }

    @Test
    public void shouldAddParcelWhenWeightCloseToMax() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5);
        StandardParcel parcel = new StandardParcel("Something", 4, "Dubai", 10);

        box.addParcel(parcel);
        assertEquals(1, box.getAllParcels().size());
    }
}