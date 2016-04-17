package trial.organizer.contact.room_allotment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    //@Override
    Map<String,Integer> mapping=new HashMap<String,Integer>();
    EditText nametxt,pref1txt,pref2txt,pref3txt,pref4txt,pref5txt;
    Button subbttn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nametxt=(EditText)findViewById(R.id.Name_input);
        pref1txt=(EditText)findViewById(R.id.editText);
        pref2txt=(EditText)findViewById(R.id.editText2);
        pref3txt=(EditText)findViewById(R.id.editText3);
        pref4txt=(EditText)findViewById(R.id.editText4);
        pref5txt=(EditText)findViewById(R.id.editText5);
        subbttn=(Button)findViewById(R.id.button);
        String Name=nametxt.getText().toString();
        String pref1=nametxt.getText().toString();
        String pref2=nametxt.getText().toString();
        String pref3=nametxt.getText().toString();
        String pref4=nametxt.getText().toString();
        String pref5=nametxt.getText().toString();
        /*if(mapping[Name]==0){
            mapping[Name]=1;
        }
        if(mapping[pref1]==0){
            mapping[pref1]=2;
        }
        if(mapping[pref2]==0){
            mapping[pref2]=3;
        }
        if(mapping[pref3]==0){
            mapping[pref3]=4;
        }
        if(mapping[pref4]==0){
            mapping[pref4]=5;
        }
        if(mapping[pref5]==0){
            mapping[pref5]=6;
        }*/
    }
}
