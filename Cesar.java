public class Cesar {

    public static void descifrarCesar(String texto1) {
        String alfabeto = "abcdefghijklmnñopqrstuvwxyz";
        int tamanioAlfa = alfabeto.length();
        String texto2 = texto1.replace(" ", "");
        texto2 = texto2.toLowerCase();
        int tamanioTexto = texto2.length();

        for (int i = 0; i < tamanioAlfa; i++) {
            StringBuilder cadena = new StringBuilder();
            for (int j = 0; j < tamanioTexto; j++) {
                int pos = alfabeto.indexOf(texto2.charAt(j));
                cadena.append(alfabeto.charAt((pos + i) % tamanioAlfa));
            }
            System.out.println("Intento numero " + i + ": " + cadena);
        }
    }

    public static void main(String[] args) {
        String texto = "gfmjdjebeft"; // Texto a descifrar
        descifrarCesar(texto);
    }
}

