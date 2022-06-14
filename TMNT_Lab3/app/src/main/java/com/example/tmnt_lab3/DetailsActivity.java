package com.example.tmnt_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private static final String[] TURTLE_DETAILS = {
            "Leonardo, often shortened to Leo, is one of the four protagonists of the Teenage Mutant Ninja Turtles comics and all related media. In the Mirage/Image Comics, all four turtles wear red bandanas, but in other versions, he wears a blue bandana. His signature weapons are two katanas. Throughout the various media, he is often depicted as the eldest and leader of the four turtles, as well as the most disciplined. He is named after Leonardo da Vinci.",
            "Michelangelo, often shortened to Mike or Mikey, is one of the four protagonists of the Teenage Mutant Ninja Turtles comics and all related media. His mask is typically portrayed as orange outside of the Mirage/Image Comics and his weapons are dual nunchucks, though he has also been portrayed using other weapons, such as a grappling hook, manriki-gusari, tonfa, and a three section staff (in some action figures).",
            "Donatello, (Don or Donnie) – The scientist, inventor, engineer, and technological genius, Donatello wears a purple mask and wields a bo staff. Donatello is perhaps the least violent turtle, preferring to use his knowledge to solve conflicts, but never hesitates to defend his brothers. He is named after the early Renaissance Italian artist and sculptor from Florence, Donatello.",
            "Raphael, often shortened to Raph, is one of the four protagonists of the Teenage Mutant Ninja Turtles comics and all related media.\n" +
                    "\n" +
                    "In the Mirage/Image Comics, all four turtles wear red bandanas over their eyes, but unlike his brothers in other versions, he is the only one who keeps the red bandana. Raphael wields twin sai as his primary weapon. He is generally the most likely to experience extremes of emotion, and is usually depicted as being aggressive, sullen, maddened, and rebellious. The origin of Raphael's anger is not always fully explored, but in some incarnations appears to stem partly from the realization that they are the only creatures of their kind and ultimately alone. He also has a somewhat turbulent relationship with his older brother Leonardo because Leonardo is seen as the group's leader. Raphael is named after the 16th-century Italian painter Raphael. In 2011 Raphael placed 23rd on IGN's Top 100 Comic Book Heroes, a list that did not feature any of his brothers."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView infotext = (TextView) findViewById(R.id.infotext);

        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("turtle_id"));

        infotext.setText(TURTLE_DETAILS[id]);
    }
}