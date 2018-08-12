
    // Name: Tran Le
    // AID - 1808
    // File name: ReviewAdapter.java

package com.sunny.android.letran_ce04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class ReviewAdapter extends BaseAdapter {

    // Member variables
    private static final long BASE_ID = 0x00001;
    private Context rContext = null;
    private ArrayList<Review> rCollection = null;

    // Constructor
    public ReviewAdapter(Context _rContext, ArrayList<Review> _rCollection) {
        rContext = _rContext;
        rCollection = _rCollection;
    }

    @Override
    public int getCount() {
        if (rCollection != null) {
            return rCollection.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        if (rCollection != null && i >= 0 || i < rCollection.size()) {
            return rCollection.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return  BASE_ID + i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh = null;
        if (view == null) {
            view = LayoutInflater.from(rContext).inflate(R.layout.custom_review_layout, viewGroup, false);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder)view.getTag();
        }

        Review review = (Review)getItem(i);

        if (review != null) {
            vh.profileImage.setImageResource(review.getAvatar());
            vh.name.setText(review.getName());
            vh.date.setText(review.getDate());
            vh.title.setText(review.getTitle());
            vh.desc.setText(review.getDesc());
            ImageView[] stars = {vh.star1, vh.star2, vh.star3, vh.star4, vh.star5};
            int loopTime = 0;
            while (loopTime != 5) {
                if (loopTime <= review.getStar()-1) {
                    stars[loopTime].setImageResource(R.drawable.full_star);
                } else {
                    stars[loopTime].setImageResource(R.drawable.empty_star);
                }
                loopTime += 1;
            }
        }

        return view;
    }

    // Recycle view
    static class ViewHolder {
        ImageView profileImage;
        TextView name;
        TextView date;
        ImageView star1;
        ImageView star2;
        ImageView star3;
        ImageView star4;
        ImageView star5;
        TextView title;
        TextView desc;

        public ViewHolder(View _layout) {
            profileImage = (ImageView) _layout.findViewById(R.id.avatar);
            name = (TextView) _layout.findViewById(R.id.reviewer_name);
            date = (TextView) _layout.findViewById(R.id.date);
            star1 = (ImageView) _layout.findViewById(R.id.reviewstar_1);
            star2 = (ImageView) _layout.findViewById(R.id.reviewstar_2);
            star3 = (ImageView) _layout.findViewById(R.id.reviewstar_3);
            star4 = (ImageView) _layout.findViewById(R.id.reviewstar_4);
            star5 = (ImageView) _layout.findViewById(R.id.reviewstar_5);
            title = (TextView) _layout.findViewById(R.id.review_title);
            desc = (TextView) _layout.findViewById(R.id.review_desc);
        }

    }
}
