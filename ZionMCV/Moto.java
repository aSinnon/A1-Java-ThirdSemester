package ZionMCV;

public class Moto extends Veiculo{
    private int cilindradas;

    public Moto(String placa, String marca, String modelo, int ano, boolean disponivel, int cilindradas){
        super(placa, marca, modelo, ano, disponivel);
        this.cilindradas = cilindradas;
    }

    @Override
    public String obterDadosEspecificos(){
        return "Cilindradas: " + cilindradas;
    }

    public int getCilindradas(){
        return cilindradas;
    }
    public void setCilindradas(int cilindradas){
        this.cilindradas = cilindradas;
    }
}