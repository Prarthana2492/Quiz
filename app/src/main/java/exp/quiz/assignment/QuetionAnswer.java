package exp.quiz.assignment;


import org.json.JSONException;
import org.json.JSONObject;


public class QuetionAnswer extends JSONObject {

    String quetion;
    String a;
    String b;


    public String getQuetion() {
        return quetion;
    }

    public void setQuetion(String quetion) {
        this.quetion = quetion;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    String c;
    String d;
    public QuetionAnswer(String quetion,String a,String b,String c,String d)throws JSONException {
       this.quetion=quetion;
       this.a=a;
       this.b=b;
       this.c=c;
       this.d=d;
    }
}
