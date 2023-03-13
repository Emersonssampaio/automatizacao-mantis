package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MinhaVisaoPO extends BasePO {

    //region Mapeamento de Elementos

    @FindBy(css = "#unassigned > div.widget-header.widget-header-small > h4 > a")
        public WebElement nomeNaoAtribuidos;

    @FindBy(css = "#timeline > div.widget-header.widget-header-small > h4")
        public WebElement nomeLinhaDoTempo;

    @FindBy(css = "#reported > div.widget-header.widget-header-small > h4 > a")
        public WebElement nomeRelatadosPorMim;

    @FindBy(css = "#reported > div.widget-body > div > div > table > tbody > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1) > a")
        public WebElement nomeTarefa;

    //endregion Mapeamento de Elementos

    //region mapeando campos para efetuar assertivas
    public String naoAtribuidos(){
        return this.nomeNaoAtribuidos.getText();
    }

    public String linhaDoTempo(){
        return this.nomeLinhaDoTempo.getText();
    }

    public String relatadosPorMim(){
        return this.nomeRelatadosPorMim.getText();
    }

    //endregion mapeando campos para efetuar assertivas

    public MinhaVisaoPO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    


}
