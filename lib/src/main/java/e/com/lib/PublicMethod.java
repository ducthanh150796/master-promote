package e.com.lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.TypedValue;

public class PublicMethod {
    public static void saveSettings(Context context, String keySave, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Pref", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(keySave, value).commit();
    }

    public static String getSetting(Context context, String keySave) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Pref", context.MODE_PRIVATE);
        String profile = sharedPreferences.getString(keySave, "");
        return profile;
    }

    public static int dpToPx(float dp, Resources resources) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }
}
