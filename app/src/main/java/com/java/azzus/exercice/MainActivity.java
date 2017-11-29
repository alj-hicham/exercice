package com.java.azzus.exercice;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.JsonToken;
import android.view.View;
import android.widget.TextView;
import org.json.*;



public class MainActivity extends AppCompatActivity {
private String text;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       textView = findViewById(R.id.coding);
        textView.setMovementMethod(new ScrollingMovementMethod());

        text =" [\n" +
                "  {\n" +
                "   \"color\": \"black\",\n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 255, 255, 1], \n " +
                "   \"hex\": \"#000\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"white\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 0, 1], \n " +
                "   \"hex\": \"#FFF\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"red\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 0, 0, 1], \n " +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"blue\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 255, 1], \n" +
                "   \"hex\": \"#00F\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"yellow\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 255, 0, 1], \n" +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"green\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"secondary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 255, 0, 1], \n" +
                "   \"hex\": \"#0F0\" \n" +
                "   }\n" +
                "   } \n" +
                "  ] ";


    }



   
    public void list(View view) throws JSONException{
    try{
        JSONArray texting = (JSONArray) new JSONTokener(text).nextValue();
      String printOut="";
        for(int i =0; i< texting.length();i++) {
            JSONObject colors = texting.getJSONObject(i);
            JSONObject colorscode = colors.getJSONObject("code");
            JSONArray rgba = (JSONArray) colorscode.get("rgba");
            String code = Integer.toString(rgba.getInt(1));
            if (code.equals("255"))
             printOut = printOut + ", "+colors.get("color");
            }
            textView.setText("Color Field" +printOut);


    }catch(JSONException ex){
    ex.printStackTrace();

    }
    }
    public void count(View view)throws JSONException{

        try{
            JSONArray colors= (JSONArray) new JSONTokener(text).nextValue();
           int count=0;
           for(int i=0;i<colors.length();i++){
               JSONObject color= colors.optJSONObject(i);
               JSONObject mycolor=color.getJSONObject("code");
               JSONArray rgba = (JSONArray) mycolor.get("rgba");
               if(rgba.getInt(1) == 255){
                   count++;
               }
           textView.setText("green component number"+Integer.toString(count));
           }
        }catch(JSONException e){
            System.out.println(e);
        }


    }


}
