import java.util.List;

/**
 *  Hola profesor le dejo aqui puede correr el programa, puede cambiar la cadena de la expresion matematica con las reglas mencionadas
 *  + -* /() <----- esta son las expresiones que puede usar en su cadena
 * @Author
 * Arnoldo Rivera Mimbela
 *
 */
public class Main {

    public static void main(String[] args) {
        String codigoFuente = "int x = 8 + 3;";
        AnalizadorLexico analizador = new AnalizadorLexico(codigoFuente);
        List<Token> tokens = analizador.analizar();
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

}