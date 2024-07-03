package com.example.mvp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements MainActivityContract.view {

    TextView textView;
    Button button;
    EditText editText, password;

    MainActivityContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.button);

        presenter = new MainActivityPresenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Valid inputs
                String email = editText.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
                    onError("Fields required");
                } else {
                    presenter.doLogin(email, pass);
                }
            }
        });

    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}