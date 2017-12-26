package sas.ita.com.yusr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by maiya on 23/12/2017.
 */

public class CustomGrid extends BaseAdapter {
    private Context mcontext;
    private String[] web;
    private  int[] image;
    private MyInterface myInterface;
    public interface MyInterface{
        public void onClick(int position);


    }

    public CustomGrid() {
    }

    public CustomGrid(Context mcontext, String[] web, int[] image) {
        this.mcontext = mcontext;
        this.web = web;
        this.image = image;
    }

    @Override
    public int getCount() {
        return web.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null)
        {
            grid=new View(mcontext);
            grid=inflater.inflate(R.layout.card_view,null);
            TextView textView=(TextView)grid.findViewById(R.id.text);
            ImageView imageView=(ImageView)grid.findViewById(R.id.image);
            textView.setText(web[position]);
            imageView.setImageResource(image[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     myInterface.onClick(position);
                }
            });
        }
        else {
            grid=(View)convertView;
        }
        return grid;

    }
    public void setOnClick(MyInterface myInterface){
        this.myInterface=myInterface;
    }
}
