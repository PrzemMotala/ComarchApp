package datamodel;

import java.util.zip.DataFormatException;

/**
 * Model class to hold address information.
 *
 * @author Przemysław Motała
 */
public class Address {
    private int buildingNumber;
    private String streetName;
    private String cityName;
    private String zipCode;

    /**
     * This parameter specifies the validator used to check data format.
     */
    private static final AddressValidator VALIDATOR = new AddressValidator();

    /**
     * This constructor creates {@link Address} object.
     * <p>
     * Data validation is performed via
     * use of methods included in {@link AddressValidator} class.
     *
     * @param buildingNumber building's number.
     * @param streetName street's name.
     * @param cityName name of the city.
     * @param zipCode zip code.
     * @see AddressValidator
     */
    public Address(int buildingNumber,
                   String streetName,
                   String cityName,
                   String zipCode) throws DataFormatException {
        this.buildingNumber = VALIDATOR.validateBuildingNumber(buildingNumber);
        this.cityName = VALIDATOR.validateCityName(cityName);
        this.zipCode = VALIDATOR.validateZipCode(zipCode);
        this.streetName = VALIDATOR.validateStreetName(streetName);
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) throws DataFormatException {
        this.buildingNumber = VALIDATOR.validateBuildingNumber(buildingNumber);
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) throws DataFormatException {
        this.streetName = VALIDATOR.validateStreetName(streetName);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) throws DataFormatException {
        this.cityName = VALIDATOR.validateCityName(cityName);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) throws DataFormatException {
        this.zipCode = VALIDATOR.validateZipCode(zipCode);
    }
}
