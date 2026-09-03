package org.pa1.cordero;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private TextView tituloToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        tituloToolbar = findViewById(R.id.tituloToolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.navigationView);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            mostrarFragment(new AcercaFragment(), "Acerca");
            navigationView.setCheckedItem(R.id.menuAcerca);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuAcerca) {
            mostrarFragment(new AcercaFragment(), "Acerca");
        } else if (id == R.id.menuTriangulo) {
            mostrarFragment(new TrianguloFragment(), "Area de triangulo");
        } else if (id == R.id.menuAleatorio) {
            mostrarFragment(new NumeroAleatorioFragment(), "Numero aleatorio");
        } else if (id == R.id.menuBinarioDecimal) {
            mostrarFragment(new BinarioDecimalFragment(), "Binario a decimal");
        } else if (id == R.id.menuHexBinario) {
            mostrarFragment(new HexBinarioFragment(), "Hexadecimal a binario");
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void mostrarFragment(Fragment fragment, String titulo) {
        tituloToolbar.setText(titulo);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedorFragments, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
