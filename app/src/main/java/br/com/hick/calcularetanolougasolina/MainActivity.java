package br.com.hick.calcularetanolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        private SeekBar seekAlcool;
        private SeekBar seekGasolina;
        private TextView valorGasolina;
        private TextView valorAlcool;
        private TextView Resultado;
        private double  precoGasolina;
        private double precoAlcool;
        private double result;
        private ImageView imagem;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekGasolina = findViewById(R.id.gasolina);
        valorGasolina = findViewById(R.id.valorGasolina);

        seekAlcool = findViewById(R.id.alcool);
        valorAlcool = findViewById(R.id.valorAlcool);

        Resultado = findViewById(R.id.Resultado);
        imagem = findViewById(R.id.resposta);

        seekAlcool.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            precoAlcool = (float)progress/10.0;
            valorAlcool.setText(String.valueOf(currencyFormat.format(precoAlcool)));

            result = precoAlcool/precoGasolina;

            if (result>=0.7){
                Resultado.setText("Etanol");
                imagem.setImageResource(R.drawable.etanol);
            }else{
                Resultado.setText("Gasolina");
                imagem.setImageResource(R.drawable.gasolina);
            } }




            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekGasolina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                precoGasolina = (float) progress/10.0;
                valorGasolina.setText(String.valueOf(currencyFormat.format(precoGasolina)));

                if (result>=0.7){
                    Resultado.setText("Etanol");
                    imagem.setImageResource(R.drawable.etanol);
                }else{
                    Resultado.setText("Gasolina");
                    imagem.setImageResource(R.drawable.gasolina);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
