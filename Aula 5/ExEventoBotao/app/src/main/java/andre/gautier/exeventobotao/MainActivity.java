package andre.gautier.exeventobotao;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btOK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TOAST

        /*Toast.makeText(
                MainActivity.this,
                getResources().getText(R.string.ma_toast_msg),
                Toast.LENGTH_LONG).show();*/

        //ALERT

        /*AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
        msg.setTitle(getResources().getText(R.string.ma_alert_titulo));
        msg.setMessage(getResources().getText(R.string.ma_alert_message));
        msg.setIcon(
                ContextCompat.getDrawable(
                        MainActivity.this,
                        R.mipmap.ic_launcher));
        msg.setPositiveButton(getResources().getText(R.string.texto_sim), null);
        msg.setNegativeButton(getResources().getText(R.string.texto_nao), null);
        msg.setNeutralButton(getResources().getText(R.string.texto_cancelar), null);
        msg.show();*/

        //referencias
        btOK = findViewById(R.id.ma_bt_ok);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getBaseContext(),
                        "Clicou",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btOK.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(
                        getBaseContext(),
                        "Clicou e Segurou",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }//fecha oncreate
}//fecha classe