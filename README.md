# A1-Java-ThirdSemester

# Sistema de Locação de Veículos

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/)

Um sistema completo de gerenciamento e locação de veículos (carros e motos) desenvolvido em Java puro. O projeto simula o funcionamento interno de uma locadora, abrangendo desde o cadastro de clientes e controle de frotas até o fluxo de locação, devolução, persistência de dados em arquivos binários e auditoria via logs de sistema.

---

## Informações Gerais sobre o Projeto

### Objetivos
O objetivo principal deste projeto foi aplicar conceitos avançados de **Programação Orientada a Objetos (POO)** e a arquitetura em camadas (separação entre visualização e regras de negócio) para solucionar um problema real de gestão. O foco foi construir um código modular, altamente extensível, seguro contra concorrência de locações e resiliente a reinicializações.

### Funcionalidades Principais
* **Gerenciamento de Pessoas:** Cadastro, edição, exclusão e listagem de Clientes (com taxas de Cashback) e Funcionários (com bônus).
* **Gerenciamento de Frota:** Cadastro e listagem de Carros (atribuição de cavalos de potência) e Motos (atribuição de cilindradas), controlando dinamicamente o status de disponibilidade.
* **Fluxo Automatizado de Locação:** * Validação em tempo real da existência de clientes e funcionários por CPF.
  * Filtro inteligente de veículos para garantir que apenas automóveis disponíveis (`true`) possam ser selecionados.
  * Resolução de ambiguidade por meio da busca por placa em casos de veículos com marcas/modelos idênticos.
* **Persistência de Dados:** Salvamento automático do estado das listas (`ArrayList`) em arquivos binários `.dat` utilizando o mecanismo de **Serialização do Java**. Os dados não são perdidos ao fechar a aplicação.
* **Sistema de Auditoria (Logs):** Geração contínua de um arquivo `log.txt` que registra o histórico cronológico de sucessos, avisos e erros gerados durante as operações.

---

## Estrutura das Classes e suas Relações

O projeto é organizado de forma modular utilizando **Packages (Pacotes)** para isolar responsabilidades, adotando uma variação conceitual do padrão MVC (Model-View-Controller):

### Pacote `JoaoMCV` (Módulo de Pessoas)
* **`Pessoa` (Classe Abstrata - Model):** Classe base contendo atributos como nome, CPF e telefone. Define as assinaturas abstratas para as taxas/bônus.
* **`Cliente` e `Funcionario` (Herança):** Especializações de `Pessoa`.
* **`PessoaController`:** Gerencia as listas na memória RAM, valida buscas por CPF e interage com o salvamento de dados.
* **`PessoaViewer`:** Interface de console que interage com o usuário para operações de clientes.

### Pacote `ZionMCV` (Módulo de Veículos)
* **`Veiculo` (Classe Abstrata - Model):** Classe base contendo placa, marca, modelo, ano e o estado booleano de disponibilidade.
* **`Carro` e `Moto` (Herança):** Especializações de `Veiculo` contendo particularidades (cavalos e cilindradas).
* **`VeiculoController` e `VeiculoViewer`:** Respectivamente, o motor de regras de negócio da frota e a interface visual de gerenciamento de veículos.

### Pacote `LeoMCV` (Módulo de Locações)
* **`Locacao` (Classe Abstrata - Model):** Representa o contrato de locação. Possui uma relação de **Associação** com as classes `Cliente` e `Funcionario`. Define métodos polimórficos abstratos para manipulação do veículo alugado.
* **`LocacaoCarro` e `LocacaoMoto` (Herança & Composição/Polimorfismo):** Classes que herdam de `Locacao` e aplicam polimorfismo para amarrar, especificamente, objetos do tipo `Carro` ou `Moto`.
* **`LocacaoController` e `LocacaoViewer`:** Camada responsável pela validação das regras de negócio das locações (ex: bloquear veículos indisponíveis, liberar status na devolução) e interface de menus.

### Pacote `Principal` (Núcleo do Sistema)
* **`PrincipalViewer`:** Ponto de entrada do programa. Configura a ordem correta de inicialização: primeiro carrega os arquivos do disco para as listas e depois renderiza o menu principal.
* **`GerenciadorDados`:** Classe utilitária genérica contendo streams de dados (`ObjectOutputStream` / `ObjectInputStream`) para ler e gravar arquivos `.dat`.
* **`Log`:** Mecanismo responsável por abrir o arquivo `log.txt
