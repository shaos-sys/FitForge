 package com.forgelabs.features;

 import java.util.ArrayList;
 import java.util.Scanner;

 public class AgendaTreino {
 private ArrayList<String> listaDias = new ArrayList<>();

 String dias;
      
     public void setAdicionarDias(Scanner sc){
    
     do{
      System.out.println("Dias de treino na semana: (Digite 'N' para sair.)");
      dias = sc.nextLine();
     if (!dias.equalsIgnoreCase("n")) {
        listaDias.add(dias);     
     }    
      } while (!dias.equalsIgnoreCase("n"));   
     }

             public ArrayList<String> getListaDias(){
               return listaDias;   
             }
    
 }
