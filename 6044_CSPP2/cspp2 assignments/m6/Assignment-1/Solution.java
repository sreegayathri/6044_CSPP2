import java.util.Scanner;

public class Solution {

    private static String comps;
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        comps = "";
        boolean prime = isPrime(number);
        if(prime){
            System.out.println(number+" is Prime");
        }
        else{
            System.out.println("The number "+number+" is composed of "+comps);
        }
    }
    public static boolean isPrime(int num){
        boolean isTrue = true;
        for(int i=2; i<=Math.ceil((num/2)); i++){
            if(num%i == 0){
                if(comps.equals("")){
                    comps += ""+i;
                }
                else{
                    comps += ","+i;
                }
                isTrue = false;
            }
        }
        return isTrue;
    }
}