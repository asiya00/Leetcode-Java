import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.math.BigDecimal;

class Solution{
	public String output(int capacity, int stops, List<String> listOfInputStrings, String query)
    {
        String outstring="";
        String q;
		int id=0;
		if (query.length() > 1){
			String[] query1 = query.split(", ");
			q = query1[0];
			id = Integer.parseInt(query1[1]);
		} else{
			q = query;
		}
		switch(q){
			case "1":
				int inbus = 0;
				int outbus = 0;
				for (int i=0; i<stops; i++){
					String[] in = listOfInputStrings.get(i).split(" ");
					for (String l:in){
						int a = Integer.parseInt(l);
						if (a > 0){
							inbus += 1;
						}
						else{
							outbus += 1;
						}
					} 
        		}
        		outstring += inbus+" passengers got on the bus and "+outbus+" passengers got out of the bus";
        		break;

			case "2":
				double d1 = (capacity*25);
				double d2 = (capacity*50);
				double d3 = capacity;
				double price25 = 0;
				double price50 = 0;
				double priceabove50 = 0;
				int num25 = 0;
				int num50 = 0;
				int numabove50 = 0;
				int temp=0;
				for (int i=0; i<stops; i++){
					int inp = 0;
					int o = 0;
					String[] k = listOfInputStrings.get(i).split(" ");
					for (int j=0; j<k.length; j++){
						int a = Integer.parseInt(k[j]);
						if (a>0){
							inp += 1;
						} else{
							o += 1;
						}
					}
					temp = (temp+inp)-o;
					// System.out.println(temp);
					if (temp<=Math.ceil(d1/100)){
						num25 += inp;
					} else if (temp>Math.ceil(d1/100) && temp<=Math.ceil(d2/100)){
						num50 += inp;
					} else if(temp>Math.ceil(d2/100)){
						numabove50 += inp;
					}
				}
				price25 = capacity+capacity*0.6;
				BigDecimal bd = new BigDecimal(price25).setScale(2, RoundingMode.HALF_UP);
				price25 = bd.doubleValue();
				price50 = capacity+capacity*0.3;
				BigDecimal bc = new BigDecimal(price50).setScale(2, RoundingMode.HALF_UP);
				price50 =bc.doubleValue();
				priceabove50 = capacity;
        		outstring += num25+" passengers traveled with a fare of "+price25+", "+num50+" passengers traveled with a fare of "+price50+" and "+numabove50+" passengers traveled with a fare of "+priceabove50;
				break;

			case "3":
				price25 = capacity+capacity*0.6;
				bd = new BigDecimal(price25).setScale(2, RoundingMode.HALF_UP);
				price25 = bd.doubleValue();
				price50 = capacity+capacity*0.3;
				bc = new BigDecimal(price50).setScale(2, RoundingMode.HALF_UP);
				price50 =bc.doubleValue();
				priceabove50 = capacity;
				// System.out.println("Price 25 "+price25+" Price 50 "+price50+" Price above 50 "+priceabove50);
				d1 = (capacity*25);
				d2 = (capacity*50);
				d3 = capacity;
				temp=0;
				double idprice = 0;
				// ArrayList<Double> idprice = new ArrayList<>();
				for (int i=0; i<stops; i++){
					int inp = 0;
					int o = 0;
					String[] k = listOfInputStrings.get(i).split(" ");
					boolean count = false;
					for (int j=0; j<k.length; j++){
						int a = Integer.parseInt(k[j]);
						if (a==id){
							count = true;
						}
						if (a>0){
							inp += 1;
						} else{
							o += 1;
						}
					}
					// System.out.println(temp+" "+inp+" "+o);
					temp = (temp+inp)-o;
					// System.out.println(Math.ceil(d1/100)+" "+Math.ceil(d2/100));
					if (temp<=Math.ceil(d1/100) && count){
						idprice += price25;
					} else if (temp>Math.ceil(d1/100) && temp<=Math.ceil(d2/100) && count){
						idprice += price50;
					} else if (count){
						idprice += priceabove50;
					}
				}
				System.out.println(idprice);
        		outstring+="Passenger "+id+" spent a total fare of "+idprice;
				break;

			case "4":
				int count = 0;
				for (int i=0; i<stops; i++){
					String[] k = listOfInputStrings.get(i).split(" ");
					for (int j=0; j<k.length; j++){
						int a = Integer.parseInt(k[j]);
						if (a==id){
							count += 1;
							break;
						}
					}
				}
        		outstring+="Passenger "+id+" has got on the bus for "+count+" times";
        		break;

			case "5":
				boolean gotin = false;
				for (int i=0; i<stops; i++){
					String[] k = listOfInputStrings.get(i).split(" ");
					for (int j=0; j<k.length; j++){
						int a = Integer.parseInt(k[j]);
						if (a==id){
							gotin = true;
						}
						if (a == -id){
							gotin = false;
						} 
					}
				}
				if (gotin == true){
					outstring += "Passenger "+id+" was inside the bus at the end of the trip";
				}
				else{
					outstring += "Passenger "+id+" was not inside the bus at the end of the trip";
				}
				break;

			default:
				outstring = "";

		}
		return  outstring;
    }
}

class Busprob{
	public static void main(String[] args) {
		List<String> listOfInputs = new ArrayList<>();
		Solution s = new Solution();
		int capacity=0;
        int stops=0;
        capacity=30;
            stops=12;
            listOfInputs.add("+100 +101 +102 +103 +104 +105 +106 +107 +108 +109");
            listOfInputs.add("+110 +111 +112 +113 +114 +115 +116 +117 +118 +119 -104 -107");
            listOfInputs.add("+120 +121 +122 +123 +124 +125 -101 -111 -115 -112 -102");
            listOfInputs.add("+126 +127 +128 +129 +130 +131 +132 +133 -120 -110");
            listOfInputs.add("+134 +135 +136 +137 +138 -100 -103");
            listOfInputs.add("+101 +104 +139 +140 -105 -106 -108 -109");
            listOfInputs.add("-113 -114 -116 -117 -118 -119 -121 -122 -123 -124 -125 -126 -127 -128 -129 -130 -131 -132 -133 -134 -135 -136 -137");
            listOfInputs.add("+141 +142");
            listOfInputs.add("+143 +144 +121 +122 +123 +124 +125 +126 -101 -139 -138 -104");
            listOfInputs.add("+145 +146 +147 +148 +149 -143 -144 -124 -125 -126");
            listOfInputs.add("+150 +151 +152 +153 +154 +155 +101 +125 +124 +104 -123 -145 -146");
            listOfInputs.add("+156 -101 -147 -148 -149 -150 -154");
            String query="2";
        String actual=s.output(capacity, stops, listOfInputs, query);
        System.out.println(actual);
        
        System.out.println(actual.hashCode());
	}
}