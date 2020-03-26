package exp.quiz.assignment;

import org.json.JSONException;
import org.json.JSONObject;

public class QuetionAnswer extends JSONObject {
    String quetion;
    String a;
    String b;


    String c;
    String d;
    String answer;
    public QuetionAnswer(String quetion,String a,String b,String c,String d,String answer)throws JSONException {
       this.quetion=quetion;
       this.a=a;
       this.b=b;
       this.c=c;
       this.d=d;
       this.answer=answer;
    }
}
