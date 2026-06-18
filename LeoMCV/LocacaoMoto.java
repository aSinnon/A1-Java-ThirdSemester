package LeoMCV;

import JoaoMCV.Cliente;
import JoaoMCV.Funcionario;
import ZionMCV.Moto;
import ZionMCV.Veiculo;

public class LocacaoMoto extends Locacao{
    Moto moto;

    public LocacaoMoto(Cliente cliente, Funcionario funcionario, String dataLocacao, String dataDevolucao, Moto moto){
        super(cliente, funcionario, dataLocacao, dataDevolucao);
        this.moto = moto;
    }

    @Override
    public Veiculo getVeiculo(){
        return moto;
    }
    @Override
    public void setVeiculo(Veiculo veiculo){
        Moto m = (Moto) veiculo;
        this.moto = m;
    }
}