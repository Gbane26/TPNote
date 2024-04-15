package com.example.tpnote;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    EditText nomEdit, capitaleEdit, superficieEdit, descriptionEdit;
    ImageView imageView;
    Button buttonAjouterImage, buttonSubmit;

    // Clés pour sauvegarder/restaurer l'état
    private static final String KEY_NOM = "nom";
    private static final String KEY_CAPITALE = "capitale";
    private static final String KEY_SUPERFICIE = "superficie";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE_VISIBILITY = "imageVisibility";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Initialiser les vues
        nomEdit = findViewById(R.id.editTextNom);
        capitaleEdit = findViewById(R.id.editCapitale);
        superficieEdit = findViewById(R.id.editSuperficie);
        descriptionEdit = findViewById(R.id.editTextDescription);
        imageView = findViewById(R.id.imageView);
        buttonAjouterImage = findViewById(R.id.buttonAjouterImage);
        buttonSubmit = findViewById(R.id.buttonValider);

        // Ecouteur pour image
        buttonAjouterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE); // Afficher l'ImageView
            }
        });

        // Ecouteur
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifier si tous les champs sont remplis
                if (validateForm()) {
                    String nom = nomEdit.getText().toString();
                    String capitale = capitaleEdit.getText().toString();
                    int superficie = Integer.parseInt(superficieEdit.getText().toString());
                    String description = descriptionEdit.getText().toString();

                    // Créer un nouvel objet Pays avec les données saisies
                    Pays nouveauPays = new Pays(nom, capitale, superficie, R.drawable.spain, description);

                    // Créer un nouvel Intent pour renvoyer les données à l'activité principale
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("nouveau_pays", nouveauPays);
                    setResult(Activity.RESULT_OK, returnIntent);

                    // Fermer cette activité
                    finish();
                } else {
                    Toast.makeText(ThirdActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Restaurer l'état si savedInstanceState n'est pas null
        if (savedInstanceState != null) {
            nomEdit.setText(savedInstanceState.getString(KEY_NOM));
            capitaleEdit.setText(savedInstanceState.getString(KEY_CAPITALE));
            superficieEdit.setText(savedInstanceState.getString(KEY_SUPERFICIE));
            descriptionEdit.setText(savedInstanceState.getString(KEY_DESCRIPTION));
            imageView.setVisibility(savedInstanceState.getInt(KEY_IMAGE_VISIBILITY));
        }
    }
    // Méthode pour valider si tous les champs du formulaire sont remplis
    private boolean validateForm() {
        String nom = nomEdit.getText().toString().trim();
        String capitale = capitaleEdit.getText().toString().trim();
        String superficie = superficieEdit.getText().toString().trim();
        String description = descriptionEdit.getText().toString().trim();

        return !nom.isEmpty() && !capitale.isEmpty() && !superficie.isEmpty() && !description.isEmpty();

    }

    // Sauvegarder l'état de l'activité
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_NOM, nomEdit.getText().toString());
        outState.putString(KEY_CAPITALE, capitaleEdit.getText().toString());
        outState.putString(KEY_SUPERFICIE, superficieEdit.getText().toString());
        outState.putString(KEY_DESCRIPTION, descriptionEdit.getText().toString());
        outState.putInt(KEY_IMAGE_VISIBILITY, imageView.getVisibility());
    }
}