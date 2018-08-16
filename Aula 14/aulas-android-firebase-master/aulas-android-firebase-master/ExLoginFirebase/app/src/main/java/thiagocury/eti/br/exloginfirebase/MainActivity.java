package thiagocury.eti.br.exloginfirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private EditText etLogin;
    private EditText etSenha;
    private Button btnEntrar;
    private Button btnCriarConta;
    private Button btnEsqueciMinhaSenha;
    private ProgressBar progress;

    //Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Refs.
        etLogin = (EditText) findViewById(R.id.et_login);
        etSenha = (EditText) findViewById(R.id.et_senha);
        btnEntrar = (Button) findViewById(R.id.btn_entrar);
        btnCriarConta = (Button) findViewById(R.id.btn_criar_conta);
        btnEsqueciMinhaSenha = (Button) findViewById(R.id.btn_esqueci_senha);
        progress = (ProgressBar) findViewById(R.id.progress);

        progress.setVisibility(View.INVISIBLE);

        //Buscando ref. firebase
        mAuth = FirebaseAuth.getInstance();

        //Verificando se o usuário já logou anteriormente
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user != null){
                    //Usuário está logado
                    Toast.makeText(
                            getBaseContext(),
                            "Você já está logado!",
                            Toast.LENGTH_LONG).show();

                    //redirecionar para tela de abertura

                }else{

                    //Usuário NÃO está logado
                    Toast.makeText(
                            getBaseContext(),
                            "Você não está logado ainda!",
                            Toast.LENGTH_LONG).show();
                }
            }
        };

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!etLogin.getText().toString().isEmpty() &&
                        !etSenha.getText().toString().isEmpty()){

                    //Iniciando progress
                    progress.setVisibility(View.VISIBLE);

                    Usuario u = new Usuario();
                    u.setLogin(etLogin.getText().toString());
                    u.setSenha(etSenha.getText().toString());

                    Log.d("TAG","u: "+u.toString());

                    //Verificar e autenticar usuário no Firebase
                    mAuth.signInWithEmailAndPassword(u.getLogin(), u.getSenha())
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d("TAG","task: "+task.isSuccessful());
                                    if(!task.isSuccessful()){
                                        Toast.makeText(
                                                getBaseContext(),
                                                "Usuário NÃO autenticado!",
                                                Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(
                                                getBaseContext(),
                                                "Usuário autenticado com sucesso!",
                                                Toast.LENGTH_LONG).show();

                                        //redirecionar para tela de abertura
                                    }
                                    //Removendo progress
                                    progress.setVisibility(View.INVISIBLE);
                                }
                            });
                }else{
                    Toast.makeText(
                            getBaseContext(),
                            "Digite os dados para entrar no App",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etLogin.getText().toString().isEmpty() &&
                        !etSenha.getText().toString().isEmpty()){

                    //Iniciando progress
                    progress.setVisibility(View.VISIBLE);

                    Usuario u = new Usuario();
                    u.setLogin(etLogin.getText().toString());
                    u.setSenha(etSenha.getText().toString());

                    Log.d("TAG","u: "+u.toString());

                    //Criando usuário no Firebase
                    mAuth.createUserWithEmailAndPassword(u.getLogin(), u.getSenha())
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d("TAG","task: "+task.isSuccessful());
                                    if(!task.isSuccessful()){
                                        Toast.makeText(
                                                getBaseContext(),
                                                "Erro ao criar conta!",
                                                Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(
                                                getBaseContext(),
                                                "Conta criada com sucesso!",
                                                Toast.LENGTH_LONG).show();

                                        //redirecionar para tela de abertura
                                    }
                                    //Removendo progress
                                    progress.setVisibility(View.INVISIBLE);
                                }
                            });
                }else{
                    Toast.makeText(
                            getBaseContext(),
                            "Digite os dados para criar a conta",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnEsqueciMinhaSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth auth = FirebaseAuth.getInstance();

                if(!etLogin.getText().toString().isEmpty()) {

                    //Iniciando progress
                    progress.setVisibility(View.VISIBLE);

                    Usuario u = new Usuario();
                    u.setLogin(etLogin.getText().toString());

                    Log.d("TAG", "u: " + u.toString());

                    auth.sendPasswordResetEmail(u.getLogin())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Log.d("TAG", "Email para redefinição de senha enviado com sucesso.");

                                        Toast.makeText(
                                                getBaseContext(),
                                                "Email para redefinição de senha enviado com sucesso",
                                                Toast.LENGTH_LONG).show();
                                    }
                                    //Removendo progress
                                    progress.setVisibility(View.INVISIBLE);
                                }
                            });
                }else{
                    Toast.makeText(
                            getBaseContext(),
                            "Digite o seu email/login pfv!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}