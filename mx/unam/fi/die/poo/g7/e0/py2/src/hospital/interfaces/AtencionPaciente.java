// Importes
package mx.unam.fi.die.poo.g7.e0.py2.src.hospital.interfaces;

import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.sistema.Sistema;

public interface AtencionPaciente {
  // Método que registra todo el objeto Paciente llamando al método 'registroPaciente' del sistema con el objeto entero como argumento
  public void registroEnSistema(Sistema sistema);

  // Método que imprime una solicitud por consulta
  public void solicitarConsulta();

  // Método que muestra un mensaje si el usuario está en tratamiento
  public void verTratamiento();

  // Método que muestra un mensaje si el usuario está en consulta
  public void verConsulta();
}
