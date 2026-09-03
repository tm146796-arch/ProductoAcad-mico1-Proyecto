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

public class HexBinarioFragment extends Fragment {

    private TextInputEditText campoHexadecimal;
    private TextView textoResultado;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_hex_binario, container, false);

        campoHexadecimal = vista.findViewById(R.id.campoHexadecimal);
        textoResultado = vista.findViewById(R.id.textoResultadoHexadecimal);
        MaterialButton botonConvertir = vista.findViewById(R.id.botonConvertirHexadecimal);

        botonConvertir.setOnClickListener(v -> convertirHexadecimal());
        return vista;
    }

    private void convertirHexadecimal() {
        String hexadecimal = campoHexadecimal.getText() == null ? "" : campoHexadecimal.getText().toString().trim();

        if (hexadecimal.isEmpty()) {
            textoResultado.setText("Ingresa un numero hexadecimal.");
            return;
        }

        if (!hexadecimal.matches("[0-9A-Fa-f]+")) {
            textoResultado.setText("Solo se permiten digitos del 0 al 9 y letras A hasta F.");
            return;
        }

        StringBuilder binario = new StringBuilder();
        for (int i = 0; i < hexadecimal.length(); i++) {
            int decimal = Integer.parseInt(String.valueOf(hexadecimal.charAt(i)), 16);
            String grupoBinario = Integer.toBinaryString(decimal);
            while (grupoBinario.length() < 4) {
                grupoBinario = "0" + grupoBinario;
            }
            binario.append(grupoBinario);
        }

        textoResultado.setText("Binario: " + binario);
    }
}
