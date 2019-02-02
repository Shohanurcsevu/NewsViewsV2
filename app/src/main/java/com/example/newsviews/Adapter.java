package com.example.newsviews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.newsviews.models.Article;

import java.util.List;

import static com.example.newsviews.R.layout.fragment_home;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Article> articles;
    private Context context;
    private OnItemClickListener onItemClickListener;


    public Adapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

         View view=LayoutInflater.from(context).inflate(R.layout.fragment_home,viewGroup,false);
        return new MyViewHolder(view,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

      public  void setOnItemClickListener(OnItemClickListener onItemClickListener )
      {
          this.onItemClickListener= onItemClickListener;
      }
    public interface OnItemClickListener
    {
        void onItemClick(View view, int position);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

     public  TextView title,desc,author,publishedat,source,time;
         ImageView imageView;
         ProgressBar progressBar;

         OnItemClickListener onItemClickListener;

        public MyViewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
            super(itemView);

            itemView.setOnClickListener(this);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
            author=itemView.findViewById(R.id.author);
            publishedat=itemView.findViewById(R.id.publishedAt);
            source=itemView.findViewById(R.id.source);
            time=itemView.findViewById(R.id.time);
            imageView=itemView.findViewById(R.id.img);
            progressBar=itemView.findViewById(R.id.progress_load_photo);

            this.onItemClickListener=onItemClickListener;




        }

        @Override
        public void onClick(View v) {

            onItemClickListener.onItemClick(v,getAdapterPosition());


        }
    }
}
