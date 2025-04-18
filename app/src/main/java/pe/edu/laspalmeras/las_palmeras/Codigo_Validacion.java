package pe.edu.laspalmeras.las_palmeras;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Codigo_Validacion extends AppCompatActivity {
    private ImageView imglibro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_codigo_validacion);
        //Inicialización de los componentes.
        imglibro = findViewById(R.id.imglibro);
        // Cargar la animación
        Animation moveanimation = AnimationUtils.loadAnimation(this,R.anim.movimiento_libro2);
        imglibro.startAnimation(moveanimation);
    }
}