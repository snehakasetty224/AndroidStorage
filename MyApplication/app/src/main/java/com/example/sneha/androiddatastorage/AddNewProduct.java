package com.example.sneha.androiddatastorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class AddNewProduct extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);
    }

    public void saveMessage(View view)
    {
        EditText editText =(EditText)findViewById(R.id.editText);
        EditText editText1 = (EditText)findViewById(R.id.editText2);
        EditText editText2 = (EditText)findViewById(R.id.editText3);
        EditText editText3 = (EditText)findViewById(R.id.editText4);

        String itemname = editText.getText().toString();
        String itemdescription = editText1.getText().toString();
        String itemprice = editText2.getText().toString();
        String itemreview = editText3.getText().toString();
        DataController dataController=new DataController(getBaseContext());
        dataController.open();
        long retValue= dataController.insert(itemname,itemdescription,itemprice,itemreview);
        dataController.close();
        if(retValue!=-1)
        {
            Context context = getApplicationContext();
            CharSequence text=getString(R.string.save_success_msg);
            int duration= Toast.LENGTH_LONG;
            Toast.makeText(context, text, duration).show();
        }

        Intent intent=new Intent(this,NewProductDatabase.class);
        startActivity(intent);

    }

    public void cancel(View view){
        EditText editText =(EditText)findViewById(R.id.editText);
        EditText editText1 = (EditText)findViewById(R.id.editText2);
        EditText editText2 = (EditText)findViewById(R.id.editText3);
        EditText editText3 = (EditText)findViewById(R.id.editText4);
        editText.setText(null);
        editText1.setText(null);
        editText2.setText(null);
        editText3.setText(null);
        Intent intent=new Intent(this,NewProductDatabase.class);
        startActivity(intent);
    }

}
