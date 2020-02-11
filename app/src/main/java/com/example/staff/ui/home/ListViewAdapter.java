package com.example.staff.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.staff.R;
import com.example.staff.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {
    List<User> userArray;
    private ListClickListener listClickListener;

    public ListViewAdapter(List<User> userArray, ListClickListener listClickListener) {
        this.userArray = userArray;
        this.listClickListener = listClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rowItem = layoutInflater.inflate(R.layout.activity_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final User user = userArray.get(holder.getAdapterPosition());

        Picasso.get().load(user.getProfile_photo()).into(holder.profile_pic);

        holder.first_name.setText(user.getF_name());
        holder.last_name.setText(user.getL_name());
        holder.email.setText(user.getEmail());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listClickListener.listItemClicked(user);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userArray.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CircleImageView profile_pic;
        public TextView first_name;
        public TextView last_name;
        public TextView email;
        public RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile_pic = itemView.findViewById(R.id.profile_photo);
            this.first_name = itemView.findViewById(R.id.f_name);
            this.last_name = itemView.findViewById(R.id.l_name);
            this.email = itemView.findViewById(R.id.email);
            this.relativeLayout = itemView.findViewById(R.id.row_layout);
        }
    }

    public interface ListClickListener {
        void listItemClicked(User user);
    }
}
