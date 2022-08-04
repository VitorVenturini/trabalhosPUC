 
import java.util.Scanner;

/**
 * @author Pablo_Montiel
 * @version 20220407
 */
public class EX3 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Digite o raio da pista 1: ");
        double raio1 = s.nextDouble();
        
        System.out.println("Digite o raio da pista 2: ");
        double raio2 = s.nextDouble();
        
        double area1 = 2 * 3.1415 * raio1;
        double area2 = 2 * 3.1415 * raio2;
        double areaT = area1 + area2;
        
        System.out.println("�?rea 1: " + area1 + "mˆ2, �?rea 2: " + 
        area2 + "mˆ2, �?rea Total: " + areaT + "mˆ2");
        
        double latas;
        if (areaT%16 == 0) {
            //para caso use as latas de tinta completas sem sobra
            latas = (areaT*2)/16;
            System.out.printf("Serão usadas %.0f latas", latas);
        } else {
            //para caso use as latas de tinta, mas acabe sobrando em uma, essa uma ainda conta!
            latas = (int)(areaT*2)/16 + 1;
            System.out.printf("Serão usadas %.0f latas", latas);
        }
        
    }
}