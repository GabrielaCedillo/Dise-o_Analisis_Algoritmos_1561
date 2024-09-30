import java.util.*;

public class Alumno {
    private int numCuenta;
    private String nombre;
    private int edad;
    private String correo;
    private int semestre;
    private String[] materias;
    private double grade;

    public Alumno() {
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "no_cuenta=" + numCuenta +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", mail='" + correo + '\'' +
                ", semestre=" + semestre +
                ", materias=" + Arrays.toString(materias) +
                ", grade=" + grade +
                '}';
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setMail(String correo) {
        this.correo = correo;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setMaterias(String[] materias) {
        this.materias = materias;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public int getSemestre() {
        return semestre;
    }

    public String[] getMaterias() {
        return materias;
    }

    public double getGrade() {
        return grade;
    }

    public Alumno(int numCuenta, String nombre, int edad, String correo, int semestre, String[] materias, double grade) {
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.semestre = semestre;
        this.materias = materias;
        this.grade = grade;
    }

    public void generarGradeAleatorio() {
        Random random = new Random();
        this.grade = 6.0 + (random.nextDouble() * 4.0);
        this.grade = Math.round(this.grade * 10.0) / 10.0;
    }
    public void generarCuentaAleatoria() {
        Random random = new Random();
        this.numCuenta = 400000000 + random.nextInt(100000000);
    }
    public void generarEdadAleatoria() {
        Random random = new Random();
        this.edad = 18 + random.nextInt(11);
    }
    public void generarSemestreAleatorio() {
        Random random = new Random();
        this.semestre = random.nextInt(9) + 1;
    }
    public void generarMateriasAleatorias(){
        Random random = new Random();
        String[] materias = {"Geometría Analítica", "Cálculo Diferencial E Integral", "Álgebra", "Computadoras Y Programación", "Introducción A La Ingeniería En Computación",
                "Álgebra Lineal", "Cálculo Vectorial", "Programación Orientada A Objetos", "Comunicación", "Emprendimiento 1", "Taller De Creatividad E Innovación",
                "Electricidad Y Magnetismo (L)", "Estructura De Datos", "Métodos Numéricos", "Ecuaciones Diferenciales", "Emprendimiento 2", "Probabilidad Y Estadística",
                "Bases De Datos 1", "Emprendimiento 3", "Matemáticas Discretas", "Dispositivos Electrónicos (L)", "Lenguajes Formales Y Autómatas", "Diseño Y Análisis De Algoritmos",
                "Administración De Proyectos", "Programación Web 1", "Diseño Lógico (L)", "Compiladores", "Sistemas Operativos", "Diseño De Sistemas Digitales (L)",
                "Ingeniería De Software", "Sistemas De Información", "Programación Web 2", "Bases De Datos 2", "Programación Móvil 1", "Redes De Computadoras 2",
                "Habilidades Directivas", "Inteligencia Artificial", "Seguridad Informática", "Minería De Datos","Micropocesador y microcontrolador (L)","Movilidad"};

        Set<String> materiasSeleccionadas = new HashSet<>();

        while (materiasSeleccionadas.size() < 5) {
            String materiaAleatoria = materias[random.nextInt(materias.length)];
            materiasSeleccionadas.add(materiaAleatoria);
        }

        this.materias = materiasSeleccionadas.toArray(new String[0]);
    }

    public void generarNombreyCorreo() {

        String[] nombres = {"Alan", "Alexa", "Alexander", "Adrian", "Aitana", "Ana", "Andrea", "Angel", "Axel", "Camila", "Damian", "Daniel", "Danna",
                "David", "Diego", "Dylan", "Eduardo", "Elizabeth", "Emiliano", "Emilio", "Emmanuel", "Fernanda", "Fernando", "Gabriel","Gabriela", "Gael",
                "Guadalupe", "Iker", "Isaac", "Isabella", "Jasiel","Jessica","Julian", "Jesus", "Jonathan", "Josue", "Joselin", "Juan", "Juan Pablo", "Leonardo",
                "Leonel", "Luis", "Maria", "Mariana", "Marisa", "Matias", "Maximiliano", "Martina", "Miguel","Marcos", "Natalia", "Regina", "Renata",
                "Ricardo", "Rodrigo", "Romina", "Rafael", "Samuel", "Samantha", "Sebastian", "Sofia", "Tadeo", "Valentina", "Valeria",
                "Victoria", "Ximena", "Yanit","Yair"};


        String[] apellidos = {"Aguilar", "Alvarado", "Alvarez", "Avila", "Bautista", "Carrillo","Cabeza", "Castillo", "Castro", "Cervantes", "Chavez",
                "Contreras", "Cortes", "Cruz", "Cedillo", "Delgado", "Diaz", "Dominguez", "Estrada", "Espinoza", "Flores",
                "Moreno", "Terrones", "Gutierrez", "Guzman", "Herrera", "Ibarra", "Jimenez", "Juarez", "Lara", "Luna", "Marquez",
                "Medina", "Mejia", "Mendoza", "Mendez", "Morales", "Hernandez", "Muñoz", "Nuñez", "Ortega", "Ortiz", "Ramirez",
                "Ramos", "Reyes", "Rios", "Rivera", "Rodriguez", "Rojas", "Romero", "Ruiz", "Salazar", "Pineda", "Sandoval",
                "Santos", "Solis", "Silva", "Soto", "Torres", "Vargas", "Vazquez", "Vega", "Velazquez","Quiroz","Balenciaga","Zuno"};



        Random random = new Random();

        String nombreAleatorio = nombres[random.nextInt(nombres.length)];
        String apellidoAleatorio = apellidos[random.nextInt(apellidos.length)];
        String apellidoAleatorio2 = apellidos[random.nextInt(apellidos.length)];
        int numero  = random.nextInt(20);

        this.nombre = nombreAleatorio + " " + apellidoAleatorio+ " " +apellidoAleatorio2;
        this.correo = nombreAleatorio.toLowerCase()+apellidoAleatorio.toLowerCase()+ numero + "@aragon.unam.mx";
    }



}