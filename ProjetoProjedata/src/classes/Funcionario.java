/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

/**
 *
 * 
 * @param {BigDecimal} salario -- salario do funcionario
 * @param {String} funcao -- Função do funcionario
 * @param {String} Nome -- Nome da pessoa
 * @param {LocalDate} dataDeNascimento -- Data de nascimento da pessoa
 * @author Admin
 */
public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    // CONSTRUTORES
    // vazio
    public Funcionario() {
    }

    // Apenas salario e função -- Pessoa definido por functions
    public Funcionario(BigDecimal salario, String funcao) {
        this.funcao = funcao;
        this.salario = salario;
    }

    // Completo
    public Funcionario(String Nome, LocalDate dataDeNascimento, BigDecimal salario, String funcao) {
        super(Nome, dataDeNascimento);
        this.funcao = funcao;
        this.salario = salario;
    }

    // GETTERS
    public BigDecimal getSalario() {
        return this.salario;
    }

    public String getFuncao() {
        return this.funcao;
    }

    // SETTERS
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    // PRINT
    private String tranformarData() {
        NumberFormat formatador = NumberFormat.getInstance(Locale.FRANCE);
        return formatador.format(this.salario);
    }

    @Override
    public void ToString() {
        super.ToString();
        System.out.printf("| %s\t| %s%n", this.tranformarData(), this.funcao);
    }
}
