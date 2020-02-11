package com.example.staff.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.staff.R;
import com.example.staff.model.User;

import de.hdodenhof.circleimageview.CircleImageView;


public class DetailFragment extends Fragment {
    View view;
    DetailViewModel detailViewModel;
    DetailFragmentArgs args;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        args = DetailFragmentArgs.fromBundle(requireArguments());
        getIncomingIntent();
    }

    private void getIncomingIntent() {
//            Integer id = getActivity().getIntent().getIntExtra("user_id", 0);
            detailViewModel.init(args.getUserId());
            detailViewModel.getUserProfile().observe(getActivity(), new Observer<User>() {
                @Override
                public void onChanged(User user) {
                    setImage(user.getProfile_photo(), user.getF_name(), user.getL_name(), user.getEmail());
                }
            });

    }

    private void setImage(String profile_photo, String f_names, String l_names, String emails) {
        TextView first_name = view.findViewById(R.id.first_name_view);
        TextView last_name = view.findViewById(R.id.last_name_view);
        TextView email = view.findViewById(R.id.email_view);
        CircleImageView image = view.findViewById(R.id.profile_photo_view);
        first_name.setText(f_names);
        last_name.setText(l_names);
        email.setText(emails);
        Glide.with(this)
                .asBitmap()
                .load(profile_photo)
                .into(image);

    }
}
