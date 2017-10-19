package com.example.robert.websource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    EditText input;
    Button getsource;
    static TextView textresult;

    Connectinternet conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = (Spinner)findViewById(R.id.webspinner);
        input = (EditText)findViewById(R.id.urlinput);
        getsource = (Button)findViewById(R.id.tombol);
        textresult = (TextView)findViewById(R.id.result);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.web_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
    }

    public void klik(View view){
        if(input.getText().toString().isEmpty()){
            Toast.makeText(this,"Please Fill the Form",Toast.LENGTH_SHORT).show();
        }
        else{
            conn = new Connectinternet(this);
            conn.execute(sp.getSelectedItem().toString()+
                    input.getText().toString());
        }
    }
}
