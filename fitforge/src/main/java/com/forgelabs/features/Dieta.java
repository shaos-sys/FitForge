 package com.forgelabs.features;

 import java.util.Scanner;

 public class Dieta {
    
 private String alergiaAlimentar;
 private String intensidadeTreino;

     public void setPerguntasDieta(Scanner sc){
     System.out.println("Possui alguma alergia alimentar? ");
     System.out.print("Resposta: ");
      alergiaAlimentar = sc.nextLine();

     System.out.println("Qual a intensidade do treino? (Leve, moderada, pesada...)");
     System.out.println("Resposta: ");
      intensidadeTreino = sc.nextLine(); 

     }
 }
