package com.example.android_buoi6_btvn;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.UserViewHolder> {

    private ArrayList<ProductModel> mListProduct;
    private Context mContext;

    public ProductAdapter(ArrayList<ProductModel> listUsers) {
        this.mListProduct = listUsers;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("TAG", "onCreateViewHolder: ");
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_product, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Log.d("TAG", "onBindViewHolder: ");
       ProductModel product = mListProduct.get(position);

        holder.tvTitle.setText(product.getTitle());
        holder.tvBrand.setText(product.getBrand());
        holder.tvCategory.setText(product.getCategory());
    }

    @Override
    public int getItemCount() {
        return mListProduct != null ? mListProduct.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvBrand, tvCategory, tvTitle;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBrand = itemView.findViewById(R.id.tvBrand);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
