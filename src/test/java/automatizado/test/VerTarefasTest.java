package automatizado.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.page.LoginPO;
import automatizado.page.CriarTarefaPO;
import automatizado.page.VerTarefasPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VerTarefasTest extends BaseTest {
    
    private static LoginPO login;
    private static VerTarefasPO visualizarTarefas;

    @BeforeClass
    public static void prepararTestes(){
        login = new LoginPO(driver);

        login.digitarLogin("emerson.santana");
        login.digitarSenha("33745063");
        login.checkboxManterConectado.click();
        login.entrar.click();

        visualizarTarefas = new VerTarefasPO(driver);
    }

    @Test
    public void TC001_Aplicando_filtro_e_editando_Tarefa () throws InterruptedException{
        
        //region Pesquisando uma tarefa cadastrada e fazendo anotações na mesma
        visualizarTarefas.buttonVisulizarTarefas.click();

        visualizarTarefas.buttonRedefinir.click();
        //TODO: Aplicação com precisa clicar duas vezes para clicar redefinir o filtro
        visualizarTarefas.buttonRedefinir.click();

        visualizarTarefas.digitarTextoProcurar("asqa");
        visualizarTarefas.buttonAplicarFiltro.click();
        visualizarTarefas.numeroTarefa.click();

        String nomeRelator = visualizarTarefas.obterNomeRelator();
        assertEquals(nomeRelator, "emerson.santana");

        String atribuicao = visualizarTarefas.obterAtribuicao();
        assertEquals(atribuicao, "mateuspinheiro");

        String resumo = visualizarTarefas.obterResumo();
        assertEquals(resumo, "0000149: asqa");

        visualizarTarefas.checkBoxVisibilidade.click();
        visualizarTarefas.escreverAnotacaoTarefa(visualizarTarefas.descricaoTarefa, "TESTE EMERSON");
        visualizarTarefas.AdicionarTarefas.click();

        visualizarTarefas.minhaconta.click();
        visualizarTarefas.sairConta.click();

        //endregion Clicando em Visualizar Tarefas

    }

    @Test
    public void TC002_Efetuando_Testes_de_Filtros () throws InterruptedException{
        
        visualizarTarefas.buttonVisulizarTarefas.click();

        visualizarTarefas.buttonRedefinir.click();
        //TODO: Aplicação com precisa clicar duas vezes para clicar redefinir o filtro
        visualizarTarefas.buttonRedefinir.click();

        visualizarTarefas.prioridade.click();
        Thread.sleep(3000);
        visualizarTarefas.selecionarPrioridade("normal");

        visualizarTarefas.gravidade.click();
        Thread.sleep(3000);
        visualizarTarefas.selecionarGravidade("texto");

        visualizarTarefas.buttonAplicarFiltro.click();

        String numeroTarefa = visualizarTarefas.spamNumeroTarefa();
        assertEquals(numeroTarefa, "0000149");

        String textoGravidade = visualizarTarefas.spamGravidade();
        assertEquals(textoGravidade, "texto");

        visualizarTarefas.minhaconta.click();
        visualizarTarefas.sairConta.click();

    }

    @Test
    public void TC003_Impressão_de_tarefas () throws InterruptedException{
        
        visualizarTarefas.buttonVisulizarTarefas.click();

        visualizarTarefas.buttonRedefinir.click();
        //TODO: Aplicação com precisa clicar duas vezes para clicar redefinir o filtro
        visualizarTarefas.buttonRedefinir.click();
        
        visualizarTarefas.exportarParaExcel.click();
        visualizarTarefas.exportarParaExcel.click();

        visualizarTarefas.minhaconta.click();
        visualizarTarefas.sairConta.click();

    }


}
