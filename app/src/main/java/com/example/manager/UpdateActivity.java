package com.example.manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UpdateActivity extends AppCompatActivity {
    final String DATABASE_NAME="SQLITE_QLSV.db";
    Button btnChonHinh,btnChupHinh,btnLuu,btnHuy;
    EditText edtTen,edtSDT;
    ImageView imgHinhDaiDien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        addControls();
        unitUI();
    }

    private void unitUI() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT *FROM NhanVien where ID = ?", new String[]{id + "",});
        cursor.moveToFirst();
        String ten = cursor.getString(1);
        String sdt = cursor.getString(2);
        byte[] anh = cursor.getBlob(3);
        Bitmap bitmap = BitmapFactory.decodeByteArray(anh,0,anh.length);
        imgHinhDaiDien.setImageBitmap(bitmap);
        edtSDT.setText(sdt);
        edtTen.setText(ten);
    }

    private void addControls() {
        btnChonHinh = (Button) findViewById(R.id.btnChonHinh);
        btnChupHinh = (Button) findViewById(R.id.btnChupHinh);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        edtTen = (EditText) findViewById(R.id.edtTen);
        edtSDT = (EditText) findViewById(R.id.edtSDT);
        imgHinhDaiDien = (ImageView) findViewById(R.id.imgHinhDaiDien);

    }
}