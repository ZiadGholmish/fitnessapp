package com.fitnessapp.presentation.views.discounts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fitnessapp.R;
import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.model.DiscountModel;
import com.fitnessapp.utils.ResourcesUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by carriagecompany on 9/26/17.
 */

public class DiscountsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<DiscountModel> discountEntities;
    private static final int NORMAL_ITEM = 0;

    OnDiscountClickInterface onDiscountClickInterface;

    public DiscountsAdapter(Context context, List<DiscountModel> discountEntities, OnDiscountClickInterface onDiscountClickInterface) {
        this.context = context;
        this.discountEntities = discountEntities;
        this.onDiscountClickInterface = onDiscountClickInterface;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;

        v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.discount_item_layout, viewGroup, false);
        return new DiscountViewHolder(v);
    }

    @Override

    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(holder.getAdapterPosition()) == NORMAL_ITEM) {
            DiscountViewHolder discountViewHolder = (DiscountViewHolder) holder;
            DiscountModel discountEntity = discountEntities.get(holder.getAdapterPosition());
            showData(discountViewHolder, discountEntity);
        }
    }


    void showData(DiscountViewHolder discountViewHolder, DiscountModel discountEntity) {

        Picasso.with(context).load(discountEntity.getImage()).into(discountViewHolder.meal_image);
        discountViewHolder.meal_name.setText(discountEntity.getMealName());
        discountViewHolder.meal_desc.setText(discountEntity.getDesc());
        discountViewHolder.meal_price.setText(String.format(ResourcesUtil.getString(R.string.price_label), discountEntity.getPrice() + ""));
    }


    @Override
    public int getItemViewType(int position) {
        return NORMAL_ITEM;
    }

    @Override
    public int getItemCount() {
        return discountEntities.size();
    }

    class DiscountViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_view)
        CardView card_view;

        @BindView(R.id.card_details)
        CardView card_details;

        @BindView(R.id.meal_image)
        ImageView meal_image;

        @BindView(R.id.meal_name)
        TextView meal_name;

        @BindView(R.id.meal_desc)
        TextView meal_desc;

        @BindView(R.id.meal_price)
        TextView meal_price;

        public DiscountViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

