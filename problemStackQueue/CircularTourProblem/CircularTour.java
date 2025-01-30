package day2.problemStackQueue.CircularTourProblem;
public class CircularTour {

    public static int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0;  // Tracks total surplus petrol
        int currentSurplus = 0; // Tracks running surplus
        int startIndex = 0;     // Tracks potential start index

        for (int i = 0; i < n; i++) {
            int diff = petrol[i] - distance[i]; // Net fuel at this pump
            totalSurplus += diff;
            currentSurplus += diff;

            // If we run out of fuel, reset start index to next pump
            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }
        }

        // If total surplus is negative, we can't complete the tour
        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPump(petrol, distance);
        System.out.println("Starting Pump Index: " + start);
    }
}

