/*
 *     Copyright 2023 ESIGELEC SHI Yufei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.calculatorv1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    //We need to import the description of our widgets in the activity_main.xml
    EditText XmlNumber1;
    EditText XmlNumber2;
    Button XmlPlus;
    Button XmlMinus;
    Button XmlMultiply;
    Button XmlDivide;
    TextView XmlResult;
    //the main java programme will take the description in Xml file and give them new values
    @SuppressLint("MissingInflatedId") // this is relative to XmlNumber2 = findViewById(R.id.XmlNumber2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //fetch the Xml description in the app/res/layout/activity_main.xml
        //fetch the editText in Xml description by its id
        //XmlNumber1 and XmlNumber2 are the editText name in our MainActivity.java
        XmlNumber1 = findViewById(R.id.XmlNumber1);
        XmlNumber1.setText("Number 1");
        XmlNumber2 = findViewById(R.id.XmlNumber2);
        XmlNumber2.setText("Number 2");
        //fetch the XmlResult in Xml description, if not, the following will show null pointer exception because it can not find the XmlResult by id
        XmlResult = findViewById(R.id.XmlResult);
        XmlResult.setText("The calculation result");
        //fetch the buttons in Xml description by its id qnd create different listener
        //XmlPlus, XmlMinus, XmlMultiply, XmlDivide are the Button name in our MainActivity.java
        //each click on different button will trigger an operation and show the result in textView called XmlResult
        XmlPlus = findViewById(R.id.XmlPlus);
        XmlPlus.setOnClickListener(new View.OnClickListener() { //do not need to import new library
            @Override
            public void onClick(View view) {
                //Before we get the string of EditText, but now we need Double type value to do the caulculation
                //double num1 = XmlNumber1.getText().toString();
                //the following one line is just to try the button works
                //XmlResult.setText("plus");
                //convert the string in XmlNumber1 to double
                //should we declare 3 global variables or just create local variables here?
                double number1 = Double.parseDouble(XmlNumber1.getText().toString());
                double number2 = Double.parseDouble(XmlNumber2.getText().toString());
                double result = number1 + number2;
                //i have to use NumberFormat in java to show the double result in the TextView
                NumberFormat nm = NumberFormat.getNumberInstance();
                XmlResult.setText(nm.format(result));
                //XmlResult.setText(result);
            }
        });
        XmlMinus = findViewById(R.id.XmlMinus);
        XmlMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the following click action is basically the copy of previous plus method
                double number1 = Double.parseDouble(XmlNumber1.getText().toString());
                double number2 = Double.parseDouble(XmlNumber2.getText().toString());
                double result = number1 - number2;
                NumberFormat nm = NumberFormat.getNumberInstance();
                XmlResult.setText(nm.format(result));
                //XmlResult.setText("Minus");
            }
        });
        XmlMultiply = findViewById(R.id.XmlMultiply);
        XmlMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number1 = Double.parseDouble(XmlNumber1.getText().toString());
                double number2 = Double.parseDouble(XmlNumber2.getText().toString());
                double result = number1 * number2;
                NumberFormat nm = NumberFormat.getNumberInstance();
                XmlResult.setText(nm.format(result));
                //XmlResult.setText("multiply");
            }
        });
        XmlDivide = findViewById(R.id.XmlDivide);
        XmlDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number1 = Double.parseDouble(XmlNumber1.getText().toString());
                double number2 = Double.parseDouble(XmlNumber2.getText().toString());
                double result = number1 / number2;
                NumberFormat nm = NumberFormat.getNumberInstance();
                XmlResult.setText(nm.format(result));
                //XmlResult.setText("divide");
            }
        });
    }
}