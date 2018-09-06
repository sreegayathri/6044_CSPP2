import java.io.BufferedInputStream;
import java.util.Scanner;
/** Class for student.*/
class Student {
    /**. { var_description } */
    private String name;
/** Constructs the object.
 * @param      name  The name. */
    protected Student(final String name1) {
        this.name = name1;
    }//A constructor used to initialize the instance variables

    public String getName() {
        return this.name;
    }//Getter method which returns the value of instance variable

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Student)) {
            return false;
        }//This method is to check if two students names are equal or not
        if (other == this) {
            return true;
        }
        Student that = (Student) other;
        return this.getName().equals(that.getName());
    }
    public int hashCode() {
        return this.hashCode();
    }
    public String toString() {
        return this.name;
    }
}
/**
 * Class for solution.
 */
public class Solution {
/**
 * @param      args  The arguments */
    public static void main(String[] args) {
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        String objectType = stdin.nextLine();

        switch (objectType) {
        case "S"://This case will be executed for String type list
            List<String> listString = new List();
            while (stdin.hasNext()) {
                String line = stdin.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listString.add(tokens[1]);
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        listString.addAll(t1);
                    }
                    break;
                case "size":
                    System.out.println(listString.size());
                    break;
                case "print":
                    System.out.println(listString);
                    break;
                case "remove":
                    listString.remove(Integer.parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listString.indexOf(tokens[1]));
                    break;
                case "get":
                    System.out.println(listString.get(Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listString.contains(tokens[1]));
                    break;
                default:
                    break;
                }
            }
            break;

        case "I"://This case will be executed for Integer type list
            List<Integer> listInteger = new List();
            while (stdin.hasNext()) {
                String line = stdin.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listInteger.add(Integer.parseInt(tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Integer[] temp = new Integer[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        listInteger.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listInteger.size());
                    break;
                case "print":
                    System.out.println(listInteger);
                    break;
                case "remove":
                    listInteger.remove(Integer.parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listInteger.indexOf(Integer.parseInt((tokens[1]))));
                    break;
                case "get":
                    System.out.println(listInteger.get(Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listInteger.contains(Integer.parseInt((tokens[1]))));
                    break;
                default:
                    break;
                }
            }
            break;

        case "F"://This case will be executed for Float type list
            List<Float> listFloat = new List();
            while (stdin.hasNext()) {
                String line = stdin.nextLine();
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                case "add":
                    listFloat.add(Float.parseFloat(tokens[1]));
                    break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Float temp[] = new Float[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = Float.parseFloat(t1[i]);
                        }
                        listFloat.addAll(temp);
                    }
                    break;
                case "size":
                    System.out.println(listFloat.size());
                    break;
                case "print":
                    System.out.println(listFloat);
                    break;
                case "remove":
                    listFloat.remove(Integer.parseInt(tokens[1]));
                    break;
                case "indexOf":
                    System.out.println(listFloat.indexOf(Float.parseFloat(tokens[1])));
                    break;
                case "get":
                    System.out.println(listFloat.get(Integer.parseInt(tokens[1])));
                    break;
                case "contains":
                    System.out.println(listFloat.contains(Float.parseFloat(tokens[1])));
                    break;
                default:
                    break;
                }
            }
            break;

        case "C"://This case will be executed for Character type list
            performCharacter(stdin);
            break;
        case "D"://This case will be executed for Double type list
            performDouble(stdin);
            break;
        case "O"://This case will be executed for, store List of Student Objects
            performStudent(stdin);
            break;
        default:
            break;
        }
    }
    public static void performStudent(final Scanner stdin) {
        List<Student> listStudent = new List();
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "add":
                listStudent.add(new Student(tokens[1]));
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    Student[] temp = new Student[t1.length];
                    for (int i = 0; i < t1.length; i++) {
                        temp[i] = new Student(t1[i]);
                    }
                    listStudent.addAll(temp);
                }
                break;
            case "size":
                System.out.println(listStudent.size());
                break;
            case "print":
                System.out.println(listStudent);
                break;
            case "remove":
                listStudent.remove(Integer.parseInt(tokens[1]));
                break;
            case "indexOf":
                System.out.println(listStudent.indexOf(new Student(tokens[1])));
                break;
            case "get":
                System.out.println(listStudent.get(Integer.parseInt(tokens[1])));
                break;
            case "contains":
                System.out.println(listStudent.contains(new Student(tokens[1])));
                break;
            default:
                break;
            }
        }
    }
    public static void performDouble(final Scanner stdin) {
        List<Double> listDouble = new List();
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "add":
                listDouble.add(Double.parseDouble(tokens[1]));
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    Double[] temp = new Double[t1.length];
                    for (int i = 0; i < t1.length; i++) {
                        temp[i] = Double.parseDouble(t1[i]);
                    }
                    listDouble.addAll(temp);
                }
                break;
            case "size":
                System.out.println(listDouble.size());
                break;
            case "print":
                System.out.println(listDouble);
                break;
            case "remove":
                listDouble.remove(Integer.parseInt(tokens[1]));
                break;
            case "indexOf":
                System.out.println(listDouble.indexOf(Double.parseDouble(tokens[1])));
                break;
            case "get":
                System.out.println(listDouble.get(Integer.parseInt(tokens[1])));
                break;
            case "contains":
                System.out.println(listDouble.contains(Double.parseDouble(tokens[1])));
                break;
            default:
                break;
            }
        }
    }
    public static void performCharacter(final Scanner stdin) {
        List<Character> listCharacter = new List();
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "add":
                listCharacter.add(tokens[1].charAt(0));
                break;
            case "addAll":
                if (tokens.length == 2) {
                    String[] t1 = tokens[1].split(",");
                    Character[] temp = new Character[t1.length];
                    for (int i = 0; i < t1.length; i++) {
                        temp[i] = t1[i].charAt(0);
                    }
                    listCharacter.addAll(temp);
                }
                break;
            case "size":
                System.out.println(listCharacter.size());
                break;
            case "print":
                System.out.println(listCharacter);
                break;
            case "remove":
                listCharacter.remove(Integer.parseInt(tokens[1]));
                break;
            case "indexOf":
                System.out.println(listCharacter.indexOf(tokens[1].charAt(0)));
                break;
            case "get":
                System.out.println(listCharacter.get(Integer.parseInt(tokens[1])));
                break;
            case "contains":
                System.out.println(listCharacter.contains(tokens[1].charAt(0)));
                break;
            default:
                break;
            }
        }
    }
}
