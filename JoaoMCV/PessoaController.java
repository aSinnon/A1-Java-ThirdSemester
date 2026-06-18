package JoaoMCV;

import Principal.GerenciadorDados;
import java.util.ArrayList;
import java.util.List;

public class PessoaController{
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void carregarDados(){
        clientes = GerenciadorDados.carregarArraylistDeArquivo("clientes.dat");
        funcionarios = GerenciadorDados.carregarArraylistDeArquivo("funcionarios.dat");
    }
    public static void salvarDados(){
        GerenciadorDados.salvarArraylistParaArquivo("clientes.dat", clientes);
        GerenciadorDados.salvarArraylistParaArquivo("funcionarios.dat", funcionarios);
    }
    
    public static void criarFuncionarios(){
        if(funcionarios.isEmpty()){
            funcionarios.add(new Funcionario("Zion", "12345678900", "41912341234", 11));
            funcionarios.add(new Funcionario("Leonardo", "98765432100", "41943214321", 2));
            funcionarios.add(new Funcionario("Joao", "14120456900", "41998709013", 3));
            salvarDados();
        }
    }
    
    public static void addCliente(String nome, String cpf, String telefone, int cashback){
        clientes.add(new Cliente(nome, cpf, telefone, cashback));
        salvarDados();
    }

    public static Cliente buscarPorCpfCliente(String cpf){
        for(int i = 0; i < clientes.size(); i++){
            Cliente c = clientes.get(i);
            if(c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    public static Funcionario buscarPorCpfFuncionario(String cpf){
        for(int i = 0; i < funcionarios.size(); i++){
            Funcionario f = funcionarios.get(i);
            if(f.getCpf().equals(cpf)){
                return f;
            }
        }
        return null;
    }

    public static boolean excluirCliente(String cpf){
        Cliente c = buscarPorCpfCliente(cpf);
        if(c != null){
            clientes.remove(c);
            return true;
        }
        return false;
    }

    public static List<Cliente> obterTodosClientes(){
        return new ArrayList<>(clientes);
    }
}