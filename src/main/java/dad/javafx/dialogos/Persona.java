package dad.javafx.dialogos;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty apellidos = new SimpleStringProperty();
	private ObjectProperty<LocalDate> fechaNacimiento = new SimpleObjectProperty<LocalDate>();

	public final StringProperty nombreProperty() {
		return this.nombre;
	}

	public final String getNombre() {
		return this.nombreProperty().get();
	}

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public final StringProperty apellidosProperty() {
		return this.apellidos;
	}

	public final String getApellidos() {
		return this.apellidosProperty().get();
	}

	public final void setApellidos(final String apellidos) {
		this.apellidosProperty().set(apellidos);
	}

	public final ObjectProperty<LocalDate> fechaNacimientoProperty() {
		return this.fechaNacimiento;
	}

	public final LocalDate getFechaNacimiento() {
		return this.fechaNacimientoProperty().get();
	}

	public final void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimientoProperty().set(fechaNacimiento);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
