package automatizado.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CriarTarefaPO extends BasePO {

    // region mapeamento de elementos
    @FindBy(css = "#sidebar > ul > li:nth-child(3) > a")
    public WebElement inputCriarTarefa;

    @FindBy(id = "category_id")
    public WebElement categoriaTarefa;

    @FindBy(id="reproducibility")
    public WebElement frequenciaTarefa;

    @FindBy(id="severity")
    public WebElement gravidadeTarefa;

    @FindBy(id="summary")
    public WebElement resumoTarefa;

    @FindBy(id="priority")
    public WebElement tarefaPrioridade;

    @FindBy(id="description")
    public WebElement descricaoTarefa;

    @FindBy(id="steps_to_reproduce")
    public WebElement reproduzirTarefa;

    @FindBy(id="additional_info")
    public WebElement infoAdicionalTarefa;

    @FindBy(id="tag_select")
    public WebElement marcadoresAtuaisTarefas;

    @FindBy(css="#bugnote-attach-files > td > div.dropzone.center.dz-clickable > i")
    public WebElement anexarArquivo;

    @FindBy(css = "#report_bug_form > div > div.widget-body.dz-clickable > div.widget-main.no-padding > div > table > tbody > tr:nth-child(12) > td > label:nth-child(2) > span")
    public WebElement visibildiadePrivadoTarefa;

    @FindBy(id="report_stay")
    public WebElement continuarRelatando;

    @FindBy(css ="#report_bug_form > div > div.widget-body.dz-clickable > div.widget-toolbox.padding-8.clearfix > input")
    public WebElement criarNovaTarefa;

    //endregion mapeamento de elementos

    // region preenchendo campos select
    public void selectPreencherFrenquencia(String texto) {

        frequenciaTarefa.click();
        Select select = new Select(frequenciaTarefa); 
        select.selectByVisibleText(texto);

    }

    public void selectPreencherPreencherGravidade(String texto) {

        frequenciaTarefa.click();
        Select select = new Select(gravidadeTarefa); 
        select.selectByVisibleText(texto);

    }

    public void selectMarcadoresAtuais(String texto) {

        marcadoresAtuaisTarefas.click();
        Select select = new Select(marcadoresAtuaisTarefas); 
        select.selectByVisibleText(texto);

    }

    public void selectPreencherPreencherPrioridade(String texto)  {
        try{
            frequenciaTarefa.click();
            Select select = new Select(tarefaPrioridade); 
            select.selectByVisibleText(texto);
        }catch (Exception e) {
            System.out.print("Opção selecionada está incorreta");
        }
    }

    // endregion preenchendo campos select

    // region escrevendo nos campos textos
    public void escreverTarefa(WebElement input, String texto){
        input.sendKeys(texto + Keys.TAB);
    }
    // endregion escrevendo nos campos textos
    


    /**
     * @param arquivo selecionado para upload
     */
    public void selecionarArquivo () {
        String filePath = "c:\\Users\\Emerson\\Downloads\\automatizado\\src\\test\\java\\automatizado\\resource\\Imagem-de-Anexo.png";
        driver.findElement(By.cssSelector("#report_bug_form > div > div.widget-body.dz-clickable > div.widget-main.no-padding > div > table > tbody > tr:nth-child(11) > td > div.dropzone.center.dz-clickable > i"));
    }
    

    /**
     * @param arquivo tentando fazer upload pelo arquivo, mas o foco não estava deixando o elemento visivel linhas comentadas de trecho
     */
    /*public void selecionarArquivo () {
       WebElement uploadFile = driver.findElement(By.cssSelector("#report_bug_form > div > div.widget-body.dz-clickable > div.widget-main.no-padding > div > table > tbody > tr:nth-child(11) > td > div.dropzone.center.dz-clickable > i"));
       uploadFile.sendKeys("C:\\Users\\Emerson\\Downloads\\automatizado\\src\\test\\java\\automatizado\\resource\\Imagem-de-Anexo.png");
       driver.findElement(By.cssSelector("#report_bug_form > div > div.widget-body.dz-clickable > div.widget-main.no-padding > div > table > tbody > tr:nth-child(11) > td > div.dropzone.center.dz-clickable > i"));
    }*/

    
    public CriarTarefaPO(WebDriver driver) {
        super(driver);
    }

    
}
