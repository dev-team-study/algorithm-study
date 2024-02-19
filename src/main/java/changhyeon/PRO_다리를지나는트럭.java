package changhyeon;

import java.util.ArrayDeque;
import java.util.Deque;

public class PRO_다리를지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        int count = 0;

        Deque<Integer> wait = new ArrayDeque<>();
        Deque<Truck> during = new ArrayDeque<>();

        for (int truckWeight : truck_weights) {
            wait.add(truckWeight);
        }

        while (true) {
            if (wait.isEmpty() && during.isEmpty()) {
                break;
            }

            count++;
            Truck duringTruck = during.peek();

            if (duringTruck != null) {
                if (duringTruck.getIndex() == bridge_length) {
                    during.poll();
                    sum -= duringTruck.getWeight();
                }

                for (Truck truck : during) {
                    truck.updateIndex();
                }
            }

            Integer truckWeight = wait.peek();
            if (truckWeight != null) {
                if (weight < (truckWeight + sum) || during.size() >= bridge_length) {
                    continue;
                }

                sum += truckWeight;
                truckWeight = wait.poll();
                during.add(new Truck(1, truckWeight));
            }
        }

        return count;
    }

    static class Truck {

        private int index;
        private int weight;

        public Truck(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public void updateIndex() {
            index++;
        }

        public int getIndex() {
            return index;
        }

        public int getWeight() {
            return weight;
        }
    }
}
