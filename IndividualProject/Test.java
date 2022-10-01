/**
 * @author Kwabena Gyane Akuamoah
 */

package IndividualProject;

import java.util.*;
import java.io.*;

public class Test {

    static HashMap<String, ArrayList<Routes>> routesHashMap = new HashMap<>(); // Creating a Hashmap for the Routes

    static HashMap<String, ArrayList<String>> airportsMap1 = new HashMap<>(); //HashMap for the City & Country to AirportCode
    static HashMap<String, String> airportsMap2 = new HashMap<>(); // HashMap for the AirportCode to City & Country


    public static void main(String[] args) {
        try {
            // Reading the 'routes.csv' file using FileReader and BufferedReader
            FileReader routesReader = new FileReader("/Users/kwabenagyaneakuamoah/Library/CloudStorage/" +
                    "OneDrive-AshesiUniversity/ASHESI/Level 200/2nd Semester/Intermediate Computer Programming/ICP2022/" +
                    "src/IndividualProject/routes.csv");
            BufferedReader bufferedRoutesFile = new BufferedReader(routesReader);
            String routesInLines = bufferedRoutesFile.readLine(); //reading the file line by line

            while (routesInLines != null) {
                String[] routeData = routesInLines.split(","); // splitting each entry by a comma

                Routes route = new Routes(routeData[0], routeData[1], routeData[2], routeData[4],
                        Integer.parseInt(routeData[7]));
                // creating an object that stores the AirlineCode, AirlineID, SourceAirportCode and DestinationAirportCode

                ArrayList<Routes> routesList = new ArrayList<>(); // storing all roots in a list

                String sourceAirportCode = routeData[2];

                if (routesList != null) {
                    routesList.add(route);
                    routesHashMap.put(sourceAirportCode, routesList);
                }
                else {
                    ArrayList<Routes> routesList2 = new ArrayList<>();
                    routesList2.add(route);
                    routesHashMap.put(sourceAirportCode, routesList);
                }

                routesInLines = bufferedRoutesFile.readLine();
            }
//            System.out.println(routesHashMap);

            // Reading the 'airports.csv' file using FileReader and BufferedReader
            FileReader airportsReader = new FileReader("/Users/kwabenagyaneakuamoah/Library/CloudStorage/" +
                    "OneDrive-AshesiUniversity/ASHESI/Level 200/2nd Semester/Intermediate Computer Programming/ICP2022/" +
                    "src/IndividualProject/airports.csv");
            BufferedReader bufferedAirportsFile = new BufferedReader(airportsReader);
            String airportsInLines = bufferedAirportsFile.readLine(); //reading the file line by line

            while (airportsInLines != null) {
                String[] airportData = airportsInLines.split(","); // splitting each entry by a comma

                String cityAndCountry = airportData[2] + "," + airportData[3]; // joining City and Country with ','
                                                                                // as a delimiter
                String airportCode = airportData[4];

                ArrayList<String> airportCodeList = new ArrayList<>();
                airportCodeList.add(airportCode);

                if (airportCodeList != null) {
                    airportCodeList.add(airportCode);
                    airportsMap1.put(cityAndCountry, airportCodeList);
                }
                else {
                    ArrayList<String> airportCodeList2 = new ArrayList<>();
                    airportCodeList2.add(airportCode);
                    airportsMap1.put(cityAndCountry, airportCodeList);
                }

                airportsMap2.put(airportCode, cityAndCountry);

                airportsInLines = bufferedAirportsFile.readLine();
            }
//            System.out.println(airportsMap1);
//            System.out.println(airportsMap2);

            // Testing the Breadth-First Search Function on an Input File containing a Start and Destination
            FileReader inputFile = new FileReader("/Users/kwabenagyaneakuamoah/Library/CloudStorage/OneDrive-" +
                    "AshesiUniversity/ASHESI/Level 200/2nd Semester/Intermediate Computer Programming/ICP2022/src/" +
                    "IndividualProject/Accra - Winnipeg.txt");
            BufferedReader bufferedFile = new BufferedReader(inputFile);

            String startCityAndCountry = bufferedFile.readLine();
            String destinationCityAndCountry = bufferedFile.readLine();

            ArrayList<String> output = breadthFirstSearch(startCityAndCountry, destinationCityAndCountry);

            File outputFile = new File("/Users/kwabenagyaneakuamoah/Library/CloudStorage/OneDrive-AshesiUniver" +
                    "sity/ASHESI/Level 200/2nd Semester/Intermediate Computer Programming/ICP2022/src/IndividualProject/" +
                    "OutputFile.txt");

            FileWriter outputData = new FileWriter("/Users/kwabenagyaneakuamoah/Library/CloudStorage/OneDrive-AshesiUniver" +
                    "sity/ASHESI/Level 200/2nd Semester/Intermediate Computer Programming/ICP2022/src/IndividualProject/" +
                    "OutputFile.txt");

        }

        catch (IOException ie) {
            System.out.println(ie.toString());
        }

    }


    // Breadth-First Search Algorithm for finding valid path from a start city to a destination city
    public static ArrayList<String> breadthFirstSearch(String start, String destination) {
        Queue<Node> frontier = new ArrayDeque<>();
        Set<String> exploredList =  new HashSet<>();

        ArrayList<String> listOfAirports = airportsMap1.get(start);

        for (String airportCode: listOfAirports) {
            frontier.add(new Node(null, null, airportCode, 0));
        }
        while(frontier.size()>0) {
            Node node = frontier.remove();
            exploredList.add(node.getAirportCode());

            ArrayList<Routes> routesList = routesHashMap.get(node.getAirportCode());

            if (routesList != null) {
                for (Routes childStates : routesList) {
                    Node child = new Node(node, Routes.getAirlineCode(),
                            childStates.getDestinationAirportCode(), childStates.getStops());

                    String destinationCityAndCountry = airportsMap2.get(child.getAirportCode());

                    if (destinationCityAndCountry != null) {
                        if (!frontier.contains(child) && !exploredList.contains(child.getAirportCode())) {
                            if (destinationCityAndCountry.equals(destination)) {
                                return child.solutionPath();
                            }
                            frontier.add(child);
                        }
                    }

                }
            }

        }
        return null;
    }


}
