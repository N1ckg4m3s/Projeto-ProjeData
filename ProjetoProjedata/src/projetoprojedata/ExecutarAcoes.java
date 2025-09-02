package projetoprojedata;

import classes.Funcionario;
import controller.FuncionarioController;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Classe responsavel por rexecutar cada uma das ações pedidas
 *
 * @author Nicolas de Aguiar Silva
 */
public class ExecutarAcoes {

    FuncionarioController funciController;

    public ExecutarAcoes() {
        funciController = new FuncionarioController();
    }

    // 3.1 [OK] Inserir todos os funcionários, na mesma ordem e informações
    public void Acao1_InserirPessoas() {
        funciController.adicionarFuncionario(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"));
        funciController.adicionarFuncionario(new Funcionario("Joao", LocalDate.of(1990, 5, 12), new BigDecimal(2284.38), "Operador"));
        funciController.adicionarFuncionario(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador"));
        funciController.adicionarFuncionario(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
        funciController.adicionarFuncionario(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), "Recepcionista"));
        funciController.adicionarFuncionario(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
        funciController.adicionarFuncionario(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador"));
        funciController.adicionarFuncionario(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), "Gerente"));
        funciController.adicionarFuncionario(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), "Eletricista"));
        funciController.adicionarFuncionario(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.93), "Gerente"));

        // espaçamento
        System.out.println("");
    }

    // 3.2 [OK] Remover o funcionário “João” da lista.
    public void Acao2_RemoverFuncionario() {
        System.out.println("Remover o funcionario 'Joao'");
        funciController.removerPorNome("Joao");

        // espaçamento
        System.out.println("");
    }

    // 3.3 [OK] Imprimir todos os funcionários.
    public void Acao3_ListarFuncionarios() {
        System.out.println("Listar funcionarios");
        List<Funcionario> Lista = funciController.obterListaCompleta();

        for (Funcionario f : Lista) {
            f.ToString();
        }

        // espaçamento
        System.out.println("");
    }

    // 3.4 [OK] Aumento de 10%.
    public void Acao4_Auemento() {
        System.out.println("Aplicando aumento");
        funciController.aplicarAumento();

        // listar novamente os funcionarios para verificar que foi implementado o aumento
        this.Acao3_ListarFuncionarios();
        
        // espaçamento
        System.out.println("");
    }

    // 3.5 [OK] Agrupar por função.
    // 3.6 [OK] Imprimir lista de funcionarios por função.
    public void Acao5_6_AgruparPorFuncao() {
        System.out.println("Agrupando e listando por Função");
        funciController.agruparPorFuncao();

        // espaçamento
        System.out.println("");
    }

    // 3.8 [OK] Imprimir os funcionários que fazem aniversário no mês 10 e 12.
    public void Acao8_PrinarPorAniversario() {
        System.out.println("Funcionarios com aniversario no mes 10");
        funciController.listarFuncionariosNascidosNoMes(10);

        System.out.println("Funcionarios com aniversario no mes 12");
        funciController.listarFuncionariosNascidosNoMes(12);

    }

    // 3.9 [OK] Imprimir o funcionário com a maior idade.
    public void Acao9_PrintarPorIdade() {
        System.out.println("Funcionario com maior idade");
        funciController.obterFuncionarioComMaiorIdade();

        // espaçamento
        System.out.println("");
    }

    // 3.10 [OK] Imprimir funcionários por ordem alfabética.
    public void Acao10_PrintarPorOrdemAlfabetica() {
        System.out.println("Funcionarios por ordem alfabetica");
        funciController.listarFuncionariosPorOrdemAlfabetica();

        // espaçamento
        System.out.println("");
    }

    // 3.11 [OK] Imprimir o total dos salários dos funcionários.
    public void Acao11_SomaDosSalarios() {
        System.out.println("Soma dos salarios dos funcionarios");
        funciController.somarSalarios();

        // espaçamento
        System.out.println("");
    }

    // 3.12 [OK] salários mínimos por funcionário
    public void Acao12_NumeroDeSalariosMinimosPorFuncionario() {
        System.out.println("Calcular o numero de salarios minimos por Funcionario");

        funciController.calcularSalariosMinimosPorFuncionario(1212);

        // espaçamento
        System.out.println("");
    }
}
