package andre.gautier.exercicio;

import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btSubZero;
    private Button btScorpion;
    private Button btBaraka;
    private Button btRaiden;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSubZero = findViewById(R.id.bt_subzero);
        btScorpion = findViewById(R.id.bt_scorpion);
        btBaraka = findViewById(R.id.bt_baraka);
        btRaiden = findViewById(R.id.bt_raiden);

        btSubZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.subzero);
                Toast.makeText(
                        getBaseContext(),
                        "SUBZERO",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btSubZero.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle(getResources().getText(R.string.ma_alert_titulo));
                msg.setMessage(getResources().getText(R.string.ma_alert_mensagem));

                msg.setIcon(ContextCompat.getDrawable(
                        MainActivity.this,
                        R.mipmap.ic_launcher));

                msg.show();
                return true;
            }
        });

        btScorpion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.scorp);
                Toast.makeText(
                        getBaseContext(),
                        "SCORPION",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btScorpion.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle(getResources().getText(R.string.ma_alert_titulo));
                msg.setMessage(getResources().getText(R.string.ma_alert_msg_scorpion));

                msg.setIcon(ContextCompat.getDrawable(
                        MainActivity.this,
                        R.mipmap.ic_launcher));

                msg.show();
                return true;
            }
        });

        btBaraka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.baraka);
                Toast.makeText(
                        getBaseContext(),
                        "BARAKA",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btBaraka.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle(getResources().getText(R.string.ma_alert_titulo));
                msg.setMessage(getResources().getText(R.string.ma_alert_msg_baraka));

                msg.setIcon(ContextCompat.getDrawable(
                        MainActivity.this,
                        R.mipmap.ic_launcher));

                msg.show();
                return true;
            }
        });

        btRaiden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.raiden);
                Toast.makeText(
                        getBaseContext(),
                        "RAIDEN",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btRaiden.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                msg.setTitle(getResources().getText(R.string.ma_alert_titulo));
                msg.setMessage(getResources().getText(R.string.ma_alert_msg_raiden));

                msg.setIcon(ContextCompat.getDrawable(
                        MainActivity.this,
                        R.mipmap.ic_launcher));

                msg.show();
                return true;
            }
        });
    }

    public void play(int som) {
        mp = MediaPlayer.create(MainActivity.this, som);
        mp.start();
    }

    public void stop() {
        if (mp.isPlaying()) {
            mp.stop();
        }
    }
}
