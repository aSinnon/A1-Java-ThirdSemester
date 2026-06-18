package ZionMCV;

public class Carro extends Veiculo{
    private int cavalos;

    public Carro(String placa, String marca, String modelo, int ano, boolean disponivel, int cavalos){
        super(placa, marca, modelo, ano, disponivel);
        this.cavalos = cavalos;
    }

    @Override
    public String obterDadosEspecificos(){
        return "Cavalos: " + cavalos;
    }

    public int getCavalos(){
        return cavalos;
    }
    public void setCavalos(int cavalos){
        this.cavalos = cavalos;
    }
}