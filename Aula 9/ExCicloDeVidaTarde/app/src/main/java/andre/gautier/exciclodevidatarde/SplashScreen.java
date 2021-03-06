package andre.gautier.exciclodevidatarde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler; //AAAAAAAAAA
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIME_OUT = 3000;

    private static final String TAG = "LogsSplashScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Log.d(TAG, "Entrou no oncreate");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "Entrou no handler");
                //abrir a tela
                Intent it = new Intent(SplashScreen.this,
                        MainActivity.class);

                it.putExtra("saudacao", "Olá, seja bem vindo!"); //HASHMAP

                startActivity(it);
                finish();

            }
        }, SPLASH_SCREEN_TIME_OUT); //AAAAAAAAAA

    }//fecha oncreate

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Entrou no onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Entrou no onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Entrou no onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Entrou no onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Entrou no ondestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Entrou no onrestart");
    }

}//fecha classe