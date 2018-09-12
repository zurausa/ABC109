import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainC {
	static FastScanner sc;
	public static void main(String[] args){
		sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		out.println(solve());
		out.flush();
	}

	static int solve(){
		int N = sc.nextInt();
		int X = sc.nextInt();
		List<Integer> distList = new ArrayList<>();
		int dist;
		for(int i=0;i<N;i++){
			dist = Math.abs(sc.nextInt() - X);
			distList.add(dist);
		}
		int gcd = distList.get(0);
		for(int i=1;i<distList.size();i++){
			gcd = getGcd(distList.get(i), gcd);
		}
		return gcd;
	}

	static int getGcd(int x,int y){
		int tmp;
		if(x<y){
			tmp = y;
			y = x;
			x = y;
		}
		while(y!=0){
			tmp = x % y;
			x = y;
			y = tmp;
		}
		return x;
	}
}
