package e.com.lib;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DialogListPromote extends Dialog {
    private Context mContext;
    private RecyclerView mRecyclerView;
    private PromoteAdapter promoteAdapter;
    private List<Promote> listItem = new ArrayList<>();
    private OnResult mOnResult;
    private View btnClose;

    public DialogListPromote(Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.dialog_list);
        initView();
    }

    public interface OnResult {
        void close();
    }

    public static DialogListPromote getInstance(Context mContext, List<Promote> listItem, OnResult onResult) {
        DialogListPromote dialogListPromote = new DialogListPromote(mContext, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialogListPromote.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogListPromote.mContext = mContext;
        dialogListPromote.mOnResult = onResult;
        dialogListPromote.listItem = listItem;
        dialogListPromote.initData();
        dialogListPromote.initControl();
        return dialogListPromote;
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rcv_item);
        btnClose = findViewById(R.id.btn_close);
    }

    private void initData() {
        promoteAdapter = new PromoteAdapter(listItem, mContext);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 1, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(promoteAdapter);
    }

    private void initControl() {
        promoteAdapter.setItemOnClick(new PromoteAdapter.ItemOnClick() {
            @Override
            public void clickInstall(String packageName) {
                try {
                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
                }
            }

            @Override
            public void remove(int position) {
                listItem.remove(position);
                promoteAdapter.notifyDataSetChanged();
                if (listItem.size()==0){
                    btnClose.callOnClick();
                }
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnResult.close();
                dismiss();
            }
        });
    }
}
