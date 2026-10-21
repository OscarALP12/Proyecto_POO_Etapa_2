// Importes
package mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.médicos;

import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.Paciente;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.PacienteGeneral;

public class MedicoGeneral extends Medico {

  private String consultorio;

  // Constructor
  public MedicoGeneral(String nombre, String cedula, String consultorio) {
    super(nombre, cedula, "General");
    this.consultorio = consultorio;
  }

  // GETTERS

  // Get que retorna la especialidad del médico
  public String getConsultorio() {
    return consultorio;
  }

  // MÉTODOS

  // Método que agrega paciente a la lista de pacientes
  @Override
  public void agregarPaciente(Paciente paciente) {
    // Verificamos si el paciente es un PacienteGeneral
    if (paciente instanceof PacienteGeneral) {
      // Verificamos si la lista ya está llena
      if (noPacientes < 10) {
        // Verificamos si el paciente no está en la lista
        if (!listaPacientes.contains(paciente)) {
          listaPacientes.add(paciente);
          noPacientes++;
        }
        // Si el paciente ya está en la lista, se imprime un mensaje
        else {
          System.out.println(
            "El paciente " +
              paciente.getNombre() +
              " ya está en la lista del médico " +
              nombre +
              "."
          );
        }
      }
      // Si la lista ya está llena, se imprime un mensaje
      else {
        System.out.println("La lista de pacientes está llena.");
      }
    }
    // Si el paciente no es un PacienteGeneral
    else {
      System.out.println(
        "El paciente " + paciente.getNombre() + " no es un paciente general."
      );
    }
  }

  // Método que imprime una solicitud por paciente
  @Override
  public void solicitarPaciente() {
    System.out.println("Solicitud de paciente para el médico " + nombre + ".");
  }

  // Método que imprime las características del paciente
  @Override
  public String toString() {
    return (
      "MedicoGeneral: [Nombre: " +
      nombre +
      ", Cédula: " +
      cedula +
      ", Consultorio: " +
      consultorio +
      ", Número de Pacientes: " +
      noPacientes +
      "]"
    );
  }
}
