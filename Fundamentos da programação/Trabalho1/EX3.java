 
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
        
        System.out.println("Ã?rea 1: " + area1 + "mË†2, Ã?rea 2: " + 
        area2 + "mË†2, Ã?rea Total: " + areaT + "mË†2");
        
        double latas;
        if (areaT%16 == 0) {
            //para caso use as latas de tinta completas sem sobra
            latas = (areaT*2)/16;
            System.out.printf("SerÃ£o usadas %.0f latas", latas);
        } else {
            //para caso use as latas de tinta, mas acabe sobrando em uma, essa uma ainda conta!
            latas = (int)(areaT*2)/16 + 1;
            System.out.printf("SerÃ£o usadas %.0f latas", latas);
        }
        
    }
}