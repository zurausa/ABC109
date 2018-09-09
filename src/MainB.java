import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MainB {
	static FastScanner sc;
	static Map<String, Integer> wordMap = new HashMap<>();
	public static void main(String[] args){
		sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		out.println(solve());
		out.flush();
	}

	static String solve(){
		int N = sc.nextInt();
		String end = "";
		String word;
		String res = "Yes";
		for(int i=0;i<N;i++){
			word = sc.next();
			if(word.substring(0,1).equals(end)||end == ""){
				end = word.substring(word.length()-1,word.length());
				if(wordMap.containsKey(word)){
					res="No";
					break;
				}else{
					wordMap.put(word, 1);
				}
			}else{
				res="No";
				break;
			}
		}
		return res;
	}
}

