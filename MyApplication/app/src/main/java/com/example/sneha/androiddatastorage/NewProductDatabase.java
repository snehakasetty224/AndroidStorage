package com.example.sneha.androiddatastorage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewProductDatabase extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product_database);
    }

    public void onClickInsertNewItem(View V){
        Intent intent = new Intent(NewProductDatabase.this,AddNewProduct.class);
        startActivity(intent);
    }

    public void onClickSearchItem(View V){
        Intent intent = new Intent(NewProductDatabase.this,SearchItem.class);
        startActivity(intent);
    }
}
