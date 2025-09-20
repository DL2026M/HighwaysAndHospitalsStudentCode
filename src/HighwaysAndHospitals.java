/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: David Lutch
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        if (hospitalCost <= highwayCost) {
            // Builds a hospital in every city because it's cheaper than building highways
            return ((long) n * hospitalCost);
        }
        int minimalCost = 0;
        // figure out how many subgraphs
        //int[] map = new int[]
// For each edge AB:
//	While city A is not its root:
//		A = roots[A]
//	While city B is not its root:
//		B = roots[B]
//	If A != B:
//		roots[B] = A
//
//Calculate cost and return
        // Left and right city
        int cityOne;
        int cityTwo;
        int[] map = new int[n + 1];
        // Top left root and top right root
        int rootOne;
        int rootTwo;
        int tracker;
        for (int i = 0; i < cities.length; i++) {
            cityOne = cities[i][0];
            rootOne = cityOne;
            while (map[rootOne] != 0) {
                rootOne = map[rootOne];
            }
            cityTwo = cities[i][1];
            rootTwo = cityTwo;
            while (map[rootTwo] != 0) {
                rootTwo = map[rootTwo];
            }
            // Path compression (53-62)
            while (map[cityOne] != 0) {
                tracker = map[cityOne];
                map[cityOne] = rootOne;
                cityOne = tracker;
            }
            while (map[cityTwo] != 0) {
                tracker = map[cityTwo];
                map[cityTwo] = rootTwo;
                cityTwo = tracker;
            }
            // Weight balancing
        }
        int counter = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) {
                counter++;
            }
        }
        minimalCost = (counter * hospitalCost) + ((n-counter) * highwayCost);
        return minimalCost;
    }

}
