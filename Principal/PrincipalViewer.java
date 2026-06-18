package Principal;

import JoaoMCV.*;
import LeoMCV.*;
import ZionMCV.*;
import java.util.Scanner;

public class PrincipalViewer {
    
    public static void menuPrincipal(){
        JoaoMCV.PessoaController.carregarDados();
        ZionMCV.VeiculoController.carregarDados();
        LeoMCV.LocacaoController.carregarDados();
        PessoaController.criarFuncionarios();
        Scanner scanf = new Scanner(System.in);
        boolean rodando = true;
        while(rodando){
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cliente");
            System.out.println("2. Veiculo");
            System.out.println("3. Locacao");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanf.nextLine());
            switch (opcao) {
                case 1:
                    PessoaViewer.menuCliente();
                    break;
                case 2:
                    VeiculoViewer.menuVeiculo();
                    break;
                case 3:
                    LocacaoViewer.menuLocacao();
                    break;
                case 0: {
                    System.out.println("Saindo...");
                    rodando = false;
                }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}