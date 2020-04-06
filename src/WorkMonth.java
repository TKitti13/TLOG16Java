import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class WorkMonth {
    private List<WorkDay> days;
    private YearMonth date;
    private long sumPerMonth;
    private long requiredMinPerMonth;

    public WorkMonth(int year, int month) {
        this.days = new ArrayList<WorkDay>();
        this.date = YearMonth.of(year, month);
    }
    public List<WorkDay> getDays() {
        return days;
    }
    public YearMonth getDate() {
        return date;
    }
    public long getSumPerMonth() {
        return sumPerMonth;
    }
    public long getRequiredMinPerMonth() {
        return requiredMinPerMonth;
    }
    public long getExtraMinPerMonth(){
        return sumPerMonth - requiredMinPerMonth;
    }
    private boolean isNewDate(WorkDay workDay){
        for (int i=0; i< days.size(); i++){
            if(workDay == days.get(i)){
                return false;
            }
        }return true;
    }
    private boolean isSameMonth(WorkDay workDay){
        return (workDay.getActualDay().getMonth().equals(this.date.getMonth()) &&
            workDay.getActualDay().getYear() == this.date.getYear());
    }
    public void addWorkDay(WorkDay wd, boolean isWeekendEnabled){
        if (isWeekendEnabled && isSameMonth(wd) && isNewDate(wd)) {
            days.add(wd);
        }
    }
    public void addWorkDay(WorkDay wd){
        if (wd.isWeekday() && isSameMonth(wd) && isNewDate(wd)) {
            days.add(wd);
        }
    }
}
