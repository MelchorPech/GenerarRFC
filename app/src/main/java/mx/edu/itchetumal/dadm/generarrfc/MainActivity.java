package mx.edu.itchetumal.dadm.generarrfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String adecuarCadena(String cadena) {
        String cadAux = cadena.toUpperCase().trim();

        char[] vocalesAcentuadas = {'Á', 'É', 'Í', 'Ó', 'Ú'};
        char[] vocales = {'A', 'E', 'I', 'O', 'U',};
        for (byte pos = 0; pos < vocalesAcentuadas.length; pos++) {
            cadAux = cadena.replace(vocalesAcentuadas[pos], vocales[pos]);
        }
        return cadAux;
    }

    public void GenerarRFC(View v) {
        // Tomar la primer letra y primer vocal del apellido paterno
        EditText editTextApPa = (EditText) findViewById(R.id.editTextApPa);

        //Hacer método que reciba cadeda y devuelva en mayúsculas
        // sin espacio al inicio o fin sin acentos
        String apPaterno = adecuarCadena(editTextApPa.getText().toString());
        Toast.makeText(this, "cadena convertida", Toast.LENGTH_LONG).show();
        char PrimerLetraAP = apPaterno.charAt(0);
        //Primera vocal

        //
        char[] vocalesAcentuadas = {'Á', 'É', 'Í', 'Ó', 'Ú'};
        char[] vocales = {'A', 'E', 'I', 'O', 'U',};
        char primerVocal;
        byte pos = 0;
        boolean encontrado = false;
        for (pos = 0; pos <= vocalesAcentuadas.length; pos++) {
            if (apPaterno.indexOf(vocales[pos]) >= 0) {
                //encontrada =true;
                break;
            }
        }
        //
        char temp;
        boolean parar = true;

        for (int i = 0; i < apPaterno.length(); i++) {
            // aqui leemos tantas veces por cada vocal
            for (int j = 0; j < vocales.length; j++) {
                temp = apPaterno.charAt(i);
                //aqui preguntamos si es una vocal
                if (temp == vocales[j]) {
                    // preguntamos si debemos parar
                    if (parar) {
                        parar = false;
                    }
                }
            }
        }


        //Tomar la primer letra del apellido materno
        EditText editTextApMa = (EditText) findViewById(R.id.editTextApMa);
        String apMaterno = adecuarCadena(editTextApMa.getText().toString());
        char PrimerLetraMA = apMaterno.charAt(0);

        //Tomar la primer letra del primer nombre
        EditText editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        String Nombre = adecuarCadena(editTextApMa.getText().toString());
        char PrimerLetraNom = Nombre.charAt(0);
        //Tomar los ùltimo 2 digitos del año de nacimiento

        //TOmar los dos digitos del mes de nacimiento

        //Tomar los 2 difitos del dia de nacimiento

        //Generar 3 caracteres(Letras mayusculas o nùmeros)
        char[] elementos={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','E','S','T','U','V','W','X','Y','Z'};
        char [] aleatorio= new char[3];
        for(int i=0;i<=2;i++){
            aleatorio[i]=elementos[(int)(Math.random()*36)];
        }
        //Concatenar lo anterior y mostrar el RFC

    }
}
