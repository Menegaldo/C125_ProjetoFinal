package br.inatel.cdg.Entidade.Pessoa;

public class Aluno extends Pessoa{

    // Atributos
    int matricula;
    int periodo;

    // Getters e Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}
