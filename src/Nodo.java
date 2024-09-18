public class Nodo {
    private int value;
    private Nodo up;
    private Nodo down;
    private Nodo center;

    // Constructor con un parámetro
    public Nodo(int value) {
        this.value = value;
        this.up = null;
        this.down = null;
        this.center = null;
    }

    // Getters y Setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nodo getUp() {
        return up;
    }

    public void setUp(Nodo up) {
        this.up = up;
    }

    public Nodo getDown() {
        return down;
    }

    public void setDown(Nodo down) {
        this.down = down;
    }

    public Nodo getCenter() {
        return center;
    }

    public void setCenter(Nodo center) {
        this.center = center;
    }

    public static void main(String[] args) {
        Nodo head = new Nodo(0);
        Nodo nodo0 = new Nodo(20);
        Nodo nodo1 = new Nodo(23);
        Nodo nodo2 = new Nodo(19);
        Nodo nodo3 = new Nodo(57);
        Nodo nodo4 = new Nodo(67);
        Nodo nodo5 = new Nodo(99);
        //relacion entre el head y el nodo 0
        head.setCenter(nodo0);
        // relacion entre nodos
        nodo0.setUp(nodo1);
        nodo1.setCenter(nodo3);

        nodo0.setCenter(nodo2);
        nodo2.setDown(nodo4);
        nodo4.setCenter(nodo5);

        System.out.println("Obtener el nodo 99:");
        System.out.println(head.getCenter().getCenter().getDown().getCenter().getValue());

        System.out.println("Obtener el nodo 57:");
        System.out.println(nodo0.getUp().getCenter().getValue());
    }
}
