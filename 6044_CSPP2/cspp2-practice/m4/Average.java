import java.util.Scanner;
class Average {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of inputs");
        int size = s.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element");
            arr[i] = s.nextInt();
            sum = sum + arr[i];
        }
        float avg = sum/size;
        System.out.println(avg);
    }
}