 package com.forgelabs.services;

 import java.net.URI;
 import java.net.http.HttpClient;
 import java.net.http.HttpRequest;
 import java.net.http.HttpResponse;
 import java.util.ArrayList;
 import com.forgelabs.features.AgendaTreino;
 import com.forgelabs.features.Dieta;
 import com.google.gson.Gson;
 import com.google.gson.JsonObject;

 public class OllamaClient {

 AgendaTreino listaDias = new AgendaTreino();   
 Dieta dietResp = new Dieta();

 public String URL = "http://localhost:11434/api/generate";
 public String MODEL = "qwen2.5";
 private final Gson gson = new Gson();

     public String gerarTreino(String objetivo, ArrayList<String> listaDias) throws Exception {
      String promptTreino = montarPromptTreino(objetivo, listaDias);

     JsonObject body = new JsonObject();
       body.addProperty("model", MODEL);
       body.addProperty("prompt", promptTreino);
       body.addProperty("stream", false);

     HttpClient client = HttpClient.newHttpClient();
     HttpRequest request = HttpRequest.newBuilder()
       .uri(URI.create(URL))
       .header("Content-Type", "application/json")
       .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(body)))
       .build();
       
     HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());   
     JsonObject resposta = gson.fromJson(response.body(), JsonObject.class);

     return resposta.get("response").getAsString();
     }

       public String gerarDieta(String objetivo) throws Exception {
        String promptDieta = montarPromptDieta(objetivo);

       JsonObject body01 = new JsonObject();
        body01.addProperty("model", MODEL); 
        body01.addProperty("prompt", promptDieta); 
        body01.addProperty("stream", false); 

       HttpClient client01 = HttpClient.newHttpClient();
       HttpRequest request01 = HttpRequest.newBuilder()
        .uri(URI.create(URL))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(body01)))
        .build();

       HttpResponse<String> response01 = client01.send(request01, HttpResponse.BodyHandlers.ofString());
       JsonObject resposta01 = gson.fromJson(response01.body(), JsonObject.class);

       return resposta01.get("response").getAsString();
       }

             public String montarPromptTreino(String objetivo, ArrayList<String>listaDias){
              StringBuilder sb1 = new StringBuilder();
        
             sb1.append("Você irá montar uma lista de exercício de treino de academia.\n");
             sb1.append("Esses são os objetivos do usuário: ").append(objetivo).append("\n\n");
             sb1.append("O treino deve ser montado com base nesses objetivos.\n");
             sb1.append("Além dos objetivos, o treino deve ser montado com base nos dias da semana que o usuário deseja.\n");

               sb1.append("Os dias da semana que o usuário deseja são:\n ");
               for(int i = 0; i < listaDias.size(); i++){
                sb1.append(i + 1).append(". ").append(listaDias.get(i)).append("\n");
               }
                
             sb1.append("Com base no objetivo do usuário e nos dias da semana o treino deve ser montado\n");
             sb1.append("REGRAS IMPORTANTE\n");
             sb1.append("Os treinos devem levar em conta somente os objetivos do usuário e devem ser montados conforme os dias da semana do usuário.");
             sb1.append("Responda em português do Brasil.");
             
             return sb1.toString();
             }   
    

                 public String montarPromptDieta(String objetivo){
                  StringBuilder sb2 = new StringBuilder();
                  
                 sb2.append("Agora, você irá montar uma dieta completa para o usuário.\n");
                 sb2.append("É uma dieta para treinos. \n");
                 sb2.append("A dieta deve ser montada conforme os objetivos do usuário, que são: ").append(objetivo).append("\n\n");
                 sb2.append("REGRAS IMPORTANTE.\n");
                 sb2.append("A dieta deve ser montada somente conforme os objetivos do usuário já fornecidos, que são: ").append(objetivo).append("\n\n");
                 
                  sb2.append("Para montar a dieta, aqui estão mais algumas informações do usuário: \n");
                  sb2.append(dietResp.getDieta()).append("\n\n");
                
                 sb2.append("Com base nessas respostas, deve ser montada a dieta, de forma mais simples e de fácil entendimento para o usuário.");
                 sb2.append("Responda em português do Brasil.");

                 return sb2.toString();
                 }

 }
