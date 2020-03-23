package loan.louise.myrecyclerview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1;
    private EditText editText1;
    private EditText editText2;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = editText1.getText().toString();
        String mdp = editText2.getText().toString();

        if (email.equals("admin@admin.com") && mdp.equals("admin")){
            //lancer l'app
            Intent secActivityIntent = new Intent(MainActivity.this,SecActivity.class);
            startActivity(secActivityIntent);
        } else {
            //erreur
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("erreur:");
            builder.setMessage("l'adresse e-mail ou le mot de passe n'est pas correct");
            builder.setPositiveButton("OK", null);
            AlertDialog dialog = builder.show();
        }
    }
}
