import java.io.PrintWriter;

public class MainA {
	static FastScanner sc;
	public static void main(String[] args){
		sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		out.println(solve());
		out.flush();
	}

	static String solve(){
		if(sc.nextInt()%2!=0&&sc.nextInt()%2!=0) return "Yes";
		else return "No";
	}
}
