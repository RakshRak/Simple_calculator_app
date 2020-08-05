package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.renderscript.Script;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Stack;

import static android.util.Log.d;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button zero;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button div;
    private Button mul;
    private Button clear;
    private Button equal;
    private Button percent;
    private Button close;
    private Button open;
    private Button dot;
    private Switch change;
    private TextView display;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    change=(Switch)findViewById(R.id.change);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eigth);
        nine = (Button) findViewById(R.id.nine);
        add = (Button) findViewById(R.id.plus);
        sub = (Button) findViewById(R.id.minus);
        div = (Button) findViewById(R.id.div);
        mul = (Button) findViewById(R.id.mul);
        clear = (Button) findViewById(R.id.clear);
        equal = (Button) findViewById(R.id.equals);
        display = (TextView) findViewById(R.id.result);
        open = (Button) findViewById(R.id.open);
        close = (Button) findViewById(R.id.close);
        dot = (Button) findViewById(R.id.dot);
        percent = (Button) findViewById(R.id.percent);


        change.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    equal.setBackgroundColor(Color.RED);
                }
                else {
                    equal.setBackgroundColor(Color.GRAY );
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "-");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "/");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "*");
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + "(");
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + ")");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString() + ".");
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=display.getText().toString();
                Double A,B = null;
                A = Double.parseDouble(text);
                B=A*0.01;
                display.setText(Double.toString(B));
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String text=display.getText().toString();
           /* Double A,B,C = null;
                A = Double.parseDouble(String.valueOf(text.charAt(0)));
                B = Double.parseDouble(String.valueOf(text.charAt(2)));
                char b=text.charAt(1);
                switch (b){
                    case '+':C=A+B;
                    break;
                    case '-':C=A-B;
                    break;
                    case '*':C=A*B;
                    break;
                    case '/':C=A/B;
                    break;
                }
                display.setText(Double.toString(C));*/
            double answer=calculate(text);
                display.setText(Double.toString(answer));
            }
        });

    }
    public static Double calculate(String expression){
        if (expression == null || expression.length() == 0)
        {
            return null;
        }
        return calc(expression.replace(" ", ""));
    }



    public static Double calc(String expression) {
        if (expression.startsWith("(") && expression.endsWith(")")) {
            return calc(expression.substring(1, expression.length() - 1));
        }
        String[] containerArr = new String[]{expression};
        double leftVal = getNextOperand(containerArr);
        expression = containerArr[0];
        if (expression.length() == 0) {
            return leftVal;
        }
        char operator = expression.charAt(0);
        expression = expression.substring(1);
        while (operator == '*' || operator == '/') {
            containerArr[0] = expression;
            double rightVal = getNextOperand(containerArr);
            expression = containerArr[0];
            if (operator == '*') {
                leftVal = leftVal * rightVal;
            } else {
                leftVal = leftVal / rightVal;
            }
            if (expression.length() > 0) {
                operator = expression.charAt(0);
                expression = expression.substring(1);
            } else { return leftVal;
            }
        }
        if (operator == '+')
        {
            return leftVal + calc(expression);
        }
        else {
            return leftVal - calc(expression);
        }
    }
    private static double getNextOperand(String[] exp){
        double res;
        if (exp[0].startsWith("(")) {
            int open = 1; int i = 1;
            while (open != 0) {
                if (exp[0].charAt(i) == '(') {
                    open++;
                } else if (exp[0].charAt(i) == ')') {
                    open--;
                } i++;
            } res = calc(exp[0].substring(1, i - 1));
            exp[0] = exp[0].substring(i);
        } else {
            int i = 1;
            if (exp[0].charAt(0) == '-')
            {
                i++;
            }
            while (exp[0].length() > i && isNumber((int) exp[0].charAt(i)))
            {
                i++;
            }
            res = Double.parseDouble(exp[0].substring(0, i));
            exp[0] = exp[0].substring(i);

        } return res;
    }
    private static boolean isNumber(int c) {
        int zero = (int) '0';
        int nine = (int) '9';
        return (c >= zero && c <= nine) || c =='.';
    }


}

