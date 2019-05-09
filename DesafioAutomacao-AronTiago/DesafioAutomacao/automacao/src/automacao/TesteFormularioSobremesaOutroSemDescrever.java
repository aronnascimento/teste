package automacao;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TesteFormularioSobremesaOutroSemDescrever {

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
	//Realiza as ações do teste
	public void testBrowserScript() throws InterruptedException{
		
		if(navegador.equalsIgnoreCase("FF")) {
			driver = new FirefoxDriver();
		}
		else if(navegador.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		
		Actions action = new Actions(driver);
		//Preenche Nome e e-mail
		Acao.Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Qual][aria-label~=nome]", "Aron Tiago do Nascimento");
		Acao.Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Qual][aria-label*=e-mail]", "aron_tiago@hotmail.com");
		
		//Seleciona cor e sobremesa
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label*=Verde]");
		Acao.PreencheComidaFavorita();
		Acao.Sendkey(".quantumWizTextinputSimpleinputInput[aria-label^=Outra]", "a");
		Thread.sleep(1000);
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(1000);
		
		//Avaliar esportes
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label^=Mediano][aria-label*=Baseball]");
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label^=Ótimo][aria-label*=Futebol]");
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label^=Ruim][aria-label*=eSport]");
		Acao.Click(".quantumWizTogglePaperradioEl[aria-label^=Bom][aria-label*=Rugby]");
		
		//Animais
        Acao.Click(".quantumWizTogglePaperradioEl[data-value^=\"10\"]" );
		
		//Montar Xburguer
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Pão][aria-label*=Xburguer]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Carne][aria-label*=Xburguer]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Queijo][aria-label*=Xburguer]");
		
		//Montar Vegetariano
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Pão][aria-label*=Vegetariano]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Salada][aria-label*=Vegetariano]");
		
		//Montar EggXburguer
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Pão][aria-label~=EggXburger]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Carne][aria-label~=EggXburger]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Queijo][aria-label~=EggXburger]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Ovo][aria-label~=EggXburger]");
		
		//Montar Hamburguer
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Pão][aria-label*=Hamburguer]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Carne][aria-label*=Hamburguer]");
        Acao.Click("div.quantumWizTogglePapercheckboxEl[aria-label^=Salada][aria-label*=Hamburguer]");


		Acao.PreencheData(navegador);
		Acao.PreencheHora(".quantumWizTextinputPaperinputInput[aria-label^=Hora]",".quantumWizTextinputPaperinputInput[aria-label^=Minuto]");
		
	    //Enviar
		Acao.ClickByClassName("quantumWizButtonPaperbuttonLabel");
	    
	    //Valida envio com sucesso
		Acao.ValidacaoByClassName("freebirdFormviewerViewResponseConfirmationMessage","Sua resposta foi registrada.");
		Acao.CloseBrowser();
		
	}
}