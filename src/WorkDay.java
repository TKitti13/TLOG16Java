import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class WorkDay {
    private List<Task> tasks;
    private long requiredMinPerDay;
    private LocalDate actualDay;
    private long sumPerDay;

    public WorkDay(int year, int month, int day) {
        this.tasks = new ArrayList<Task>();
        this.requiredMinPerDay = 450;
        this.actualDay = LocalDate.of(year, month, day);
    }

    public long getRequiredMinPerDay() {
        return requiredMinPerDay;
    }

    public LocalDate getActualDay() {
        return actualDay;
    }

    public long getSumPerDay() {
        return sumPerDay;
    }

    public long getExtraMinPerDay() {
        return sumPerDay - requiredMinPerDay;
    }

    private boolean isSeparatedTime(Task t) {
        for (int i = 0; i < this.tasks.size(); i++) {
            LocalTime checkTasksStart =tasks.get(i).getStartTime();
            LocalTime checkTasksEnd =tasks.get(i).getEndTime();
            if (checkTasksStart.isBefore(t.getEndTime()) &&
                    checkTasksEnd.isAfter(t.getEndTime()) ||
                    checkTasksStart.isBefore(t.getStartTime()) &&
                            checkTasksEnd.isAfter(t.getStartTime())) {
                return false;
            }
        }
        return true;
    }
    public void addTask(Task t){
        if(isSeparatedTime(t) && t.isMultipleQuarterHour()){
            tasks.add(t);
        }else{

        }
    }
    public boolean isWeekday(){
       return(!actualDay.getDayOfWeek().toString().equals("SATURDAY") ||
               !actualDay.getDayOfWeek().toString().equals("SUNDAY"));
    }
}