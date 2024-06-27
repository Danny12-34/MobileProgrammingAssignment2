package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.renderscript.Script;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.*;
import javax.script.Context;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView resultTv,solutionTv;
    MaterialButton buttonC,buttonBlacketOpen,getButtonBlacketClose;
    MaterialButton buttonDivision,buttonMultilpication,buttonplus,buttonMinus,buttonEqual;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAC,buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv =findViewById(R.id.solution_tv);

        assignId(buttonC,R.id.button_C);
        assignId(buttonBlacketOpen,R.id.button_Open_blacket);
        assignId(getButtonBlacketClose,R.id.button_Close_blacket);
        assignId(buttonDivision,R.id.button_division);
        assignId(buttonAC,R.id.button_AC);
        assignId(button0,R.id.button_0);
        assignId(buttonDot,R.id.button_dot);
        assignId(buttonEqual,R.id.button_equal);
        assignId(button1,R.id.button_1);
        assignId(button2,R.id.button_2);
        assignId(button3,R.id.button_3);
        assignId(buttonMinus,R.id.button_neg);
        assignId(button4,R.id.button_4);
        assignId(button5,R.id.button_5);
        assignId(button6,R.id.button_6);
        assignId(buttonplus,R.id.button_add);
        assignId(button7,R.id.button_7);
        assignId(button8,R.id.button_8);
        assignId(button9,R.id.button_9);
        assignId(buttonMultilpication,R.id.button_mult);


    }

    void assignId(MaterialButton btn,int id){

        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if(buttonText.equals("AC")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        if (buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }
        if (buttonText.equals("C")){
            dataToCalculate =dataToCalculate.substring(0,dataToCalculate.length()-1);
        }else {
            dataToCalculate = dataToCalculate+buttonText;
        }
        solutionTv.setText(dataToCalculate);
        String finalResult=getresult(dataToCalculate);

        if (!finalResult.equals("Error")){
            resultTv.setText(finalResult);
        }
    }
    String getresult(String data) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            String finalResult = (String) engine.eval(data); // Evaluate the data as a JavaScript expression
            finalResult = finalResult.replaceAll("\\.0*$", ""); // Remove trailing ".0" (any number of zeros)
            return finalResult;
        } catch (ScriptException e) {
            return "Error: Script evaluation failed: " + e.getMessage();
        } catch (Exception e) {
            // Handle other unexpected exceptions
            return "Error: Unexpected error: " + e.getMessage();
        }
    }
}