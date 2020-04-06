import java.util.ArrayList;
import java.util.List;

public class TimeLogger {
    private List<WorkMonth> months;

    public TimeLogger() {
        this.months = new ArrayList<WorkMonth>();
    }

    public List<WorkMonth> getMonths() {
        return months;
    }
    private boolean isNewMonth(WorkMonth wm){
        for (int i=0; i< this.months.size(); i++){
            if( wm == this.months.get(i)){
                return false;
            }
        }return true;
    }
    public void addMonth(WorkMonth wm){
        if (isNewMonth(wm)){
            this.months.add(wm);
        }
    }
}
