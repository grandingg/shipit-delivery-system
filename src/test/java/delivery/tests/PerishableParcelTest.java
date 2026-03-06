package delivery.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import delivery.model.*;

public class PerishableParcelTest {

    @Test
    public void shouldBeNegativeIfNotExpired() {
        PerishableParcel parcel = new PerishableParcel("сливки", 49,
                "Москва", 3, 4);
        assertFalse(parcel.isExpired(6));
    }

    @Test
    public void shouldBePositiveIfNotExpired() {
        PerishableParcel parcel = new PerishableParcel("морковка", 38,
                "Питер", 6, 2);
        assertTrue(parcel.isExpired(10));
    }

    @Test
    void shouldReturnFalseOnBorder() {
        PerishableParcel parcel = new PerishableParcel("молоко", 2,
                "Москва", 1, 9);
        assertFalse(parcel.isExpired(10));
    }


}
