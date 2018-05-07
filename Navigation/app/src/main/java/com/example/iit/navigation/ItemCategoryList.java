package com.example.iit.navigation;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iit.navigation.ListSourceAdapterForItemList;
//import com.example.iit.androidnewsappspl2.Common.Common;
//import com.example.iit.androidnewsappspl2.Interface.NewsService;
//import com.example.iit.androidnewsappspl2.Model.WebSite;
//import com.google.gson.Gson;

import java.util.ArrayList;

import dmax.dialog.SpotsDialog;
//import io.paperdb.Paper;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class ItemCategoryList extends Fragment {
    RecyclerView listWebsite;
    RecyclerView.LayoutManager layoutManager;
    //NewsService mService;
    ListSourceAdapterForItemList adapter;
    //AlertDialog dialog;
    //SwipeRefreshLayout swipeLayout;

    ArrayList<String>arrayList=new ArrayList<String>();
    private int position;
    private String category;
    // private TextView content;
    // private ImageView image;

    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position=getArguments().getInt("position");
        //get data from Argument

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,@Nullable Bundle savedInstanceState) {

       // category = getArguments().getString("category");

        return inflater.inflate(R.layout.activity_mainf, container, false);
    }

    @Override
    public void onViewCreated(View view , @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Toast.makeText(getActivity(),category,Toast.LENGTH_LONG).show();
        //image = (ImageView) view.findViewById(R.id.image);
        //content = (TextView) view.findViewById(R.id.textView);

        ArrayList<String>a=new ArrayList<String>();
        a.add("d");
        a.add("e");
        arrayList=this.getArguments().getStringArrayList("arraylist");

        listWebsite =getActivity().findViewById(R.id.list_source);
        listWebsite.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        listWebsite.setLayoutManager(layoutManager);
        adapter = new ListSourceAdapterForItemList(getContext(),arrayList,a);
        adapter.notifyDataSetChanged();
        listWebsite.setAdapter(adapter);
       // dialog = new SpotsDialog(getActivity());

        //loadWebsiteSource(true);
    }
}