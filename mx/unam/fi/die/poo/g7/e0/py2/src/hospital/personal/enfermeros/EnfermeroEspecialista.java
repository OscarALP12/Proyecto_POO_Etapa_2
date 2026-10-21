// Importes
package mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.enfermeros;

public class EnfermeroEspecialista extends Enfermero {

  private String subEspecialidad;

  // Constructor
  public EnfermeroEspecialista(
    String nombre,
    String cedula,
    String especialidad,
    String subEspecialidad
  ) {
    super(nombre, cedula, especialidad);
    this.subEspecialidad = subEspecialidad;
  }

  // GETTERS

  // Get que retorna la subespecialidad de la atención que necesita
  public String getSubEspecialidadAtencion() {
    return subEspecialidad;
  }

  // MÉTODOS

  // Método que imprime las características del paciente
  @Override
  public String toString() {
    return (
      "EnfermeroEspecialista: [Nombre: " +
      nombre +
      ", Cédula: " +
      cedula +
      ", Especialidad: " +
      especialidad +
      ", Subespecialidad: " +
      subEspecialidad +
      ", Número de Pacientes: " +
      noPacientes +
      "]"
    );
  }
}
