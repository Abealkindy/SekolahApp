package com.rosinante24.sekolahapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rosinante24.sekolahapp.R;
import com.rosinante24.sekolahapp.activities.DetailActivity;
import com.rosinante24.sekolahapp.response.SekolahResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rosinante24 on 24/11/17.
 */

public class SekolahRecyclerAdapter extends RecyclerView.Adapter<SekolahRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<SekolahResponse.DataSekolah> data;

    public SekolahRecyclerAdapter(Context context, List<SekolahResponse.DataSekolah> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sekolah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textnama.setText(data.get(position).getNama_sekolah());
        holder.textalamat.setText(data.get(position).getAlamat());
        if (data.get(position).getJenjang().equals("sd")) {
            holder.imageback.setImageResource(R.drawable.sdlogo);
        } else if (data.get(position).getJenjang().equals("smp")) {
            holder.imageback.setImageResource(R.drawable.smplogos);
        } else if (data.get(position).getJenjang().equals("SMA")) {
            holder.imageback.setImageResource(R.drawable.smalogos);
        } else if (data.get(position).getJenjang().equals("smk")) {
            holder.imageback.setImageResource(R.drawable.smlklogo);
        }
        holder.viewRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), DetailActivity.class);
                intent.putExtra("nama", data.get(position).getNama_sekolah());
                intent.putExtra("alamat", data.get(position).getAlamat());
                intent.putExtra("telp", data.get(position).getTelp());
                intent.putExtra("npsn", data.get(position).getNpsn());
                intent.putExtra("kecamatan", data.get(position).getKecamatan());
                intent.putExtra("kelurahan", data.get(position).getKelurahan());
                intent.putExtra("latitude", data.get(position).getLat());
                intent.putExtra("longitude", data.get(position).getLng());
                intent.putExtra("kota", data.get(position).getKota());
                if (data.get(position).getJenjang().equals("sd")) {
                    intent.putExtra("gambar", R.drawable.sdlogo);
                } else if (data.get(position).getJenjang().equals("smp")) {
                    intent.putExtra("gambar", R.drawable.smplogos);
                } else if (data.get(position).getJenjang().equals("SMA")) {
                    intent.putExtra("gambar", R.drawable.smalogos);
                } else if (data.get(position).getJenjang().equals("smk")) {
                    intent.putExtra("gambar", R.drawable.smlklogo);
                }
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageback)
        ImageView imageback;
        @BindView(R.id.viewRecycler)
        View viewRecycler;
        @BindView(R.id.textnama)
        TextView textnama;
        @BindView(R.id.textalamat)
        TextView textalamat;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
