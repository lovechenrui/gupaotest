import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	public static void main(String[] args){

		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
		map.put("11","value");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			StringBuilder res = new StringBuilder();
			while(num != 0){
				if(num % 2 == 0){
					num = (num - 2) / 2;
					res.insert(0, "3");
				}else{
					num = (num - 1) / 2;
					res.insert(0, "2");
				}
			}
			System.out.println(res);
		}
	}
	public void test(){
		IntefaceTest a = ()-> {return "a";};
		System.out.println(a.a());
	}
}
