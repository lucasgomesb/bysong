package bysong.app.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import bysong.app.R;

/**
 * Created by Tiago on 10/08/2016.
 */
public class ImagePageAdapter extends PagerAdapter {

    private Context context;
    private final int[] imagens;

    public ImagePageAdapter(Context context, int[] imagens){

        this.context = context;
        this.imagens = imagens;

    }

    // Retorna o número de páginas do view pager(equivalente ao número de abas)
    @Override
    public int getCount() {

        return imagens != null ? imagens.length : 0;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Infla o view
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_imagem, container, false);
        ImageView img = (ImageView) view.findViewById(R.id.imagem);
        img.setImageResource(imagens[position]);
        ((ViewGroup) container).addView(view);// Adicionou ao layout ViewGroup
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {

        ((ViewGroup) container).removeView((View)view);

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        // Determina se a view informada é igual ao object retornado pelo instantiateItem
        return view == object;

    }

}
