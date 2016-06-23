package com.example.bbbkakashi.calculator_1442061;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String chuoi_tinh="";
    private String so_trai= "";
    private String so_phai= "";
    private Double ket_qua= 0.0;
    private String phep_tinh = "";
    private boolean so_trai_cham = false;
    private boolean so_phai_cham = false;
    private boolean so_trai_end = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1=(Button)findViewById(R.id.btnBang);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(so_trai != "" && phep_tinh != "" && so_phai != ""){
                    thuchienPhepTinh();
                    chuoi_tinh = "";
                    so_trai = "";
                    so_phai = "";
                    so_trai_cham = false;
                    so_phai_cham = false;
                    so_trai_end = false;
                    capnhatHienThiChuoiTinh();
                    ket_qua = 0.0;
                    phep_tinh = "";
                }
            }
        });
    }

    public void buttonNotice(View view){
        inra("Thành thật xin lỗi!Phần mềm chưa hoàn thiện chức năng này");
    }
    public void buttonOnClick(View view){
        Button b = (Button) view;
        switch(view.getId()){
            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
                capnhatChuoiTinh(b);
                break;
            case R.id.btncham:
                capnhatSo(b);
                break;
            case R.id.btnCong:
                themPhepTinh(b);
                break;
            case R.id.btnTru:
                themPhepTinh(b);
                break;
            case R.id.btnNhan:
                themPhepTinh(b);
                break;
            case R.id.btnChia:
                themPhepTinh(b);
                break;
        }
    }

    public void xoaTrang(View view){
        chuoi_tinh = "";
        so_trai = "";
        so_phai = "";
        so_phai_cham = false;
        so_trai_cham = false;
        ket_qua = 0.0;
        capnhatHienThiChuoiTinh();
    }

    public void thuchienPhepTinh(){
        switch (phep_tinh){
            case "+": ket_qua = Double.parseDouble(so_trai) + Double.parseDouble(so_phai);break;
            case "-": ket_qua = Double.parseDouble(so_trai) - Double.parseDouble(so_phai);break;
            case "x": ket_qua = Double.parseDouble(so_trai) * Double.parseDouble(so_phai);break;
            case "/": if(Double.parseDouble(so_phai) == 0.0){
                inra("Số bị chia phải khác không");
            }else{
                ket_qua = Double.parseDouble(so_trai) / Double.parseDouble(so_phai);break;
            }

        }
    }
    public void themPhepTinh(Button b){
        if(so_trai == "")
        {
            inra("Vui lòng nhập số trước");
            return;
        }

        if(phep_tinh == "" ){
            phep_tinh = b.getText().toString();
            chuoi_tinh = chuoi_tinh + b.getText().toString();
            capnhatHienThiChuoiTinh();
            so_trai_end = true;
        }else{
            if(so_phai != ""){
                thuchienPhepTinh();
                so_trai = Double.toString(ket_qua);
                so_phai = "";
                chuoi_tinh = ket_qua + b.getText().toString();
                so_trai_end = true;
                phep_tinh = b.getText().toString();
                capnhatHienThiChuoiTinh();
            }
        }
    }

    public void capnhatHienThiChuoiTinh(){
        EditText chuoi_tinh_txt = (EditText)findViewById(R.id.txtPhepTinh);
        chuoi_tinh_txt.setText(chuoi_tinh, TextView.BufferType.EDITABLE);
        EditText ket_qua_txt = (EditText)findViewById(R.id.txtKetQua);
        ket_qua_txt.setText(ket_qua.toString(), TextView.BufferType.EDITABLE);
    }

    public void capnhatSo(Button b){
        if(so_trai_end == false){
            if(so_trai_cham == false){
                chuoi_tinh = chuoi_tinh + b.getText().toString();
                so_trai = so_trai + b.getText().toString();
                so_trai_cham = true;
                capnhatHienThiChuoiTinh();
            }
        }else{
            if(so_phai_cham == false){
                chuoi_tinh = chuoi_tinh + b.getText().toString();
                so_phai = so_phai + b.getText().toString();
                so_phai_cham = true;
                capnhatHienThiChuoiTinh();
            }
        }
    }

    public void inra(String a){
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(a).create();
        myAlert.show();
    }

    public void capnhatChuoiTinh(Button b){
        chuoi_tinh = chuoi_tinh + b.getText().toString();
        if(so_trai_end == false){
            if(so_trai == "") {
                so_trai = b.getText().toString();
            }else{
                so_trai = so_trai + b.getText().toString();
            }
        }else{
            if(so_phai == ""){
                so_phai = b.getText().toString();
            }else{
                so_phai = so_phai + b.getText().toString();
            }
        }
        capnhatHienThiChuoiTinh();
    }
}
