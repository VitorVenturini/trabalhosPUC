import java.util.Random;
import java.util.Scanner;

public class CadastroDinossauro { 

    private  Dinossauro[] dinossauros;
    private int tam;

    public CadastroDinossauro() {
        dinossauros = new Dinossauro[100];
        tam = 0;
    }
    
    public boolean adicionarDinossauro(){
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o ID do dinossauro: ");
        int id = s.nextInt();
        System.out.print("Digite a raça do dinossauro: ");
        String raca = s.next();
        System.out.print("Digite o tipo do dinossauro [1 para carnívoro e 2 para herbívoro]: ");
        int tipo = s.nextInt();
        System.out.print("Digite a categoria do dinossauro [1 para Pequeno Porte, 2 para Médio Porte e 3 para Grande Porte]: ");
        int categoria = s.nextInt();
        System.out.print("Digite o peso do dinossauro (kg): ");
        double peso = s.nextDouble();
        System.out.print("Digite a velocidade do dinossauro (km/h): ");
        double velocidade = s.nextDouble();

        dinossauros[tam++] = new Dinossauro(id, raca, tipo, categoria, peso, velocidade);

        System.out.println("Novo dinossauro cadastrado!");
        return true;
    }
    
    public Dinossauro pesquisarDinossauro(int id){ 
        for (int i = 0; i < tam; i++) {
            if (dinossauros[i].getId() == id) {
                return dinossauros[i];
            }
        }
        return null;
    }

    public boolean removerDinossauro(int id){
        int pos = 0;
        boolean achou = false;
        for (int i = 0; i < tam; i++) {
            if(dinossauros[i].getId() == id){
                dinossauros[i] = null;
                achou = true;
                pos = i;
                tam --;
                break;
            }
        }
        if (achou == true){
            for(int j = pos; j < tam; j ++){
                dinossauros[j] = dinossauros[j + 1];
            }
            return true;
        }else{
            return false;
        }
    }

    // Relatórios
    public String quantidadeAnimais(){
        int carniviros_pp = 0;
        int carnivoros_mp = 0;
        int carnivoros_gp = 0;
        int herbivoros_pp = 0;
        int herbivoros_mp = 0;
        int herbivoros_gp = 0;
        for (int i = 0; i < tam; i++) {
            if (dinossauros[i].getTipo() == 1 && dinossauros[i].getCategoria() == 1) {
                carniviros_pp ++;
            }else if(dinossauros[i].getTipo() == 1 && dinossauros[i].getCategoria() == 2){
                carnivoros_mp ++;
            }else if(dinossauros[i].getTipo() == 1 && dinossauros[i].getCategoria() == 3){
                carnivoros_gp ++;
            }else if(dinossauros[i].getTipo() == 2 && dinossauros[i].getCategoria() == 1){
                herbivoros_pp ++;
            }else if(dinossauros[i].getTipo() == 2 && dinossauros[i].getCategoria() == 2){
                herbivoros_mp ++;
            }else if(dinossauros[i].getTipo() == 2 && dinossauros[i].getCategoria() == 3){
                herbivoros_gp ++;
            }
        }
        String car = "Carnívoros: PP: " + carniviros_pp +", MP: " + carnivoros_mp + ", GP: " + carnivoros_gp + ". ";
        String herb = "Herbívoros: PP: " + herbivoros_pp +", MP: " + herbivoros_mp + ", GP: " + herbivoros_gp + ".";
    
        return (car + herb);
    }

    public Dinossauro pesoPesado(int tipo, int categoria){ 
        Dinossauro maior = null; 
        for (int i = 0; i < tam; i++){
            if(dinossauros[i].getTipo() == tipo && dinossauros[i].getCategoria() == categoria){
                if (maior == null || maior.getPeso() < dinossauros[i].getPeso()) {
                    maior = dinossauros[i];
                }
            }
        }
        return maior;
    }

    public double quantidadeCarne(){ //RELATÓRIO QUANTIDADE DE CARNE
        int pp = 0;
        int mp = 0;
        int gp = 0;
        for (int i = 0; i < tam; i++) {
            if (dinossauros[i].getTipo() == 1 && dinossauros[i].getCategoria() == 1) {
                pp ++;
            }else if(dinossauros[i].getTipo() == 1 && dinossauros[i].getCategoria() == 2){
                mp ++;
            }else if(dinossauros[i].getTipo() == 1 && dinossauros[i].getCategoria() == 3){
                gp ++;
            }
        }
        double kg = (double)((pp * 0.1) + (mp * 0.15) + (gp * 0.2)) * 30;
        return kg;
    }

    public boolean fugir(int id, double distDinoBunker, double distPessoaBunker){
        double tempoPessoa = distPessoaBunker / 20;
        double tempoDinossauro = 0; 
        for(int i = 0; i < tam; i ++){
            if(dinossauros[i].getId() == id){
                tempoDinossauro = distDinoBunker / dinossauros[i].getVelocidade();
            }
        }

        if(tempoDinossauro <= tempoPessoa){
            return false;
        }
        else{
            return true;
        }
    }

    private boolean inserePosicao(Dinossauro[] vetor, int tam, Dinossauro d, int pos) {

        // desloca vetor para abrir espaço para novo Dinossauro
        for (int i = tam; i > pos; i--) {
            vetor[i] = vetor[i-1]; 
        }

        vetor[pos] = d;
        tam++;
        return true;
    }

    private boolean insereOrdenado(Dinossauro[] vetor, int tam, Dinossauro d) {
        int pos = tam;
        for (int i = 0; i < tam; i++) {
            if (d.getVelocidade() > vetor[i].getVelocidade()) {
                pos = i;
                break;
            }
        }
        return inserePosicao(vetor, tam, d, pos);
    }

    public Dinossauro[] top10(){ //RELATÓRIO TOP 10 MAIS VELOSES
        Dinossauro[] top10velocidade = new Dinossauro[10];

        Dinossauro[] ordenado = new Dinossauro[dinossauros.length];
        for (int i = 0; i < 10; i++) {
            insereOrdenado(ordenado, i, dinossauros[i]);            
        }

        for (int i = 0; i < 10; i++) {
            
            if(ordenado[i]!= null){
                System.out.println(ordenado[i]);
            }

        }
        
        return top10velocidade;
    }
    public boolean adicionarDinossaurosAleatorios(int quantidade) {
        Random random = new Random();
        String[] nomes = { "Tiranossauro Rex", "Velociraptor", "Diplodoco", "Tricerátops", "Pterodáctilo", "Estegossauro" };

        for (int i = 0; i < quantidade; i++) {
            int id = tam + 1;
            String raca = nomes[random.nextInt(nomes.length)];
            int tipo = random.nextInt(2) + 1;

            int categoria = random.nextInt(3) + 1;

            double peso_inteiro = (random.nextDouble() * 899) + 101;
            double peso = Math.round(peso_inteiro * 100) / 100;  // arredonda o double pra duas casas decimais

            double velocidade_inteira = random.nextDouble() * 59 + 1;
            double velocidade = Math.round(velocidade_inteira * 100) / 100;

            dinossauros[tam++] = new Dinossauro(id, raca, tipo, categoria, peso, velocidade);
        }
        return true;
    }

    public void listarDinossauros() {
        for (int i = 0; i < tam; i++) {
            System.out.println(dinossauros[i]);
        }
    }
}

