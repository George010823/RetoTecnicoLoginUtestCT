package motoresdebusqueda.dogpile.pageobject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.utest.com/")
public class UtestPaginaPrincipal extends PageObject{

    @FindBy(css = "div.unauthenticated-container div.navbar.navbar-default.navbar-fixed-top.unauthenticated-nav-bar div.unauthenticated-nav-bar__links.navbar-right.hidden-sm.hidden-xs ul.nav.navbar-nav:nth-child(2) li:nth-child(2) > a.unauthenticated-nav-bar__sign-up")
    WebElementFacade botonJoinToday;
    @FindBy(css = "#firstName")
    WebElementFacade cajaTextoNombre;

    @FindBy(css = "#lastName")
    WebElementFacade cajaTextoApellido;
    @FindBy(css = "#email")
    WebElementFacade cajaTextoCorreo;
    @FindBy(css = "#birthMonth")
    WebElementFacade cajaTextoMes;
    @FindBy(css = "#birthDay")
    WebElementFacade cajaTextoDia;
    @FindBy(css = "#birthYear")
    WebElementFacade cajaTextoAnio;

    public static final String NOMBRE_BOTON = "//span[contains(text(),'Next: Location')]";
    public static final String NOMBRE_CIUDAD = "//input[@id='city']";
    public static final String CODIGOPOSTAL = "//input[@id='zip']";
    public static final String NOMBRE_PAIS = "//body/ui-view[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/span[1]/span[2]";
    public static final String PAIS_SELECCIONADO = "//div[contains(text(),'Algeria')]";
    public static final String NOMBRE_BOTON_DISPOSITIVO = "//span[contains(text(),'Next: Devices')]";
    public static final String SELECCIONAR_DISPOSITIVO = "//body/ui-view[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]";
    public static final String NOMBRE_DISPOSITIVO = "//div[contains(text(),'Alcatel')]";
    public static final String SELECCIONAR_MODELO = "//body/ui-view[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/span[1]";
    public static final String NOMBRE_MODELO = "//div[contains(text(),'Crystal')]";
    public static final String SELECCIONAR_SO_MOBIL = "//body/ui-view[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[3]/div[2]/div[1]/div[1]/span[1]";
    public static final String NOMBRE_SO_MOBIL = "//div[contains(text(),'Android 7.0')]";
    public static final String NOMBRE_BOTON_LASTSTEP = "//span[contains(text(),'Next: Last Step')]";
    public static final String PASSWORD_CAMPOUNO = "//input[@id='password']";
    public static final String PASSWORD_CAMPODOS = "//input[@id='confirmPassword']";
    public static final String CHECK_CAMPOUNO = "//body/ui-view[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[5]/label[1]/span[1]";
    public static final String CHECK_CAMPODOS = "//body/ui-view[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[6]/label[1]/span[1]";
    public static final String NOMBRE_BOTON_FINAL = "//span[contains(text(),'Complete Setup')]";

    public void ingresarAFormularioDatosPersonales() {
        botonJoinToday.click();
    }

    public void ingresarNombre(String nombre) {
        cajaTextoNombre.type(nombre);
    }

    public void ingresarApellido(String apellido) {
        cajaTextoApellido.type(apellido);
    }

    public void ingresarCorreo(String correo) {
        cajaTextoCorreo.type(correo);
    }

    public void ingresarMes(String mes) {
        cajaTextoMes.selectByVisibleText(mes);
    }

    public void ingresarDia(String dia) {
        cajaTextoDia.selectByVisibleText(dia);
    }

    public void ingresarAnio(String anio) {
        cajaTextoAnio.selectByVisibleText(anio);
    }

    public void ingresarAFormularioLocation() {
        $(NOMBRE_BOTON).click();
    }

    public void ingresarCiudad(String ciudad) {
        $(NOMBRE_CIUDAD).type(ciudad);
    }

    public void ingresarCodigoPostal(String codigoPostal) {
        $(CODIGOPOSTAL).type(codigoPostal);
    }

    public void ingresarPais() {
        $(NOMBRE_PAIS, PAIS_SELECCIONADO).click();
    }

    public void ingresarAFormularioDispositivo() {
        $(NOMBRE_BOTON_DISPOSITIVO).click();
    }

    public void ingresarMobil()  {
        $(SELECCIONAR_DISPOSITIVO, NOMBRE_DISPOSITIVO).click();
    }

    public void ingresarModelo()  {
        $(SELECCIONAR_MODELO, NOMBRE_MODELO).click();
    }

    public void ingresarMovilSistemaOperativo()  {
        $(SELECCIONAR_SO_MOBIL, NOMBRE_SO_MOBIL).click();
    }

    public void ingresarAFormularioCrearPassword() {
        $(NOMBRE_BOTON_LASTSTEP).click();
    }

    public void ingresarPassword(String password) {
        $(PASSWORD_CAMPOUNO).type(password);
        $(PASSWORD_CAMPODOS).type(password);

        WebElement checkboxUno = $(CHECK_CAMPOUNO).findElement(By.xpath("//span[contains(@class, 'checkmark')]"));
        WebElement checkboxDos = $(CHECK_CAMPODOS).findElement(By.xpath("//span[contains(@class, 'checkmark')]"));

        if (!checkboxUno.isSelected()) {
            System.out.println("Check 1 OK");
            checkboxUno.click();
        }
        if (!checkboxDos.isSelected()) {
            System.out.println("Check 2 OK");
            checkboxDos.click();
        }
    }

    public void finalizarLogin() {
        $(NOMBRE_BOTON_FINAL).click();
        System.out.println("USUARIO LOGUEADO CON EXITO");
    }
}
