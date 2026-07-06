## 💪 FitForge

## SISTEMA DE RECOMENDAÇÃO DE TREINOS E DIETAS PERSONALIZADAS COM IA LOCAL.

Sistema desenvolvido em Java puro, sem uso de Frameworks. O usuário informa o seu objetivo (perder peso, ganhar massa, resistência física) e a IA gera um plano de treinos 
e dietas com base nas informações obtidas do usuário.

## 🚀 Tecnologias utilizadas

Java 21.
Maven — para gerenciamento de dependências e build.
Gson 2.14.0 — serialização e desserialização de JSON.
Ollama (qwen2.5) — LLM local para gerar as recomendações.

## 📋 Pré-requisitos

Java 17+
Maven 3.6+
Ollama instalado

## ⚙️ Como rodar

1. Instalar o modelo da IA: 
   ollama pull qwen2.5

2. Clonar repositório: 
   git clone https://github.com/shaos-sys/FitForge
   cd fitforge

3. Compilar o projeto:
   mvn package

4. Executar:
   java -jar target/fitforge-1.0-SNAPSHOT-jar-with-dependencies.jar

## 🗂️ Estrutura do projeto

fitforge/
├── pom.xml
├── rodar.bat
└── src/main/java/com/forgelabs/
    ├── services/
    │   ├── Main.java            — menu principal e controle do fluxo
    │   └── OllamaClient.java    — integração com a IA via HTTP
    └── features/
        ├── Menu.java            — exibição dos menus
        ├── AgendaTreino.java    — gerenciamento dos dias de treino
        └── Dieta.java           — recomendação de dieta

## 🎯 Funcionalidades

Informar objetivo de treino (ganhar massa, emagrecer, resistência...).
Selecionar dias da semana disponíveis para treinar.
Gerar recomendação de treino personalizada com IA.
Gerar recomendação de dieta semanal com IA.
Menu interativo no terminal.

## 🧠 Conceitos aplicados

Integração de LLM local via API REST (HttpClient nativo do Java).
Gerenciamento de dependências com Maven,
Serialização e desserialização de JSON com Gson.
ArrayList e laços de repetição para controle do menu.
Estrutura condicional para validação.
Separação de responsabilidades em pacotes (services e features).

## 👨‍💻 Autor

Desenvolvido por Hélio Souza como projeto pessoal para estudos, com foco em aprendizado de integrações de IA no Java puro.