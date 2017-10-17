package product.dp.io.ab180blog.Memo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jaewanlee on 2017. 9. 11..
 */

public class MemoListAdapter extends RecyclerView.Adapter<MemoListAdapter.ViewHolder> {
    Context context;
    ArrayList<MemoListDatabase> memoDatabases;

    public MemoListAdapter(Context context, ArrayList<MemoListDatabase> memoDatabases) {
        this.context = context;
        this.memoDatabases = memoDatabases;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(product.dp.io.ab180blog.R.layout.recyclerview_item_memo_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MemoListDatabase memoDatabase=memoDatabases.get(position);
        holder.memoTitle_tv.setText(memoDatabase.getMemo_document_place_name());
        holder.memoCategory_iv.setImageResource(product.dp.io.ab180blog.R.drawable.ic_action_back);
        holder.createDate_tv.setText(new Date(memoDatabase.getMemo_createDate()).toString());
        holder.memoContent_tv.setText(memoDatabase.getMemo_content());
        holder.phoneCall_ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "phone call", Toast.LENGTH_SHORT).show();
            }
        });
        holder.blogWeb_ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "blog moving", Toast.LENGTH_SHORT).show();
            }
        });

        if(memoDatabase.getIsNew()){
            holder.newMemo_iv.setVisibility(View.VISIBLE);
            memoDatabase.setIsNew(false);
        }

    }

    @Override
    public int getItemCount() {
        return memoDatabases.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView memoTitle_tv;
        ImageView memoCategory_iv;
        TextView createDate_tv;
        TextView memoContent_tv;
        ImageButton phoneCall_ib;
        ImageButton blogWeb_ib;

        ImageView newMemo_iv;

        public ViewHolder(View itemView) {
            super(itemView);
            memoTitle_tv = (TextView) itemView.findViewById(product.dp.io.ab180blog.R.id.memoListRecy_title_TextView);
            memoCategory_iv = (ImageView) itemView.findViewById(product.dp.io.ab180blog.R.id.memoListRecy_category_ImageView);
            createDate_tv = (TextView) itemView.findViewById(product.dp.io.ab180blog.R.id.memoListRecy_date_TextView);
            memoContent_tv = (TextView) itemView.findViewById(product.dp.io.ab180blog.R.id.memoListRecy_memoContent_TextView);
            phoneCall_ib = (ImageButton) itemView.findViewById(product.dp.io.ab180blog.R.id.memoListRecy_call_ImageButton);
            blogWeb_ib = (ImageButton) itemView.findViewById(product.dp.io.ab180blog.R.id.memoListRecy_web_ImageButton);
            newMemo_iv=(ImageView)itemView.findViewById(product.dp.io.ab180blog.R.id.memoListRecy_newMemo_ImageView);

        }
    }

}