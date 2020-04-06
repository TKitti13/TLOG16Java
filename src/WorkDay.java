// TODO: remove this unused import
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

    // TODO: create constructor with requiredMinPerDay parameters
    // TODO: create constructor with requiredMinPerDay, year, month, day parameters
    // TODO: create constructor with requiredMinPerDay, actualDay
    // none of them is necessary, do it as you like
    public WorkDay(int year, int month, int day) {
        // TODO: remove <Task>, since java7 you dont have to declare here
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

    // TODO: fill comment
    /**
     *
     * @param t
     * @return
     */
    private boolean isSeparatedTime(Task t) {
        for (int i = 0; i < this.tasks.size(); i++) {
            LocalTime checkTasksStart = tasks.get(i).getStartTime();
            LocalTime checkTasksEnd = tasks.get(i).getEndTime();
            if (checkTasksStart.isBefore(t.getEndTime()) &&
                    checkTasksEnd.isAfter(t.getEndTime()) ||
                    checkTasksStart.isBefore(t.getStartTime()) &&
                            checkTasksEnd.isAfter(t.getStartTime())) {
                return false;
            }
        }
        return true;
    }

    // TODO: fill comment
    /**
     *
     * @param t
     */
    public void addTask(Task t) {
        if (isSeparatedTime(t) && t.isMultipleQuarterHour()) {
            tasks.add(t);
        } else {
            // TODO: fill this code block or remove it
        }
    }

    // TODO: fill comment
    /**
     *
     * @return
     */
    public boolean isWeekday() {
        return (!actualDay.getDayOfWeek().toString().equals("SATURDAY") ||
                !actualDay.getDayOfWeek().toString().equals("SUNDAY"));
    }
}