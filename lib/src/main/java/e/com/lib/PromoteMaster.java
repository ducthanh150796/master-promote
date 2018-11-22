package e.com.lib;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PromoteMaster {
    private List<Promote> promoteList = new ArrayList<>();

    public void Instance(Context mContext, boolean isShow) {
        if (!isShow) {
            return;
        }
        GetContacts getContacts = new GetContacts(mContext);
        getContacts.execute();
//        DialogListPromote mDialogListPromote = DialogListPromote.getInstance(mContext, new DialogListPromote.OnResult() {
//            @Override
//            public void close() {
//
//            }
//        });
//        mDialogListPromote.show();
    }

    public class GetContacts extends AsyncTask<Void, Void, List<Promote>> {
        private Context mContext;

        public GetContacts(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Promote> doInBackground(Void... arg0) {
            List<Promote> listPromotes = new ArrayList<>();
            HttpHandler sh = new HttpHandler();
            String url = "https://raw.githubusercontent.com/ducthanh150796/master-promote/master/promote.txt";
            String jsonStr = sh.makeServiceCall(url);
            Log.e("TAG", "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray contacts = jsonObj.getJSONArray("promote");
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        boolean iShow = c.getBoolean("is-show-promote");
                        String packageName = c.getString("package-name");
                        String title = c.getString("title");
                        String description = c.getString("short-des");
                        String img = c.getString("img");
                        String background = c.getString("background");
                        listPromotes.add(new Promote(iShow, img, background, packageName, description, title));
                    }
                } catch (final JSONException e) {
                    Log.e("TAG", "Json parsing error: " + e.getMessage());
                }

            } else {
                Log.e("TAG", "Couldn't get json from server.");
            }
            return listPromotes;
        }

        @Override
        protected void onPostExecute(List<Promote> result) {
            super.onPostExecute(result);
            promoteList.clear();
            promoteList.addAll(result);
        }
    }

}
