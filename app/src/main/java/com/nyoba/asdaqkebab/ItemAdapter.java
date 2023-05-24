package com.nyoba.asdaqkebab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nyoba.asdaqkebab.databinding.CardItemsBinding;

import java.util.ArrayList;
//public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
//    private ArrayList<Items> items;
//    private OnClickListener onClickListener;
//
//    public ItemAdapter(ArrayList<Items> items) {
//        this.items = items;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new ViewHolder(CardItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        Items item = items.get(position);
//        holder.tv_tanggal.setText(item.getTanggal());
//        holder.tv_kota.setText(item.getKota());
//        holder.tv_pemasukan.setText(item.getPemasukkan());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (onClickListener != null) {
//                    onClickListener.onClick(position, item);
//                }
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
//    public void setOnClickListener(OnClickListener onClickListener) {
//        this.onClickListener = onClickListener;
//    }
//
//    public interface OnClickListener {
//        void onClick(int position, Items model);
//    }
//
//    static class ViewHolder extends RecyclerView.ViewHolder {
//        CardItemsBinding binding;
//
//        ViewHolder(CardItemsBinding binding) {
//            super(binding.getRoot());
//            this.binding = binding;
//        }
//
//        final CardItemsBinding getBinding() {
//            return binding;
//        }
//
//        final void setBinding(CardItemsBinding binding) {
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
//
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
//
//        final CharSequence getTvPemasukkan() {
//            return binding.tvPemasukan.getText();
//        }
//    }
//}

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<Items> datalist;
    private OnClickListener onClickListener;

    public ItemAdapter(ArrayList<Items> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.card_items, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder itemViewHolder, int position) {
        Items item = datalist.get(position);
        itemViewHolder.tvTanggal.setText(datalist.get(position).getTanggal());
        itemViewHolder.tvKota.setText(String.valueOf(datalist.get(position).getKota()));
        itemViewHolder.tvPemasukan.setText(String.valueOf(datalist.get(position).getPemasukan()));

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
        CardItemsBinding binding;
        ViewHolder(CardItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        final CardItemsBinding getBinding() {
            return binding;
        }

        final void setBinding(CardItemsBinding binding) {
            this.binding = binding;
        }

        final void setTvTanggal(CharSequence value) {
            binding.tvTanggal.setText(value);
        }

        final void setTvKota(CharSequence value) {
            binding.tvKota.setText(value);
        }
        final void setTvPemasukkan(CharSequence value) {
            binding.tvPemasukan.setText(value);
        }

        final CharSequence getTvTanggal() {
            return binding.tvTanggal.getText();
        }

        final CharSequence getTvKota() {
            return binding.tvKota.getText();
        }
        final CharSequence getTvPemasukkan() {
            return binding.tvPemasukan.getText();
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTanggal, tvKota, tvPemasukan;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvKota = itemView.findViewById(R.id.tv_kota);
            tvPemasukan = itemView.findViewById(R.id.tv_pemasukan);
            
        }
    }
}

