package LeoMCV;

import JoaoMCV.Cliente;
import JoaoMCV.Funcionario;
import ZionMCV.Carro;
import ZionMCV.Veiculo;

public class LocacaoCarro extends Locacao{
    Carro carro;

    public LocacaoCarro(Cliente cliente, Funcionario funcionario, String dataLocacao, String dataDevolucao, Carro carro){
        super(cliente, funcionario, dataLocacao, dataDevolucao);
        this.carro = carro;
    }

    @Override
    public Veiculo getVeiculo(){
        return carro;
    }
    @Override
    public void setVeiculo(Veiculo veiculo){
        Carro c = (Carro) veiculo;
        this.carro = c;
    }
}