package com.seuprojeto.mvpfeira.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ProductDao {
    // Retorna os produtos em tempo real usando LiveData
    @Query("SELECT * FROM products ORDER BY id ASC")
    LiveData<List<Product>> getAllProducts();

    @Query("SELECT * FROM products WHERE id = :productId")
    Product getProductById(int productId);

    @Update
    void updateProduct(Product product);

    @Insert
    void insertInitialData(List<Product> products);
}