package automacao;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;


public class Acoes {
	
	WebDriver driver;
	@Parameters("browser")
	
   /**
	*Configura o driver de acordo com o navegador utilizado
	*/
	public void setup(String browser) throws Exception{
		if(browser.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
		}		
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else{
			throw new Exception("Browser incorreto.");
		}
	}
	
   /**
	*Acessar a Url solicitada
	* @param URL Url a ser acessada
	*/
	public void GetURL(String URL) {
		driver.get(URL);
	}
	
   /**
	*Fecha o browser
	*/
	public void CloseBrowser() {
		driver.close();
	}
	
   /**
	*Preenche o campo hora adicionando 1 hora do horario atual
	* @param StrFindObjHora String para localizar o campo hora
	* @param StrFindObjMin  String para localiar o campo minuto
	*/
	public void PreencheHora(String StrFindObjHora, String StrFindObjMin) throws InterruptedException {
		String DT = datahora(1,0);
		Sendkey(StrFindObjHora, DT.toString().substring(21, 23));
		Sendkey(StrFindObjMin , DT.toString().substring(24, 26));
	}
   /**
	*Realiza o click em um objeto através do cssSelector.
	* @param selector = string para localizar o objeto a ser acionado.
	*/
	public void Click(String selector) throws InterruptedException{
		WebElement select = driver.findElement(By.cssSelector(selector));
		select.click();
		Thread.sleep(500);
	}
	
   /**
	*Realiza o click em um objeto através do ClassName
	* @param selector = string para localizar o objeto a ser acionado.
	*/
	public void ClickByClassName(String selector) throws InterruptedException{
		WebElement select = driver.findElement(By.className(selector));
		select.click();
		Thread.sleep(500);
	}
	
   /**
	* Realiza a digitação de string em campos Input
	* @param selector = string para localizar o campo
	* @param texto = texto a ser digitado
	*/
	public void Sendkey(String selector, String texto) throws InterruptedException{
		WebElement input = driver.findElement(By.cssSelector(selector));
		input.sendKeys(texto);
		Thread.sleep(500);
	}
	
   /**
	* Limpa campos de texto
	* @param selector = string para localizar o campo a ser limpo.
	*/
	public void Clear(String selector) throws InterruptedException{
		WebElement input = driver.findElement(By.cssSelector(selector));
		input.clear();
		Thread.sleep(500);
	}
	
   /**
	* Preenche o campo Comida Favorita
	*/
	public void PreencheComidaFavorita() throws InterruptedException {
		WebElement list = driver.findElement(By.className("quantumWizMenuPaperselectEl"));
		list.click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(list).perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.RETURN).build().perform();
	}
	
   /**
	* Limpa campos de texto
	* @param AddHora quantidade de horas a serem adicionadas no horario atual, se desejado.
	* @param AddMin  quantidade de minutos a serem adicionados no horario atual, se desejado.
	* @return data/hora atual ou adicionada de acordo com os parâmetros
	*/
	public static String datahora(int AddHora, int AddMin) {
		   java.util.Date data = new java.util.Date();
		   java.text.SimpleDateFormat spd = new java.text.SimpleDateFormat("dd/MM/yyyy");
		   java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
		   gc.setTime(data);
		   gc.add(java.util.Calendar.HOUR,AddHora);
		   gc.add(java.util.Calendar.MINUTE,AddMin);
		   return spd.format(data)+gc.getTime();
	}
	
   /**
	* Realiza a validação do caso de teste utilizando className
	* @param StrFindObj string para localizar o objeto a ser validado
	* @param-esperado   string esperada no objetivo do teste.
	*/
	public void ValidacaoByClassName(String StrFindObj, String esperado) {
		Assert.assertEquals(driver.findElement(By.className(StrFindObj)).getText(),esperado);		
	}
	
   /**
	* Realiza a validação do caso de teste utilizando cssSelector
	* @param StrFindObj string para localizar o objeto a ser validado
	* @param-esperado   string esperada no objetivo do teste.
	*/
	public void ValidacaoBycssselector(String StrFindObj, String esperado) {
		Assert.assertEquals(driver.findElement(By.cssSelector(StrFindObj)).getText(),esperado);		
	}
	
   /**
	* Realiza o preenchimento do campo data de acordo com o parâmetro 'browser'.
	* @param browser browser ativo no teste
	*/
	public void PreencheData(String browser) throws InterruptedException{
		String DT = datahora(1,0);
		if(browser.equalsIgnoreCase("FF")){
			Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Dia]", DT.toString().substring(0,2));
			Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Mês]", DT.toString().substring(3,5));
			Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Ano]", DT.toString().substring(6,10));
		}		
		else if(browser.equalsIgnoreCase("chrome")){
			Click(".quantumWizTextinputPaperinputInput[type^=date]");
			Sendkey(".quantumWizTextinputPaperinputInput[type^=date]", DT.toString().substring(0,2) + DT.toString().substring(3,5) + DT.toString().substring(6,10));
		}
	}
	
	
   /**
	* Realiza o preenchimento incorreto do campo data de acordo com o parâmetro 'browser'
	* @param browser browser ativo no teste
	*/
	public void PreencheDataInvalida(String browser) throws InterruptedException{
		Actions action = new Actions(driver);
		String DT = datahora(1,0);
		if(browser.equalsIgnoreCase("FF")){
			Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Dia]", DT.toString().substring(0,2));
			Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Mês]", DT.toString().substring(3,5));
			Sendkey(".quantumWizTextinputPaperinputInput[aria-label^=Ano]", DT.toString().substring(6,10));
			Thread.sleep(2000);
			action.sendKeys(Keys.BACK_SPACE).build().perform();
			action.sendKeys(Keys.BACK_SPACE).build().perform();
			action.sendKeys(Keys.BACK_SPACE).build().perform();
			action.sendKeys(Keys.BACK_SPACE).build().perform();
			Thread.sleep(2000);
		}		
		else if(browser.equalsIgnoreCase("chrome")){
			Click(".quantumWizTextinputPaperinputInput[type^=date]");
			Sendkey(".quantumWizTextinputPaperinputInput[type^=date]", DT.toString().substring(0,2) + DT.toString().substring(3,5) + DT.toString().substring(6,10));
			Thread.sleep(2000);
			action.sendKeys(Keys.BACK_SPACE).build().perform();
			Thread.sleep(2000);
		}
	}
}