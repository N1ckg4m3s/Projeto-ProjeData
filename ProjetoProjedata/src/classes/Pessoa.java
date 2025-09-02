package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe pessoa
 *
 * @param {String} Nome -- Nome da pessoa
 * @param {LocalDate} dataDeNascimento -- Data de nascimento da pessoa
 *
 * @author Nicolas de Aguiar Silva
 */
public class Pessoa {

    private String Nome; // nome do usuario
    private LocalDate dataDeNascimento; // data de nascimento do usuario

    // CONSTRUTORES
    public Pessoa() {
    }

    public Pessoa(String Nome, LocalDate dataDeNascimento) {
        this.Nome = Nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    // GETTERS
    public String getNome() {
        return this.Nome;
    }

    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    // SETTERS
    public void setNome(String novoNome) {
        this.Nome = novoNome;
    }

    public void setDataDeNascimento(LocalDate novoData) {
        this.dataDeNascimento = novoData;
    }

    // PRINT
    private String tranformarData() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatador.format(this.dataDeNascimento);
    }

    public void ToString() {
        System.out.printf("%s\t| %s\t", this.Nome, this.tranformarData());
    }
}
