package student;
import java.util.*;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ScoreList<T extends ArrayList>{
    T studentData;

    public ScoreList(T t2){
    	this.studentData = t2;
    }

    public <T> void addElement(T name){
		this.studentData.add(name);
	}
	public void removeElement(int index){
		this.studentData.remove(index);
	}
	public Object getElement(int index){
		Object s = this.studentData.get(index);
		return s;
	}

    public String averageValues(){
    	double total = 0;
    	for (Object i: this.studentData){
    		Double val = ((Number) i).doubleValue();;
    		total += val;
    	}
    	double avg = total/this.studentData.size();
    	BigDecimal bd = new BigDecimal(avg).setScale(2, RoundingMode.HALF_UP);
    	DecimalFormat df = new DecimalFormat("0.00");
    	avg = bd.doubleValue();
	    String a = df.format(avg);
	    // Double ans = new Double(a);
    	return a;
    }


    
}
