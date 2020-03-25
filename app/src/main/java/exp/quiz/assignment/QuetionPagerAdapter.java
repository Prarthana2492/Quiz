package exp.quiz.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class QuetionPagerAdapter extends PagerAdapter {

    Context context;
    LayoutInflater mLayoutInflater;
    List<QuetionAnswer> qns_ans_list=new ArrayList<>();


    QuetionPagerAdapter(Context context,List<QuetionAnswer> qns_ans_list){
        this.context=context;
        this.qns_ans_list=qns_ans_list;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return qns_ans_list.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.qns_lyt, container, false);


        TextView quetion = itemView.findViewById(R.id.quetion);

        RadioButton a = itemView.findViewById(R.id.a);
        RadioButton b = itemView.findViewById(R.id.b);
        RadioButton c = itemView.findViewById(R.id.c);
        RadioButton d = itemView.findViewById(R.id.d);
        quetion.setText(qns_ans_list.get(position).quetion);

        a.setText(qns_ans_list.get(position).a);
        b.setText(qns_ans_list.get(position).b);
        c.setText(qns_ans_list.get(position).c);
        d.setText(qns_ans_list.get(position).d);

        container.addView(itemView);


        return itemView;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);

    }
}