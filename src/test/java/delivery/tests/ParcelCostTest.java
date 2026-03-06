package delivery.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import delivery.model.*;

public class ParcelCostTest {

    @Test
    public void shouldReturnCorrectCostForStandardParcel() {
        Parcel parcel = new StandardParcel("standard parcel", 36, "Vienna", 3);
        assertEquals(72, parcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturnCorrectCostForFragileParcel() {
        Parcel parcel = new FragileParcel("perishable parcel", 36, "Paris", 3);
        assertEquals(144, parcel.calculateDeliveryCost());
    }

    @Test
    public void shouldReturnCorrectCostForPerishableParcel() {
        Parcel parcel = new PerishableParcel("fragile parcel",
                36, "Berlin", 3, 4);
        assertEquals(108, parcel.calculateDeliveryCost());
    }

}
