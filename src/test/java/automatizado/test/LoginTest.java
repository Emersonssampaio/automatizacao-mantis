package automatizado.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.page.LoginPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
    
    private static LoginPO login;

    @BeforeClass
    public static void prepararTestes(){
        login = new LoginPO(driver); 
    }

    @Test
    public void TC001_Login_em_Branco(){
        login.digitarLogin("");
        String mensagem = login.obterMensagem();
        assertEquals(mensagem, "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.");

    }

    @Test
    public void TC003_Efetuar_Login_Com_Sucesso(){

        login.efetuarLogin("emerson.santana", "123456789");
        login.checkboxManterConectado.click();
        login.entrar.click();
        String mensagem = login.obterMensagem();
        assertEquals(mensagem, "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.");

    }

    @Test
    public void TC002_Login_com_Sucesso(){

        login.efetuarLogin("emerson.santana", "33745063");
        login.checkboxManterConectado.click();
        login.entrar.click();
        assertEquals(login.obterTituloPagina(), "MantisBT");

    }
}
