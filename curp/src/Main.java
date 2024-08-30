import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        // Expresion regular
        String reglas = "^[A-Z]{1}[AEIOU]{1}[A-Z]{2}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[HM](AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[A-Z]{3}\\d{2}$";
        Pattern pattern = Pattern.compile(reglas);

        try {

            FileReader archivoFisico = new FileReader("curp_lista.csv");
            BufferedReader archivoLogico = new BufferedReader(archivoFisico);

            String curp;
            int contador = 0;

            while ((curp = archivoLogico.readLine()) != null) {
                contador++;
                Matcher matcher = pattern.matcher(curp);

                // Se imprime solo si la CURP no es válida
                if (!matcher.matches()) {
                    System.out.println("CURP inválida: " + curp + " en la posición: " + contador);
                }
            }

            archivoLogico.close();
            archivoFisico.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
