/**.
 *program to know the area of a circle
 */
import java.util.Scanner;
class Areaofcircle
{ /**.
   *class of the circle's area
   */
	public static void main(String[] args) {
		/**.
		 *main function of the class
		 */
		Scanner s =new Scanner(System.in);
		double r = s.nextDouble();
		
		double a = area(r);
		System.out.println(a);
	}
	static double area( double r){
		return pi() * r * r;
	}
	static double pi(){
		return 3.14;
	}
}