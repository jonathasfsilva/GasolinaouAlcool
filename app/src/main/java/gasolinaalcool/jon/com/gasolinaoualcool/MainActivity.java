package gasolinaalcool.jon.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Localizar componentes na tela
        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        textoResultado = (TextView) findViewById(R.id.textoResultadoId);

        //evento quando clicar no botao
        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recuperar valores
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                //Convertendo valores de str para double
                Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                //teste se vale a pena

                if(textoPrecoAlcool.equals("") || textoPrecoGasolina.equals("")){
                    textoResultado.setText("Digite um valor para alcool e outro para gasolina!");
                }else{
                    double resultado = valorAlcool / valorGasolina;

                    if(resultado >= 0.7){
                        //Gasolina
                        textoResultado.setText("Eh melhor utilizar Gasolina");
                    }else{
                        //Alcool
                        textoResultado.setText("Eh melhor utilizar Alcool");
                    }
                }
            }
        });

    }
}
