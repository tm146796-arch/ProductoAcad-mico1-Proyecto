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

public class BinarioDecimalFragment extends Fragment {

    private TextInputEditText campoBinario;
    private TextView textoResultado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_binario_decimal, container, false);

        campoBinario = vista.findViewById(R.id.campoBinario);
        textoResultado = vista.findViewById(R.id.textoResultadoBinario);
        MaterialButton botonConvertir = vista.findViewById(R.id.botonConvertirBinario);

        botonConvertir.setOnClickListener(v -> convertirBinario());
        return vista;
    }

    private void convertirBinario() {
        String binario = campoBinario.getText() == null ? "" : campoBinario.getText().toString().trim();

        if (binario.isEmpty()) {
            textoResultado.setText("Ingresa un numero binario.");
            return;
        }

        if (!binario.matches("[01]+")) {
            textoResultado.setText("Solo se permiten los digitos 0 y 1.");
            return;
        }

        int decimal = Integer.parseInt(binario, 2);
        textoResultado.setText("Decimal: " + decimal);
    }
}
