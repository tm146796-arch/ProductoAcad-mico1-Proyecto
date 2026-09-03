package org.pa1.cordero;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class TrianguloFragment extends Fragment {

    private TextInputEditText campoLadoA;
    private TextInputEditText campoLadoB;
    private TextInputEditText campoLadoC;
    private TextView textoResultado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_triangulo, container, false);

        campoLadoA = vista.findViewById(R.id.campoLadoA);
        campoLadoB = vista.findViewById(R.id.campoLadoB);
        campoLadoC = vista.findViewById(R.id.campoLadoC);
        textoResultado = vista.findViewById(R.id.textoResultadoTriangulo);
        MaterialButton botonCalcular = vista.findViewById(R.id.botonCalcularTriangulo);

        botonCalcular.setOnClickListener(v -> calcularArea());
        return vista;
    }

    private void calcularArea() {
        String textoA = obtenerTexto(campoLadoA);
        String textoB = obtenerTexto(campoLadoB);
        String textoC = obtenerTexto(campoLadoC);

        if (textoA.isEmpty() || textoB.isEmpty() || textoC.isEmpty()) {
            textoResultado.setText("Ingresa los tres lados.");
            return;
        }

        double ladoA = Double.parseDouble(textoA);
        double ladoB = Double.parseDouble(textoB);
        double ladoC = Double.parseDouble(textoC);

        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            textoResultado.setText("Los lados deben ser mayores que cero.");
            return;
        }

        if (ladoA + ladoB <= ladoC || ladoA + ladoC <= ladoB || ladoB + ladoC <= ladoA) {
            textoResultado.setText("Los lados no forman un triangulo.");
            return;
        }

        double semiperimetro = (ladoA + ladoB + ladoC) / 2;
        double area = Math.sqrt(semiperimetro
                * (semiperimetro - ladoA)
                * (semiperimetro - ladoB)
                * (semiperimetro - ladoC));

        textoResultado.setText(String.format("Area: %.2f", area));
    }

    private String obtenerTexto(TextInputEditText campo) {
        return campo.getText() == null ? "" : campo.getText().toString().trim();
    }
}
