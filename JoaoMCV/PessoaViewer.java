package JoaoMCV;

import java.util.Scanner;

import Principal.Log;

import java.util.List;

public class PessoaViewer{
    private static final Scanner scanner = new Scanner(System.in);

    public static void menuCliente(){
        boolean rodando = true;
        while(rodando){
            System.out.println("\n--- MENU CLIENTE ---");
            System.out.println("1. Cadastrar");
            System.out.println("2. Editar");
            System.out.println("3. Excluir");
            System.out.println("4. Listar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch(opcao){
                case 1:
                    menuCadastrar();
                    break;
                case 2:
                    menuEditar();
                    break;
                case 3:
                    menuExcluir();
                    break;
                case 4:
                    menuListar();
                    break;
                case 0: {
                    System.out.println("Saindo do menu cliente...");
                    rodando = false;
                    break;
                }
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void menuCadastrar(){
        System.out.println("\n--- CADASTRAR CLIENTE ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Cashback (%): ");
        int cashback = Integer.parseInt(scanner.nextLine());
        PessoaController.addCliente(nome, cpf, telefone, cashback);
        System.out.println("Cliente cadastrado com sucesso!");
        Log.gravar("SUCESSO: Cliente "+nome+" de CPF "+cpf+" cadastrado.");
    }

    private static void menuEditar(){
        System.out.println("\n--- EDITAR CLIENTE ---");
        System.out.print("Digite o CPF do cliente que deseja editar: ");
        Cliente cliente = PessoaController.buscarPorCpfCliente(scanner.nextLine());
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
            Log.gravar("ERRO: Cliente não encontrado no menuEditar().");
            return;
        }
        System.out.println("\nCliente encontrado: " + cliente.getNome());
        System.out.println("O que deseja editar?");
        System.out.println("1. Nome");
        System.out.println("2. CPF");
        System.out.println("3. Telefone");
        System.out.println("4. Cashback");
        System.out.print("Escolha uma opção: ");
        int subOpcao = Integer.parseInt(scanner.nextLine());
        switch(subOpcao){
            case 1: {
                System.out.print("Novo Nome: ");
                cliente.setNome(scanner.nextLine());
                System.out.println("Nome alterado com sucesso!");
                Log.gravar("SUCESSO: Nome do cliente de CPF "+cliente.getCpf()+" alterado para "+cliente.getNome());
            }
                break;
            case 2: {
                System.out.print("Novo CPF: ");
                cliente.setCpf(scanner.nextLine());
                System.out.println("CPF alterado com sucesso!");
                Log.gravar("SUCESSO: Cliente "+cliente.getNome()+" teve seu CPF alterado para "+cliente.getCpf());
            }
                break;
            case 3: {
                System.out.print("Novo Telefone: ");
                cliente.setTelefone(scanner.nextLine());
                System.out.println("Telefone alterado com sucesso!");
                Log.gravar("SUCESSO: Cliente "+cliente.getNome()+" de CPF "+cliente.getCpf()+" teve seu telefone alterado para "+cliente.getTelefone());
            
            }
                break;
            case 4: {
                System.out.print("Novo Cashback: ");
                cliente.setTaxa(Integer.parseInt(scanner.nextLine()));
                System.out.println("Cashback alterado com sucesso!");
                Log.gravar("SUCESSO: Cliente "+cliente.getNome()+" de CPF "+cliente.getCpf()+" teve seu cashback alterado para "+cliente.getTaxa());
            }
                break;
            default:
                System.out.println("Opção inválida. Nenhuma alteração feita.");
                Log.gravar("AVISO: Cliente encontrado mas opção inválida selecionada no menuEditar().");
                break;
        }
    }

    private static void menuExcluir(){
        System.out.println("\n--- EXCLUIR CLIENTE ---");
        System.out.print("Digite o CPF do cliente: ");
        if(PessoaController.excluirCliente(scanner.nextLine())){
            System.out.println("Cliente removido com sucesso.");
            Log.gravar("SUCESSO: Cliente removido com sucesso no menuExcluir().");
        } else {
            System.out.println("Cliente não encontrado.");
            Log.gravar("ERRO: Cliente não encontrado no menuExcluir().");
        }
    }

    private static void menuListar(){
        System.out.println("\n--- LISTA DE CLIENTES ---");
        List<Cliente> lista = PessoaController.obterTodosClientes();
        if(lista.isEmpty()){
            System.out.println("Nenhum cliente cadastrado.");
            Log.gravar("AVISO: Nenhum cliente cadastrado para imprimir.");
            return;
        }
        for(int i = 0; i < lista.size(); i++){
            Cliente c = lista.get(i);
            System.out.printf("Nome: %s - CPF: %s - Telefone: %s - Cashback: %d%%\n", 
            c.getNome(), c.getCpf(), c.getTelefone(), c.getTaxa());
        }
        Log.gravar("SUCESSO: Clientes impressos no menuListar().");
    }
}