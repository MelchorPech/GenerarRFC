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
    public String adecuarCadena(String cadena){
        String cadAux= cadena.toUpperCas().trim();

        char[] vocalesAcentuadas = {'Á', 'É', 'Í', 'Ó', 'Ú'};
        char[] vocales = {'A', 'E', 'I', 'O', 'U',};
        for (byte pos = 0; pos <= vocalesAcentuadas.length; pos++) {
            apPaterno.replace(vocalesAcentuadas[pos], vocales[pos]);
        }
        return cadAux;
    }

    public void GenerarRFC(View v){
        // Tomar la primer letra y primer vocal del apellido paterno
        EditText editTextApPa = (EditText) findViewById(R.id.editTextApPa);

        //Hacer método que reciba cadeda y devuelva en mayúsculas
        // sin espacio al inicio o fin sin acentos
        String apPaterno = adecuarCadena(editTextApPa.getText().toString());
        Toast.makeText(this,"cadena convertida",Toast.LENGTH_LONG).show();
        char PrimerLetraAP = apPaterno.CharAt(0);

        char primerVocal=" ";
        byte pos =0;
        boolean encontrado =false;
        for (byte pos = 0; pos <= vocalesAcentuadas.length; pos++) {
            if (apPaterno.indexOf(vocales[pos])>=0){
                encontrada =true;
                break;
            }
        }

        //String CadAux="Pedro Perez";
        //char primeraLetra = CadAux.charAt(0);
        //Char letraAp = new Character(CadAux.charAt(0));


        //Tomar la primer letra del apellido materno

        //Tomar la primer letra del primer nombre

        //Tomar los ùltimo 2 digitos del año de nacimiento

        //TOmar los dos digitos del mes de nacimiento

        //Tomar los 2 difitos del dia de nacimiento

        //Generar 3 caracteres(Letras mayusculas o nùmeros)

        //Concatenar lo anterior y mostrar el RFC
    }
}
