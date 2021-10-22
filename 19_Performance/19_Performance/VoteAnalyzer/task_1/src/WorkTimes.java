import java.util.Date;
import java.util.TreeSet;

public class WorkTimes {

    private TreeSet<TimePeriods> periods;

    /**
     * Set of TimePeriod objects
     */
    public WorkTimes() {
        periods = new TreeSet<>();
    }

    public void addVisitTime(long visitTime) {
        Date visit = new Date(visitTime);
        TimePeriods newPeriod = new TimePeriods(visit, visit);
        for (TimePeriods period : periods) {
            if (period.compareTo(newPeriod) == 0) {
                period.appendTime(visit);
                return;
            }
        }
        periods.add(new TimePeriods(visit, visit));
    }

    public String toString() {
        String line = "";
        for (TimePeriods period : periods) {
            if (!line.isEmpty()) {
                line += ", ";
            }
            line += period;
        }
        return line;
    }
}
