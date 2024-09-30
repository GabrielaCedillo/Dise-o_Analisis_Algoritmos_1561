public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }
    public void insertar(Alumno alumno) {
        raiz = insertarRecursivo(raiz, alumno);
    }

    private Nodo insertarRecursivo(Nodo nodo, Alumno alumno) {
        if (nodo == null) {
            nodo = new Nodo(alumno);
            return nodo;
        }
        if (alumno.getNumCuenta() < nodo.alumno.getNumCuenta()) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, alumno);
        } else if (alumno.getNumCuenta() > nodo.alumno.getNumCuenta()) {
            nodo.derecha = insertarRecursivo(nodo.derecha, alumno);
        }
        return nodo;
    }
    public Alumno buscar(int noCuenta) {
        return buscarRecursivo(raiz, noCuenta);
    }

    private Alumno buscarRecursivo(Nodo nodo, int noCuenta) {
        if (nodo == null) {
            return null;
        }
        if (noCuenta == nodo.alumno.getNumCuenta()) {
            return nodo.alumno;
        }
        if (noCuenta < nodo.alumno.getNumCuenta()) {
            return buscarRecursivo(nodo.izquierda, noCuenta);
        } else {
            return buscarRecursivo(nodo.derecha, noCuenta);
        }
    }
    public void mostrarEnOrden() {
        mostrarInOrdenRecursivo(raiz);
    }

    private void mostrarInOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            mostrarInOrdenRecursivo(nodo.izquierda);
            System.out.println(nodo.alumno);
            mostrarInOrdenRecursivo(nodo.derecha);
        }
    }

}
