package automacao;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TesteFormularioCamposObrigatorios {

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
		
	    //Enviar
		Acao.ClickByClassName("quantumWizButtonPaperbuttonLabel");
	    Thread.sleep(2000);
	  
	    //Valida mensagem obrigatorios
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='338029540']", "Esta pergunta é obrigatória");
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='2081699196']", "Esta pergunta é obrigatória");
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='2125875329']", "Esta pergunta é obrigatória");
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='1449888689']", "Esta pergunta é obrigatória");
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='1171906890']", "Esta pergunta é obrigatória");
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='1157512433']", "Esta pergunta é obrigatória");
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='1693046790']", "Esta pergunta exige uma resposta por linha");
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='456499868']", "Esta pergunta exige pelo menos uma resposta por linha");
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='1672509407']", "Esta pergunta é obrigatória");
	    Acao.ValidacaoBycssselector(".freebirdFormviewerViewItemsItemErrorMessage[id$='1229910557']", "Esta pergunta é obrigatória");
	    
		Acao.CloseBrowser();
	}
}