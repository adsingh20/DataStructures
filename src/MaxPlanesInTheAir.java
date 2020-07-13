import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxPlanesInTheAir {

    public static int findMaxPlanesInTheAir(List<Flight> flights) {
        int maxFlights = 0;

        flights.sort(Comparator.comparingInt(t -> t.startTime));

        PriorityQueue<Flight> flightsInTheAir = new PriorityQueue<>(Comparator.comparingInt(t -> t.endTime));

        for (Flight flight: flights) {
            while(!flightsInTheAir.isEmpty() && flightsInTheAir.peek().endTime < flight.startTime) {
                flightsInTheAir.poll();
            }

            flightsInTheAir.add(flight);
            maxFlights = Math.max(maxFlights, flightsInTheAir.size());
        }

        return maxFlights;
    }


    static class Flight {
        int startTime;
        int endTime;
    }
}
