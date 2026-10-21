// Importes
package mx.unam.fi.die.poo.g7.e0.py2.src.hospital;

import java.util.Scanner;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.Paciente;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.PacienteEspecialidad;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.pacientes.PacienteGeneral;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.enfermeros.Enfermero;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.enfermeros.EnfermeroEspecialista;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.enfermeros.JefeEnfermeria;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.médicos.Medico;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.médicos.MedicoEspecialista;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.médicos.MedicoGeneral;
import mx.unam.fi.die.poo.g7.e0.py2.src.hospital.sistema.Sistema;

public class Main {

  public static void main(String[] args) {
    // Declaramos el scanner
    Scanner scanner = new Scanner(System.in);

    String nombreHospital = "";

    // Solicitamos al usuario proveer un nombre para el hospital para instanciar la clase Sistema
    do {
      System.out.print("\nIngresa un nombre para el Hospital: ");
      nombreHospital = scanner.nextLine();

      if (nombreHospital.isEmpty()) {
        System.out.println("ERROR: no se ingresó nada, intenta de nuevo");
      }
    } while (nombreHospital.isEmpty());

    // Instanciamos la clase
    Sistema hospital = new Sistema(nombreHospital);

    // Instanciamos objetos con polimorfismo a la interfaz

    Medico medico1 = new MedicoEspecialista(
      "Juan",
      "12345",
      "Cardiología",
      "Ecocardiografía"
    );
    Medico medico2 = new MedicoGeneral("Pedro", "67890", "458");
    Enfermero enfermero1 = new JefeEnfermeria(
      "Ana",
      "54321",
      "Pediatría",
      "Piso 2"
    );
    Enfermero enfermero2 = new EnfermeroEspecialista(
      "Luis",
      "98765",
      "Cardiología",
      "Cardiología Intervencionista"
    );
    Paciente paciente1 = new PacienteEspecialidad(
      "Paciente 1",
      "Cardiología",
      "diabetes"
    );
    Paciente paciente2 = new PacienteGeneral("Paciente 2", "dolor de estómago");

    // MÉTODOS

    System.out.println("\nMÉTODOS DE REGISTRO\n");

    medico1.registroEnSistema(hospital);
    enfermero1.registroEnSistema(hospital);
    paciente1.registroEnSistema(hospital);

    // Directamente desde el sistema
    hospital.registroMedico(medico2);
    hospital.registroEnfermero(enfermero2);
    hospital.registroPaciente(paciente2);

    System.out.println("\nGETTERS DE CONSULTA DE DATOS DEL SISTEMA\n");

    System.out.println("Número de Médicos: " + hospital.getNoMedicos());
    for (Medico medico : hospital.getMedicos()) {
      System.out.println(medico);
    }
    System.out.println("Número de Enfermeros: " + hospital.getNoEnfermeros());
    for (Enfermero enfermero : hospital.getEnfermeros()) {
      System.out.println(enfermero);
    }
    System.out.println("Número de Pacientes: " + hospital.getNoPacientes());
    for (Paciente paciente : hospital.getPacientes()) {
      System.out.println(paciente);
    }

    System.out.println("\nINFORMACIÓN PACIENTES\n");

    for (Paciente paciente : hospital.getPacientes()) {
      paciente.verTratamiento();
      paciente.verConsulta();
      paciente.solicitarConsulta();
      System.out.println(paciente);
    }

    System.out.println("\nASIGNACIÓN MÉDICOS/ENFERMEROS A PACIENTES\n");

    hospital.asignarPaciente(paciente1, enfermero1); // No va a funcionar correctamente porque la especialidad no es la misma ("Pediatría" vs "Cardioliogía")
    hospital.asignarPaciente(paciente2, enfermero1); // No va a funcionar correctamente porque el paciente no es de especialiad y el enfermero sí
    hospital.asignarPaciente(paciente1, enfermero2); // Va a funcionar correctamente porque la especialidad es la misma ("Cardioliogía")
    hospital.asignarPaciente(paciente2, enfermero2); // No va a funcionar correctamente porque el paciente no es de especialiad y el enfermero sí
    hospital.asignarPaciente(paciente1, medico1); // Va a funcionar correctamente porque la especialidad es la misma ("Cardioliogía")
    hospital.asignarPaciente(paciente2, medico1); // No va a funcionar correctamente porque el paciente no es de especialiad y el médico sí
    hospital.asignarPaciente(paciente1, medico2); // No va a funcionar correctamente porque el paciente es de especialiad y el médico no lo es
    hospital.asignarPaciente(paciente2, medico2); // Va a funcionar correctamente porque ambos son generales

    enfermero1.verListaPacientes();
    enfermero2.verListaPacientes();
    medico1.verListaPacientes();
    medico2.verListaPacientes();

    System.out.println("\nMÉTODOS Y GETTER DE MÉDICOS/ENFERMEROS\n");

    // Médicos
    System.out.println("Nombre de Médico 1: " + medico1.getNombre());
    System.out.println("Cedula de Médico 1: " + medico1.getCedula());
    System.out.println(
      "Especialidad de Médico 1: " + medico1.getEspecialidad()
    );
    System.out.println(
      "Número de pacientes del Médico 1: " + medico1.getNoPacientes()
    );
    medico1.solicitarPaciente();
    medico1.verListaPacientes();
    // Método toString
    System.out.println(medico1);

    System.out.println("Nombre de Médico 2: " + medico2.getNombre());
    System.out.println("Cedula de Médico 2: " + medico2.getCedula());
    System.out.println(
      "Especialidad de Médico 2: " + medico2.getEspecialidad()
    );
    System.out.println(
      "Número de pacientes del Médico 2: " + medico2.getNoPacientes()
    );
    medico2.solicitarPaciente();
    medico2.verListaPacientes();
    // Método toString
    System.out.println(medico2);

    // Enfermeros
    System.out.println("Nombre de Enfermero 1: " + enfermero1.getNombre());
    System.out.println("Cedula de Enfermero 1: " + enfermero1.getCedula());
    System.out.println(
      "Especialidad de Enfermero 1: " + enfermero1.getEspecialidad()
    );
    System.out.println(
      "Número de pacientes del Enfermero 1: " + enfermero1.getNoPacientes()
    );
    enfermero1.verListaPacientes();
    // Método toString
    System.out.println(enfermero1);

    System.out.println("Nombre de Enfermero 2: " + enfermero2.getNombre());
    System.out.println("Cedula de Enfermero 2: " + enfermero2.getCedula());
    System.out.println(
      "Especialidad de Enfermero 2: " + enfermero2.getEspecialidad()
    );
    System.out.println(
      "Número de pacientes del Enfermero 2: " + enfermero2.getNoPacientes()
    );
    enfermero2.verListaPacientes();
    // Método toString
    System.out.println(enfermero2);

    System.out.println("\nFLUJO CONSULTA Y TRATAMIENTO\n");

    // Especialistas
    // 1. Primero se consulta el estado del paciente
    paciente1.verConsulta();
    paciente1.verTratamiento();

    // 2. Luego se le da consulta al paciente
    medico1.darConsulta(paciente1);
    paciente1.verConsulta();

    // 3. Se finaliza a terminar la consulta (Si el Médico es el que proporciona el tratamiento este paso es opcional ya que al llamar el método darTratamiento se asume que la consulta ha finalizado)
    medico1.finalizarConsulta();

    // 4. Y procede a dársele tratamiento (puede ser via médico y via enfermero)
    enfermero2.darTratamiento(paciente1);

    // Generales
    // 1. Primero se consulta el estado del paciente
    paciente2.verConsulta();
    paciente2.verTratamiento();

    // 2. Luego se le da consulta al paciente
    medico2.darConsulta(paciente2);
    paciente2.verConsulta();

    // 3. Y procede a dársele tratamiento (Via médico no fue necesario finalizar la consulta previamente)
    medico2.darTratamiento(paciente2);

    scanner.close();
  }
}
