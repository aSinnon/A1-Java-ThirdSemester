package ZionMCV;

import java.util.Scanner;

import Principal.Log;

import java.util.ArrayList;

public class VeiculoViewer{
    public static void menuEditar(ArrayList<Integer> arrayPosicoes){
        Scanner sc = new Scanner(System.in);
        String marca = VeiculoController.veiculo.get(arrayPosicoes.get(0)).getMarca();
        String modelo = VeiculoController.veiculo.get(arrayPosicoes.get(0)).getModelo();
        int ano = VeiculoController.veiculo.get(arrayPosicoes.get(0)).getAno();
        String placa = VeiculoController.veiculo.get(arrayPosicoes.get(0)).getPlaca();
        boolean disponivel = VeiculoController.veiculo.get(arrayPosicoes.get(0)).isDisponivel();
        System.out.println("Marca: " + marca + " - Modelo: " + modelo + " - Ano: " + ano + " - Placa: " + placa + " - Disponivel: " + (disponivel ? "Sim" : "Não"));
        System.out.println("EDITAR\n1. Marca\n2. Modelo\n3. Ano\n4. Placa\n5. Disponibilidade");
        int op = Integer.parseInt(sc.nextLine());
        switch(op){
            case 1:
                System.out.println("Nova marca:");
                VeiculoController.veiculo.get(arrayPosicoes.get(0)).setMarca(sc.nextLine());
                break;
            case 2:
                System.out.println("Novo modelo:");
                VeiculoController.veiculo.get(arrayPosicoes.get(0)).setModelo(sc.nextLine());
                break;
            case 3:
                System.out.println("Novo ano:");
                VeiculoController.veiculo.get(arrayPosicoes.get(0)).setAno(Integer.parseInt(sc.nextLine()));
                break;
            case 4:
                System.out.println("Nova placa:");
                VeiculoController.veiculo.get(arrayPosicoes.get(0)).setPlaca(sc.nextLine());
                break;
            case 5:
                System.out.println("Disponibilidade (true/false):");
                VeiculoController.veiculo.get(arrayPosicoes.get(0)).setDisponivel(Boolean.parseBoolean(sc.nextLine()));
                break;
            default:
                System.out.println("Opcao invalida.");
                break;
        }
    }

    public static String menuVeiculo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("MENU VEICULO\n1. Cadastrar Carro\n2. Cadastrar Moto\n3. Editar\n4. Listar");
        int op = Integer.parseInt(sc.nextLine());
        switch(op){
            case 1:
                System.out.println("Placa:");
                String placaC = sc.nextLine();
                System.out.println("Marca:");
                String marcaC = sc.nextLine();
                System.out.println("Modelo:");
                String modeloC = sc.nextLine();
                System.out.println("Ano:");
                int anoC = Integer.parseInt(sc.nextLine());
                System.out.println("Cavalos:");
                int cavalos = Integer.parseInt(sc.nextLine());
                VeiculoController.adicionarCarro(placaC, marcaC, modeloC, anoC, true, cavalos);
                Log.gravar("Sucesso: Carro cadastrado com sucesso.");
                break;
            case 2:
                System.out.println("Placa:");
                String placaM = sc.nextLine();
                System.out.println("Marca:");
                String marcaM = sc.nextLine();
                System.out.println("Modelo:");
                String modeloM = sc.nextLine();
                System.out.println("Ano:");
                int anoM = Integer.parseInt(sc.nextLine());
                System.out.println("Cilindradas:");
                int cilindradas = Integer.parseInt(sc.nextLine());
                VeiculoController.adicionarMoto(placaM, marcaM, modeloM, anoM, true, cilindradas);
                Log.gravar("Sucesso: Moto cadastrado com sucesso.");
                break;
            case 3:
                System.out.println("Digite a marca:");
                String mB = sc.nextLine();
                System.out.println("Digite o modelo:");
                String moB = sc.nextLine();
                ArrayList<Integer> pos = VeiculoController.buscarVeiculo(mB, moB);
                if(pos.get(0) == -1){
                    System.out.println("Veiculo nao encontrado.");
                    Log.gravar("Erro: Veículo não encontrado em menuVeículo().");
                } else {
                    menuEditar(pos);
                    Log.gravar("Sucesso: Veículo editado em menuVeículo().");
                }
                break;
            case 4:
                for(int i = 0; i < VeiculoController.veiculo.size(); i++){
                    String listarMarca = VeiculoController.veiculo.get(i).getMarca();
                    String listarModelo = VeiculoController.veiculo.get(i).getModelo();
                    int listarAno = VeiculoController.veiculo.get(i).getAno();
                    String listarPlaca = VeiculoController.veiculo.get(i).getPlaca();
                    String listarDisponivel = VeiculoController.veiculo.get(i).isDisponivel() ? " - Disponivel: Sim" : " - Disponivel: Nao";
                    if(VeiculoController.veiculo.get(i) instanceof Moto){
                        Moto m = (Moto) VeiculoController.veiculo.get(i);
                        System.out.println("Marca: " + listarMarca + " - Modelo: " + listarModelo + " - Ano: " + listarAno + " - Placa: " + listarPlaca + " - Cilindradas: " + m.getCilindradas() + listarDisponivel);
                    } else {
                        Carro c = (Carro) VeiculoController.veiculo.get(i);
                        System.out.println("Marca: " + listarMarca + " - Modelo: " + listarModelo + " - Ano: " + listarAno + " - Placa: " + listarPlaca + " - Cavalos: " + c.getCavalos() + listarDisponivel);
                    }
                    Log.gravar("Lista de Schrodinger: Pode ou não pode ter sido impressa a lista em menuVeiculo().");
                }
                break;
            default:
                System.out.println("Opcao invalida.");
                Log.gravar("Aviso: Opção invalida seleciona em menuVeículo().");
                break;
        }
        return "Saindo...";
    }
}