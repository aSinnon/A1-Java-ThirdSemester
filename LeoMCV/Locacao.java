package LeoMCV;

import JoaoMCV.Cliente;
import JoaoMCV.Funcionario;
import ZionMCV.Veiculo;

import java.io.Serializable;

abstract public class Locacao implements Serializable{
    private Cliente cliente;
    private Funcionario funcionario;
    private String dataLocacao;
    private String dataDevolucao;

    public Locacao(Cliente cliente, Funcionario funcionario, String dataLocacao, String dataDevolucao){
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
    }

    abstract public Veiculo getVeiculo();
    abstract public void setVeiculo(Veiculo veiculo);

    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Funcionario getFuncionario(){
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public String getDataLocacao(){
        return dataLocacao;
    }
    public void setDataLocacao(String dataLocacao){
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao(){
        return dataDevolucao;
    }
    public void setDataDevolucao(String dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }
}