package com.example.aleff.aulas;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class AtividadeMain extends AppCompatActivity {

    TextView numA;
    TextView numB;
    TextView resp;
    EditText resposta;
    Random gerador = new Random();
    int numeroGerado;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_main);
        numA = (TextView) findViewById(R.id.numA);
        numB = (TextView) findViewById(R.id.numB);

        Button votarA = (Button) findViewById(R.id.votoA);
        Button votarB = (Button) findViewById(R.id.votoB);
        resposta = (EditText) findViewById(R.id.numberGenerate);

        resp = (TextView) findViewById(R.id.Resposta);

        resp.setText("Resposta: " + numeroGerado);


        if (numeroGerado == 0 && resposta != null) {
            randomic();
        }
        votarA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String respTxt = resposta.getText().toString();
                if (respTxt != null) {
                    int respostaInt = new Integer(respTxt).intValue();
                    if (respostaInt == numeroGerado)
                        votarA();
                }
            }
        });
        votarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String respTxt = resposta.getText().toString();
                if (respTxt != null) {
                    int respostaInt = new Integer(respTxt).intValue();
                    if (votoCerto(respostaInt))
                        votarB();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_atividade_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    public void votarA() {
        Integer a = Integer.parseInt(this.numA.getText().toString());
        ++a;
        numA.setText("" + a);
        randomic();
    }

    public void votarB() {
        Integer a = Integer.parseInt(this.numB.getText().toString());
        ++a;
        numB.setText("" + a);
        randomic();
    }

    public void randomic() {
        numeroGerado = gerador.nextInt(1);
        resp.setText("Resposta: " + numeroGerado);
    }

    public boolean votoCerto(int resposta) {
        if (resposta == numeroGerado) return true;
        else return false;

    }
}
