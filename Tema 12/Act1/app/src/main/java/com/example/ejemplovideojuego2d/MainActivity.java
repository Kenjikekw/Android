package com.example.ejemplovideojuego2d;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import vista.PantallaVideojuego;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static PantallaVideojuego pantallajuego;
    private ImageButton ibDerecha, ibIzquierda, ibArriba, ibAbajo, ibPausa;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.musica);
        mediaPlayer.start();

        // ***** Ligo los recursos de la actividad *****
        pantallajuego = (PantallaVideojuego)findViewById(R.id.pantallajuego);
        ibDerecha = (ImageButton)findViewById(R.id.ibDerecha);
        ibIzquierda = (ImageButton)findViewById(R.id.ibIzquierda);
        ibArriba = (ImageButton)findViewById(R.id.ibArriba);
        ibAbajo = (ImageButton)findViewById(R.id.ibAbajo);
        ibPausa = (ImageButton)findViewById(R.id.ibPausa);
        // ************************************************

        ibAbajo.setOnClickListener(this);
        ibArriba.setOnClickListener(this);
        ibDerecha.setOnClickListener(this);
        ibIzquierda.setOnClickListener(this);
        ibPausa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.ibAbajo:
                pantallajuego.cambiarDireccionAbajo();
                break;
            case R.id.ibArriba:
                pantallajuego.cambiarDireccionArriba();
                break;
            case R.id.ibDerecha:
                pantallajuego.cambiarDireccionDerecha();
                break;
            case R.id.ibIzquierda:
                pantallajuego.cambiarDireccionIzquierda();
                break;
            case R.id.ibPausa:
                pantallajuego.pausar();
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else{
                    mediaPlayer.start();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Liberar recursos del MediaPlayer cuando la actividad se destruye
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
