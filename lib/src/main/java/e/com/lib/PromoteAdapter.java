package e.com.lib;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PromoteAdapter extends RecyclerView.Adapter<PromoteAdapter.ViewHolder> {
    private List<Promote> listItem;
    private Context mContext;
    private ItemOnClick itemOnClick;

    public PromoteAdapter(List<Promote> listItem, Context mContext) {
        this.listItem = listItem;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PromoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_promote, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoteAdapter.ViewHolder viewHolder, final int i) {
        final Promote promote = listItem.get(i);
        if (promote != null) {
            viewHolder.tvName.setSelected(true);
            viewHolder.tvName.setText(promote.getTitle() + "");
            viewHolder.tvDes.setText(promote.getDescription() + "");
//            Glide.with(mContext).load(promote.getmImage()).into(viewHolder.imIcon);
            viewHolder.tvInstall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemOnClick.clickInstall(promote.getPackageName() + "");
                }
            });
            viewHolder.tvClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemOnClick.remove(i);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvDes;
        private ImageView imIcon;
        private TextView tvInstall;
        private TextView tvClose;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDes = itemView.findViewById(R.id.tv_des);
            tvInstall = itemView.findViewById(R.id.tv_install);
            imIcon = itemView.findViewById(R.id.im_icon);
            tvClose = itemView.findViewById(R.id.tv_close);
        }
    }

    public void setItemOnClick(ItemOnClick itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public interface ItemOnClick {
        void clickInstall(String packageName);

        void remove(int position);
    }
}
