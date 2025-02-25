package com.example.matule;

import static android.app.ProgressDialog.show;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Patterns;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.util.PatternsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.test.espresso.core.internal.deps.guava.base.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("dialog");
        builder.setMessage("click");
        builder.setCancelable(true);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Отпускает диалоговое окно
            }
        });
        AlertDialog dialog = builder.create();
        Button login = findViewById(R.id.button_login);
        EditText email_input = findViewById(R.id.email);
        EditText password_input = findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_input.getText().toString();
                String password = password_input.getText().toString();
                if (isEmailValid(email) && isPasswordValid(password)){
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    startActivity(intent);
                }
                else{
                    dialog.show();
                }

            }
        });

    }
    public static boolean isEmailValid(String email) {
        return !Strings.isNullOrEmpty(email) && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches();
    }
    public static boolean isPasswordValid(String password) {
        return !Strings.isNullOrEmpty(password);
    }
}