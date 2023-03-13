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
import automatizado.page.MinhaVisaoPO;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinhaVisaoTest extends BaseTest {
    
    private static LoginPO login;
    private static VerTarefasPO visualizarTarefas;
    private static MinhaVisaoPO minhaVisao;
  

    @BeforeClass
    public static void prepararTestes(){
        login = new LoginPO(driver);

        login.digitarLogin("emerson.santana");
        login.digitarSenha("33745063");
        login.checkboxManterConectado.click();
        login.entrar.click();

        visualizarTarefas = new VerTarefasPO(driver);
        minhaVisao = new MinhaVisaoPO(driver);

    }

    @Test
    public void TC001_Validações_e_edição_de_tarefas(){

        String naoAtribuidos = minhaVisao.naoAtribuidos();
        assertEquals(naoAtribuidos, "Não Atribuídos");

        String relatadosPorMim = minhaVisao.relatadosPorMim();
        assertEquals(relatadosPorMim, "Relatados por Mim");

        String linhaDoTempo = minhaVisao.linhaDoTempo();
        assertEquals(linhaDoTempo, "Linha do tempo");

        minhaVisao.nomeTarefa.click();
        visualizarTarefas.checkBoxVisibilidade.click();

        visualizarTarefas.escreverAnotacaoTarefa(visualizarTarefas.descricaoTarefa, "TESTE EMERSON MINHA VISÃO");
        visualizarTarefas.AdicionarTarefas.click();

        visualizarTarefas.minhaconta.click();
        visualizarTarefas.sairConta.click();

    }

   


}
