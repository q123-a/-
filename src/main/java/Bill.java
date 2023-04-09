import java.time.Duration;
import java.time.LocalDateTime;

public class Bill {
    double cost0, cost;
    LocalDateTime springTime = LocalDateTime.of(2022, 3, 13, 3, 0, 0);
    LocalDateTime fallTime = LocalDateTime.of(2022, 11, 6, 2, 59, 59);
    public double calculatecost(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration;
        if (startTime.isBefore(endTime)) {
            duration = Duration.between(startTime, endTime);
        } else {
            duration = Duration.between(endTime, startTime);
        }
        long minutes = duration.toMinutes();
        long seconds = duration.getSeconds();
        long timelength;
        if(seconds%60 > 0) timelength = minutes + 1;
        else timelength = minutes;

        if(timelength <= 20 && timelength >= 1) {cost0 = timelength*0.05;}
        else if(timelength < 1) {cost0 = 0.05;}
        else if(timelength > 1800) {throw new IllegalArgumentException("Invalid call time");}
        else {cost0 = 1 + 0.1*(timelength-20);}

        if (springTime.isAfter(startTime) && springTime.isBefore(endTime)) {
            cost = cost0-5;
        } else if (fallTime.isAfter(startTime) && fallTime.isBefore(endTime)) {
            cost = cost0+5;
        } else {
            cost = cost0;
        }
        return cost;
    }
}
