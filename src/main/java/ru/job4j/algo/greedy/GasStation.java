package ru.job4j.algo.greedy;

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas, totalCost, tank, start;
        for (int i = 0; i < gas.length; i++) {
            totalGas = 0;
            totalCost = 0;
            tank = 0;
            start = i;
            for (int j = i; j < gas.length + i; j++) {
                int help = j < gas.length ? 0 : gas.length;
                tank += gas[j - help] - cost[j - help];
                totalGas += gas[j - help];
                totalCost += cost[j - help];
                if (tank < 0) {
                    break;
                }
                if (j == gas.length + i - 1 && totalGas >= totalCost) {
                    return start;
                }
            }
        }
        return -1;
    }
}