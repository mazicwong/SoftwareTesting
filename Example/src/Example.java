
public class Example {
	int a;
    int b;
    int c;

    public Example(int m, int n, int i){
		a = m;
        b = n;
        c = i;
    }

	public int A(int a){
		if(a>8){
			a=B(a-18);
			return a;
		}else{
			a=B(a);
			return a;
		}
	};
	
	//
	public int B(int b){
		if(b>=0){
			b = b+3;
			return b;
		}else{
			b = b-3;
			return b;
		}
	};
	
	public int C(int c ){
		c=B(c);
		return c;
	}
	
}
