/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * { item_description }
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    /**.
     * { item_description }
     */
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**.
         * { var_description }
         */
        FitByte fb = new FitByte();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            // read the line
            String line = scan.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case"Food":
                    String[] arr = tokens[1].split(",");
                    fb.addLog(new FoodLog(arr[0], Float.parseFloat(arr[1]), arr[2], arr[3]));
                    break;
                case"Water":
                    String[] arr1 = tokens[1].split(",");
                    fb.addLog(new WaterLog(Integer.parseInt(arr1[0]), arr1[1], arr1[2]));
                    break;
                case"PhysicalActivity":
                    String[] arr2 = tokens[1].split(",");
                    fb.addLog(new PhysicalActivity(arr2[0], arr2[1], arr2[2], arr2[3], arr2[4]));
                    break;
                case"Weight":
                    String[] arr3 = tokens[1].split(",");
                    fb.addLog(new Weight(arr3[0], arr3[1], arr3[2], arr3[3]));
                    break;
                case"Sleep":
                    String[] arr4 = tokens[1].split(",");
                    fb.addLog(new Sleep(arr4[0], arr4[1], arr4[2]));
                    break;
                case"Foodlog":
                    fb.printFoodLog();
                    System.out.println();
                    break;
                case"Waterlog":
                    fb.printWaterLog();
                    System.out.println();
                    break;
                case"Weightlog":
                    fb.printWeightLog();
                    System.out.println();
                    break;
                case"PhysicalActivitylog":
                    fb.printPhysicalActivity();
                    System.out.println();
                    break;
                case"Sleeplog":
                    fb.printSleep();
                    System.out.println();
                    break;
                case"Summary":
                    fb.displaySummary();
                    break;
                default:
                    break;
            }
        }
    }
}