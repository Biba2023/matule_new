package com.example.matule;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton a = findViewById(R.id.tr1);
        ImageButton b = findViewById(R.id.tr2);
        ImageView img = findViewById(R.id.trainer);
        TextView text = findViewById(R.id.text);

        ImageButton plus = findViewById(R.id.plus);
        ImageButton minus = findViewById(R.id.minus);
        TextView amount = findViewById(R.id.amount);
        Integer num = showPreferences("n");
        amount.setText(Integer.toString(num));
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.img_10);
                a.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_blue));
                text.setMaxLines(3);

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer c = showPreferences("n") + 1;
                SavePreferences("n", c);
                amount.setText(Integer.toString(c));

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer d = showPreferences("n") - 1;
                if (d >= 1) {
                    SavePreferences("n", d);
                    amount.setText(Integer.toString(d));
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setMaxLines(Integer.MAX_VALUE);
            }
        });
    }
    private void SavePreferences(String key, int value) {
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    private int showPreferences(String key){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);

    }

}