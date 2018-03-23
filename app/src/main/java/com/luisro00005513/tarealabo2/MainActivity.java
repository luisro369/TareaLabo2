package com.luisro00005513.tarealabo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int contadorClickBoton1 = 0,contadorClickBoton2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }// onCreate class

    //======================metodos====================
    public void darClick(View v){
        Button buttonIdplayer1, buttonIdplayer2;
        TextView textContadorPlayer1, textContadorPlayer2;
        //------------------------
        buttonIdplayer1 = findViewById(R.id.button_idplayer1);
        buttonIdplayer2 = findViewById(R.id.button_idplayer2);

        textContadorPlayer1 = findViewById(R.id.text_contador_player1);
        textContadorPlayer2 = findViewById(R.id.text_contador_player2);
        //------------------------
        if (v == buttonIdplayer1){
            contadorClickBoton1 += 1;
            textContadorPlayer1.setText(String.valueOf(contadorClickBoton1 * 15));

        }//boton1
        if (v == buttonIdplayer2){
            contadorClickBoton2 += 1;
            textContadorPlayer2.setText(String.valueOf(contadorClickBoton2 * 15));

        }//boton2

    }//darClick
}//main class
