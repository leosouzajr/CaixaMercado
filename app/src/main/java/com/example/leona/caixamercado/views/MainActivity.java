package com.example.leona.caixamercado.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leona.caixamercado.R;

public class MainActivity extends AppCompatActivity {
    InicioFragment inicioFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarFragment("inicio");
    }

    private void carregarFragment(String tipoFragment) {
        if (tipoFragment.equalsIgnoreCase("inicio")) {

            inicioFragment = new InicioFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, inicioFragment).commit();
        }

    }
}
