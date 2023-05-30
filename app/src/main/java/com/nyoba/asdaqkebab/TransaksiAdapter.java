package com.nyoba.asdaqkebab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nyoba.asdaqkebab.databinding.CardItemsBinding;
import com.nyoba.asdaqkebab.databinding.CardsTransaksiBinding;

import java.util.ArrayList;
import java.util.List;

//
public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.ItemViewHolder> {

    private ArrayList<Transaksi> datalist;
    private OnClickListener onClickListener;

    public TransaksiAdapter(ArrayList<Transaksi> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public TransaksiAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.cards_transaksi, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransaksiAdapter.ItemViewHolder itemViewHolder, int position) {
        Transaksi item = datalist.get(position);
        itemViewHolder.tvNama.setText(datalist.get(position).getName());
        itemViewHolder.tvJumlah.setText(String.valueOf(datalist.get(position).getJumlah()));
        itemViewHolder.tvHarga.setText(String.valueOf(datalist.get(position).getHarga()));

        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = itemViewHolder.getAdapterPosition();
//                if (onClickListener != null) {
//                    onClickListener.onClick(clickedPosition, datalist.get(clickedPosition));
//                    onClickListener.onClick(position, item);
                Context context = view.getContext();
                Intent intent = new Intent(context, LaporanCabangActivity.class);
                intent.putExtra("ITEM_POSITION", clickedPosition);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
//        return (datalist != null) ? datalist.size() : 0;
        return datalist.size();
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, Items model);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardsTransaksiBinding binding;
        ViewHolder(CardsTransaksiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        final CardsTransaksiBinding getBinding() {
            return binding;
        }

//        final void setBinding(CardsTransaksiBinding binding) {
//            this.binding = binding;
//        }
//
//        final void setTvTanggal(CharSequence value) {
//            binding.tvTanggal.setText(value);
//        }
//
//        final void setTvKota(CharSequence value) {
//            binding.tvKota.setText(value);
//        }
//        final void setTvPemasukkan(CharSequence value) {
//            binding.tvPemasukan.setText(value);
//        }
//
//        final CharSequence getTvTanggal() {
//            return binding.tvTanggal.getText();
//        }
//
//        final CharSequence getTvKota() {
//            return binding.tvKota.getText();
//        }
//        final CharSequence getTvPemasukkan() {
//            return binding.tvPemasukan.getText();
//        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama, tvJumlah, tvHarga;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.name);
            tvJumlah = itemView.findViewById(R.id.jumlah);
            tvHarga = itemView.findViewById(R.id.harga);

        }
    }
}



