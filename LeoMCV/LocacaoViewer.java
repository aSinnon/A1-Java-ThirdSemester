package LeoMCV;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import JoaoMCV.*;
import Principal.Log;
import ZionMCV.*;

public class LocacaoViewer{
    private static final Scanner scanner = new Scanner(System.in);

    public static void menuLocacao(){
        System.out.println("\n--- MENU LOCAÇÃO ---");
        System.out.println("1. Criar Locação\n2. Devolução\n3. Cancelar Locação\n4. Histórico\n0. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = Integer.parseInt(scanner.nextLine());
        switch(opcao){
            case 1:
                iniciarFluxoCriacao();
                break;
            case 2:
                executarDevolucaoOuCancelamento();
                break;
            case 3:
                executarDevolucaoOuCancelamento();
                break;
            case 4:
                mostrarHistorico();
                break;
            case 0:
                System.out.println("Saindo do menu de locação...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static void iniciarFluxoCriacao(){
        System.out.println("\n--- CRIAR LOCAÇÃO ---");
        System.out.print("CPF do cliente: ");
        Cliente cliente = PessoaController.buscarPorCpfCliente(scanner.nextLine());
        if(cliente == null){
            System.out.println("Cliente não encontrado.");
            Log.gravar("ERRO: Cliente não encontrado no método iniciarFluxoCriacao().");
            return;
        }
        System.out.print("CPF do funcionário: ");
        Funcionario funcionario = PessoaController.buscarPorCpfFuncionario(scanner.nextLine());
        if(funcionario == null){
            System.out.println("Funcionário não encontrado.");
            Log.gravar("ERRO: Funcionário não encontrado no método iniciarFluxoCriacao().");
            return;
        }
        Veiculo veiculo = escolherVeiculoDisponivel();
        if(veiculo == null){
            System.out.println("Nenhum veículo disponível correspondente foi encontrado.");
            Log.gravar("ERRO: Nenhum veículo encontrado no método iniciarFluxoCriacao().");
            return;
        }
        System.out.print("Data da Locação: ");
        String dataLoc = scanner.nextLine();
        System.out.print("Data da Devolução: ");
        String dataDev = scanner.nextLine();
        if(veiculo instanceof Carro){
            LocacaoController.criarLocacaoCarro(cliente, funcionario, dataLoc, dataDev, (Carro) veiculo);
        } else if(veiculo instanceof Moto){
            LocacaoController.criarLocacaoMoto(cliente, funcionario, dataLoc, dataDev, (Moto) veiculo);
        }
        System.out.println("Locação realizada com sucesso!");
        Log.gravar("SUCESSO: Locação realiza com sucesso em iniciarFluxoCriacao().");
    }

    private static Veiculo escolherVeiculoDisponivel(){
        System.out.print("Marca do veículo: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ano do veículo: ");
        int ano = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> posicoes = VeiculoController.buscarVeiculo(marca, modelo, ano);
        if(posicoes.get(0) == -1){
            Log.gravar("ERRO: Nenhum veículo encontrado em escolherVeiculoDisponivel().");
            return null;
        }
        List<Veiculo> encontrados = new ArrayList<>();
        for(int i = 0; i < posicoes.size(); i++){
            int pos = posicoes.get(i);
            Veiculo v = VeiculoController.veiculo.get(pos);
            if(v.isDisponivel()){
                encontrados.clear();
                encontrados.add(v);
            }
        }
        if(encontrados.isEmpty()){
            Log.gravar("ERRO: Nenhum veículo disponível encontrado em escolherVeiculoDisponivel().");
            return null;
        }
        if(encontrados.size() == 1){
            Log.gravar("SUCESSO: Veículo disponível encontrado em escolherVeiculoDisponivel().");
            return encontrados.get(0);
        }
        System.out.print("Mais de um veículo disponível encontrado. Qual a placa do veículo desejado?");
        Log.gravar("AVISO: Mais de um veículo disponível encontrado em escolherVeiculoDisponivel().");
        return VeiculoController.buscarPorPlaca(scanner.nextLine());
    }

    private static void executarDevolucaoOuCancelamento(){
        System.out.println("\n--- FINALIZAR / CANCELAR LOCAÇÃO ---");
        System.out.print("CPF do funcionário: ");
        String cpfFunc = scanner.nextLine();
        System.out.print("CPF do cliente: ");
        String cpfCli = scanner.nextLine();
        if(LocacaoController.finalizarLocacao(cpfCli, cpfFunc)){
            System.out.println("Operação realizada com sucesso! Veículo liberado.");
            Log.gravar("SUCESSO: Veículo liberado em executarDevolucaoOuCancelamento().");
        } else {
            System.out.println("Locação ativa não encontrada para os dados informados.");
            Log.gravar("SUCESSO: Locação não encontrada em executarDevolucaoOuCancelamento().");
        }
    }

    private static void mostrarHistorico(){
        System.out.println("\n--- HISTÓRICO DE LOCAÇÕES ---");
        List<Locacao> historico = LocacaoController.obterHistorico();
        if(historico.isEmpty()){
            System.out.println("Nenhuma locação registrada.");
            Log.gravar("AVISO: Nenhuma locação registrada para ser impressa em mostrarHistorico().");
            return;
        }
        for(int i = 0; i < historico.size(); i++){
            Locacao loc = historico.get(i);
            System.out.printf("Cliente: %s | Func: %s | Retirada: %s | Devolução: %s | Placa Veículo: %s\n",
            loc.getCliente().getNome(), loc.getFuncionario().getNome(), loc.getDataLocacao(), loc.getDataDevolucao(), loc.getVeiculo().getPlaca());
        }
        Log.gravar("SUCESSO: Locação(ões) impressas em mostrarHistorico().");
    }
}