package datamodel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    private static Address address;

    @BeforeAll
    static void setUp() {
        try {
            address = new Address(10, "Polna", "Wrocław", "11-121");
        } catch (DataFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void shouldBeBadBuildingNumber() {
        assertThrows(DataFormatException.class,() -> address.setBuildingNumber(-7));
    }

    @Test
    void shouldBeBadZipCode() {
        assertThrows(DataFormatException.class,() -> address.setZipCode("12345"));
    }

    @Test
    void shouldBeBadCityName() {
        assertThrows(DataFormatException.class,() -> address.setCityName("cityname"));
    }

    @Test
    void shouldBeBadStreetName() {
        assertThrows(DataFormatException.class,() -> address.setStreetName(""));
    }

}