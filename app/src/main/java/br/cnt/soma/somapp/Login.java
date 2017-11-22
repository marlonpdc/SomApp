package br.cnt.soma.somapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText Nome;
    private EditText Senha;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Nome = (EditText)findViewById(R.id.txt_loginName);
        Senha = (EditText)findViewById(R.id.txt_loginPass);
        Login = (Button) findViewById(R.id.bt_login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar(Nome.getText().toString(), Senha.getText().toString());
            }
        });
    }

    private void validar(String userName, String userPass){
        if(((userName.equals("Marlon")) || (userName.equals("marlon"))) && (userPass.equals("1234"))){
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
