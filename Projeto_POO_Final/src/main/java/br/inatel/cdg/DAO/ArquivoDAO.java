package br.inatel.cdg.DAO;
import java.util.ArrayList;

public abstract class ArquivoDAO {

    // Atributos
    String nomeArquivo;

    // Construtor
    public ArquivoDAO(String nomeArquivo) {

        this.nomeArquivo = nomeArquivo;
    }

    // Metodo de Leitura
    public abstract ArrayList<?> ler();

}
