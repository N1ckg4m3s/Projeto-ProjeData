/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import classes.Funcionario;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.RoundingMode;

/**
 * Classe Reponsavel por controlar os dados de Funcionario
 * e ter contato com o banco de dados
 *
 * @author Admin
 */
public class FuncionarioController {

    Connection connection;

    public FuncionarioController() {
        connection = new MySqlConnection().getConection();
    }

    public void adicionarFuncionario(Funcionario f) {
        String sql = "INSERT INTO funcionarios (nome, dataNascimento, salario, funcao) VALUES (?,?,?,?)";

        f.ToString();

        try (PreparedStatement psw = connection.prepareStatement(sql)) {
            psw.setString(1, f.getNome());
            psw.setDate(2, java.sql.Date.valueOf(f.getDataDeNascimento()));
            psw.setBigDecimal(3, f.getSalario());
            psw.setString(4, f.getFuncao());

            if (psw.executeUpdate() <= 0) {
                System.out.println("Nenhuma linha foi inserida.");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] FuncionarioController.AdicionarFuncionario:" + e.getMessage());
        }
    }

    public void removerPorNome(String nome) {
        String sql = "DELETE FROM funcionarios WHERE nome = ?";

        try (PreparedStatement psw = connection.prepareStatement(sql)) {
            psw.setString(1, nome);

            if (psw.executeUpdate() <= 0) {
                System.out.println("Nenhuma linha foi inserida.");
            }

        } catch (SQLException e) {
            System.err.println("[ERROR] FuncionarioController.removerPorNome:" + e.getMessage());
        }
    }

    public List<Funcionario> obterListaCompleta() {
        List<Funcionario> listaDeRetorno = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try (PreparedStatement psw = connection.prepareStatement(sql); ResultSet rs = psw.executeQuery()) {
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome"));
                f.setDataDeNascimento(rs.getDate("dataNascimento").toLocalDate());
                f.setFuncao(rs.getString("funcao"));
                f.setSalario(rs.getBigDecimal("salario"));
                listaDeRetorno.add(f);
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] FuncionarioController.obterListaCompleta:" + e.getMessage());
        }

        return listaDeRetorno;
    }

    public void aplicarAumento() {
        // 1.10 representa 10%
        String sql = "UPDATE funcionarios SET salario = salario * 1.10";
        try (PreparedStatement psw = connection.prepareStatement(sql)) {
            if (psw.executeUpdate() <= 0) {
                System.out.println("Nenhuma linha foi inserida.");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] FuncionarioController.aplicarAumento:" + e.getMessage());
        }
    }

    public void agruparPorFuncao() {
        String sql = """
                     SELECT funcao, GROUP_CONCAT(nome) as FuncionariosNaFuncao
                        FROM funcionarios
                        GROUP BY funcao
                     """;

        try (PreparedStatement psw = connection.prepareStatement(sql); ResultSet rs = psw.executeQuery()) {
            while (rs.next()) {
                System.out.printf("%-20s | %s%n", rs.getString("funcao"), rs.getString("FuncionariosNaFuncao"));
            }

        } catch (SQLException e) {
            System.err.println("[ERROR] FuncionarioController.agruparPorFuncao:" + e.getMessage());
        }
    }

    public void listarFuncionariosNascidosNoMes(int Mes) {
        boolean encontrouAniversario = false;
        String sql = """
                   SELECT * FROM funcionarios
                   WHERE MONTH(dataNascimento) = ?;
                   """;

        try (PreparedStatement psw = connection.prepareStatement(sql)) {
            psw.setInt(1, Mes);
            try (ResultSet rs = psw.executeQuery()) {
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setNome(rs.getString("nome"));
                    f.setDataDeNascimento(rs.getDate("dataNascimento").toLocalDate());
                    f.setFuncao(rs.getString("funcao"));
                    f.setSalario(rs.getBigDecimal("salario"));

                    f.ToString();
                    encontrouAniversario = true;
                }
            }
        } catch (SQLException e) {
            System.out.printf("controller.FuncionarioController.listarFuncionariosNascidosNoMes(%d): %s%n", Mes, e.getMessage());
        }

        if (!encontrouAniversario) {
            System.out.println(" \t - SEM ANIVERSARIANTES NO MES - ");
        }

        // só para dar espaçamento..
        System.out.println("");
    }

    public void obterFuncionarioComMaiorIdade() {
        String sql = """
                    SELECT nome, 
                    TIMESTAMPDIFF(YEAR, dataNascimento, CURDATE()) AS idade
                    FROM funcionarios
                    ORDER BY idade DESC
                    LIMIT 1;
                    """;
        try (PreparedStatement psw = connection.prepareStatement(sql); ResultSet rs = psw.executeQuery()) {
            while (rs.next()) {
                System.out.printf("%-20s | %s%n", rs.getString("nome"), rs.getString("idade"));
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] FuncionarioController.obterFuncionarioComMaiorIdade:" + e.getMessage());
        }
    }

    public void listarFuncionariosPorOrdemAlfabetica() {
        String sql = """
                    SELECT *
                    FROM funcionarios
                    ORDER BY nome ASC;
                    """;
        try (PreparedStatement psw = connection.prepareStatement(sql); ResultSet rs = psw.executeQuery()) {
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome"));
                f.setDataDeNascimento(rs.getDate("dataNascimento").toLocalDate());
                f.setFuncao(rs.getString("funcao"));
                f.setSalario(rs.getBigDecimal("salario"));

                f.ToString();
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] FuncionarioController.listarFuncionariosPorOrdemAlfabetica:" + e.getMessage());
        }
    }

    public void somarSalarios() {
        String sql = """
                    SELECT COUNT(salario) as QuantidadeDePessoas, SUM(salario) as SalarioTotal
                    FROM funcionarios
                    """;
        try (PreparedStatement psw = connection.prepareStatement(sql); ResultSet rs = psw.executeQuery()) {
            System.out.printf("%-20s | SalarioTotal %n", "QuantidadeDePessoas");
            while (rs.next()) {
                System.out.printf("%-20s | %s%n", rs.getString("QuantidadeDePessoas"), rs.getString("SalarioTotal"));
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] FuncionarioController.somarSalarios:" + e.getMessage());
        }
    }

    public void calcularSalariosMinimosPorFuncionario(int salarioMinimo) {
        String sql = """
                    SELECT nome, salario, salario/? as SalariosMinimo
                    FROM funcionarios
                    ORDER BY SalariosMinimo ASC
                    """;
        try (PreparedStatement psw = connection.prepareStatement(sql)) {
            psw.setInt(1, salarioMinimo);
            try (ResultSet rs = psw.executeQuery()) {
                System.out.printf("%-10s | %-10s | SalariosMinimo %n", "nome", "salario");
                while (rs.next()) {
                    double NumeroDeSalarios = Double.parseDouble(rs.getString("SalariosMinimo"));
                    BigDecimal NumeroArredondado = new BigDecimal(NumeroDeSalarios);
                    NumeroArredondado = NumeroArredondado.setScale(2, RoundingMode.HALF_UP);

                    System.out.printf("%-10s | %-10s | %.2f%n", rs.getString("nome"), rs.getString("salario"), NumeroArredondado);
                }
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] FuncionarioController.calcularSalariosMinimosPorFuncionario:" + e.getMessage());
        }
    }

}
