import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        for (int i = 0; i < 100; i++) {
            Alumno alumno = new Alumno();

            alumno.generarCuentaAleatoria();
            alumno.generarEdadAleatoria();
            alumno.generarNombreyCorreo();
            alumno.generarSemestreAleatorio();
            alumno.generarMateriasAleatorias();
            alumno.generarGradeAleatorio();

            arbol.insertar(alumno);
        }


        arbol.mostrarEnOrden();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n********************MENU********************");
            System.out.println("1. Alumno");
            System.out.println("2. Numero de Cuenta");
            System.out.println("3. Salir");
            System.out.print("Elige la opcion que desees: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Alumno nuevoAlumno = new Alumno();
                    nuevoAlumno.generarCuentaAleatoria();
                    nuevoAlumno.generarEdadAleatoria();
                    nuevoAlumno.generarNombreyCorreo();
                    nuevoAlumno.generarSemestreAleatorio();
                    nuevoAlumno.generarMateriasAleatorias();
                    nuevoAlumno.generarGradeAleatorio();

                    arbol.insertar(nuevoAlumno);
                    System.out.println("Se agrego al nuevo alumno");
                    System.out.println(nuevoAlumno);
                    break;

                case 2:
                    System.out.print("Numero de cuenta a buscar:");
                    int numCuenta = scanner.nextInt();

                    Alumno encontrado = arbol.buscar(numCuenta);

                    if (encontrado != null) {
                        System.out.println("Alumno:");
                        System.out.println("Nombre: " + encontrado.getNombre());
                        System.out.println("Materias: ");
                        for (String materia : encontrado.getMaterias()) {
                            System.out.println("- " + materia);
                        }
                        System.out.println("Promedio: " + encontrado.getGrade());
                    } else {
                        System.out.println("El numero de cuenta" + numCuenta + " NO pertenece a ningun alumno");
                    }
                    break;

                case 3:
                    salir = true;
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Error");
                    break;
            }
        }

    }
}
