package Principal;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log{
    private static final String CAMINHO_ARQUIVO = "log.txt";

    public static void gravar(String mensagem){
        try(FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, true); PrintWriter pw = new PrintWriter(fw)){
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.println("[" + dataHora + "] " + mensagem);
        }catch(IOException e){
            System.err.println("Erro ao gravar no arquivo de log: " + e.getMessage());
        }
    }
}
