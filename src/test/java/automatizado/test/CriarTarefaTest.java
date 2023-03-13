package automatizado.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.page.LoginPO;
import automatizado.page.CriarTarefaPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CriarTarefaTest extends BaseTest {
    
    private static LoginPO login;
    private static CriarTarefaPO criarTarefa;

    @BeforeClass
    public static void prepararTestes(){
        login = new LoginPO(driver);

        login.digitarLogin("emerson.santana");
        login.digitarSenha("33745063");
        login.checkboxManterConectado.click();
        login.entrar.click();

        criarTarefa = new CriarTarefaPO(driver);
    }

    /**
     * Tentei criar vários cenarios, mas a aplicação não estava ocorrendo mensagem de alerta.
     */
    @Test
    public void TC001_Criar_Tarefa(){

        /* Criando um Tarefa completa. */

        criarTarefa.inputCriarTarefa.click();
        criarTarefa.selectPreencherFrenquencia("sempre");
        criarTarefa.selectPreencherPreencherGravidade("trivial");
        criarTarefa.selectPreencherPreencherPrioridade("urgente");
        criarTarefa.escreverTarefa(criarTarefa.resumoTarefa, "RESUMO TESTE AUTOMATIZADO EMERSON");
        criarTarefa.escreverTarefa(criarTarefa.descricaoTarefa, "DESCRIÇÃO TESTE AUTOMATIZADO EMERSON");
        criarTarefa.escreverTarefa(criarTarefa.reproduzirTarefa, "PASSOS A REPRODUZIR TESTE AUTOMATIZADO EMERSON");
        criarTarefa.escreverTarefa(criarTarefa.infoAdicionalTarefa, "INFORMAÇOES ADICIONAIS TESTE AUTOMATIZADO EMERSON");
        criarTarefa.selectMarcadoresAtuais("Desenvolvimento");
        criarTarefa.selecionarArquivo();
        criarTarefa.criarNovaTarefa.click();
    }



    


   
}
