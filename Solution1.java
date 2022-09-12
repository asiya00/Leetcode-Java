import java.util.*;

class Avenger{
	String name;
	int sequence;

	public Avenger(String name, int sequence){
		this.name = name;
		this.sequence = sequence;
	}
}

class Multiverse{
	HashMap<String, ArrayList<Avenger>> avengers = new HashMap<>();

	public String visitVerse(String verseName, Avenger avenger){
		if (!avengers.containsKey(verseName)){
			Avenger a = new Avenger(avenger.name, avenger.sequence);
			ArrayList<Avenger> al = new ArrayList<Avenger>();
			avengers.put(verseName, al);
			avengers.get(verseName).add(a);
		}else if (avengers.containsKey(verseName)){
			// ArrayList<String> avenger_name = new ArrayList<String>();
			ArrayList<Avenger> values = avengers.get(verseName);
			for (Avenger l: values){
				if (avenger.name.equals(l.name)){
					if (avenger.sequence == l.sequence){
						return "You are in your universe";
					}
					else{
						avengers.get(verseName).add(avenger);
						return "Welcome to Multiverse";
					}
				}
			}
			else {
				avengers.get(verseName).add(avenger);
				return "Welcome to Multiverse";
			}
		}
		return "Welcome to Multiverse";
	}

	public ArrayList<String> avengersAssemble(String verseName){
		ArrayList<String> avenger_n = new ArrayList<>();
		if (avengers.containsKey(verseName)){
			for (Avenger k: avengers.get(verseName)){
				avenger_n.add(k.name);
			}
		}
		return avenger_n;
	}
}

class Solution1{
	public static void main(String[] args) {
		Avenger a1 = new Avenger("Falcon", 23);
		Avenger a2 = new Avenger("Winter Soldier", 2);
		Avenger a3 = new Avenger("Black Panther", 100);
		Multiverse obj = new Multiverse();
		String temp = obj.visitVerse("Earth B12", a1);
		System.out.println(temp);
		temp = obj.visitVerse("Earth 23", a2);
		System.out.println(temp);
		temp = obj.visitVerse("Earth N91", a3);
		System.out.println(temp);
		ArrayList<String> ans = new ArrayList<>();
		ans = obj.avengersAssemble("Earth B12");
		for (String i: ans){
			System.out.println(i);
		}
	}
}