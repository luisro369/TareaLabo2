package com.luisro00005513.tarealabo2;

import android.app.Application;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//===============contador pensado para un set(6 juegos)===============
public class MainActivity extends AppCompatActivity {
    int contadorClickBoton1 = 0,contadorClickBoton2 = 0, contadorJuego = 0,contadorJuego1 = 0, contadorJuego2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }// onCreate class

    //===============================metodo dar click ===============================================
    public void darClick(View v) {
        Button buttonIdplayer1, buttonIdplayer2, buttonGanador;
        TextView textContadorPlayer1, textContadorPlayer2, juego, textGanador;
        ImageView jugador1, jugador2;
        //------------------------
        textGanador = findViewById(R.id.nombrarGanador);
        buttonGanador = findViewById(R.id.botonGanador);
        juego = findViewById(R.id.juegoId);
        jugador1 = findViewById(R.id.image_id1);
        jugador2 = findViewById(R.id.image_id2);

        buttonIdplayer1 = findViewById(R.id.button_idplayer1);
        buttonIdplayer2 = findViewById(R.id.button_idplayer2);

        textContadorPlayer1 = findViewById(R.id.text_contador_player1);
        textContadorPlayer2 = findViewById(R.id.text_contador_player2);
        //-------------------------
        jugador1.setBackgroundResource(R.color.Juego);
        jugador2.setBackgroundResource(R.color.Juego);
        //--------------condiciones iniciales----------
        textGanador.setText("");
        buttonGanador.setBackgroundResource(R.color.Juego);
        buttonGanador.setText("");
        //-------------condiciones iniciales(fin)------
        if (v == buttonIdplayer1) {
            contadorClickBoton1 += 1;
            if(contadorClickBoton1 < 4) {
                textContadorPlayer1.setText(String.valueOf(contadorClickBoton1 * 15));
            }
        }//boton1
        if (v == buttonIdplayer2) {
            contadorClickBoton2 += 1;
            if(contadorClickBoton2 < 4) {
                textContadorPlayer2.setText(String.valueOf(contadorClickBoton2 * 15));
            }
        }//boton2
        if(contadorJuego < 6){
            if((contadorClickBoton1 >= 3) || (contadorClickBoton2 >= 3)){
                if((contadorClickBoton1 & contadorClickBoton2) == 3){
                    textContadorPlayer1.setText("Deuce");
                    textContadorPlayer2.setText("Deuce");
                }//if de si ambos estan empatados con 45
                //----------------------------------------
                if(contadorClickBoton1 == 4 & contadorClickBoton2 >= 3){
                    textContadorPlayer1.setText("advantage");
                    textContadorPlayer2.setText(String.valueOf(contadorClickBoton2 * 15));

                    if(contadorClickBoton2 == 4){
                        contadorClickBoton1 = 3;
                        contadorClickBoton2 = 3;
                        textContadorPlayer1.setText(String.valueOf(contadorClickBoton1 * 15));
                        textContadorPlayer2.setText(String.valueOf(contadorClickBoton2 * 15));
                    }//si el jugdor 2 mete punto le quita el advantage al jugador 1
                }//si anota un punto mas el jugador1
                if(contadorClickBoton2 == 4 & contadorClickBoton1 >= 3){
                    textContadorPlayer2.setText("advantage");
                    textContadorPlayer1.setText(String.valueOf(contadorClickBoton1 * 15));


                    if(contadorClickBoton1 == 4){
                        contadorClickBoton1 = 3;
                        contadorClickBoton2 = 3;
                        textContadorPlayer1.setText(String.valueOf(contadorClickBoton1 * 15));
                        textContadorPlayer2.setText(String.valueOf(contadorClickBoton2 * 15));
                        //textContadorPlayer1.setText("advantage");
                    }//si el jugdor 1 mete punto le quita el advantage al jugador 2
                }//si anota un punto mas el jugador1
                if(contadorClickBoton1 > 4){
                    //jugador1.setBackgroundColor(R.color.ganadorJuego);
                    jugador1.setBackgroundResource(R.color.ganadorJuego);
                    contadorJuego += 1;
                    juego.setText("juego " + String.valueOf(contadorJuego));
                    contadorJuego1 += 1;
                    resetear(textContadorPlayer1,textContadorPlayer2, jugador1, jugador2);
                }//si gana el juego jugador1
                if(contadorClickBoton2 > 4){
                    //jugador1.setBackgroundColor(R.color.ganadorJuego);
                    jugador2.setBackgroundResource(R.color.ganadorJuego);
                    contadorJuego += 1;
                    juego.setText("juego " + String.valueOf(contadorJuego));
                    contadorJuego2 += 1;
                    resetear(textContadorPlayer1,textContadorPlayer2,jugador1, jugador2);
                }//si gana el juego jugador1
            }//if contador click
        }//contadorJuego
        else{
            contadorJuego = 0;
            juego.setText("juego " + String.valueOf(contadorJuego));
            if((contadorJuego1 >= 4) & (contadorJuego1 > contadorJuego2)){
                textGanador.setText("Jugador 1 gana!!!");
            }//si gana el jugador 1
            if((contadorJuego2 >= 4) & (contadorJuego2 > contadorJuego1)){
                textGanador.setText("Jugador 2 gana!!!");
            }//si gana el jugador 1
            buttonGanador.setBackgroundResource(R.color.ganadorJuego);
            buttonGanador.setText("Volver a jugar?");
            resetear(textContadorPlayer1,textContadorPlayer2,jugador1, jugador2);
        }// define quien es el ganador, en 1 set cada jugador por lo menos tiene que ganar 4 partidas
    }//darClick
    //===============================metodo dar click (fin)===============================================

    //===============================metodo resetear variables ===============================================

    public void resetear(TextView textContadorPlayer1, TextView textContadorPlayer2, ImageView jugador1, ImageView jugador2){
        contadorClickBoton1 = 0;
        textContadorPlayer1.setText(String.valueOf(contadorClickBoton1 * 15));
        contadorClickBoton2 = 0;
        textContadorPlayer2.setText(String.valueOf(contadorClickBoton2 * 15));
    }//resetear
    //===============================metodo resetear variables (fin)===============================================


}//main class

