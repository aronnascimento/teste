package automacao;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TesteFormularioNomeIncompleto {

	String navegador;
	Acoes Acao = new Acoes();
	WebDriver driver;

	/**
	 * @param browser
	 * @throws Exception
	 */
	
	@BeforeTest
	@Parameters("browser")
	
	
	public void setup(String browser) throws Exception{
		Acao.setup(browser);
		navegador = browser;
		Acao.GetURL("https://docs.google.com/forms/d/e/1FAIpQLSfWfPcADbvEPrGDePWhY-agioR1TAyFZTW-hwNTucN28-VACg/viewform" );
	}
	
	@Test
	//Realiza as a��es do teste
	public void testBrowserScript() throws InterruptedException{
		
		
		//Preenche Nome e e-mail
		Acao.Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Qual][aria-label~=nome]", "Aron");
		Acao.Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Qual][aria-label*=e-mail]", "aron_tiago@hotmail.com");
		
		//Seleciona cor e sobremesa
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label*=Verde]");
		Acao.Click(".quantumWizTogglePapercheckboxEl[aria-label^=Bolo]");
		Acao.PreencheComidaFavorita();
		
		//Avaliar esportes
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label^=Mediano][aria-label*=Baseball]");
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label^=�timo][aria-label*=Futebol]");
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label^=Ruim][aria-label*=eSport]");
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label^=Bom][aria-label*=Rugby]");
		
		//Animais
        Acao.Click(".quantumWizTogglePaperradioEl[data-value^=\"10\"]" );
		
		//Montar Xburguer
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=P�o][aria-label*=Xburguer]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Carne][aria-label*=Xburguer]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Queijo][aria-label*=Xburguer]");
		
		//Montar Vegetariano
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=P�o][aria-label*=Vegetariano]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Salada][aria-label*=Vegetariano]");
		
		//Montar EggXburguer
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=P�o][aria-label~=EggXburger]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Carne][aria-label~=EggXburger]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Queijo][aria-label~=EggXburger]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Ovo][aria-label~=EggXburger]");
		
		//Montar Hamburguer
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=P�o][aria-label*=Hamburguer]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Carne][aria-label*=Hamburguer]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Salada][aria-label*=Hamburguer]");
		
        //PreencheDataHora
		Acao.PreencheData(navegador);
		Acao.PreencheHora(".quantumWizTextinputPaperinputInput[aria-label^=Hora]",".quantumWizTextinputPaperinputInput[aria-label^=Minuto]");
		
		Acao.ClickByClassName("quantumWizButtonPaperbuttonLabel");
	    //Enviar
	  
	    //Valida envio com sucesso
	    if(navegador.equalsIgnoreCase("FF")){
	    	Acao.ValidacaoBycssselector("div[id$='338029540'][class^=freebirdFormviewerViewItemsItemErrorMessage]", "Preencha o sobrenome");
		}		
			
		else if(navegador.equalsIgnoreCase("chrome")){
	    	Acao.ValidacaoByClassName("freebirdFormviewerViewItemsItemErrorMessage[id$='338029540'", "Preencha o sobrenome");
		}
		Acao.CloseBrowser();
	}
}