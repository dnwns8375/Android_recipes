package aaa.bbb.ccc7;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import tangxiaolv.com.library.EffectiveShapeView;

import static aaa.bbb.ccc7.MainActivity.listRecipes;

public class RecDetail extends AppCompatActivity {

    TextView name, calory, time;
    ImageView mainImg;
    TextView listIngr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        LinearLayout mainLayout = findViewById(R.id.text);

        name = findViewById(R.id.name);
        calory = findViewById(R.id.calory);
        time = findViewById(R.id.time);
        mainImg = findViewById(R.id.mainImg);
        listIngr = findViewById(R.id.listIngr);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("pos", 0);

        Recipe recipe = listRecipes.get(pos);

        name.setText(recipe.getName());
        calory.setText(recipe.getCalory() + " 허기");
        time.setText(recipe.getTime());
        mainImg.setImageResource(recipe.getMainImage());

        String[] ingr = getResources().getStringArray(recipe.getIngredients());

        String listIngredients = "";
        for (int i = 0; i < ingr.length; i++) {
            listIngredients += "- " + ingr[i] + "\n";
        }

        listIngr.setText(listIngredients);

        for (int i = 0; i < recipe.getFullText().length; i++) {


            TextView textView = new TextView(RecDetail.this);
            textView.setTextSize(16);
            textView.setText(recipe.getFullText()[i]);
            LinearLayout.LayoutParams lpText = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lpText.setMargins(0, 20, 0, 20);
            textView.setLayoutParams(lpText);
            mainLayout.addView(textView);

            EffectiveShapeView imageView = new EffectiveShapeView(RecDetail.this);
            imageView.changeShapeType(3);
            imageView.setBorderColor(R.color.colorAccent);
            imageView.setBorderWidth(5);
            imageView.setImageResource(recipe.getAllImg()[i]);
            LinearLayout.LayoutParams imageViewLayoutParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(imageViewLayoutParams2);

            mainLayout.addView(imageView);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
