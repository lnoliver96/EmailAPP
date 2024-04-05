package oliveira.otoni.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEnviar = findViewById(R.id.btnEnviar);
        //Definição da ação do click do botao
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtendo dados digitados pelo usuario
                EditText etEmail = findViewById(R.id.etEmail);
                String email = etEmail.getText().toString();

                EditText etAssunto = findViewById(R.id.etAssunto);
                String assunto = etEmail.getText().toString();

                EditText etTexto = findViewById(R.id.etTexto);
                String texto = etEmail.getText().toString();

                //Cria uma intencao para abrir um app de mensagem
                Intent i = new Intent(Intent.ACTION_SENDTO);

                //Indica apps de envio e recebimento de email
                i.setData(Uri.parse("mailto: "));

                //Dados a serem enviados na intencao
                String[] emails = new String[]{email};
                i.putExtra(Intent.EXTRA_EMAIL,emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);

                //Cria menu de escolha de app
                try {
                    startActivity(Intent.createChooser(i,"Escolha o APP"));

                }
                //Mensagem de Erro
                catch (ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this,"Não há nenhum app que posso realizar essa operação", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}