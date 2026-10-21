// Importes
package mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes;

public class PacienteEspecialidad extends Paciente {

  private String condicionMedica;

  // Constructor
  public PacienteEspecialidad(String nombre, String especialidadAtencion, String condicionMedica) {
    super(nombre, especialidadAtencion);
    this.condicionMedica = condicionMedica;
  }

  // GETTERS

  // Get que retorna la condición médica del paciente
  public String getCondicionMedica() {
    return condicionMedica;
  }

  // MÉTODOS

  // Método que imprime una solicitud por consulta
  @Override
  public void solicitarConsulta() {
    System.out.println(
      "Paciente de especialidad " +
        nombre +
        " solicita consulta con especialista en " +
        especialidadAtencion +
        "."
    );
  }

  // Método que imprime las características del paciente
  @Override
  public String toString() {
    return (
      "PacienteEspecialidad: [Nombre: " +
      nombre +
      ", Condición Médica: " +
      condicionMedica +
      ", Especialidad Requerida: " +
      especialidadAtencion +
      ", En Consulta: " +
      enConsulta +
      ", En Tratamiento: " +
      enTratamiento +
      "]"
    );
  }
}
