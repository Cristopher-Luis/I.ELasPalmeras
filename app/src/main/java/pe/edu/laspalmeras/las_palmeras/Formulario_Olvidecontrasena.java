package pe.edu.laspalmeras.las_palmeras;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Formulario_Olvidecontrasena extends AppCompatActivity {
    private EditText lblnumerotelefono;
    private EditText lblcorreoelectronico;
    private Button btnsiguienteolvidecontraseña;
    private ImageView imgEyeTelefono;
    private ImageView imgEyeCorreo;
    private ImageView imglibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_olvidecontrasena);
        //Inicialización de los componentes.
        lblnumerotelefono = findViewById(R.id.lblnumerotelefono);
        lblcorreoelectronico = findViewById(R.id.lblcorreoelectronico);
        btnsiguienteolvidecontraseña = findViewById(R.id.btnsiguienteolvidecontraseña);
        imgEyeTelefono = findViewById(R.id.imgEyeTelefono);
        imgEyeCorreo = findViewById(R.id.imgEyeCorreo);
        imglibro = findViewById(R.id.imglibro);

        // Cargar la animación
        Animation moveAnimation = AnimationUtils.loadAnimation(this,R.anim.movimiento_libro_1);
        imglibro.startAnimation(moveAnimation);// Inicia la animación

        // Configuración del listener para el botón
        btnsiguienteolvidecontraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarYcontinuar();
            }
        });

        // Listener para mostrar/ocultar número de teléfono
        imgEyeTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleNumberVisibility(lblnumerotelefono, imgEyeTelefono);
            }

            private void toggleNumberVisibility(EditText editText, ImageView eyeIcon) {
                if (editText.getInputType() == (InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD)) {
                    // Cambiar a texto visible
                    editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
                    eyeIcon.setImageResource(R.drawable.ic_eye); // Cambia a ícono de ojo visible
                } else {
                    // Cambiar a texto oculto
                    editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                    eyeIcon.setImageResource(R.drawable.ic_eye_off); // Cambia a ícono de ojo oculto
                }
                // Mueve el cursor al final del texto
                editText.setSelection(editText.getText().length());
            }
        });

        // Listener para mostrar/ocultar correo electrónico
        imgEyeCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility(lblcorreoelectronico, imgEyeCorreo);
            }
            private void togglePasswordVisibility(EditText editText, ImageView eyeIcon) {
                if (editText.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                    // Cambiar a texto visible
                    editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    eyeIcon.setImageResource(R.drawable.ic_eye); // Cambia a ícono de ojo visible
                } else {
                    // Cambiar a texto oculto
                    editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    eyeIcon.setImageResource(R.drawable.ic_eye_off); // Cambia a ícono de ojo oculto
                }
                // Mueve el cursor al final del texto
                editText.setSelection(editText.getText().length());
            }
        });
    }
    private void validarYcontinuar() {
        String numeroTelefono = lblnumerotelefono.getText().toString().trim();
        String correoElectronico = lblcorreoelectronico.getText().toString().trim();
        //Validar los campos
        if (TextUtils.isEmpty(numeroTelefono)) {
            Toast.makeText(this, "Porfavor ingrese su número telefonico", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(correoElectronico)) {
            Toast.makeText(this,"Porfavor ingree su correo electronico", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this,Codigo_Validacion.class);
        startActivity(intent);
    }
}

