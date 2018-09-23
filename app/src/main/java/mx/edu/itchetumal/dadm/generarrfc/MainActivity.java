package mx.edu.itchetumal.dadm.generarrfc;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {
    static EditText DateEdit;
    DatePicker datePicker;
    private static final String CERO = "0";
    private static final String BARRA = "/";
    int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateEdit = (EditText) findViewById(R.id.editTextFechaN);
        DateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showTruitonDatePickerDialog(v);
            }
        });
    }
    public String adecuarCadena(String cadena) {

        char[] vocalesAcentuadas = {'Á', 'É', 'Í', 'Ó', 'Ú'};
        char[] vocales = {'A', 'E', 'I', 'O', 'U',};
        cadena = cadena.toUpperCase().trim();
        for (int pos = 0; pos < vocalesAcentuadas.length; pos++) {
            cadena = cadena.replace(vocalesAcentuadas[pos], vocales[pos]);
        }
        return cadena;
    }

    public void showTruitonDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {


        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
            final int mesActual = month + 1;
            //Formateo el día obtenido: antepone el 0 si son menores de 10
            String diaFormateado = (day < 10)? CERO + String.valueOf(day):String.valueOf(day);
            //Formateo el mes obtenido: antepone el 0 si son menores de 10
             String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
            DateEdit.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
            String Fecha = diaFormateado + BARRA + mesFormateado + BARRA + year;

        }

    }



        public void Limpiar(View v) {
            String nulo = "";
            EditText editTextApPa = (EditText) findViewById(R.id.editTextApPa);
            editTextApPa.setText(nulo);

            EditText editTextApMa = (EditText) findViewById(R.id.editTextApMa);
            editTextApMa.setText(nulo);

            EditText editTextNombre = (EditText) findViewById(R.id.editTextNombre);
            editTextNombre.setText(nulo);

            EditText editTextRFC = (EditText) findViewById(R.id.editTextRFC);
            editTextRFC.setText(nulo);

            EditText editTextHomo = (EditText) findViewById(R.id.editTextHomo);
            editTextHomo.setText(nulo);

            EditText editTextFechaN = (EditText) findViewById(R.id.editTextFechaN);
            editTextFechaN.setText(nulo);
        }

        public void GenerarRFC(View v) {

            EditText TextApPa = (EditText) findViewById(R.id.editTextApPa);
            String apPaAux = TextApPa.getText().toString();
            EditText TextNombre = (EditText) findViewById(R.id.editTextNombre);
            String nombreAux = TextNombre.getText().toString();
            EditText TextApMa = (EditText) findViewById(R.id.editTextApMa);
            String apMaAux = TextApMa.getText().toString();
            EditText TextFechaN = (EditText) findViewById(R.id.editTextFechaN);
            String fechaNaAux = TextFechaN.getText().toString();

            if(TextUtils.isEmpty(nombreAux) || TextUtils.isEmpty(apPaAux) || TextUtils.isEmpty(apMaAux) || TextUtils.isEmpty(fechaNaAux) ){

                Toast.makeText(this, "Todos los campos deben estar llenos", Toast.LENGTH_SHORT).show();

            }else {


                // Tomar la primer letra y primer vocal del apellido paterno
                EditText editTextApPa = (EditText) findViewById(R.id.editTextApPa);

                //Hacer método que reciba cadeda y devuelva en mayúsculas
                // sin espacio al inicio o fin sin acentos
                String apPaterno = adecuarCadena(editTextApPa.getText().toString());
                char PrimerLetraAP = apPaterno.charAt(0);
                //Primera vocal Buscar
                char[] vocalesAcentuadas = {'Á', 'É', 'Í', 'Ó', 'Ú'};
                char[] vocales = {'A', 'E', 'I', 'O', 'U',};
                char temp;
                String primerVocal = "";
                boolean parar = true;

                for (int i = 0; i < apPaterno.length(); i++) {
                    // aqui leemos tantas veces por cada vocal
                    for (int j = 0; j < vocales.length; j++) {
                        temp = apPaterno.charAt(i);
                        //aqui preguntamos si es una vocal
                        if (temp == vocales[j]) {
                            // preguntamos si debemos parar
                            if (parar) {
                                primerVocal += temp;
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
                String Nombre = adecuarCadena(editTextNombre.getText().toString());
                char PrimerLetraNom = Nombre.charAt(0);


                //Tomar los ùltimo 2 digitos del año de nacimiento
                EditText editTextFechaN = (EditText) findViewById(R.id.editTextFechaN);
                String Fecha = editTextFechaN.getText().toString();

                String anio = "";
                char PrimeDigitoAño = Fecha.charAt(8);
                char segundoDigitoAño = Fecha.charAt(9);
                String variable = String.valueOf(PrimeDigitoAño);
                String variable2 = String.valueOf(segundoDigitoAño);
                anio += variable + variable2;

                //TOmar los dos digitos del mes de nacimiento
                String mes1 = "";
                char PrimeDigitoMes = Fecha.charAt(3);
                char segundoDigitoMes = Fecha.charAt(4);
                String variable3 = String.valueOf(PrimeDigitoMes);
                String variable4 = String.valueOf(segundoDigitoMes);
                mes1 += variable3 + variable4;

                //Tomar los 2 digitos del dia de nacimiento
                String dia1 = "";
                char PrimeDigitoDia = Fecha.charAt(0);
                char segundoDigitoDia = Fecha.charAt(1);
                String variable5 = String.valueOf(PrimeDigitoDia);
                String variable6 = String.valueOf(segundoDigitoDia);
                dia1 += variable5 + variable6;


                //Generar 3 caracteres(Letras mayusculas o nùmeros)
                char[] elementos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'Ñ', 'N', 'O', 'P', 'Q', 'E', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
                String aleatorio = "";
                for (int i = 0; i <= 2; i++) {
                    aleatorio += elementos[(int) (Math.random() * 37)];
                }
                //Mostrar en el edit text la homonimia
                EditText editTextHomo = (EditText) findViewById(R.id.editTextHomo);
                editTextHomo.setText(aleatorio);
                //Concatenar lo anterior y mostrar el RFC
                String RFC = "";
                RFC += PrimerLetraAP + primerVocal + PrimerLetraMA + PrimerLetraNom + anio + mes1 + dia1 + aleatorio;
                EditText editTextRFC = (EditText) findViewById(R.id.editTextRFC);
                editTextRFC.setText(RFC);

            }
            }

    }
