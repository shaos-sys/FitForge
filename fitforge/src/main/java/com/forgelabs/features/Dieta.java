 package com.forgelabs.features;

 import java.util.Scanner;

 public class Dieta {
 
  String intensidadeTreino;
  String restAlimentar;
  String difiAlimentar;
  String idade;
  String peso;
    
     public void setPerguntasDieta(Scanner sc){
     System.out.println("Qual a intensidade do treino? (Leve, moderada, pesada...)");
     System.out.print("R: ");
      intensidadeTreino = sc.nextLine(); 
     
     System.out.println("Possui alguma restrição alimentar?"); 
     System.out.print("R: ");
      restAlimentar = sc.nextLine();

     System.out.println("Costuma ter alguma dificuldade para se alimentar? (Ex: Falta de tempo para cozinhar, dificuldade em comer sem distrações, etc..."); 
     System.out.print("R: ");
      difiAlimentar = sc.nextLine();
     
     System.out.println("Qual sua idade?"); 
     System.out.print("R: ");
      idade = sc.nextLine();

     System.out.println("Qual seu peso?");
      System.out.print("R: ");
      peso = sc.nextLine(); 
     
     }

     public String getDieta(){
      StringBuilder dt = new StringBuilder();
     dt.append("Intensidade do treino: " + intensidadeTreino + "\n");
     dt.append("Restrição alimentar: " + restAlimentar + "\n"); 
     dt.append("Dificuldade para se alimentar: "+ difiAlimentar + "\n");
     dt.append("Idade: " + idade + "\n");
     dt.append("Peso: " + peso + "kg \n");
       return dt.toString();     
     }

        
 }
