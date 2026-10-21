// Importes
package mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.médicos;

import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.Paciente;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.PacienteEspecialidad;

public class MedicoEspecialista extends Medico {

  private String subEspecialidad;

  // Constructor
  public MedicoEspecialista(
    String nombre,
    String cedula,
    String especialidad,
    String subEspecialidad
  ) {
    super(nombre, cedula, especialidad);
    this.subEspecialidad = subEspecialidad;
  }

  // GETTERS

  // Get que retorna la subespecialidad del médico
  public String getSubEspecialidad() {
    return subEspecialidad;
  }

  // MÉTODOS

  // Método que agrega paciente a la lista de pacientes
  @Override
  public void agregarPaciente(Paciente paciente) {
    // Verificamos si el paciente es un PacienteEspecialidad
    if (paciente instanceof PacienteEspecialidad) {
      // Verificamos si la especialidad del paciente coincide con la del médico
      if (paciente.getEspecialidadAtencion().equals(especialidad)) {
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
      // Si la especialidad del paciente no coincide con la del médico
      else {
        System.out.println(
          "La especialidad del paciente (" +
            paciente.getEspecialidadAtencion() +
            ") no coincide con la del médico (" +
            especialidad +
            ")."
        );
      }
    }
    // Si el paciente no es un PacienteEspecialidad
    else {
      System.out.println(
        "El paciente " +
          paciente.getNombre() +
          " no es un paciente con especialidad."
      );
    }
  }

  // Método que imprime una solicitud por paciente
  @Override
  public void solicitarPaciente() {
    System.out.println(
      "Solicitud de paciente para el médico " +
        nombre +
        " con especialidad " +
        especialidad +
        "."
    );
  }

  // Método que imprime las características del paciente
  @Override
  public String toString() {
    return (
      "MedicoEspecialista: [Nombre: " +
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
