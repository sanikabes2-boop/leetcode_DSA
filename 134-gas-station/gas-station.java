class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            int difference = gas[i] - cost[i];

            totalGas += difference;
            currentGas += difference;

            // Cannot reach the next station
            if (currentGas < 0) {

                // Start from next station
                start = i + 1;

                // Reset gas
                currentGas = 0;
            }
        }

        // Total gas is insufficient
        if (totalGas < 0) {
            return -1;
        }

        return start;
    }
}