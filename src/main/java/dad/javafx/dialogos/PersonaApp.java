package dad.javafx.dialogos;

import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Stage;

public class PersonaApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		PersonaDialog dialog = new PersonaDialog();
		Optional<Persona> persona = dialog.showAndWait();
		
		if (persona.isPresent()) {
			System.out.println(persona.get());
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
