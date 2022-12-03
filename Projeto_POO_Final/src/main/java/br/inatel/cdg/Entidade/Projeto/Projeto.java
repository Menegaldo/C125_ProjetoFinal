package br.inatel.cdg.Entidade.Projeto;

import br.inatel.cdg.Entidade.Pessoa.Aluno;
import java.util.ArrayList;

public class Projeto {

    // Atributos e Lista de Alunos
    private String nome;
    private String orientador;
    private int num;
    private int quant;
    private float notaFinal;
    ArrayList<Aluno> alunos = new ArrayList<>();

    // Construtor
    public Projeto(int quant, String nome, String orientador, int num, float notaFinal) {
        this.nome = nome;
        this.orientador = orientador;
        this.num = num;
        this.notaFinal = notaFinal;
        this.quant = quant;
    }

    // Metodo de Add aluno
    public void addIntegrantes(Aluno a){
        this.alunos.add(a);
    }

    // Sobrecarga de Método (Arraylist de alunos)
    public void addIntegrantes(ArrayList<Aluno> a){
        this.alunos = a;
    }

    // Getters
    public int getNum() {

        return num;
    }

    public String getNome() {

        return nome;
    }

    public String getOrientador() {

        return orientador;
    }

    public ArrayList<Aluno> getAlunos() {

        return alunos;
    }

    public float getNotaFinal() {

        return notaFinal;
    }

    public int getQuant() {
        return quant;
    }
}
