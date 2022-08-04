import java.util.Scanner;
public class trabalho2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("DIGITE SUA OPÇÃO:\n 1 - CIFRAR\n 2 - DECIFRAR\n 3 - SAIR");
        int num = Integer.parseInt(sc.nextLine());

        while(num < 1 || num > 3){
            System.out.println("DIGITE SUA OPÇÃO:\n 1 - CIFRAR\n 2 - DECIFRAR\n 3 - SAIR");
            num = Integer.parseInt(sc.nextLine());
        }

        switch(num){
            case 1:
            System.out.println("DIGITE O TEXTO PARA SER CIFRADO:");
            String texto = sc.nextLine();
            String cifrado = "";
            for(int i = 0; i < texto.length(); i++){
                char c = texto.charAt(i);
                if(texto.charAt(i) == ' '){
                    cifrado = cifrado + c;
                }else{
                    cifrado = cifrado + "p" + c;
                }
            }
            System.out.println(cifrado);
            break;

            case 2:
            System.out.println("DIGITE O TEXTO PARA SER DECIFRADO:");
            String textod = sc.nextLine();
            String decifrado = "";

            for(int i = 0; i < textod.length(); i++){
                char c = textod.charAt(i);

                if(c == ' '){
                    decifrado = decifrado + c;
                }else if(c == 'p' && textod.charAt(i + 1) != 'p'){
                    decifrado = decifrado + textod.charAt(i + 1);
                } else if(c == 'p' && textod.charAt(i + 1) == 'p' && textod.charAt(i + 2) == 'p'){
                    decifrado = decifrado + "p";
                }
                
            }
            System.out.println(decifrado);
            break;

            case 3:
            System.out.println("VOCE SAIU");
            break;

        }
    }
}