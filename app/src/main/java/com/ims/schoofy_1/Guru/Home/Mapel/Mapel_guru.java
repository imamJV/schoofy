package com.ims.schoofy_1.Guru.Home.Mapel;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.ims.schoofy_1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Mapel_guru extends Fragment {

    ArrayList<Users> users;
    String data = "";
    TableLayout tl;
    TableRow tr;
    TextView label,nama;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_mapel_guru, container, false);

        tl          = view.findViewById(R.id.tableInvoices);
        final GetDataFromDB getdb = new GetDataFromDB();
        final ProgressDialog loading = ProgressDialog.show(getContext(),
                "Memproses...", "Harap Menunggu...", false, false);
        loading.show();
        new Thread(new Runnable() {
            public void run() {
                data = getdb.getDataFromDB("tampil");
                System.out.println(data);
                Log.d("parseJSON",data);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        users = parseJSON(data);
                        addData(users);
                        loading.dismiss();
                    }
                });

            }
        }).start();
        return  view;
    }

    public ArrayList<Users>parseJSON(String result) {
        ArrayList<Users>users = new ArrayList<Users>();
        Log.d("parseJSON",result);
        try {
            JSONArray jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Users user = new Users();
                user.setNo(json_data.getString("no"));
                user.setLayanan(json_data.getString("Id"));
                user.setRoom(json_data.getString("invoice"));
                user.setKamar(json_data.getString("status_bayar"));
                user.setTotal(json_data.getString("room"));
                user.setInvoice(json_data.getString("tot_kamar"));
                users.add(user);
            }
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return users;
    }


    void addHeader(){
        /** Create a TableRow dynamically **/
        tr = new TableRow(getContext());

        /** Creating a TextView to add to the row **/
        label = new TextView(getContext());
        label.setText("NO");
        label.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        label.setPadding(5, 5, 5, 5);
        label.setBackgroundColor(getContext().getResources().getColor(R.color.header));
        LinearLayout Ll = new LinearLayout(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        Ll.setOrientation(LinearLayout.HORIZONTAL);
        params.setMargins(5, 5, 5, 5);
        Ll.addView(label,params);
        tr.addView((View)Ll); // Adding textView to tablerow.

        TextView Invoice = new TextView(getContext());
        Invoice.setText("INVOICE");
        Invoice.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        Invoice.setPadding(5, 5, 5, 5);
        Invoice.setBackgroundColor( getResources().getColor(R.color.header));
        Ll = new LinearLayout(getContext());
        params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(Invoice,params);
        tr.addView((View)Ll); // Adding textview to tablerow.


        /** Creating Qty Button **/
        TextView penginap = new TextView(getContext());
        penginap.setText("KAMAR");
        penginap.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        penginap.setPadding(5, 5, 5, 5);
        penginap.setBackgroundColor( getResources().getColor(R.color.header));
        Ll = new LinearLayout(getContext());
        params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(penginap,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView Biaya_Kamar = new TextView(getContext());
        Biaya_Kamar.setText("BIAYA KAMAR");
        Biaya_Kamar.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        Biaya_Kamar.setPadding(5, 5, 5, 5);
        Biaya_Kamar.setBackgroundColor( getResources().getColor(R.color.header));
        Ll = new LinearLayout(getContext());
        params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(Biaya_Kamar,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        /** Creating Qty Button **/
        TextView place = new TextView(getContext());
        place.setText("BIAYA SERVICE");
        place.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        place.setPadding(5, 5, 5, 5);
        place.setBackgroundColor(getContext().getResources().getColor(R.color.header));
        Ll = new LinearLayout(getContext());
        params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(place,params);
        tr.addView((View)Ll); // Adding textview to tablerow.


        /** Creating Qty Button **/
        TextView CHECKIN = new TextView(getContext());
        CHECKIN.setText("JUMLAH");
        CHECKIN.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        CHECKIN.setPadding(5, 5, 5, 5);
        CHECKIN.setBackgroundColor( getResources().getColor(R.color.header));
        Ll = new LinearLayout(getContext());
        params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 5, 5);
        //Ll.setPadding(10, 5, 5, 5);
        Ll.addView(CHECKIN,params);
        tr.addView((View)Ll); // Adding textview to tablerow.

        label.setTextColor(Color.WHITE);
        place.setTextColor(Color.WHITE);
        penginap.setTextColor(Color.WHITE);
        CHECKIN.setTextColor(Color.WHITE);
        Invoice.setTextColor(Color.WHITE);
        Biaya_Kamar.setTextColor(Color.WHITE);
        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
    }

    @SuppressWarnings({ "rawtypes" })
    public void addData(ArrayList<Users> users) {
        addHeader();
        for (Iterator i = users.iterator(); i.hasNext();) {

            Users p = (Users) i.next();

            /** Create a TableRow dynamically **/
            tr = new TableRow(getContext());

            /** Creating a TextView to add to the row **/
            label = new TextView(getContext());
            label.setText(p.getNo());
            label.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            label.setPadding(5, 5, 5, 5);
            label.setBackgroundColor( getResources().getColor(R.color.record));
            LinearLayout Ll = new LinearLayout(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            Ll.setOrientation(LinearLayout.HORIZONTAL);
            params.setMargins(5, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(label,params);
            tr.addView((View)Ll); // Adding textView to tablerow.

            /** Creating Qty Button **/
            TextView place = new TextView(getContext());
            place.setText(p.getInvoice());
            place.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            place.setPadding(5, 5, 5, 5);
            place.setBackgroundColor( getResources().getColor(R.color.record));
            Ll = new LinearLayout(getContext());
            params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(place,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView penginap = new TextView(getContext());
            penginap.setText(p.getRoom());
            penginap.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            penginap.setPadding(5, 5, 5, 5);
            penginap.setBackgroundColor( getResources().getColor(R.color.record));
            Ll = new LinearLayout(getContext());
            params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(penginap,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView CHECKIN = new TextView(getContext());
            CHECKIN.setText(p.getKamar());
            CHECKIN.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            CHECKIN.setPadding(5, 5, 5, 5);
            CHECKIN.setBackgroundColor( getResources().getColor(R.color.record));
            Ll = new LinearLayout(getContext());
            CHECKIN.setGravity(Gravity.RIGHT);
            params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(CHECKIN,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView CHECKIN1 = new TextView(getContext());
            CHECKIN1.setText(p.getLayanan());
            CHECKIN1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            CHECKIN1.setPadding(5, 5, 5, 5);
            CHECKIN1.setBackgroundColor( getResources().getColor(R.color.record));
            Ll = new LinearLayout(getContext());
            CHECKIN1.setGravity(Gravity.RIGHT);
            params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(CHECKIN1,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            /** Creating Qty Button **/
            TextView CHECKIN12 = new TextView(getContext());
            CHECKIN12.setText(p.getTotal());
            CHECKIN12.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            CHECKIN12.setGravity(Gravity.RIGHT);
            CHECKIN12.setPadding(5, 5, 5, 5);
            CHECKIN12.setBackgroundColor( getResources().getColor(R.color.record));
            Ll = new LinearLayout(getContext());
            params = new LinearLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 2, 2, 2);
            //Ll.setPadding(10, 5, 5, 5);
            Ll.addView(CHECKIN12,params);
            tr.addView((View)Ll); // Adding textview to tablerow.

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }
}