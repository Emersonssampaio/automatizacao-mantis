package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    //region mapeamento de elementos
    @FindBy(id = "username")
        public WebElement inputUsuario;

    @FindBy(id = "password")
        public WebElement inputSenha;

    @FindBy(css = "#login-form > fieldset > input.width-40.pull-right.btn.btn-success.btn-inverse.bigger-110")
        public WebElement entrar;

    @FindBy(css = "#main-container > div > div > div > div > div.alert.alert-danger > p")
        public WebElement spanMensagemUsuario;

    @FindBy(css = "#login-form > fieldset > div:nth-child(4) > label > span")
        public WebElement checkboxManterConectado;

    public Object digitarLogin;

    //endregion mapeamento de elementos

    /**
     * Construtor para criação da pagina do Mantis.
     * @param driver Driver da pagina.
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Metodo que irá efetuar uma pesquisa no Mantis baseando no texto.
     * @param texto Texto a ser pesquisado.
     */

    //region escrevendo nos campos textos



        public void digitarLogin(String texto){
            inputUsuario.sendKeys(texto + Keys.ENTER);
        }

        public void digitarSenha(String texto){
            inputSenha.sendKeys(texto);
        }

        public void escrever (WebElement input, String texto){
            input.sendKeys(texto);
        }

    //endregion escrevendo nos campos textos


    //region obtendo mensagens da tela
    public String obterMensagem(){
        return this.spanMensagemUsuario.getText();
    }
    //endregion obtendo mensagens da tela

    
    //region obtendo titulo da pagina
    public String obterTituloPagina(){
        return driver.getTitle();
    }
    //endregion //region obtendo titulo da pagina

    /**
     * Metodo que executa a ação de logar no sistema
     * @param usuario para tentativa login
     * @param texto campos para serem digitados
     */

    public void efetuarLogin (String string, String texto){
        inputUsuario.sendKeys(texto + Keys.ENTER);
        inputSenha.sendKeys(texto);
    }

}
