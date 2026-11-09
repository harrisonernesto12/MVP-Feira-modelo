package com.seuprojeto.mvpfeira.controller;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.seuprojeto.mvpfeira.model.AppDatabase;
import com.seuprojeto.mvpfeira.model.Product;
import com.seuprojeto.mvpfeira.model.ProductDao;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FeiraViewModel extends AndroidViewModel {
    private ProductDao dao;
    private LiveData<List<Product>> productList;
    private ExecutorService executorService; // Para rodar o banco fora da thread principal

    public FeiraViewModel(Application application) {
        super(application);
        dao = AppDatabase.getDatabase(application).productDao();
        productList = dao.getAllProducts();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<Product>> getProductList() {
        return productList;
    }

    public void saveProduct(Product product) {
        if (product.isAvailable() && product.getPrice() == null) {
            throw new NumberFormatException("Preço não pode ser nulo para itens disponíveis");
        }

        // A gravação no Room deve ocorrer de forma assíncrona no ExecutorService.
        executorService.execute(() -> dao.insertProduct(product));
    }

    public boolean verifyPin(String pin) {
        return pin.equals("1234");
    }

    public void updateProduct(Product product) {
        executorService.execute(() -> dao.updateProduct(product));
    }

    public boolean canGenerateTable() {
        List<Product> currentList = productList.getValue();
        if (currentList == null) return false;
        
        for (Product p : currentList) {
            if (p.isAvailable() && p.getPrice() == null) {
                return false; // Bloqueia se um item ativo estiver sem preço
            }
        }
        return true;
    }
}