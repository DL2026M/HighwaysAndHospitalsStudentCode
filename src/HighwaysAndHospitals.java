/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: David Lutch
 *
 */
// I want to cite Diego Villegas for helping debug my errors and giving me some pointers on how to solve the problem
public class HighwaysAndHospitals {
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        if (hospitalCost <= highwayCost) {
            // Builds a hospital in every city because it's cheaper than building highways
            return ((long) n * hospitalCost);
        }
        long minimalCost = 0;
        // Left city
        int cityOne;
        // Right city
        int cityTwo;
        int[] map = new int[n + 1];
        // Top left root
        int rootOne;
        // Top right root
        int rootTwo;
        int tracker;
        // Union-Find algorithm
        for (int i = 0; i < cities.length; i++) {
            cityOne = cities[i][0];
            rootOne = cityOne;
            // Grouping cities that can be connected via highways
            while (map[rootOne] > 0) {
                rootOne = map[rootOne];
            }
            cityTwo = cities[i][1];
            rootTwo = cityTwo;
            // Traversing the map to find the root of the group of the cities
            while (map[rootTwo] > 0) {
                rootTwo = map[rootTwo];
            }
            // Path compression
            while (map[cityOne] > 0) {
                // Storing the parent node of city one
                tracker = map[cityOne];
                map[cityOne] = rootOne;
                cityOne = tracker;
            }
            // Runs until city two is the root of the group of cities
            while (map[cityTwo] > 0) {
                tracker = map[cityTwo];
                map[cityTwo] = rootTwo;
                // Moving onto the next node
                cityTwo = tracker;
            }

            // Weight balancing
            if (rootOne != rootTwo) {
                // Checks to see how many cities are connected to the first root
                if (map[rootOne] > map[rootTwo]) {
                    // Minusing one from the total cities connected to root one because I don't want to include the root itself
                    map[rootTwo] += map[rootOne] - 1;
                    map[rootOne] = rootTwo;
                }
                else {
                    // Minusing one from the total cities connected to root two because I don't want to include the root itself
                    map[rootOne] += map[rootTwo] - 1;
                    map[rootTwo] = rootOne;
                }
            }
        }

        // Calculating the total number of disconnected cities in the problem
        int counter = 0;
        for (int i = 1; i < map.length; i++) {
            if (map[i] <= 0) {
                counter++;
            }
        }
        // Finding the most economical way to have every city connected to a hospital
        minimalCost = ((long) counter * hospitalCost) + ((long) (n - counter) * highwayCost);
        return minimalCost;
    }

}
