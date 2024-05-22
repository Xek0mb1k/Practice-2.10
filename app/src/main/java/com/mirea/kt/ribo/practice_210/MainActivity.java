package com.mirea.kt.ribo.practice_210;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextFirstName, editTextLastName, editTextAge;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));

        editTextFirstName = findViewById(R.id.etFirstName);
        editTextLastName = findViewById(R.id.etLastName);
        editTextAge = findViewById(R.id.etAge);
        Button btnAdd = findViewById(R.id.addButton);
        Button btnNext = findViewById(R.id.continueButton);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        Log.d("DEBUG", "AKOPYAN OGANES RIBO-03-22");
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.addButton) {
            if (this.dbManager != null) {
                String fName = editTextFirstName.getText().toString();
                String lName = editTextLastName.getText().toString();
                String age = editTextAge.getText().toString();
                if (!fName.isEmpty() && !lName.isEmpty() && !age.isEmpty()) {
                    boolean result = dbManager.saveCarToDatabase(new Car(fName, lName, Integer.parseInt(age)));
                    if (result) {
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }

            }
        }

        if (v.getId() == R.id.continueButton) {
            Intent intent = new Intent(this, RecyclerActivity.class);
            startActivity(intent);
        }
    }
}