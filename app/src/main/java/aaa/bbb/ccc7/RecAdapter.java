package aaa.bbb.ccc7;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static aaa.bbb.ccc7.MainActivity.listRecipes;

public class RecAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;

    RecAdapter(Context context, ArrayList<Recipe> recipes) {
        ctx = context;
        listRecipes = recipes;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listRecipes.size();
    }

    @Override
    public Object getItem(int position) {
        return listRecipes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list, parent, false);
        }

        Recipe p = getRecipe(position);

        ((TextView) view.findViewById(R.id.name)).setText(p.getName());
        ((TextView) view.findViewById(R.id.time)).setText(p.getTime());
        ((TextView) view.findViewById(R.id.calory)).setText(p.getCalory() + " 허기");
        ((ImageView) view.findViewById(R.id.recImg)).setImageResource(p.getMainImage());
        return view;
    }

    Recipe getRecipe(int position) {
        return ((Recipe) getItem(position));
    }
}