import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MainD {
	static FastScanner sc;
	static int H;
	static int W;
	static List<Integer> resList = new ArrayList<>();
	public static void main(String[] args){
		sc = new FastScanner();
		solve();
	}

	static void solve(){
		H = sc.nextInt();
		W = sc.nextInt();
		int HW = H*W;
		PrintWriter out = new PrintWriter(System.out);
		boolean[] matMap = new boolean[HW+1];
		boolean revFlg = false;
		for(int i=1;i<=HW;i++){
			if(!revFlg){
				matMap[i] = sc.nextInt()%2==0;
			}else{
				int tmp = i - 1;
				int l = (tmp/W+1)*W - (tmp%W);
				matMap[l] = sc.nextInt()%2==0;
			}
			if(i%W==0){
				revFlg = !revFlg;
			}
		}
		int count =0;
		for(int i=1;i<=HW;i++){
			if(!matMap[i] && i!=HW){
				getLine(i);
				matMap[i+1] = !matMap[i+1];
				count++;
			}
		}
		out.println(count);
		for(int i=0;i<resList.size();i++){
			if(i%4==3){
				out.println(resList.get(i));
			}else {
				out.print(resList.get(i));
				out.print(" ");
			}
		}
		out.flush();
		return;
	}
	static void getLine(int i){
		i--;
		int div = i/W;
		int mod = i%W;
		boolean revFlg = div%2==1;
		if(!revFlg){
			resList.add(div+1);
			resList.add(mod+1);
			if(mod+1==W){
				resList.add(div+2);
				resList.add(mod+1);
			}else{
				resList.add(div+1);
				resList.add(mod+2);
			}
		}else{
			int tmp = (div+1)*W-mod -1;
			mod = tmp%W;
			resList.add(div+1);
			resList.add(mod+1);
			if(mod==0){
				resList.add(div+2);
				resList.add(mod+1);
			}else{
				resList.add(div+1);
				resList.add(mod);
			}
		}

	}
}

class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;
    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        }else{
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }
    private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
    private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
    public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while(isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    public long nextLong() {
        if (!hasNext()) throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while(true){
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            }else if(b == -1 || !isPrintableChar(b)){
                return minus ? -n : n;
            }else{
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }
    public int nextInt() {
        long nl = nextLong();
        if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
        return (int) nl;
    }
    public double nextDouble() { return Double.parseDouble(next());}
}