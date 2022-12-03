import br.inatel.cdg.DAO.ProjetoDAO;
import br.inatel.cdg.Entidade.Pessoa.Aluno;
import br.inatel.cdg.Entidade.Pessoa.Orientador;
import br.inatel.cdg.Entidade.Projeto.Projeto;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Orientador orient = new Orientador();

        ArrayList<Projeto> proj;
        boolean flag = true;

        ProjetoDAO arq1 = new ProjetoDAO("Fetin.txt");

        //--------------------------------------------

        // Selecionar o que será executado

        System.out.println("\n  -SEJA BEM VINDO-  \n");

        while(flag) {
            System.out.println("1 - CADASTRAR PROJETO");
            System.out.println("2 - INFORMAÇÕES DE PROJETO");
            System.out.println("3 - ORIENTADORES");
            System.out.println("4 - SAIR\n");

            System.out.println("Digite a opção: ");
            int opcao = input.nextInt();
            input.nextLine();

            System.out.println("-----------------\n");

            switch (opcao) {
                //Opção 1: Cadastro de Projeto
                case 1:

                    // Entrada das Especificações do Projeto
                    System.out.println("Nome do projeto: ");
                    String nomeProjeto = input.nextLine();

                    System.out.println("Orientador: ");
                    String orientador = input.nextLine();

                    System.out.println("Numero Projeto: ");
                    int numero = input.nextInt();
                    input.nextLine();

                    System.out.println("Nota Final: ");
                    float notaFinal = input.nextFloat();
                    input.nextLine();

                    System.out.println("Quantidade de integrantes: ");
                    int quant = input.nextInt();
                    input.nextLine();

                    // Adicionando as Especificações no projeto
                    Projeto projeto = new Projeto(quant, nomeProjeto, orientador, numero, notaFinal);

                    for (int i = 0; i < quant; i++) {

                        // Entrada dos Integrantes com base na quantidade
                        Aluno auxAluno = new Aluno();

                        System.out.println();

                        System.out.println("Nome integrante: ");
                        String nome = input.nextLine();

                        System.out.println("Matricula integrante: ");
                        int mat = input.nextInt();
                        input.nextLine();

                        System.out.println("Periodo integrante: ");
                        int per = input.nextInt();
                        input.nextLine();

                        auxAluno.setNome(nome);
                        auxAluno.setMatricula(mat);
                        auxAluno.setPeriodo(per);

                        // Guarda os Integrantes no projeto
                        projeto.addIntegrantes(auxAluno);
                    }

                    // Escreve no arquivo o Projeto
                    arq1.escrever(projeto);
                    break;

                case 2:
                    // Opção 2: Leitura do Arquivo Fetin.txt
                    proj = arq1.ler();

                    // Se não tiver projeto cadastrado
                    if (proj.size() == 0) {
                        System.out.println("Não temos projetos cadastrados\n");

                    } else {

                        // Ler Especificações do Projeto
                        for (int i = 0; i < proj.size(); i++) {

                            System.out.println("ID: " + proj.get(i).getNum());
                            System.out.println("Projeto: " + proj.get(i).getNome());
                            System.out.println("Orientador: " + proj.get(i).getOrientador());
                            System.out.println();

                            ArrayList<Aluno> alunos = proj.get(i).getAlunos();

                            // Ler os integrantes do Projeto
                            for (int j = 0; j < alunos.size(); j++) {
                                System.out.println("Nome: " + alunos.get(j).getNome());
                                System.out.println("Matricula: " + alunos.get(j).getMatricula());
                                System.out.println("Periodo: " + alunos.get(j).getPeriodo());
                                System.out.println();
                            }
                            System.out.println("-----------------\n");
                        }
                    }
                    break;

                case 3:
                    // Opção 3: Ler Orientadores
                    proj = arq1.ler();

                    // Sem projetos/Sem orientadores
                    if (proj.size() == 0) {
                        System.out.println("Não temos avaliadores cadastrados\n");

                    } else {

                        // Ler orientadores e guardar em orientador
                        System.out.println("Orientadores: ");
                        for (int i = 0; i < proj.size(); i++) {
                            orient.setNome(proj.get(i).getOrientador());
                            System.out.println("- " + orient.getNome());
                        }

                        System.out.println();
                    }
                    break;

                case 4:
                    // Opção 4: Sair
                    flag = false;
                    break;

                default:
                    // Qualquer outra opção
                    System.out.println("Essa opção não é valida\n");
                    break;
            }
        }
    }
}
