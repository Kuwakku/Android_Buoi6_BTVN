package com.example.android_buoi6_btvn;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBHelper mDbHelper;
    private RecyclerView rvProduct;
    private ProductAdapter mProductAdapter;
    private ArrayList<ProductModel> mListProductModels;
    private Button btnTitle, btnCategory, btnBrand;
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        rvProduct = findViewById(R.id.rvProduct);
        btnTitle = findViewById(R.id.btnTitle);
        btnCategory = findViewById(R.id.btnCategory);
        btnBrand = findViewById(R.id.btnBrand);
        edtSearch = findViewById(R.id.edtSearch);

        mProductAdapter = new ProductAdapter(mListProductModels);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvProduct.setLayoutManager(gridLayoutManager);
        rvProduct.setAdapter(mProductAdapter);

        btnTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + mListProductModels);
                mListProductModels = (ArrayList<ProductModel>) mDbHelper.searchTitle(edtSearch.getText().toString());
                mProductAdapter = new ProductAdapter(mListProductModels);
                rvProduct = findViewById(R.id.rvProduct);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
                rvProduct.setLayoutManager(gridLayoutManager);
                rvProduct.setAdapter(mProductAdapter);
                mProductAdapter.notifyDataSetChanged();
            }
        });
        btnBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + mListProductModels);
                mListProductModels = (ArrayList<ProductModel>) mDbHelper.searchTitle(edtSearch.getText().toString());
                mProductAdapter = new ProductAdapter(mListProductModels);
                rvProduct = findViewById(R.id.rvProduct);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
                rvProduct.setLayoutManager(gridLayoutManager);
                rvProduct.setAdapter(mProductAdapter);
                mProductAdapter.notifyDataSetChanged();
            }
        });
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + mListProductModels);
                mListProductModels = (ArrayList<ProductModel>) mDbHelper.searchTitle(edtSearch.getText().toString());
                mProductAdapter = new ProductAdapter(mListProductModels);
                rvProduct = findViewById(R.id.rvProduct);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
                rvProduct.setLayoutManager(gridLayoutManager);
                rvProduct.setAdapter(mProductAdapter);
                mProductAdapter.notifyDataSetChanged();
            }
        });
        mProductAdapter.notifyDataSetChanged();
    }

    private void initData() {
        mDbHelper = new DBHelper(this);
        mListProductModels = new ArrayList<>();
        mProductAdapter = new ProductAdapter(mListProductModels);
        ProductModel productModel = new ProductModel();
        int index = 10;
        while (index > 0) {
            productModel.setTitle("iPhone" + index);
            productModel.setBrand("Apple" + index);
            productModel.setCategory("smartphones" + index);
//            mDbHelper.addProduct(productModel);
            index--;
        }
        mListProductModels.addAll(mDbHelper.getProduct());
    }
}