package student;
import java.util.*;

public class StudentList<T1 extends ArrayList>{
	T1 studentData;

	public StudentList(T1 t1){
		this.studentData = t1;
	}

	public <T1> void addElement(T1 name){
		this.studentData.add(name);
	}
	public void removeElement(int index){
		this.studentData.remove(index);
	}
	public Object getElement(int index){
		Object s = this.studentData.get(index);
		return s;
	}
    
    public String beginsWith(String character){
    	String ans = "";
    	for (Object l: this.studentData){
    		if (l.toString().toLowerCase().startsWith(character.toLowerCase())){
    			ans += l.toString() +"\n";
    		}
    	}
    	return ans.strip();
    }

    public String bloodGroupOf(String[] bgs, String bg){
    	String ans = "";
    	for (int i=0; i<bgs.length; i++){
    		if (bgs[i].equals(bg)){
    			ans += this.studentData.get(i).toString() +"\n";
    		}
    	}
    	return ans.strip();
    }

    public int thresholdScore(int threshold){
    	int count = 0;
    	for (Object l: this.studentData){
    		int val = (int) l;
    		if (val >= threshold){
    			count += 1;
    		}
    	}
    	return count;
    }
}
