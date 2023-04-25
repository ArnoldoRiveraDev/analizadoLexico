import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {

    private String codigoFuente;
    private int indice;

    public AnalizadorLexico(String codigoFuente) {
        this.codigoFuente = codigoFuente;
        this.indice = 0;
    }

    public List<Token> analizar() {
        List<Token> tokens = new ArrayList<Token>();

        while (indice < codigoFuente.length()) {
            char caracterActual = codigoFuente.charAt(indice);

            if (esLetra(caracterActual)) {
                String palabra = leerPalabra();
                if (esPalabraClave(palabra)) {
                    tokens.add(new Token(TipoToken.PALABRA_CLAVE, palabra));
                } else {
                    tokens.add(new Token(TipoToken.IDENTIFICADOR, palabra));
                }
            } else if (esNumero(caracterActual)) {
                String numero = leerNumero();
                tokens.add(new Token(TipoToken.NUMERO, numero));
            } else if (esSimbolo(caracterActual)) {
                tokens.add(new Token(TipoToken.SIMBOLO, Character.toString(caracterActual)));
                indice++;
            } else {
                indice++;
            }
        }

        return tokens;
    }

    private boolean esLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean esNumero(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean esSimbolo(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '=' || c == '(' || c == ')';
    }

    private boolean esPalabraClave(String palabra) {
        return palabra.equals("if") || palabra.equals("else") || palabra.equals("while") || palabra.equals("for");
    }

    private String leerPalabra() {
        int inicio = indice;
        while (indice < codigoFuente.length() && esLetra(codigoFuente.charAt(indice))) {
            indice++;
        }
        return codigoFuente.substring(inicio, indice);
    }

    private String leerNumero() {
        int inicio = indice;
        while (indice < codigoFuente.length() && esNumero(codigoFuente.charAt(indice))) {
            indice++;
        }
        return codigoFuente.substring(inicio, indice);
    }

}

enum TipoToken {
    PALABRA_CLAVE,
    IDENTIFICADOR,
    NUMERO,
    SIMBOLO
}

class Token {

    private TipoToken tipo;
    private String valor;

    public Token(TipoToken tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public String toString() {
        return tipo + ": " + valor;
    }

}
