// Importes
package mx.unam.fi.die.poo.g7.e0.py2.src.hospital.personal.enfermeros;

import java.util.List;
import java.util.ArrayList;

public class JefeEnfermeria extends Enfermero {

    private String areaSupervision;
    private List<Enfermero> enfermerosACargo;
    private int noEnfermerosACargo;

    // Constructor
  public JefeEnfermeria(String nombre, String cedula, String especialidad, String areaSupervision) {
    super(nombre, cedula, especialidad);
    this.areaSupervision = areaSupervision;
    this.enfermerosACargo = new ArrayList<>();
    this.noEnfermerosACargo = 0;
  }

  // GETTERS

  // Get que retorna el area de supervision del jefe de enfermeria
  public String getAreaSupervision() {
    return areaSupervision;
  }

  // Get que retorna la lista de enfermeros a cargo del jefe de enfermeria
  public List<Enfermero> getEnfermerosACargo() {
    return enfermerosACargo;
  }


  // MÉTODOS

  // Método que agrega un enfermero a la lista de enfermeros a cargo del jefe de enfermería
  public void agregarEnfermeroACargo(Enfermero enfermero) {
    enfermerosACargo.add(enfermero);
    noEnfermerosACargo++;
    System.out.println(
      "El enfermero " + enfermero.getNombre() + " ahora está a cargo del jefe de enfermería " + nombre + "."
    );
  }

  // Método para supervisar a los enfermeros a cargo del jefe de enfermería
  public void supervisarEnfermeros() {
    // Si no tiene enfermeros a su cargo, se imprime un mensaje y se retorna
    if (enfermerosACargo.isEmpty()) {
      System.out.println(
        "El jefe de enfermería " + nombre + " no tiene enfermeros a su cargo."
      );
      return;
    }

    System.out.println(
      "El jefe de enfermería " + nombre + " está supervisando a los enfermeros del área de " + areaSupervision + ":"
    );
    System.out.println(
      "Personal a su cargo: " + noEnfermerosACargo
    );
    for (Enfermero enfermero : enfermerosACargo) {
      System.out.println("- " + enfermero.getNombre() + " (Cédula: " + enfermero.getCedula() + ")" + " (Especialidad: " + enfermero.getEspecialidad() + ")" + " (Número de Pacientes: " + enfermero.getNoPacientes() + ")");
    }
  }

  // Método que imprime las características del enfermero
  @Override
  public String toString() {
    return (
      "JefeEnfermeria: [Nombre: " +
      nombre +
      ", Cédula: " +
      cedula +
      ", Especialidad: " +
      especialidad +
      ", Área de Supervisión: " +
      areaSupervision +
      ", Número de Pacientes: " +
      noPacientes +
      ", Número de Enfermeros a Cargo: " +
      noEnfermerosACargo +
      "]"
    );
  }
}
