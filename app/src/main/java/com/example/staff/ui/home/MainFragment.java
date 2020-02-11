package com.example.staff.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.staff.R;
import com.example.staff.model.User;
import com.example.staff.util.Helpers;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment implements ListViewAdapter.ListClickListener {
    private View view;
    private List<User> users;
    ArrayList<User> usersList;
    ListViewAdapter adapter;
    private RecyclerView recyclerView;
    private HomeViewModel homeViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initRecyclerView();
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.init();
        usersList = new ArrayList<>();
        homeViewModel.getUserList().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> response) {
                users = response;
                usersList.addAll(users);
                setupAdapter();
            }
        });

    }

    private void initRecyclerView() {
        recyclerView = view.findViewById(R.id.recycler_view_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    private void setupAdapter() {
        adapter = new ListViewAdapter(users, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void listItemClicked(User user) {
        try{
            Navigation.findNavController(getView()).navigate(MainFragmentDirections.navigateToUserDetail(user.getId()));
        }catch (Exception e){
            e.printStackTrace();
        }
//        Intent intent = new Intent(view.getContext(), DetailActivity.class);
//        intent.putExtra("user_id", user.getId());
//        view.getContext().startActivity(intent);
    }
}
