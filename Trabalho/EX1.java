 
import java.util.Scanner;

/**
 * @author Pablo_Montiel
 * @version 20220406
 */
public class EX1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a hora de início [hh mm]: ");
        int hi = sc.nextInt();
        int mi = sc.nextInt();
        
        System.out.println("Digite a hora de término [hh mm]: ");
        int ht = sc.nextInt();
        int mt = sc.nextInt();
        
        System.out.printf("Início: %02d:%02d, Término: %02d:%02d\n", hi, mi, ht, mt);
        
        //para calcular o valor do aluguel das quadras
        int hJ;
        int mJ;
        int valor;
        
        
        if(hi > 24 || hi < 0 || mi > 60 || mi < 0) {
            System.out.println("Horário de Início Inválido");
            return;
        }
        if(ht > 24 || ht < 0 || mt > 60 || mt< 0) {
            System.out.println("Horário de Término Inválido");
            return;
        }
        
        //tempo e preço do jogo
        if (ht > hi) {
            hJ = ((ht*60 + mt) - (hi*60 + mi)) / 60;
            mJ = ((ht*60 + mt) - (hi*60 + mi)) % 60;
            System.out.printf("A duração do jogo será de %02d:%02d", hJ, mJ);
            
            //definir o preço
            if(mJ != 0){
                valor = (hJ + 1) * 50;
                System.out.printf(", e custará cerca de R$%02d\n", valor);
            } else {
                valor = hJ * 50;
                System.out.printf(", e custará cerca de R$%02d\n", valor);
            }
        } else if (ht < hi) {
            hJ = (24*60 - (hi*60 + mi) + (ht*60 + mt)) / 60;
            mJ = (24*60 - (hi*60 + mi) + (ht*60 + mt)) % 60;
            System.out.printf("A duração do jogo será de %02d:%02d", hJ, mJ);
            
            if (mJ != 0) {
                valor = (hJ + 1)*50;
                System.out.printf(", e custará cerca de R$%02d\n", valor);
            } else {
                valor = hJ*50;
                System.out.printf(", e custará cerca de R$%02d\n", valor);
            }
        
            //caso a duração do jogo seja de um dia completo ou seja 0
        } else if (ht == hi) {
            if (mt > mi) {
                hJ = 0;
                mJ = mt - mi;
                System.out.printf("A duração do jogo será de %02d:%02d", hJ, mJ);
                
                valor = 50;
                System.out.printf(", e custará cerca de R$%02d\n", valor);
            } else if (mt < mi) {
                hJ = 23;
                mJ = mi - mt;
                System.out.printf("A duração do jogo será de %02d:%02d", hJ, mJ);
                
                valor = 24*50;
                System.out.printf(", e custará cerca de R$%02d\n", valor);
            } else {
                hJ = 24;
                mJ = 00;
                System.out.printf("A duração do jogo será de %02d:%02d", hJ, mJ);
                
                valor = hJ*50;
                System.out.printf(", e custará cerca de R$%02d\n", valor);
            }
        }
    }
}