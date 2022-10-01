/**
 * @author Kwabena Gyane Akuamoah
 */

package IndividualProject;

public class Routes {

    // Instance Variables
    private static String airlineCode;
    private String airlineID;
    private String sourceAirportCode;
    private String destinationAirportCode;
    private int stops;


    // Constructor for the Routes Class
    public Routes(String airlineCode, String airlineID, String sourceAirportCode, String destinationAirportCode,
                  int stops) {
        this.airlineCode = airlineCode;
        this.airlineID = airlineID;
        this.sourceAirportCode = sourceAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.stops = stops;
    }


    // Accessor Methods
    public static String getAirlineCode() {return airlineCode;}
    public String getAirlineID() {return airlineID;}
    public String getSourceAirportCode() {return sourceAirportCode;}
    public String getDestinationAirportCode() {return destinationAirportCode;}
    public int getStops() {return stops;}


    // Mutator Methods
    public void setAirlineCode(String airlineCode) {this.airlineCode = airlineCode;}
    public void setAirlineID(String airlineID) {this.airlineID = airlineID;}
    public void setSourceAirportCode(String sourceAirportCode) {this.sourceAirportCode = sourceAirportCode;}
    public void setDestinationAirportCode(String destinationAirportCode) {this.destinationAirportCode = destinationAirportCode;}
    public void setStops(int stops) {this.stops = stops;}

    @Override
    public String toString() {
        return "Routes{" +
                "airlineID='" + airlineID + '\'' +
                ", sourceAirportCode='" + sourceAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", stops=" + stops +
                '}';
    }
}