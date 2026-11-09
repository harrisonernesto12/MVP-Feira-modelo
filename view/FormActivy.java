package com.seuprojeto.mvpfeira.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.seuprojeto.mvpfeira.R;
import com.seuprojeto.mvpfeira.controller.FeiraViewModel;
import com.seuprojeto.mvpfeira.model.Product;

public class FormActivity extends AppCompatActivity {
    private FeiraViewModel viewModel;
    private Product currentProduct; // Você passaria o ID do produto pela Intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        viewModel = new ViewModelProvider(this).get(FeiraViewModel.class);

        EditText editPrice = findViewById(R.id.editPrice);
        EditText editStock = findViewById(R.id.editStock);
        Switch switchAvailable = findViewById(R.id.switchAvailable);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            try {
                Double newPrice = Double.parseDouble(editPrice.getText().toString());
                int newStock = Integer.parseInt(editStock.getText().toString());
                
                currentProduct.setPrice(newPrice);
                currentProduct.setStock(newStock);
                currentProduct.setAvailable(switchAvailable.isChecked());
                
                viewModel.updateProduct(currentProduct);
                finish(); // Retorna para a tela 1
            } catch (NumberFormatException e) {
                editPrice.setError("Preço em branco ou inválido"); // RNF02: Proteção de entrada
            }
        });
    }
}