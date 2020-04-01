package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAdd,btnMul,btnMinus,btnDiv,btnEqual,btnClear,btndel,btnCE;
    TextView display,display2;
    String process;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAdd = findViewById(R.id.Add);
        btnMul = findViewById(R.id.Mul);
        btnMinus = findViewById(R.id.Minus);
        btnDiv = findViewById(R.id.Div);
        btnClear = findViewById(R.id.C);
        btnEqual = findViewById(R.id.Equal);
        btndel = findViewById(R.id.delete);
        display=findViewById(R.id.display);
        display2=findViewById(R.id.display2);
        btnCE = findViewById(R.id.CE);


//       btn BS  xóa từng phần tử một
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                process = process.substring(0,process.length()-1);
                display.setText(process);
            }
        });
//          button C xóa phép tính đang thực hiện
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
            }
        });
//          button CE xóa toàn bộ phép tính
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
                display2.setText("");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn0.getText());
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn1.getText());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn2.getText());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn3.getText());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn4.getText());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn5.getText());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn6.getText());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn7.getText());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn8.getText());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btn9.getText());
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display2.getText().toString() == ""){
                    //lấy ra kí tự trên màn hình nhập
                    process = display.getText().toString();
                    //chèn thêm toán tử
                    display.setText(process + btnDiv.getText());
                }else{
                    //lấy kí tự trên màn hình kết quả
                    process = display2.getText().toString();
                    //chèn thêm toán tử
                    display.setText(process + btnDiv.getText());
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display2.getText().toString() == ""){
                    process = display.getText().toString();
                    display.setText(process + btnAdd.getText());
                }else {
                    process = display2.getText().toString();
                    display.setText(process + btnAdd.getText());
                }

            }
        });
//        Trừ
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display2.getText().toString() == ""){
                    process = display.getText().toString();
                    display.setText(process + btnMinus.getText());
                }else{
                    process = display2.getText().toString();
                    display.setText(process + btnMinus.getText());
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (display2.getText().toString() == ""){
                    process = display.getText().toString();
                    display.setText(process + btnMul.getText());
                }else{
                    process = display2.getText().toString();
                    display.setText(process + btnMul.getText());
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = display.getText().toString();
                display.setText(process + btnEqual.getText());
                process = process.replaceAll("x","*");
                process = process.replaceAll("÷","/");
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                Scriptable scriptable = rhino.initStandardObjects();
                result = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                result = result.substring(0, result.length() -2);
                display2.setText(result);
            }
        });

    }
}
