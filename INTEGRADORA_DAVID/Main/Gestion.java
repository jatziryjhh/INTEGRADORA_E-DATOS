import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listaTareas = new ArrayList<>();

        Map<String, String> mapaTareas = new HashMap<>();

        while (true) {
            System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
            System.out.println("BIENVENIDO A LA ESCUELITA");
            System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
            System.out.println("1.-AGREGAR TAREAS");
            System.out.println("2.-EDITAR TAREAS");
            System.out.println("3.-ELIMINAR TAREAS");
            System.out.println("4.-MOSTRAR TAREAS");
            System.out.println("5.-SALIR");
            System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
            System.out.println("¿QUÉ OPCIÓN QUIERES ENTRAR");
            System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");

            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.out.println("USTED INGRESO PARA AGREGAR TAREAS");
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.out.println("INGRESA EL NOMBRE DE LA TAREA");
                    String nuevoNom = sc.nextLine();
                    listaTareas.add(nuevoNom);
                    System.out.println("INGRESA SU DESCRIPCION");
                    String nuevoDes = sc.nextLine();
                    mapaTareas.put(nuevoNom, nuevoDes);
                    System.out.println("LA TAREA HA SIDO AGREGADA CON EXITO");
                    break;
                case 2:
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.out.println("USTED INGRESO PARA EDITAR TAREAS");
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.out.println("TENEMOS ESTAS TAREAS");
                    for (int i = 0; i < listaTareas.size(); i++) {
                        System.out.println((i + 1) + " " + listaTareas.get(i));
                    }
                    System.out.println("INGRESA EL NUMERO DE LA TAREA");
                    int tarea = sc.nextInt();
                    sc.nextLine();
                    if (tarea >= 1 && tarea <= listaTareas.size()) {
                        String tareaAct = listaTareas.get(tarea - 1);
                        System.out.println("INGRESA EL NOMBRE");
                        String actNombre = sc.nextLine();
                        System.out.println("INGRESA LA DESCRIPCION");
                        String actDesc = sc.nextLine();
                        mapaTareas.put(actNombre, actDesc);
                        System.out.println("TAREA ACTUALIZADA CON EXITO");
                    } else {
                        System.out.println("ESA NO TA");
                    }
                    break;
                case 3:
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.out.println("USTED INGRESO PARA ELIMINAR TAREAS");
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    for (int i = 0; i < listaTareas.size(); i++) {
                        System.out.println((i + 1) + ". " + listaTareas.get(i));
                    }
                    System.out.print("QUE NUMERO DE TAREA DESEA ELIMINAR ");
                    int indiceEliminar = sc.nextInt();
                    sc.nextLine();
                    if (indiceEliminar >= 1 && indiceEliminar <= listaTareas.size()) {
                        String tareaEliminar = listaTareas.get(indiceEliminar - 1);
                        listaTareas.remove(indiceEliminar - 1);
                        mapaTareas.remove(tareaEliminar);
                        System.out.println("TAREA ELIMINADA");
                    } else {
                        System.out.println("ESA NO TA");
                    }
                    break;
                case 4:
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.out.println("USTED INGRESO PARA MOSTRAR TAREAS");
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.out.println("TENEMOS ESTAS TAREAS");
                    for (int i = 0; i < listaTareas.size(); i++) {
                        String tareaas = listaTareas.get(i);
                        String descripcionTarea = mapaTareas.get(tareaas);
                        System.out.println((i + 1) + ". " + tareaas + " - " + descripcionTarea);
                    }
                    break;
                case 5:
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.out.println("USTED INGRESO PARA SALIR");
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.exit(0);
                    break;

                default:
                 System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    System.out.println("ESA OPCION NO TA");
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    break;
            }
        }
    }
}