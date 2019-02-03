import java.util.Scanner;
class sole {
    sole(){}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int n = word.length();
        int num = 2 + 2 + 2;
        if(n == num){
            System.out.println("true");
        } else{
            System.out.println("false");
        }
    }   
}