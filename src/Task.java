import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String taskId;
    private LocalTime startTime;
    private LocalTime endTime;
    private String comment;

    public Task(String taskId, String comment, int startHour, int startMin, int endHour, int endMinutes) {
        this.taskId = taskId;
        this.comment = comment;
        this.startTime = LocalTime.of(startHour, startMin);
        this.endTime = LocalTime.of(endHour, endMinutes);
    }
    public Task(String taskId, String comment, String startTime, String endTime) {
        this.taskId = taskId;
        this.comment = comment;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.startTime = LocalTime.parse(startTime, formatter);
        this.endTime = LocalTime.parse(endTime, formatter);
    }
    public String getTaskId() {
        return taskId;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public String getComment() {
        return comment;
    }
    public long getMinPerTask(){
        return Duration.between(startTime, endTime).toMinutes();
    }
    public boolean isValidTaskId(String taskId){
        return (taskId.matches("\\d{4}")|| taskId.matches("LT-\\d{4}"));
    }
    public boolean isMultipleQuarterHour(){
        return (getMinPerTask()%15==0);
    }
}
