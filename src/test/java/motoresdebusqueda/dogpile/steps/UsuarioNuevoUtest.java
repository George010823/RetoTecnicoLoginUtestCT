package motoresdebusqueda.dogpile.steps;

import cucumber.api.DataTable;
import motoresdebusqueda.dogpile.pageobject.UtestPaginaPrincipal;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class UsuarioNuevoUtest extends ScenarioActor {
    String actor;
    @Steps(shared = true)
    UtestPaginaPrincipal paginaPrincipal;

    @Step("#actor enters the main page of Utest.com")
    public void ingresarAUtest() {
        paginaPrincipal.setDefaultBaseUrl("https://www.utest.com/");
        paginaPrincipal.open();
    }

    @Step("#actor clicks on the JOIN TODAY botton")
    public void presionarBotonJoinToday() {
        paginaPrincipal.ingresarAFormularioDatosPersonales();
    }

    @Step("#actor fills out the personal data form")
    public void rellenarFormularioDatosPersonales(DataTable dataTable) {

        Map<String, String> personalData = getFirstRowData(dataTable);
        paginaPrincipal.ingresarNombre(personalData.get("First Name"));
        paginaPrincipal.ingresarApellido(personalData.get("Last Name"));
        paginaPrincipal.ingresarCorreo(personalData.get("Email"));
    }
    @Step("#actor fills out the birthday data form")
    public void rellenarFormularioFechaNacimiento(DataTable dataTable) {

        Map<String, String> birthdayData = getFirstRowData(dataTable);
        paginaPrincipal.ingresarMes(birthdayData.get("Month"));
        paginaPrincipal.ingresarDia(birthdayData.get("Day"));
        paginaPrincipal.ingresarAnio(birthdayData.get("Year"));
    }

    @Step("#actor presses the Next Location button")
    public void presionarBotonNextLocation() {
        paginaPrincipal.ingresarAFormularioLocation();
    }

    @Step("#actor fills out the address form")
    public void rellenarFormularioDireccion(DataTable dataTable) {

        Map<String, String> addressData = getFirstRowData(dataTable);
        paginaPrincipal.ingresarCiudad(addressData.get("City"));
        paginaPrincipal.ingresarCodigoPostal(addressData.get("Postal Code"));
        paginaPrincipal.ingresarPais();
    }

    @Step("#actor presses the Next Devices")
    public void presionarBotonNextDevices() {
        paginaPrincipal.ingresarAFormularioDispositivo();
    }

    @Step("#actor fills out the device data form")
    public void rellenarFormularioDatosDevices() {
        paginaPrincipal.ingresarMobil();
        paginaPrincipal.ingresarModelo();
        paginaPrincipal.ingresarMovilSistemaOperativo();
    }

    @Step("#actor presses the LastStep")
    public void presionarBotonLastStep() {
        paginaPrincipal.ingresarAFormularioCrearPassword();
    }

    @Step("#actor fills out the form password form with the following information: {0}")
    public void rellenarFormularioPassword(String password) {
        paginaPrincipal.ingresarPassword(password);
    }
    @Step("#actor should be successfully logged in")
    public void presionarBotonCompleteSetup() {
        paginaPrincipal.finalizarLogin();
    }

    private Map<String, String> getFirstRowData(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        return dataList.get(0);
    }
}
