package JoaoMCV;

public class Funcionario extends Pessoa{
    private int taxa;

    public Funcionario(String nome, String cpf, String telefone, int bonus){
        super(nome, cpf, telefone);
        this.taxa = bonus;
    }

    @Override
    public void setTaxa(int bonus){
        this.taxa = bonus;
    }
    @Override
    public int getTaxa(){
        return taxa;
    }
}