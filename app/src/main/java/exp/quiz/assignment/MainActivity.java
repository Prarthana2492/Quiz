package exp.quiz.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<QuetionAnswer> qns_ans_list=new ArrayList<>();
    static Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next=findViewById(R.id.next);
        Button pre=findViewById(R.id.Prev);
        submit=findViewById(R.id.submit);
        MainActivity.submit.setVisibility(View.GONE);

        String jsonLocation = ReadJson.getAssetJsonData(this);
        gettingdata(jsonLocation);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new QuetionPagerAdapter(this,qns_ans_list));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                if (viewPager.getCurrentItem()==qns_ans_list.size()-1){
                    MainActivity.submit.setVisibility(View.VISIBLE);
                }else {
                    MainActivity.submit.setVisibility(View.GONE);
                }
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                MainActivity.submit.setVisibility(View.GONE);

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        final TextView text_desctxt;

                        final Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.question_layout);
                        text_desctxt =  dialog.findViewById(R.id.text_desc);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.setCancelable(true);

                        text_desctxt.setText(QuetionPagerAdapter.scoreMap.size() + "  Out of  " + qns_ans_list.size());
                            dialog.show();

                    }



                });

            }

    public void gettingdata(String data){
    try {
        JSONArray jsonArray=new JSONArray(data);
        for (int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            QuetionAnswer quetionAnswer=new QuetionAnswer(jsonObject.getString("Question"),jsonObject.getString("a"),jsonObject.getString("b"),jsonObject.getString("c"),jsonObject.getString("d"),jsonObject.getString("Answer"));
            qns_ans_list.add(quetionAnswer);


        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
}

}
