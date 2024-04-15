package com.example.tpnote;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tpnote.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    final Pays[] initdata = {
            new Pays("France", "Paris", 551695, R.drawable.france, "La France, pays de l'Europe occidentale, compte des villes médiévales, des villages alpins et des plages. Paris, sa capitale, est célèbre pour ses maisons de mode, ses musées d'art classique, dont celui du Louvre, et ses monuments comme la Tour Eiffel. Le pays est également réputé pour ses vins et sa cuisine raffinée. Les peintures rupestres des grottes de Lascaux, le théâtre romain de Lyon et l'immense château de Versailles témoignent de sa riche histoire."),
            new Pays("USA", "Washington", 9834000, R.drawable.america, "Les États-Unis sont un pays constitué de 50 états et couvrant une vaste portion de l'Amérique du Nord, avec l'Alaska au nord-ouest et Hawaï étendant la présence du pays dans l'océan Pacifique. Les principales villes de la côte atlantique sont New York, centre international financier et culturel, et Washington, la capitale. Dans la région du Midwest, la métropole de Chicago est connue pour son architecture influente et sur la côte ouest, le quartier d'Hollywood à Los Angeles est célèbre pour ses studios de cinéma."),
            new Pays("Australia","Canberra", 7692024, R.drawable.australia, "L'Australie est un pays d'Océanie connu pour ses vastes étendues désertiques, ses plages spectaculaires et ses forêts tropicales. Sydney, Brisbane, Melbourne, Perth, et Adelaide sont les principales villes du pays. L'opéra de Sydney et le pont du port de Sydney sont parmi les attractions les plus emblématiques du pays. L'Australie est également réputée pour sa faune unique, notamment les kangourous et les koalas."),
            new Pays("Afrique du Sud", "Le Cap",  1220813, R.drawable.africa_sud, "L'Afrique du Sud, située à l'extrémité australe du continent africain, est connue pour sa diversité culturelle, ses langues officielles multiples et ses paysages variés. Le pays abrite des villes animées comme Johannesburg, Le Cap et Durban. Les visiteurs peuvent explorer des sites historiques tels que Robben Island, où Nelson Mandela a été emprisonné, ou le parc national Kruger, qui abrite une abondance de vie sauvage, dont les célèbres Big Five."),
            new Pays("Colombie", "Bogota", 1141748, R.drawable.columbia, "La Colombie, située en Amérique du Sud, est connue pour sa diversité géographique allant des plages des Caraïbes aux forêts amazoniennes et aux montagnes des Andes. Sa capitale, Bogota, est une ville cosmopolite nichée dans les montagnes. La Colombie est réputée pour sa culture vibrante, sa musique entraînante, sa danse de la cumbia, ainsi que pour son café de renommée mondiale."),
            new Pays("Germany", "Berlin", 357022, R.drawable.germany, "L'Allemagne, pays d'Europe centrale, est connue pour son riche patrimoine historique et culturel, avec des villes médiévales bien préservées et des châteaux imposants. Sa capitale, Berlin, est réputée pour sa scène artistique dynamique et son histoire tumultueuse. Munich est célèbre pour sa fête de la bière, Oktoberfest, et Hambourg pour son port animé."),
            new Pays("Côte d'Ivoire", "Yamoussoukro", 322463, R.drawable.cote_divoire, "La Côte d'Ivoire, située en Afrique de l'Ouest, est connue pour sa diversité culturelle, ses paysages variés et ses ressources naturelles abondantes. Abidjan, sa capitale économique, est un centre financier et commercial majeur avec une architecture moderne et une vie nocturne animée. La Côte d'Ivoire est également réputée pour ses plages de sable fin et sa cuisine délicieuse."),
            new Pays("Poland", "Varsovie", 312696, R.drawable.poland, "La Pologne, située en Europe centrale, est connue pour son riche patrimoine historique, sa culture vibrante et sa cuisine délicieuse. Sa capitale, Varsovie, mélange l'architecture médiévale avec des bâtiments modernes. Cracovie, la deuxième plus grande ville du pays, est célèbre pour sa magnifique vieille ville et son passé royal. La Pologne est également réputée pour ses paysages pittoresques, ses montagnes et ses lacs."),
            new Pays("Ghana", "Accra", 238535, R.drawable.ghana, "Le Ghana, situé en Afrique de l'Ouest, est connu pour sa stabilité politique et son économie en plein essor. Accra, la capitale, est un centre financier et culturel majeur avec une scène artistique dynamique. Le pays est réputé pour ses festivals colorés, sa musique et sa danse, ainsi que pour ses plages de sable doré."),
            new Pays("Sénégal", "Dakar", 196722, R.drawable.senegal, "Le Sénégal, situé en Afrique de l'Ouest, est connu pour sa culture riche et diversifiée, sa musique, sa danse et sa cuisine délicieuse. La capitale, Dakar, est un centre dynamique avec une scène artistique vibrante et des marchés animés. Le pays est également réputé pour son hospitalité chaleureuse et ses sites historiques, tels que l'île de Gorée, un site classé au patrimoine mondial de l'UNESCO.")
    };

    private List<Pays> liste;
    private ActivityMainBinding ui;
    private PaysAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());

        liste = new ArrayList<>(Arrays.asList(initdata));

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        ui.recycler.setLayoutManager(lm);

        ui.recycler.setHasFixedSize(true);

        // Adaptateur
        adapter = new PaysAdapter(liste);
        ui.recycler.setAdapter(adapter);

        // Separateur
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ui.recycler.addItemDecoration(dividerItemDecoration);

        //écouteur pour les clics
        adapter.setOnItemClickListener(this::onItemClick);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ouvrir la troisième activité
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void onItemClick(int position) {
        Pays pays = liste.get(position);
        Intent intent = new Intent( this, DetailActivity.class);
        String nom = pays.getNom();
        String capitale = pays.getCapitale();
        int superficie = pays.getSuperficie();
        int image = pays.getImage();
        String description = pays.getDescription();
        intent.putExtra("name", nom);
        intent.putExtra("capitale", capitale);
        intent.putExtra("dist", superficie);
        intent.putExtra("img", image);
        intent.putExtra("descr", description);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                // Récupérer le nouveau pays de l'Intent de retour
                Pays nouveauPays = (Pays) data.getSerializableExtra("nouveau_pays");

                // Ajouter le nouveau pays à la liste et notifier l'adaptateur
                liste.add(nouveauPays);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Sauvegarder l'état de votre activité ici, par exemple la liste de pays
        outState.putSerializable("liste_pays", (Serializable) liste);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restaurer l'état de votre activité ici, par exemple la liste de pays
        List<Pays> restoredListe = (List<Pays>) savedInstanceState.getSerializable("liste_pays");
        if (restoredListe != null) {
            liste.clear();
            liste.addAll(restoredListe);
            adapter.notifyDataSetChanged();
        }
    }

}