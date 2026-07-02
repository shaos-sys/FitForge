 package com.forgelabs.services;

 import java.util.Scanner;
 import com.forgelabs.features.AgendaTreino;
import com.forgelabs.features.Dieta;
import com.forgelabs.features.Menu;

 public class Main {
     public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);   
     
     Menu m = new Menu();
     AgendaTreino agenda = new AgendaTreino();
     OllamaClient ollama = new OllamaClient();
     Dieta dietaResp = new Dieta();

     int opcao = 0;   
     String objetivo = " ";
    
        m.menuPrincipal();
        opcao = scan.nextInt();
        scan.nextLine();

     while (opcao != 5) {
      
         switch (opcao) {

             case 1:
             System.out.println("====== SEU OBJETIVO ======");
             System.out.print("Objetivo: ");
               objetivo = scan.nextLine();
               m.menuPrincipal();
               opcao = scan.nextInt();  
               scan.nextLine();
             break;

             case 2:
             agenda.setAdicionarDias(scan);
              m.menuPrincipal();
              opcao = scan.nextInt();
              scan.nextLine(); 
             break;

             case 3:
             if (agenda.getListaDias().isEmpty()) {
             System.out.println("Informe os dias da semana primeiro! ");
              m.menuPrincipal();
              opcao = scan.nextInt();  
              scan.nextLine();
             break; 
             }

               System.out.println("Gerando treino...");
               try {
               System.out.println("====== TREINO ======");                               
                String treino = ollama.gerarTreino(objetivo, agenda.getListaDias());
               System.out.println(treino); 
                
               } catch (Exception e) {             
               System.out.println("Falha ao conectar com ollama.");
               System.out.println("Certifique-se que a conexação com Ollama 'Ollama serve' está rodando.");
               }

                m.menuPrincipal();
                opcao = scan.nextInt();  
                scan.nextLine();
               break;

             case 4:
             dietaResp.setPerguntasDieta(scan); 
             System.out.println("Gerando dieta...");
              try {
             System.out.println("====== DIETA ======"); 
              String dieta = ollama.gerarDieta(objetivo);
             System.out.println(dieta); 
             
              } catch (Exception e) {
             System.out.println("Falha ao conectar com ollama.");   
             System.out.println("Certifique-se que a conexação com Ollama 'Ollama serve' está rodando.");
             } 

              m.menuPrincipal();
              opcao = scan.nextInt();  
              scan.nextLine();
             break;

             default:
             System.out.println("Opção inválida!");
               m.menuPrincipal();
               opcao = scan.nextInt(); 
               scan.nextLine();  
             break;

          }  
         } 

     System.out.println("Encerrando...");

    }
   }