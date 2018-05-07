package com.example.iit.navigation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.iit.androidnewsappspl2.Common.Common;
//import com.example.iit.androidnewsappspl2.Interface.IconBetterIdeaService;
//import com.example.iit.androidnewsappspl2.Interface.ItemClickListener;
//import com.example.iit.androidnewsappspl2.ListNews;
//import com.example.iit.androidnewsappspl2.Model.IconBetterIdea;
//import com.example.iit.androidnewsappspl2.Model.WebSite;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//import de.hdodenhof.circleimageview.CircleImageView;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

/**
 * Created by reale on 10/4/2017.
 */

class ListSourceViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener
{
    ItemClickListener itemClickListener;

    TextView source_title;
    ImageView imageView;
    //CircleImageView source_image;

    public ListSourceViewHolder(View itemView) {
        super(itemView);

        //source_image = (CircleImageView) itemView.findViewById(R.id.source_image);
        source_title = (TextView)itemView.findViewById(R.id.source_name);
        itemView=(ImageView)itemView.findViewById(R.id.img);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}

public class ListSourceAdapterForItemList extends RecyclerView.Adapter<ListSourceViewHolder>{
    private Context context;
    private ArrayList<String> webSite=new ArrayList<String>();
    private ArrayList<String> deletArrayList =new ArrayList<String>();


    //private IconBetterIdeaService mService;

    public ListSourceAdapterForItemList(Context context, ArrayList<String> webSite,ArrayList<String>deletArrayList) {
        this.context = context;

        this.webSite = webSite;

       // mService = Common.getIconService();
    }

    @Override
    public ListSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.source_layout1,parent,false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListSourceViewHolder holder, int position) {



        holder.source_title.setText(webSite.get(position));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                  deletArrayList.add(webSite.get(position));
                  webSite.remove(position);
                  new ListSourceAdapterForItemList2(context,deletArrayList,webSite);
                  //new ListSourceAdapterForItemList(context, webSite);
            }
        });

    }

    @Override
    public int getItemCount() {
        return webSite.size();
    }
}
