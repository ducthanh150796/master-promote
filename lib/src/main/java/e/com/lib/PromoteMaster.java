package e.com.lib;

import android.content.Context;

public class PromoteMaster {

    public static void Instance(Context mContext, boolean isShow) {
        if (!isShow) {
            return;
        }
        DialogListPromote mDialogListPromote = DialogListPromote.getInstance(mContext, new DialogListPromote.OnResult() {
            @Override
            public void close() {

            }
        });
        mDialogListPromote.show();
    }
}
