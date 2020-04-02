package loan.louise.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SecActivity extends AppCompatActivity implements PokemonAdapter.OnItemClickListener {
    public static final String EXTRA_IMAGE = "image";
    public static final String EXTRA_TITRE = "titre";
    public static final String EXTRA_DESC = "desc";

    private ArrayList<Pokemon> mExampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private PokemonAdapter mAdapter;

    private Button boutonPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        mExampleList = new ArrayList<>();

        mExampleList.add(new Pokemon("https://www.pokepedia.fr/images/thumb/8/89/Salam%C3%A8che-RFVF.png/375px-Salam%C3%A8che-RFVF.png", "Salameche", "Pokemon feu"));
        mExampleList.add(new Pokemon("https://www.pokepedia.fr/images/6/64/Reptincel-RFVF.png", "Reptincel", "Pokemon feu"));
        mExampleList.add(new Pokemon("https://www.pokepedia.fr/images/thumb/1/17/Dracaufeu-RFVF.png/375px-Dracaufeu-RFVF.png", "Dracaufeu", "Pokemon feu"));
        mExampleList.add(new Pokemon("https://www.pokepedia.fr/images/thumb/c/cc/Carapuce-RFVF.png/375px-Carapuce-RFVF.png", "Carapuce", "Pokemon eau"));
        mExampleList.add(new Pokemon("https://www.pokepedia.fr/images/thumb/2/2a/Carabaffe-RFVF.png/375px-Carabaffe-RFVF.png", "Carabaffe", "Pokemon eau"));
        mExampleList.add(new Pokemon("https://www.pokepedia.fr/images/thumb/2/24/Tortank-RFVF.png/375px-Tortank-RFVF.png", "Tortank", "Pokemon eau"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mAdapter = new PokemonAdapter(mExampleList, getApplicationContext());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(SecActivity.this);

        //Bouton Plus
        boutonPlus = findViewById(R.id.button_add);
        boutonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExampleList.add(new Pokemon("https://www.pokepedia.fr/images/thumb/e/e7/Pikachu-RFVF.png/375px-Pikachu-RFVF.png", "Pikachu", "Pokemon électrique"));
                mAdapter.notifyDataSetChanged();
                }
        });
    }

    @Override
    public void OnItemClick(int position) {
        Intent detailIntent = new Intent(this,DetailActivity.class);
        Pokemon clickedItem = mExampleList.get(position);

        detailIntent.putExtra(EXTRA_IMAGE, clickedItem.getImageResource());
        detailIntent.putExtra(EXTRA_TITRE, clickedItem.getText1());
        detailIntent.putExtra(EXTRA_DESC, clickedItem.getText2());

        startActivity(detailIntent);
    }

    @Override
    public void onDeleteClick(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
}