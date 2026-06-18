package Principal;

import java.io.*;
import java.util.ArrayList;

public class GerenciadorDados{

    public static void salvarArraylistParaArquivo(String nomeArquivo, ArrayList<?> lista) {
        try(FileOutputStream fos = new FileOutputStream(nomeArquivo); ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(lista);
        } catch(IOException e){
            System.out.println("Erro ao salvar o arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> carregarArraylistDeArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if(!arquivo.exists()){
            return new ArrayList<T>();
        }
        try(FileInputStream fis = new FileInputStream(arquivo); ObjectInputStream ois = new ObjectInputStream(fis)){ 
            return (ArrayList<T>) ois.readObject();
        } catch(IOException | ClassNotFoundException e){
            System.out.println("Erro ao carregar o arquivo " + nomeArquivo + ". Criando nova lista.");
            return new ArrayList<T>();
        }
    }
}
