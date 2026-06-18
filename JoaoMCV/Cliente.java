package JoaoMCV;

public class Cliente extends Pessoa{
    private int taxa;

    public Cliente(String nome, String cpf, String telefone, int cashback){
        super(nome, cpf, telefone);
        this.taxa = cashback;
    }

    @Override
    public void setTaxa(int cashback){
        this.taxa = cashback;
    }
    @Override
    public int getTaxa(){ 
        return taxa; 
    }
}