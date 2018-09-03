import java.util.Scanner;
import java.lang.Math.*;
class Student {
    String name;
    String rollno;
    double english , science, craft;

    Student(String name, String rollnum, double english , double science, double craft) {
        this.name = name;
        this.rollno = rollnum;
        this.english  = english ;
        this.science = science;
        this.craft = craft;
    }
    public static double gpa(double english , double science, double craft) {
        double gpa;
        gpa = (english + science + craft)/3;
        return (Math.floor(gpa * 10)) / 10;
    }
}
class StudentDetails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String rollno = scan.nextLine();  
        double english  = scan.nextDouble();
        double science = scan.nextDouble();
        double craft = scan.nextDouble();
        Student stu = new Student(name, rollno, english , science, craft);
        System.out.println(stu.gpa(english , science, craft));
    }
}