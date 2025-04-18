package pe.edu.laspalmeras.las_palmeras;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText lblcorreo, lblcontraseña;
    private Button btningresar, btncancelar;
    private TextView txtolvidecontraseña, txtcrearcuenta;
    private FirebaseAuth firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Declaramos la variable de inicialización en firebase.
        firebase = FirebaseAuth.getInstance();
        //Declaramos o instanciamos los textview de olvidecontraseña y crear contraseña.
        TextView txtolvidecontraseña = findViewById(R.id.txtolvidecontraseña);
        TextView txtcrearcuenta = findViewById(R.id.txtcrearcuenta);
        //Declaramos o instanciamos los elementos xml de editexte correo y contraseña.
        EditText lblcorreo = findViewById(R.id.lblcorreo);
        EditText lblcontraseña = findViewById(R.id.lblcontraseña);
        //Declaramos o instanciamos los elementos xml de los botones de Ingresar y cancelar.
        Button btningresar = findViewById(R.id.btningresar);
        Button btncancelar = findViewById(R.id.btncancelar);
        //Declaramos o instanciamos los elementos del xml de login.
        Button btnfacebook = findViewById(R.id.btnfacebook);
        Button btngooglemaps = findViewById(R.id.btngooglemaps);

        //Realizamos los eventos del boton ingresar.
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = lblcorreo.getText().toString().trim();
                String contraseña = lblcontraseña.getText().toString().trim();
                if (!correo.isEmpty() && !contraseña.isEmpty()){
                    iniciarSesion(correo, contraseña);
                } else {
                    Toast.makeText(Login.this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                }
            }

            //Creamos el metodo iniciar sesión
            private void iniciarSesion(String correo, String contraseña) {
                firebase.signInWithEmailAndPassword(correo, contraseña)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


        //Realizamos los eventos para poder ejecutar la acción de btnfacebook.
        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/share/1BmxdUadaf/"));
                startActivity(intent2);
            }
        });
        //Realizamos los eventos para poder ejecutar la acción de btngooglemaps.
        btngooglemaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/DHEf91BxKMSnsHFD9"));
                startActivity(intent3);
            }
        });
    }
}