public class Main {
    public static void main(String[] args) {
        Task task1= new Task("63289", "test", "11:10", "12:40");
        System.out.println(task1.getMinPerTask());
        System.out.println(task1.isValidTaskId(task1.getTaskId()));
        System.out.println(task1.isMultipleQuarterHour());


    }
}
