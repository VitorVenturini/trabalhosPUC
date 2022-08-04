// Andressa Farkas
// Vitor Venturini
// Pablo Montiel

import java.util.Scanner;

public class Aplicacao {
    public static void main (String [] args){
        CadastroDinossauro d = new CadastroDinossauro();

        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        
        System.out.println("Menu");
        System.out.println("1 - Cadastrar Dinossauro");
        System.out.println("2 - Pesquisar Dinossauro");
        System.out.println("3 - Remover Dinossauro");
        System.out.println("4 - RELATÓRIO: Quantidade de animais de cada tipo e categoria");
        System.out.println("5 - RELATÓRIO: Peso pesado");
        System.out.println("6 - RELATÓRIO: Quantidade de carne para carnívoros");
        System.out.println("7 - RELATÓRIO: Dá tempo de fugir");
        System.out.println("8 - RELATÓRIO: Top 10 mais velozes");
        System.out.println("9 - listar todos os Dinossauros");
        System.out.println("10 - Gerar 15 Dinossauros aleatórios");
        System.out.println("11 - Sair do progama");
        System.out.print("Digite a opção desejada: ");

        opcao = sc.nextInt();
        boolean sair = false;
        while(sair == false){

            switch(opcao){
                case 1 : //ADICIONAR DINOSSAURO
                    d.adicionarDinossauro();       
                    break;

                case 2 : //PESQUISAR DINOSSAURO
                    System.out.print("Digite o ID do Dinossauro: ");
                    int id = sc.nextInt();
                    Dinossauro dino = d.pesquisarDinossauro(id);
        
                    if(dino == null){
                        System.out.println("Dinossauro com ID informado não exixte.");
                    }else{
                        System.out.println(dino);
                    }

                    break;
    
                case 3 : //REMOVER DINOSSAURO E CADA TIPO E CATEGORIA
                    System.out.print("Digite o ID do Dinossauro: ");
                    id = sc.nextInt();
                    d.removerDinossauro(id);
                    System.out.println("Dinossauro removido!");
                    break;
    
    
                case 4 :  //RELATÓRIO QUANTIDADE DE DINOSSAUROS
                    System.out.println(d.quantidadeAnimais());
                    break;

                
                case 5 : // RELATÓRIO PESO PESADO
                    System.out.println("Tipo:");
                    System.out.println("1 - CARNIVORO");
                    System.out.println("2 - HERBIVORO");
                    int tipo = sc.nextInt();

                    System.out.println("Categoria:");
                    System.out.println("1 - PEQUENO PORTE");
                    System.out.println("2 - MEDIO PORTE");
                    System.out.println("3 - GRANDE PORTE");
                    int categoria = sc.nextInt();

                    d.pesoPesado(tipo, categoria);
                    System.out.println(d.pesoPesado(tipo, categoria));

                    break;

                case 6 : // RELATÓRIO QUANTIDADE DE CARNE
                    d.quantidadeCarne();
                    System.out.println(d.quantidadeCarne() + " kg");
                    break;
                
                case 7 : //RELATÓRIO DA TEMPO DE FUGIR
                    System.out.print("ID do dinossauro: ");
                    id = sc.nextInt();

                    System.out.print("Distância entre o dinossauro e o bunker [km]: ");
                    int distDinoBunker = sc.nextInt();

                    System.out.print("Distância entre a pessoa e o bunker [km]: ");
                    int distPessoaBunker = sc.nextInt();
                    
                    if(d.fugir(id, distDinoBunker, distPessoaBunker)){
                        System.out.println("Consegue fugir!");

                    }else{

                        System.out.println("Não consegue fugir!");
                    }
                    break;

                case 8 : //RELATÓRIO TOP 10 MAIS VELOSES 
                    d.top10();
                    break;
                    
                case 9 : //IMPRIMIR TODOS OS DINOSSAUROS
                    d.listarDinossauros();    
                    break;
                    
                case 10 : //GERAR 15 DINOSSARUROS ALEATORIOS
                    d.adicionarDinossaurosAleatorios(15);
                    System.out.println("15 Dinossauros foram adicionados");
                    break;

                case 11 ://SAIR
                    System.out.println("Saindo...");
                    sair = true;
                    break;

                default:
                    System.out.println("Opção Inválida!");
        }

        if(sair == false){
            System.out.println("Menu");
            System.out.println("1 - Cadastrar Dinossauro");
            System.out.println("2 - Pesquisar Dinossauro");
            System.out.println("3 - Remover Dinossauro");
            System.out.println("4 - RELATÓRIO: Quantidade de animais de cada tipo e categoria");
            System.out.println("5 - RELATÓRIO: Peso pesado");
            System.out.println("6 - RELATÓRIO: Quantidade de carne para carnívoros");
            System.out.println("7 - RELATÓRIO: Dá tempo de fugir");
            System.out.println("8 - RELATÓRIO: Top 10 mais velozes");
            System.out.println("9 - listar todos os Dinossauros");
            System.out.println("10 - Gerar 15 Dinossauros aleatórios");
            System.out.println("11 - Sair do progama");
            System.out.print("Digite a opção desejada: ");

            opcao = sc.nextInt();
            }
        }
        sc.close();
    }  
}
