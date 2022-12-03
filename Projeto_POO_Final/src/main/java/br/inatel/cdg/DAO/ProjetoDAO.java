package br.inatel.cdg.DAO;

import br.inatel.cdg.Entidade.Pessoa.Aluno;
import br.inatel.cdg.Entidade.Projeto.Projeto;
import java.io.*;
import java.util.ArrayList;

public class ProjetoDAO extends ArquivoDAO {

    // Construtor
    public ProjetoDAO(String nomeArquivo) {
        super(nomeArquivo);
    }

    // Metodo de Leitura de arquivo
    @Override
    public ArrayList<Projeto> ler() {

        ArrayList<Projeto> encontreiNoArquivo = new ArrayList<>();

        InputStream is;
        InputStreamReader isr;
        BufferedReader br = null;

        String linhaLer;

        String nomeAluno;
        int mat;
        int per;

        try {
            is = new FileInputStream(nomeArquivo);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine();

            while (linhaLer != null) {

                // Ler Projeto (busca do projeto dentro do Arquivo)
                if (linhaLer.contains("Projeto")) {

                    ArrayList<Aluno> alunos = new ArrayList<>();

                    int numero = Integer.parseInt(br.readLine());

                    String nome = br.readLine();
                    String orientador = br.readLine();
                    int quant = Integer.parseInt(br.readLine());

                    float notaFinal = Float.parseFloat(br.readLine());

                    linhaLer = br.readLine();

                    // Ler Integrantes
                    if(linhaLer.contains("Integrante")) {
                        for (int i = 0; i < quant; i++) {

                            Aluno a = new Aluno();

                            nomeAluno = br.readLine();
                            mat = Integer.parseInt(br.readLine());
                            per = Integer.parseInt(br.readLine());

                            a.setMatricula(mat);
                            a.setNome(nomeAluno);
                            a.setPeriodo(per);

                            alunos.add(a);
                        }
                    }

                    Projeto proj = new Projeto(quant, nome, orientador, numero, notaFinal);
                    proj.addIntegrantes(alunos);

                    // Guarda dentro de encontreiNoArquivo todas as informações do proejto
                    encontreiNoArquivo.add(proj);
                }

                linhaLer = br.readLine();
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }finally{
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("ERRO: " + e);
            }
        }

        // Retorna as informações do projeto
        return encontreiNoArquivo;
    }

    // Metodo de Escrita de Arquivo
    public void escrever(Projeto p) {

        OutputStream os;
        OutputStreamWriter osw;
        BufferedWriter bw = null;

        try{
            os = new FileOutputStream("Fetin.txt",true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Escrita dentro do arquivo ( marcador "Projeto" e as informações de Projeto)
            bw.write("Projeto\n");
            bw.write(p.getNum() + "\n");
            bw.write(p.getNome() + "\n");
            bw.write(p.getOrientador() + "\n");
            bw.write(p.getQuant() + "\n");
            bw.write(p.getNotaFinal() + "\n");

            String nome;
            int mat;
            int periodo;

            // Escrita de Integrantes no arquivo (maracador "Integrante" e os dados de integrantes)
            bw.write("Integrante\n");
            for(int i = 0; i < p.getAlunos().size(); i++){

                nome = p.getAlunos().get(i).getNome();
                mat = p.getAlunos().get(i).getMatricula();
                periodo = p.getAlunos().get(i).getPeriodo();

                bw.write(nome + "\n");
                bw.write(mat + "\n");
                bw.write(periodo + "\n");

            }

        }catch(Exception e){
            System.out.println("ERRO: " + e);
        }finally{
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}