/**
 * @author Kwabena Gyane Akuamoah
 */

package IndividualProject;

import java.util.ArrayList;
import java.util.Collections;

public class Node {

    // Instance Variables
    private Node parent;
    private String airlineCode;
    private String airportCode;
    private int stops;


    // Constructor for the Node class
    public Node(Node parent, String airlineCode, String airportCode, int stops) {
        this.parent = parent;
        this.airlineCode = airlineCode;
        this.airportCode = airportCode;
        this.stops = stops;
    }


    // Accessor Methods
    public Node getParent() {return parent;}
    public String getAirlineCode() {return airlineCode;}
    public String getAirportCode() {return airportCode;}
    public int getStops() {return stops;}


    // Mutator Methods
    public void setParent(Node parent) {this.parent = parent;}
    public void setAirlineCode(String airlineCode) {this.airlineCode = airlineCode;}
    public void setAirportCode(String airportCode) {this.airportCode = airportCode;}
    public void setStops(int stops) {this.stops = stops;}


    public ArrayList<String> solutionPath() {
        ArrayList<String> sequenceList = new ArrayList();
        ArrayList<Integer> stopsList = new ArrayList();
        ArrayList<String> airportCodesList = new ArrayList();
        ArrayList<String> airlineCodesList = new ArrayList();

        Node currentNode = this;

        while (currentNode != null) {
            stopsList.add(currentNode.getStops());
            airportCodesList.add(currentNode.getAirportCode());
            airlineCodesList.add(currentNode.getAirlineCode());

            currentNode = currentNode.parent;
        }

        Collections.reverse(stopsList);
        Collections.reverse(airportCodesList);
        Collections.reverse(airlineCodesList);

        for (int i = 0; i < airlineCodesList.size() - 1; i++) {
            String output = i+1 + ". " + airlineCodesList.get(i+1) + " from " + airportCodesList.get(i) + " to " +
                    airlineCodesList.get(i+1) + " " + stopsList.get(i) + " stops";

            sequenceList.add(output);

        }

        return sequenceList;
    }

}
