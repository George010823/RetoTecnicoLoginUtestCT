package motoresdebusqueda.dogpile.stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import motoresdebusqueda.dogpile.steps.UsuarioNuevoUtest;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class UsuarioDefinicionPasos {

    @Steps(shared = true)
    UsuarioNuevoUtest usuario;

    @Given("^(.*) wants to register on the uTest.com page$")
    public void ingresar_a_utest(String nombreUsuario) {
        usuario.isCalled(nombreUsuario);
        usuario.ingresarAUtest();
    }

    @When("^(.*) clicks on the JOIN TODAY option$")
    public void oprimirBotonJoinToday(String nombreUsuario) {
        usuario.isCalled(nombreUsuario);
        usuario.presionarBotonJoinToday();
    }

    @And("^(.*) fills out the personal data form with the following information:$")
    public void ingrearDatosPersonales(String nombreUsuario, DataTable dataTable) {
        usuario.isCalled(nombreUsuario);
        usuario.rellenarFormularioDatosPersonales(dataTable);
    }
    @And("^(.*) fills out the birthday data form with the following information:")
    public void ingrearFechaNacimiento(String nombreUsuario, DataTable dataTable) {
        usuario.isCalled(nombreUsuario);
        usuario.rellenarFormularioFechaNacimiento(dataTable);
    }

    @And("^(.*) presses the Next Location button$")
    public void oprimirBotonNextLocation(String nombreUsuario) {
        usuario.isCalled(nombreUsuario);
        usuario.presionarBotonNextLocation();
    }

    @And("^(.*) fills out the form with his address data:$")
    public void ingresarDireccion(String nombreUsuario, DataTable dataTable) {
        usuario.isCalled(nombreUsuario);
        usuario.rellenarFormularioDireccion(dataTable);
    }

    @And("^(.*) presses the Next Devices$")
    public void oprimirBotonNextDevices(String nombreUsuario) {
        usuario.isCalled(nombreUsuario);
        usuario.presionarBotonNextDevices();
    }

    @And("^(.*) fills out the device data form$")
    public void ingresarDatosDevices(String nombreUsuario) {
        usuario.isCalled(nombreUsuario);
        usuario.rellenarFormularioDatosDevices();
    }

    @And("^(.*) presses the LastStep$")
    public void oprimirBotonLastStep(String nombreUsuario) {
        usuario.isCalled(nombreUsuario);
        usuario.presionarBotonLastStep();
    }

    @And("^(.*) fills out the password assignment form with the following information: (.*)$")
    public void ingresarPassword(String nombreUsuario, String password) {
        usuario.isCalled(nombreUsuario);
        usuario.rellenarFormularioPassword(password);
    }
    @Then("^(.*) should be successfully logged in$")
    public void oprimirBotonCompleteSetup(String nombreUsuario) {
        usuario.isCalled(nombreUsuario);
        usuario.presionarBotonCompleteSetup();
    }

    private Map<String, String> getFirstRowData(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        return dataList.get(0);
    }
}
