package loan.louise.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SecActivity extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {
    public static final String EXTRA_IMAGE = "image";
    public static final String EXTRA_TITRE = "titre";
    public static final String EXTRA_DESC = "desc";

    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ExampleAdapter mAdapter;

    private Button boutonPlus;
    private Button boutonMoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.android_pikachu, "Pikachu", "Pokemon électrique ..."));
        mExampleList.add(new ExampleItem(R.drawable.android_salameche, "Salameche", "Pokemon feu ..."));
        mExampleList.add(new ExampleItem(R.drawable.android_reptincel, "Reptincel", "Pokemon feu ..."));
        mExampleList.add(new ExampleItem(R.drawable.android_dracaufeu, "Dracaufeu", "Pokemon feu ..."));
        mExampleList.add(new ExampleItem(R.drawable.android_bulbizarre, "Bulbizarre", "Pokemon plante ..."));
        mExampleList.add(new ExampleItem(R.drawable.android_herbizarre, "Herbizarre", "Pokemon plante ..."));
        mExampleList.add(new ExampleItem(R.drawable.android_florizarre, "Florizarre", "Pokemon plante ..."));
        mExampleList.add(new ExampleItem(R.drawable.android_carapuce, "Carapuce", "Pokemon eau ..."));
        mExampleList.add(new ExampleItem(R.drawable.android_carabaffe, "Carabaffe", "Pokemon eau ..."));
        mExampleList.add(new ExampleItem(R.drawable.android_tortank, "Tortank", "Pokemon eau ..."));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(SecActivity.this);

        //Bouton Plus
        boutonPlus = findViewById(R.id.button_add);
        boutonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mExampleList.size();
                switch (position){
                    case 0: mExampleList.add(new ExampleItem(R.drawable.android_pikachu, "Pikachu", "Pokemon électrique ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 1: mExampleList.add(new ExampleItem(R.drawable.android_salameche, "Salameche", "Pokemon feu ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 2: mExampleList.add(new ExampleItem(R.drawable.android_reptincel, "Reptincel", "Pokemon feu ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 3: mExampleList.add(new ExampleItem(R.drawable.android_dracaufeu, "Dracaufeu", "Pokemon feu ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 4: mExampleList.add(new ExampleItem(R.drawable.android_bulbizarre, "Bulbizarre", "Pokemon plante ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 5: mExampleList.add(new ExampleItem(R.drawable.android_herbizarre, "Herbizarre", "Pokemon plante ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 6:mExampleList.add(new ExampleItem(R.drawable.android_florizarre, "Florizarre", "Pokemon plante ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 7:mExampleList.add(new ExampleItem(R.drawable.android_carapuce, "Carapuce", "Pokemon eau ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 8:mExampleList.add(new ExampleItem(R.drawable.android_carabaffe, "Carabaffe", "Pokemon eau ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 9:mExampleList.add(new ExampleItem(R.drawable.android_tortank, "Tortank", "Pokemon eau ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 10:mExampleList.add(new ExampleItem(R.drawable.android_mew, "Mew", "Pokemon légendaire ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    case 11:mExampleList.add(new ExampleItem(R.drawable.android_mewtwo, "Mewtwo", "Pokemon légendaire ..."));
                        mAdapter.notifyDataSetChanged();
                        break;
                    default:Context context = getApplicationContext();
                            CharSequence text = "Liste complète";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context,text,duration);
                            toast.setGravity(Gravity.TOP,0,250);
                            toast.show();
                }
            }
        });

        //Bouton Moin
        boutonMoin = findViewById(R.id.button_remove);
        boutonMoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExampleList.size()>0) {
                    mExampleList.remove(mExampleList.size() - 1);
                    mAdapter.notifyDataSetChanged();
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Aucun Pokemon";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context,text,duration);
                    toast.setGravity(Gravity.TOP,0,250);
                    toast.show();
                }
            }
        });


    }


    @Override
    public void OnItemClick(int position) {
        Intent detailIntent = new Intent(this,DetailActivity.class);
        ExampleItem clickedItem = mExampleList.get(position);

        detailIntent.putExtra(EXTRA_IMAGE, clickedItem.getImageResource());
        detailIntent.putExtra(EXTRA_TITRE, clickedItem.getText1());
        detailIntent.putExtra(EXTRA_DESC, clickedItem.getText2());

        startActivity(detailIntent);
    }
}