package com.example.sneha.androiddatastorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchItem extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);
    }


    public void search(View view)
    {
        EditText editText5 =(EditText)findViewById(R.id.editText5);
        TextView textView =(TextView) findViewById(R.id.textView9);
        String searchItem = editText5.getText().toString();
        DataController dataController=new DataController(getBaseContext());
        dataController.open();
        Cursor cursor = dataController.retrieve();
        if(cursor != null)
        {
            while(cursor.moveToNext())
            {
                String itemName=cursor.getString(0);
                if(itemName.equals(searchItem)){
                    String itemDesc=cursor.getString(1);
                    String itemPrice=cursor.getString(2);
                    textView.setText("Search results: \n " +
                            "Item name: "+ itemName+"\n" +
                            "Item Description: "+itemDesc+"\n" +
                            "Price: "+itemPrice);
                }
            }
        }
        cursor.close();
        dataController.close();
    }

    public void cancel(View view)
    {
        Intent intent=new Intent(this,NewProductDatabase.class);
        startActivity(intent);
    }
}
