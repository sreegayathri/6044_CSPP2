import java.util.Scanner;
import java.util.Arrays;

class Task {
    private String title;
    private String assignedTo;
    private int timeToComplete;
    private boolean important;
    private boolean urgent;
    private String status;

    public Task() {}

    public Task(String title, String assignedo, int timeToComplete, boolean important, boolean urgent, String status) {
        this.title = title;
        this.assignedTo = assignedTo;
        this.timeToComplete = timeToComplete;
        this.important = important;
        this.urgent = urgent;
        this.status = status;
    }

    public String gettitle() {
        return this.title;
    }
    public void settitle(String title) {
        this.title = title;
    }

    public String getassignedTo() {
        return this.assignedTo;
    }
    public void setassignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int gettimeToCompleteo() {
        return this.timeToComplete;
    }
    public void settimeToComplete(int timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public boolean getimportant() {
        return this.important;
    }
    public void setimportant(boolean important) {
        this.important = important;
    }

    public boolean geturgent() {
        return this.urgent;
    }
    public void seturgent(boolean urgent) {
        this.urgent = urgent;
    }

    public String getstatus() {
        return this.status;
    }
    public void setstatus(String status) {
        this.status = status;
    }

    public String toString() {
        return this.title+ ","+ " "+ this.assignedTo+ ","+ " "+ this.timeToComplete+ ","+ " "+ this.important+ ","+ " "+ this.urgent+ ","+ " "+ this.status; 
    }
}
/**
  * write your code below this comment
  */
class Todoist {
    /**
     * { var_description }
     */
    private String[] task;
    /**
     * { var_description }
     */
    private int size;
    /**
     * Constructs the object.
     */
    Todoist(){
        task = new String[2 + 2 + 2 + 2 + 2];
        size = 0;
    }
    /**
     * Adds a task.
     * @param      title  The title
     */
    public void addTask(int title) {
        if (size == task.length) {
            resize();
        }
        task[size++] = title;
    }
/**
 * { function_description }
 * @return     { description_of_the_return_value }
 */
    public int size() {
        return size;
    }
    /**.
     * resize
     */
    private void resize() {
        task = Arrays.copyOf(task, size * 2);
    }
    /**
     * { function_description }
     * @return     { description_of_the_return_value }
     */
    public int totalTime4Completion(int time, String status) {
        int totaltime = 0;
        for (String element : task) {
            if (status.equals(todo)) {
                totaltime += time;
            }
        }
        return totaltime;
    }
    /**
     * { item_description }
     */
    public String getNextTask(String assignedTo, String[] task, Boolean important, boolean urgent) {
        for (String element : task) {
            if (element.equals(y)) {
                if (element.equals(n)) {
                    if (element.equals(todo)) {
                        return task[element];
                    }
                }
            }
            return null;
        }
    }
}
/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
