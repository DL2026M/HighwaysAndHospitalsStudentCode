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
        int minimalCost = 0;
        if (hospitalCost <= highwayCost) {
            // Builds a hospital in every city because it's cheaper than building highways
            return (n * hospitalCost);
        }





        return 0;
    }

}
