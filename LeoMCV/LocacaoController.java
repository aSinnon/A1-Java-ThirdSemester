package LeoMCV;

import java.util.ArrayList;
import java.util.List;
import JoaoMCV.Cliente;
import JoaoMCV.Funcionario;
import Principal.GerenciadorDados;
import ZionMCV.Carro;
import ZionMCV.Moto;

public class LocacaoController{
    private static ArrayList<Locacao> locacoes = new ArrayList<>();

    public static void carregarDados(){
        locacoes = GerenciadorDados.carregarArraylistDeArquivo("locacoes.dat");
    }
    public static void salvarDados(){
        GerenciadorDados.salvarArraylistParaArquivo("locacoes.dat", locacoes);
    }

    public static void criarLocacaoCarro(Cliente cliente, Funcionario funcionario, String dataLocacao, String dataDevolucao, Carro carro){
        carro.setDisponivel(false);
        locacoes.add(new LocacaoCarro(cliente, funcionario, dataLocacao, dataDevolucao, carro));
        salvarDados();
    }

    public static void criarLocacaoMoto(Cliente cliente, Funcionario funcionario, String dataLocacao, String dataDevolucao, Moto moto){
        moto.setDisponivel(false);
        locacoes.add(new LocacaoMoto(cliente, funcionario, dataLocacao, dataDevolucao, moto));
        salvarDados();
    }

    public static Locacao buscarLocacao(String cpfCliente, String cpfFuncionario){
        for(int i = 0; i < locacoes.size(); i++){
            Locacao loc = locacoes.get(i);
            if(loc.getCliente().getCpf().equals(cpfCliente) && loc.getFuncionario().getCpf().equals(cpfFuncionario)){
                return loc;
            }
        }
        return null;
    }

    public static boolean finalizarLocacao(String cpfCliente, String cpfFuncionario){
        Locacao locacao = buscarLocacao(cpfCliente, cpfFuncionario);
        if(locacao != null){
            locacao.getVeiculo().setDisponivel(true);
            locacoes.remove(locacao);
            salvarDados();
            return true;
        }
        return false;
    }

    public static List<Locacao> obterHistorico(){
        return locacoes;
    }
}