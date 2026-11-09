package com.seuprojeto.mvpfeira.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.seuprojeto.mvpfeira.R;
import com.seuprojeto.mvpfeira.controller.FeiraViewModel;

public class MainActivity extends AppCompatActivity {
    private FeiraViewModel viewModel;
    // Adaptador do RecyclerView omitido por brevidade

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Conecta com o seu XML

        viewModel = new ViewModelProvider(this).get(FeiraViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewProducts);
        Button btnGenerate = findViewById(R.id.btnGenerateTable);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Observa mudanças no banco de dados e atualiza a tela
        viewModel.getProductList().observe(this, products -> {
            // Atualizar o RecyclerView aqui
        });

        btnGenerate.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PreviewActivity.class);
            startActivity(intent);
        });
    }
}