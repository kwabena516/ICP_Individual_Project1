/**
 * @author Kwabena Gyane Akuamoah
 */

package IndividualProject;

public class Airports {

    // Instance Variables
    private static String airportID;
    private static String airportName;
    private static String cityName;
    private static String country;
    private static String IATACode;


    // Constructor for the  Airports class
    public Airports(String airportID, String airportName, String cityName, String country, String IATACode) {
        this.airportID = airportID;
        this.airportName = airportName;
        this.cityName = cityName;
        this.IATACode = IATACode;
    }


    // Accessor Methods
    public String getAirportID() {return airportID;}
    public String getAirportName() {return airportName;}
    public String getCityName() {return cityName;}
    public String getCountry() {return country;}
    public String getIATACode() {return IATACode;}


    // Mutator Methods
    public static void setAirportID(String airportID) {Airports.airportID = airportID;}
    public static void setAirportName(String airportName) {Airports.airportName = airportName;}
    public static void setCityName(String cityName) {Airports.cityName = cityName;}
    public static void setCountry(String country) {Airports.country = country;}
    public static void setIATACode(String IATACode) {Airports.IATACode = IATACode;}


}

