package projetoprojedata;

/**
 * Main do projeto responsavel por rodar todas as funções requisitadas no projeto
 * 
 * O Projeto foi desenvolvido com JDK 17
 * Libraeies:
 *  mysql-connector-j-9.4.0.jar -> conexão com MySql local
 * 
 * @author Nicoals de Aguiar Silva
 */
public class ProjetoProjedata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ExecutarAcoes RealizarTeste = new ExecutarAcoes();

        System.out.println("Iniciando testes");
        
        RealizarTeste.Acao1_InserirPessoas();
        
        RealizarTeste.Acao2_RemoverFuncionario();
        
        RealizarTeste.Acao3_ListarFuncionarios();
        
        RealizarTeste.Acao4_Auemento();
        
        RealizarTeste.Acao5_6_AgruparPorFuncao();
        
        RealizarTeste.Acao8_PrinarPorAniversario();
        
        RealizarTeste.Acao10_PrintarPorOrdemAlfabetica();
        
        RealizarTeste.Acao11_SomaDosSalarios();
        
        RealizarTeste.Acao12_NumeroDeSalariosMinimosPorFuncionario();

    }
}
