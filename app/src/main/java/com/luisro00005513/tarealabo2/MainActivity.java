package com.luisro00005513.tarealabo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }// onCreate class

    //======================metodos====================
    public void darClick(View boton){
        TextView textContadorPlayer1, textContadorPlayer2;
        int contadorClickBoton1 = 0,contadorClickBoton2 = 0;
        //------------------------
        textContadorPlayer1 = findViewById(R.id.text_contador_player1);
        textContadorPlayer2 = findViewById(R.id.text_contador_player2);
        if (boton == textContadorPlayer1){
            contadorClickBoton1 += 1;
            textContadorPlayer1.setText((String)contadorClickBoton1);
            textContadorPlayer1.setText();

        }//boton1

    }//darClick
}//main class
