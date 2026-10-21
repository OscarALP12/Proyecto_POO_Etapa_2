// Importes
package mx.unam.fi.die.poo.g7.e0.py2.src.hospital.sistema;

import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.enfermeros.Enfermero;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.Paciente;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.PacienteGeneral;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.PacienteEspecialidad;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.médicos.Medico;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.médicos.MedicoGeneral;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.médicos.MedicoEspecialista;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

  private String nombreHospital;
  private int noMedicos;
  private int noEnfermeros;
  private int noPacientes;

  // Listas para llevar registro
  private List<Medico> medicos;
  private List<Enfermero> enfermeros;
  private List<Paciente> pacientes;

  // Constructor
  public Sistema(String nombreHospital) {
    this.nombreHospital = nombreHospital;
    this.noMedicos = 0;
    this.noEnfermeros = 0;
    this.noPacientes = 0;
    this.medicos = new ArrayList<>();
    this.enfermeros = new ArrayList<>();
    this.pacientes = new ArrayList<>();
  }

  // GETTERS

  // Get que retorna el nombre del hospital
  public String getNombreHospital() {
    return nombreHospital;
  }

  // Get que retorna el número de médicos
  public int getNoMedicos() {
    return noMedicos;
  }

  // Get que retorna el número de enfermeros
  public int getNoEnfermeros() {
    return noEnfermeros;
  }

  // Get que retorna el número de pacientes
  public int getNoPacientes() {
    return noPacientes;
  }

  // Get que retorna la lista de médicos
  public List<Medico> getMedicos() {
    return medicos;
  }

  // Get que retorna la lista de enfermeros
  public List<Enfermero> getEnfermeros() {
    return enfermeros;
  }

  // Get que retorna la lista de pacientes
  public List<Paciente> getPacientes() {
    return pacientes;
  }

  // MÉTODOS

  // Método que agrega objeto Médico a la lista de los médicos y suma uno al número de médicos
  public void registroMedico(Medico medico) {
    this.medicos.add(medico);
    this.noMedicos++;
  }

  // Método que agrega objeto Enfermero a la lista de los enfermeros y suma uno al número de enfermeros
  public void registroEnfermero(Enfermero enfermero) {
    this.enfermeros.add(enfermero);
    this.noEnfermeros++;
  }

  // Método que agrega objeto Paciente a la lista de los pacientes y suma uno al número de pacientes
  public void registroPaciente(Paciente paciente) {
    this.pacientes.add(paciente);
    this.noPacientes++;
  }

  // Método asignarPaciente a un Médico
  public void asignarPaciente(Paciente paciente, Medico medico) {
    // Verificamos si el médico no tiene todavía 10 o más pacientes
    if (medico.getNoPacientes() < 10) {
      // Verificamos si el paciente es de especialidad
      if (paciente instanceof PacienteEspecialidad) {
        // Verificamos si el médico es especialista
        if (medico instanceof MedicoEspecialista) {
          // Verificamos si la especialidad del paciente coincide con la del médico especialista
          if (paciente.getEspecialidadAtencion().equals(medico.getEspecialidad())) {
            medico.agregarPaciente(paciente);
            System.out.println("Paciente especializado asignado al médico de manera exitosa.");
          } 
          // Si la especialidad del paciente no coincide con la del médico especialista, se imprime un mensaje de error
          else {
            System.out.println(
              "Error: La especialidad del paciente (" + paciente.getEspecialidadAtencion() + ") no coincide con la del médico (" + medico.getEspecialidad() + ")."
            );
          }
        }
        // Si el médico no es especialista, se imprime un mensaje de error
        else {
          System.out.println(
            "Error: El médico no es especialista."
          );
        }
      }
      // Si el paciente no es de especialidad, se imprime un mensaje de error
      else {
        // Verificamos si el médico no es especialista
        if (!(medico instanceof MedicoEspecialista)) {
          medico.agregarPaciente(paciente);
          System.out.println("Paciente general asignado al médico de manera exitosa.");
        }
        // Si el médico es especialista, se imprime un mensaje de error
        else {
          System.out.println(
            "Error: El médico es especialista y no puede atender pacientes generales."
          );
        }
      }
    } 
    // Si el médico ya tiene 10 o más pacientes, se imprime un mensaje de error
    else {
      System.out.println(
        "Error: El médico alcanzó su límite de 10 pacientes."
      );
    }
  }


  // Método asignarPaciente a un Enfermero
  public void asignarPaciente(Paciente paciente, Enfermero enfermero) {
    // Verificamos si el paciente es de especialidad
    if (paciente instanceof PacienteEspecialidad) {
      // Verificamos si la especialidad del paciente coincide con la del enfermero
      if (paciente.getEspecialidadAtencion().equals(enfermero.getEspecialidad())) {
        // Verificamos si el enfermero no tiene todavía 3 o más pacientes
        if (enfermero.getNoPacientes() < 3) {
          enfermero.agregarPaciente(paciente);
          System.out.println("Paciente especializado asignado al enfermero de manera exitosa.");
        } 
        // Si el enfermero ya tiene 3 o más pacientes, se imprime un mensaje de error
        else {
          System.out.println(
            "Error: El enfermero alcanzó su límite de 3 pacientes."
          );
        }
      }
      // Si la especialidad del paciente no coincide con la del enfermero, se imprime un mensaje de error
      else {
        System.out.println(
          "Error: La especialidad del paciente (" + paciente.getEspecialidadAtencion() + ") no coincide con la del enfermero (" + enfermero.getEspecialidad() + ")."
        );
      }
    }
    // Si el paciente no es de especialidad, se imprime un mensaje de error
    else {
      System.out.println(
        "Error: El paciente no es de especialidad."
      );
    }
  }
}