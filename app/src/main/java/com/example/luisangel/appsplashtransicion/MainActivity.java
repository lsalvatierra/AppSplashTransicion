package com.example.luisangel.appsplashtransicion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView tvMensaje;
    private ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recuperamos los controles
        tvMensaje = (TextView)findViewById(R.id.tvInformacion);
        ivImagen = (ImageView)findViewById(R.id.ivLogo);
        //Declaramos la animación.
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.transicion);

        tvMensaje.startAnimation(animacion);
        ivImagen.startAnimation(animacion);

        final Intent x = new Intent(this, Main2Activity.class);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5000);
                }catch (InterruptedException ex){

                    ex.printStackTrace();
                }finally {
                    startActivity(x);
                    finish();
                }
            }
        };

        timer.start();


    }
}
