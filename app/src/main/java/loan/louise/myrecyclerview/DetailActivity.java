package loan.louise.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static loan.louise.myrecyclerview.SecActivity.EXTRA_DESC;
import static loan.louise.myrecyclerview.SecActivity.EXTRA_IMAGE;
import static loan.louise.myrecyclerview.SecActivity.EXTRA_TITRE;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String image = intent.getStringExtra(EXTRA_IMAGE);
        String titre = intent.getStringExtra(EXTRA_TITRE);
        String desc = intent.getStringExtra(EXTRA_DESC);

        ImageView imageView = findViewById(R.id.image_detail);
        TextView textViewTitre = findViewById(R.id.titre_detail);
        TextView textViewDesc = findViewById(R.id.desc_detail);

        Picasso.with(this).load(image).fit().centerInside().into(imageView);
        textViewTitre.setText(titre);
        textViewDesc.setText(desc);
    }
}
