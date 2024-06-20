# ProjeData-Teste
Aplicação simples utilizando Java e Maven, com o objetivo de mostrar o uso de conceitos básicos de java em um sofware de gerenciamento de funcionarios.

## Passo a passo para testar o programa:

Este guia detalha os passos necessários para configurar o ambiente de desenvolvimento para um projeto utilizando Java e Maven.

**Pré-requisitos:**

* Computador com sistema operacional Windows

**Dependências:**

* **Maven** 
* **java** 

**Configuração do projeto em sua máquina:**

1. **Rodando o projeto localmente com Maven:**

   * Inicie o maven localmente na raiz do projeto:
      ```bash
        mvn clean package      
      ```

   * Rode a aplicação localmente:
      ```bash
         java -jar target/App-1.0-SNAPSHOT-jar-with-dependencies.jar      
      ```

2. **Caso não queira usar Maven:**

   * Compile os arquivos com o comando javac:
      ```bash
          javac main.java      
      ```

   * Rode a aplicação localmente:
      ```bash
         java Main  
      ```
