package ZionMCV;

import java.util.ArrayList;

import Principal.GerenciadorDados;

public class VeiculoController{
    public static ArrayList<Veiculo> veiculo = new ArrayList<>();

    public static void carregarDados(){
        veiculo = GerenciadorDados.carregarArraylistDeArquivo("veiculo.dat");
    }
    public static void salvarDados(){
        GerenciadorDados.salvarArraylistParaArquivo("veiculo.dat", veiculo);
    }

    public static void adicionarCarro(String placaVeiculo, String marcaVeiculo, String modeloVeiculo, int anoVeiculo, boolean disponivelVeiculo, int cavaloCarro){
        Carro c = new Carro(placaVeiculo, marcaVeiculo, modeloVeiculo, anoVeiculo, disponivelVeiculo, cavaloCarro);
        veiculo.add(c);
        salvarDados();
    }
    public static void adicionarMoto(String placaVeiculo, String marcaVeiculo, String modeloVeiculo, int anoVeiculo, boolean disponivelVeiculo, int cilindradaMoto){
        Moto m = new Moto(placaVeiculo, marcaVeiculo, modeloVeiculo, anoVeiculo, disponivelVeiculo, cilindradaMoto);
        veiculo.add(m);
        salvarDados();
    }

    public static ArrayList<Integer> buscarVeiculo(String marcaBuscar){
        ArrayList<Integer> posicao = new ArrayList<>();
        for(int i = 0; i < veiculo.size(); i++){
            if(marcaBuscar.equals(veiculo.get(i).getMarca())){
                posicao.add(i);
            }
        }
        if(posicao.size() == 0){
            posicao.add(-1);
        }
        return posicao;
    }

    public static ArrayList<Integer> buscarVeiculo(String marcaBuscar, String modeloBuscar){
        ArrayList<Integer> posicao = new ArrayList<>();
        for(int i = 0; i < veiculo.size(); i++){
            if (marcaBuscar.equals(veiculo.get(i).getMarca()) && modeloBuscar.equals(veiculo.get(i).getModelo())){
                posicao.add(i);
            }
        }
        if(posicao.size() == 0){
            posicao.add(-1);
        }
        return posicao;
    }

    public static ArrayList<Integer> buscarVeiculo(String marcaBuscar, String modeloBuscar, int anoBuscar){
        ArrayList<Integer> posicao = new ArrayList<>();
        for(int i = 0; i < veiculo.size(); i++){
            if(marcaBuscar.equals(veiculo.get(i).getMarca()) && modeloBuscar.equals(veiculo.get(i).getModelo()) && anoBuscar == veiculo.get(i).getAno()){
                posicao.add(i);
            }
        }
        if(posicao.size() == 0){
            posicao.add(-1);
        }
        return posicao;
    }

    public static Veiculo buscarPorPlaca(String placaBuscar){
        for(int i = 0; i < veiculo.size(); i++){
            Veiculo v = veiculo.get(i);
            if(v.getPlaca().equalsIgnoreCase(placaBuscar)){
                return v;
            }
        }
        return null;
    }
}