import java.util.List;

/**
 *  Hola profesor le dejo aqui puede correr el programa, puede cambiar la cadena de la expresion matematica con las reglas mencionadas
 *  + -* /() <----- esta son las expresiones que puede usar en su cadena
 * @Author
 * Arnoldo Rivera Mimbela
 *
 * cadenas con las que puede testear profesor:
 * if (x == 3) { y = 2; }
 * for (i = 0; i < 10; i++) { System.out.println(i); }
 * <, ;, ++, {, ;, } y ()
 * x = "Hola, mundo!";
 * y = 2.5 + x;
 *
 */
public class Main {

    public static void main(String[] args) {
        String codigoFuente = "for (i = 0; i < 10; i++) { System.out.println(i); }";
        AnalizadorLexico analizador = new AnalizadorLexico(codigoFuente);
        List<Token> tokens = analizador.analizar();
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

}