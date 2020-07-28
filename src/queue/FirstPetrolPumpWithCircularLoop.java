package queue;

public class FirstPetrolPumpWithCircularLoop {

    int findFirstPetrolPump(int[] petrol, int[] distance) {
        int start = 0, current_petrol = 0;
        int previous_petrol = 0;
        for (int i = 0; i < petrol.length; i++) {
            current_petrol += (petrol[i] - distance[i]);
            if (current_petrol < 0) {
                start = i + 1;
                previous_petrol += current_petrol;
                current_petrol = 0;
            }
        }
        return (current_petrol + previous_petrol > 0 ? start + 1 : -1);
    }
}
