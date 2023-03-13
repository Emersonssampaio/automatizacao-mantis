package automatizado.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class VerTarefasPO extends BasePO {

    public VerTarefasPO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }


    //region Mapeamento de Elementos

    @FindBy(id="filter-search-txt")
    public WebElement textoProcurar;

    @FindBy(css="#filters_form_open > div.widget-toolbox.padding-8.clearfix > div > div > input.btn.btn-primary.btn-sm.btn-white.btn-round.no-float")
    public WebElement buttonAplicarFiltro;

    @FindBy(id="show_priority_filter")
    public WebElement prioridade;
    
    @FindBy(css="#show_priority_filter_target > select")
    public WebElement selectPrioridade;
    
    @FindBy(id="show_severity_filter")
    public WebElement gravidade;

    @FindBy(css="#show_severity_filter_target > select")
    public WebElement selectGravidade;

    @FindBy(css="#filter > div.widget-body > div > div > div > div > a")
    public WebElement buttonRedefinir;

    @FindBy(css = "#buglist > tbody > tr > td.column-id > a")
    public WebElement numeroTarefa;

    @FindBy(css = "#buglist > tbody > tr > td.column-severity")
    public WebElement resultadaGravidade;

    @FindBy(css="#unassigned > div.widget-header.widget-header-small > div.widget-toolbar.no-border.hidden-xs > div > a")
    public WebElement buttonVisulizarTarefas;

    @FindBy(css="#main-container > div.main-content > div.page-content > div > div:nth-child(1) > div > div.widget-body > div.widget-main.no-padding > div > table > tbody > tr:nth-child(5) > td.bug-reporter > a")
    public WebElement nomeRelator;

    @FindBy(css="#main-container > div.main-content > div.page-content > div > div:nth-child(1) > div > div.widget-body > div.widget-main.no-padding > div > table > tbody > tr:nth-child(5) > td.bug-assigned-to > a")
    public WebElement atribuicao;

    @FindBy(css="#main-container > div.main-content > div.page-content > div > div:nth-child(1) > div > div.widget-body > div.widget-main.no-padding > div > table > tbody > tr:nth-child(10) > td")
    public WebElement resumo;

    @FindBy(id="bugnote_text")
    public WebElement descricaoTarefa;

    @FindBy(css="#bugnote_add > div.widget-body > div.widget-main.no-padding > div > table > tbody > tr:nth-child(1) > td > label > span")
    public WebElement checkBoxVisibilidade;

    @FindBy(css="#bugnote_add > div.widget-body > div.widget-toolbox.padding-8.clearfix > input")
    public WebElement AdicionarTarefas;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/ul/li[3]/a/span")
    public WebElement minhaconta;

    @FindBy(css ="#navbar-container > div.navbar-buttons.navbar-header.navbar-collapse.collapse > ul > li.grey.open > ul > li:nth-child(4) > a")
    public WebElement sairConta;

    @FindBy(css ="#bug_action > div > div.widget-body > div.widget-toolbox.padding-8.clearfix > div > div.btn-group.pull-left > a:nth-child(1)")
    public WebElement imprimirTarefas;

    @FindBy(css ="#bug_action > div > div.widget-body > div.widget-toolbox.padding-8.clearfix > div > div.btn-group.pull-left > a:nth-child(2)")
    public WebElement imprimirArquivoCsv;

    @FindBy(css ="#bug_action > div > div.widget-body > div.widget-toolbox.padding-8.clearfix > div > div.btn-group.pull-left > a:nth-child(2)")
    public WebElement exportarParaExcel;

  //endregion Mapeamento de Elementos
    
    
    //region mapeando campos para efetuar assertivas

    public String obterNomeRelator(){
        return this.nomeRelator.getText();
    }

    public String obterAtribuicao(){
        return this.atribuicao.getText();
    }

    public String obterResumo(){
        return this.resumo.getText();
    }

    public void escreverAnotacaoTarefa(WebElement input, String texto){
        input.sendKeys(texto + Keys.TAB);
    }

    public void digitarTextoProcurar(String texto){
        textoProcurar.sendKeys(texto);
    }

    public String spamNumeroTarefa(){
        return this.numeroTarefa.getText();
    }

    public String spamGravidade(){
        return this.resultadaGravidade.getText();
    }

    //endregion mapeando campos para efetuar assertivas

    
    //region metodo para clicar nos campos Selects da tela
    public void selecionarPrioridade(String texto) {

        selectPrioridade.click();
        Select select = new Select(selectPrioridade); 
        select.selectByVisibleText(texto);

    }

    public void selecionarGravidade(String texto) {

        selectGravidade.click();
        Select select = new Select(selectGravidade); 
        select.selectByVisibleText(texto);

    }

    //endregion metodo para clicar nos campos Selects da tela

}
