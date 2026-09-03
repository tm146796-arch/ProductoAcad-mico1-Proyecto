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

import java.util.Random;

public class NumeroAleatorioFragment extends Fragment {

    private final Random random = new Random();
    private TextView textoNumero;
    private TextView textoResultado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_numero_aleatorio, container, false);

        textoNumero = vista.findViewById(R.id.textoNumeroGenerado);
        textoResultado = vista.findViewById(R.id.textoResultadoAleatorio);
        MaterialButton botonGenerar = vista.findViewById(R.id.botonGenerarNumero);

        botonGenerar.setOnClickListener(v -> generarNumero());
        return vista;
    }

    private void generarNumero() {
        int numero = 100000 + random.nextInt(900000);
        int cantidadImpares = contarDigitosImpares(numero);

        textoNumero.setText("Numero generado: " + numero);
        if (cantidadImpares == 3) {
            textoResultado.setText("Es correcto. Tiene 3 digitos impares.");
        } else {
            textoResultado.setText("No es correcto. Tiene " + cantidadImpares + " digitos impares.");
        }
    }

    private int contarDigitosImpares(int numero) {
        int contador = 0;
        int numeroTemporal = numero;

        while (numeroTemporal > 0) {
            int digito = numeroTemporal % 10;
            if (digito % 2 != 0) {
                contador++;
            }
            numeroTemporal = numeroTemporal / 10;
        }

        return contador;
    }
}
