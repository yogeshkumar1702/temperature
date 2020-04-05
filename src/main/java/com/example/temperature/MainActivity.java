package com.example.temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button calculate;
    TextView result;
    RadioGroup rg;
    RadioButton ftoc,ctof;
    EditText input;

    enum radio_buttons{
        CELSIUS_TO_FAHRENHEIT,
        FARENHEIT_TO_CELSIOUS
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        ftoc = findViewById(R.id.ftoc);
        ctof = findViewById(R.id.ctof);
        input = findViewById(R.id.input_text);
        rg = findViewById(R.id.radio_group);
        input.setText("0");

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(get_radio_button_status() == radio_buttons.CELSIUS_TO_FAHRENHEIT){
                    double input_value = Float.parseFloat(input.getText().toString());
                    input_value = 1.8*input_value + 32;
                    result.setText(input_value+" F");

                }else{
                    double input_value = Float.parseFloat(input.getText().toString());
                    input_value = (input_value - 32)/.5556;
                    result.setText(input_value+" C");
                }
            }
        });
    }

    radio_buttons get_radio_button_status(){
        int selectedId = rg.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        if(radioButton.getText().toString().equals("Celsius to Farenheit")){
            return radio_buttons.CELSIUS_TO_FAHRENHEIT;
        }else{
            return radio_buttons.FARENHEIT_TO_CELSIOUS;
        }
    }

}
