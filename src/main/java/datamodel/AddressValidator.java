package datamodel;

import java.util.Optional;
import java.util.zip.DataFormatException;

/**
 * Validation class used for checking address data.
 *
 * @author Przemysław Motała
 */
public class AddressValidator {
    /**
     * This method validates the building's number.
     * <p>
     * Building's number should be bigger than 0.
     *
     * @param buildingNumber building's number.
     * @see Address
     */
    public int validateBuildingNumber(int buildingNumber) throws DataFormatException {
        if (buildingNumber > 0) {
            return buildingNumber;
        } else {
            throw new DataFormatException("Invalid data format!");
        }
    }

    /**
     * This method validates the street's name.
     * <p>
     * Street's name shouldn't be empty.
     *
     * @param streetName street's name.
     * @see Address
     * @see Optional
     */
    public String validateStreetName(String streetName) throws DataFormatException{
        return Optional.ofNullable(streetName)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .orElseThrow(() -> new DataFormatException("Invalid data format!"));
    }

    /**
     * This method validates the name of the city.
     * <p>
     * City's name shouldn't be empty and
     * its first letter should be in uppercase.
     *
     * @param cityName name of the city.
     * @see Address
     * @see Optional
     */
    public String validateCityName(String cityName) throws DataFormatException {
        return Optional.ofNullable(cityName)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .orElseThrow(() -> new DataFormatException("Invalid data format!"));
    }

    /**
     * This method validates the zip code.
     * <p>
     * Zip code should be in format dd-ddd.
     *
     * @param zipCode zip code.
     * @see Address
     * @see Optional
     */
    public String validateZipCode(String zipCode) throws DataFormatException {
        return Optional.ofNullable(zipCode)
                .map(String::trim)
                .filter(s -> s.matches("^[0-9]{2}-[0-9]{3}$"))
                .orElseThrow(() -> new DataFormatException("Invalid data format!"));
    }
}
