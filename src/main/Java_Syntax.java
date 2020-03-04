package main;

public class Java_Syntax {
	/*Java Syntax*/
	
	/*
	//Hashmap
	HashMap<Integer, String> hm1 = new HashMap<>();
	hm1.put(1, "Key1");
	hm1.put(2, "Key2");
	hm1.put(3, "Key3");
	
	for(Entry<Integer, String> s: hm1.entrySet()) {
		System.out.print(s.getKey()+" ");
		System.out.println(s.getValue());
	}
	
	
	//LinkedList
	LinkedList<Integer> ll1 = new LinkedList<>();
	ll1.add(1);
	ll1.push(2);
	ll1.add(0);
	ll1.add(5);
	
	Collections.sort(ll1);
	
	for(Integer i: ll1) {
		System.out.println(i);
	}
	
	
	//Random Numbers
	Random rand = new Random();
	for(int i =0;i<10;i++) {
		float r_num = (rand.nextFloat())*50;
		int int_num = (int)r_num;
		System.out.println("RANDOM:"+ int_num); //number between [0,50]
	}
	
	if(Character.compare('f', 'f')==0)
		System.out.println("EQUAL CHARS");
	
	if('f'=='f') {
		System.out.println("EQUAL CHARS");
	}
	
	class DINO{
		int size;
		
		DINO(){
			this.size = 5;
		}
		
		DINO(int size){
			this.size = size;
		}
		
		public String toString() {
			return "This dino has a size of:"+this.size;
		}
		
//		public int compareTo(Object o) {
//			
//			//Superclass reference, subclass behavior
//			if(o instanceof DINO) {
//				DINO casted_o = (DINO) o;
//				
//				return this.size-casted_o.size;
//				
//			}
//			else {
//				return -1;
//			}
//			
//		}
	}
	
	/*
	List<DINO> dino_list = new ArrayList<DINO>();
	dino_list.add(new DINO(10));
	dino_list.add(new DINO(50));
	dino_list.add(new DINO(3));
	dino_list.add(new DINO());
	
	System.out.println(dino_list);
	
	Collections.sort(dino_list, new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			//Superclass reference, subclass behavior
			if(o1 instanceof DINO && o2 instanceof DINO) {
				DINO casted_o1 = (DINO) o1;
				DINO casted_o2 = (DINO) o2;
				
				return casted_o1.size-casted_o2.size;
				
			}
			else {
				return -1;
			}
		}
		
	});
	*/
	
	/*
	
	System.out.println(dino_list);
	
	String s1 = "50";
	int i1 = 20;
	
	System.out.println(Integer.valueOf(s1));
	System.out.println(String.valueOf(i1));
	
	String new_str = s1+String.valueOf(i1);
	System.out.println(new_str);
	
	int new_int = i1+ Integer.valueOf(s1);
	System.out.println(new_int);
	*/
}
