package com.example.tpnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView name, capitale, superficies, description;
    ImageView image;
    Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        setContentView(R.layout.activity_detail_land);

        name = findViewById(R.id.nameEdit);
        capitale = findViewById(R.id.capitale);
        superficies = findViewById(R.id.superficie);
        image = findViewById(R.id.imagePays);
        description = findViewById(R.id.description);

        btn_close = findViewById(R.id.btn_close);

        String nomPays = getIntent().getStringExtra("name");
        String capitalePays = getIntent().getStringExtra("capitale");
        int superficiePays = getIntent().getIntExtra("dist", 0);
        int imagePays = getIntent().getIntExtra("img", 0);
        String descriptionPays = getIntent().getStringExtra("descr");

        name.setText(nomPays);
        capitale.setText(capitalePays);
        superficies.setText(Integer.toString(superficiePays));
        image.setImageResource(imagePays);
        description.setText(descriptionPays);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    } else {
            // Si l'orientation est en mode portrait, utilisez la mise en page portrait par défaut
            setContentView(R.layout.activity_detail);
            // Référencez les vues dans la mise en page portrait par défaut et mettez à jour les données si nécessaire
            name = findViewById(R.id.nameEdit);
            capitale = findViewById(R.id.capitale);
            superficies = findViewById(R.id.superficie);
            image = findViewById(R.id.imagePays);
            description = findViewById(R.id.description);
            btn_close = findViewById(R.id.btn_close);

            // Mettez à jour les données si nécessaire
            name.setText(getIntent().getStringExtra("name"));
            capitale.setText(getIntent().getStringExtra("capitale"));
            superficies.setText(Integer.toString(getIntent().getIntExtra("dist", 0)));
            image.setImageResource(getIntent().getIntExtra("img", 0));
            description.setText(getIntent().getStringExtra("descr"));

            btn_close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
