package com.example.matule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OnBoardSecondActivity extends AppCompatActivity {

    private Integer promoIndex = 0;
    ImageView image;
    TextView title;
    TextView desc;
    ImageView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board_second);
        Button button_next = (Button) findViewById(R.id.button_next);



        image = findViewById(R.id.promo_image);
        title = findViewById(R.id.promo_tittle);
        desc =findViewById(R.id.promo_desc);
        scroll = findViewById(R.id.img_scroll);
        setPromoIndex(promoIndex);

        //Обработка нажатия на кнопку next и переход к следующему привественному экрану
        button_next.setOnClickListener(v -> {
            promoIndex++;
            if(promoIndex < PromoData.values.length) {
                setPromoIndex(promoIndex);
            }  else {
                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                prefs.edit().putBoolean("completed", true).apply();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

        //Обработка нажатия на кнопку skip, переход к странице holder

    }

    private void setPromoIndex(Integer index){
        PromoData current = PromoData.values[index];
        image.setImageResource(current.imageId);
        title.setText(current.title);
        desc.setText(current.description);
        scroll.setImageResource(current.scrollId);
    }
}