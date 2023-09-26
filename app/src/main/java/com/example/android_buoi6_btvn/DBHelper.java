package com.example.android_buoi6_btvn;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "product.db";
    private static int VERSION = 2;
    public static final String TABLE_NAME = "product";
    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT_TITLE = "title";
    public static final String PRODUCT_BRAND = "brand";
    public static final String PRODUCT_CATEGORY = "category";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + "("
                + PRODUCT_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + PRODUCT_TITLE + " TEXT NOT NULL,"
                + PRODUCT_BRAND + " TEXT NOT NULL,"
                + PRODUCT_CATEGORY + " TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addProduct(ProductModel product) {
        if(product != null) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(PRODUCT_TITLE, product.getTitle());
            contentValues.put(PRODUCT_BRAND, product.getBrand());
            contentValues.put(PRODUCT_CATEGORY, product.getCategory());
            long respond = db.insert(TABLE_NAME, null, contentValues);
            db.close();

            if (respond > -1 ) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean updateProduct(int productId, ProductModel product) {
        if(product != null && productId >= 0) {
            SQLiteDatabase db = getWritableDatabase();
            String whereClause = PRODUCT_ID + " =?";
            String[] whereArgs = {productId + ""};
            ContentValues contentValues = new ContentValues();
            contentValues.put(PRODUCT_TITLE, product.getTitle());
            contentValues.put(PRODUCT_BRAND, product.getBrand());
            contentValues.put(PRODUCT_CATEGORY, product.getCategory());
            long respond = db.insert(TABLE_NAME, null, contentValues);
            db.update(TABLE_NAME, contentValues, whereClause, whereArgs);
            db.close();
            return true;
        }
        return false;
    }

    public boolean deleteProduct(int productId) {
        if (productId >= 0 ) {
            SQLiteDatabase db =getWritableDatabase();
            String whereClause = PRODUCT_ID + " =?";
            String[] whereArgs = {productId + ""};
            db.delete(TABLE_NAME, whereClause, whereArgs);
            db.close();
        }
        return false;
    }

    @SuppressLint("Range")
    public List<ProductModel> getProduct() {
        List<ProductModel> listProduct = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                ProductModel productModel = new ProductModel();
                productModel.setId(cursor.getColumnIndex(PRODUCT_ID));
                productModel.setTitle(cursor.getString(cursor.getColumnIndex(PRODUCT_TITLE)));
                productModel.setBrand(cursor.getString(cursor.getColumnIndex(PRODUCT_BRAND)));
                productModel.setCategory(cursor.getString(cursor.getColumnIndex(PRODUCT_CATEGORY)));
                listProduct.add(productModel);
            }
        }
        db.close();
        return listProduct;
    }

    @SuppressLint("Range")
    public List<ProductModel> searchTitle(String title) {
        List<ProductModel> listProduct = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + PRODUCT_TITLE + " LIKE '%" + title + "%'";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                ProductModel productModel = new ProductModel();
                productModel.setId(cursor.getColumnIndex(PRODUCT_ID));
                productModel.setTitle(cursor.getString(cursor.getColumnIndex(PRODUCT_TITLE)));
                productModel.setBrand(cursor.getString(cursor.getColumnIndex(PRODUCT_BRAND)));
                productModel.setCategory(cursor.getString(cursor.getColumnIndex(PRODUCT_CATEGORY)));
                listProduct.add(productModel);
            }
        }
        cursor.close();
        db.close();
        return listProduct;
    }
    @SuppressLint("Range")
    public List<ProductModel> searchBrand(String brand) {
        List<ProductModel> listProduct = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + PRODUCT_BRAND + " LIKE '%" + brand + "%'";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                ProductModel productModel = new ProductModel();
                productModel.setId(cursor.getColumnIndex(PRODUCT_ID));
                productModel.setTitle(cursor.getString(cursor.getColumnIndex(PRODUCT_TITLE)));
                productModel.setBrand(cursor.getString(cursor.getColumnIndex(PRODUCT_BRAND)));
                productModel.setCategory(cursor.getString(cursor.getColumnIndex(PRODUCT_CATEGORY)));
                listProduct.add(productModel);
            }
        }
        cursor.close();
        db.close();
        return listProduct;
    }
    @SuppressLint("Range")
    public List<ProductModel> searchCategory(String category) {
        List<ProductModel> listProduct = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + PRODUCT_CATEGORY + " LIKE '%" + category + "%'";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                ProductModel productModel = new ProductModel();
                productModel.setId(cursor.getColumnIndex(PRODUCT_ID));
                productModel.setTitle(cursor.getString(cursor.getColumnIndex(PRODUCT_TITLE)));
                productModel.setBrand(cursor.getString(cursor.getColumnIndex(PRODUCT_BRAND)));
                productModel.setCategory(cursor.getString(cursor.getColumnIndex(PRODUCT_CATEGORY)));
                listProduct.add(productModel);
            }
        }
        cursor.close();
        db.close();
        return listProduct;
    }
}
