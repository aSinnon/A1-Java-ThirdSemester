package ZionMCV;
import java.io.Serializable;

abstract public class Veiculo implements Serializable{
    private String marca;
    private String modelo;
    private int ano;
    private boolean disponivel;
    private String placa;

    public Veiculo(String placa, String marca, String modelo, int ano, boolean disponivel){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.disponivel = disponivel;
        this.placa = placa;
    }

    abstract public String obterDadosEspecificos();

    public void setPlaca(String placa){
        this.placa = placa;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public void setAno(int ano){
        this.ano = ano;
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    public String getPlaca(){
        return placa;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public int getAno(){
        return ano;
    }
    public boolean isDisponivel(){
        return disponivel;
    }
}