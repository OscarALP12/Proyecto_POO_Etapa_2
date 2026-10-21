// Importes
package mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes;

public class PacienteGeneral extends Paciente {

  private String malestar;

  // Constructor
  public PacienteGeneral(String nombre, String malestar) {
    super(nombre, "General");
    this.malestar = malestar;
  }

  // GETTERS

  // Get que retorna el malestar del paciente
  public String getMalestar() {
    return malestar;
  }

  // MÉTODOS

  // Método que imprime una solicitud por consulta
  @Override
  public void solicitarConsulta() {
    System.out.println(
      "Paciente general " +
        nombre +
        " solicita consulta por malestar: " +
        malestar +
        "."
    );
  }

  // Método que imprime las características del paciente
  @Override
  public String toString() {
    return (
      "PacienteGeneral: [Nombre: " +
      nombre +
      ", Malestar: " +
      malestar +
      ", En Consulta: " +
      enConsulta +
      ", En Tratamiento: " +
      enTratamiento +
      "]"
    );
  }
}
