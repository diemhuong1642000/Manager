package com.example.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

public class AdapterNhanVien extends BaseAdapter {
    Activity context;
    ArrayList<NhanVien> list;

    public AdapterNhanVien(Activity context, ArrayList<NhanVien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_row,null);
        ImageView imgHinhDaiDien = (ImageView) row.findViewById(R.id.imgHinhDaiDien);
        TextView txtID = (TextView) row.findViewById(R.id.txtID);
        TextView txtTen = (TextView) row.findViewById(R.id.txtTen);
        TextView txtSDT = (TextView) row.findViewById(R.id.txtSDT);
        TextView btnSua = (TextView) row.findViewById(R.id.btnSua);
        TextView btnXoa = (TextView) row.findViewById(R.id.btnXoa);
        final NhanVien nhanVien = list.get(position);
        txtID.setText(nhanVien.id+"");
        txtTen.setText(nhanVien.ten);
        txtSDT.setText(nhanVien.sdt);
        Bitmap bmHinhDaiDien = BitmapFactory.decodeByteArray(nhanVien.anh,0,nhanVien.anh.length);
        imgHinhDaiDien.setImageBitmap(bmHinhDaiDien);

       btnSua.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent (context,UpdateActivity.class);
               intent.putExtra("ID",nhanVien.id);
               context.startActivity(intent);
           }
       });
        return row;

    }
}
