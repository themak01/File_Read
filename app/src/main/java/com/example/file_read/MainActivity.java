package com.example.file_read;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String filename="d.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t=(TextView)findViewById(R.id.tv1);
        Button bb1=(Button)findViewById(R.id.b);
        Button bb2=(Button)findViewById(R.id.b1);
        EditText ed =(EditText)findViewById(R.id.ed);

        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                    String data = ed.getText().toString();
                    fos.write(data.getBytes());
                    fos.flush();
                    ;
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT);
                }

            }
        });

        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileInputStream fin = openFileInput(filename);
                    int i;
                    StringBuilder stnb= new StringBuilder();
                    while ((i = fin.read()) != -1){
                        stnb.append((char)i);
                    }
                    t.setText(stnb.toString());
                    fin.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}