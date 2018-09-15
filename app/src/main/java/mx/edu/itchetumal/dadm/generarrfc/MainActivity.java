package mx.edu.itchetumal.dadm.generarrfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GenerarRFC(View v){
        //Tomar la primer letra y primer vocal del apellido paterno
        EditText editTextApPa = (EditText) findViewById(R.id.editTextApPa);
        editTextApPa.getText().CharAt(0);


        char[] vocales ={'A','E','I','O','U','a','e','i','o','u'};
        String CadAux="Pedro Perez";
        char primeraLetra = CadAux.charAt(0);


        Char letraAp = new Character(CadAux.charAt(0));


        //Tomar la primer letra del apellido materno

        //Tomar la primer letra del primer nombre

        //Tomar los ùltimo 2 digitos del año de nacimiento

        //TOmar los dos digitos del mes de nacimiento

        //Tomar los 2 difitos del dia de nacimiento

        //Generar 3 caracteres(Letras mayusculas o nùmeros)

        //Concatenar lo anterior y mostrar el RFC
    }
}
