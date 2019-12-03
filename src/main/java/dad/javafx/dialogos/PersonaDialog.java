package dad.javafx.dialogos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PersonaDialog extends Dialog<Persona> implements Initializable {
	
	private ButtonType CREAR_BUTTON_TYPE = new ButtonType("Crear", ButtonData.OK_DONE);
	
	// model
	
	private Persona persona = new Persona();
	
	// view
	
	@FXML
	private TextField nombreText, apellidosText;
	
	@FXML
	private DatePicker fechaNacimientoDatePicker;

	public PersonaDialog() {
		super();
		setTitle("Nueva persona");
		setHeaderText("Introduce los datos de la persona.");
		setGraphic(new ImageView(getClass().getResource("/images/nueva-persona.png").toString()));
		getDialogPane().getButtonTypes().addAll(
				CREAR_BUTTON_TYPE, // botón personalizado
				ButtonType.CANCEL
			);
		getDialogPane().setContent(loadContent("/fxml/PersonaDialog.fxml"));
		setResultConverter(dialogButton -> {
		    if (dialogButton.getButtonData() == ButtonData.OK_DONE) {
		    	Persona nuevaPersona = new Persona();
		    	nuevaPersona.setNombre(persona.getNombre());
		    	nuevaPersona.setApellidos(persona.getApellidos());
		    	nuevaPersona.setFechaNacimiento(persona.getFechaNacimiento());
		        return nuevaPersona;
		    }
		    return null;
		});
	}
	
	private Node loadContent(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
			loader.setController(this);
			return loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		persona.nombreProperty().bind(nombreText.textProperty());
		persona.apellidosProperty().bind(apellidosText.textProperty());
		persona.fechaNacimientoProperty().bind(fechaNacimientoDatePicker.valueProperty());
		
		Node crearButton = getDialogPane().lookupButton(CREAR_BUTTON_TYPE);
		crearButton.disableProperty().bind(
				persona.nombreProperty().isEmpty()
				.or(persona.apellidosProperty().isEmpty())
				.or(persona.fechaNacimientoProperty().isNull())
				);
	}

}
