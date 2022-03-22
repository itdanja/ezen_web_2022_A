package Day15;

public class SumThread extends Thread {
	// 필드 
	private long sum;
	// 메소드 
	public long getsum() {
		return sum;
	}
	// 메소드
	public void setSum( long sum) {
		this.sum = sum;
	}
	// 병렬처리
	@Override
	public void run() {
		for( int i = 1 ; i<=100 ; i++) {
			sum+=i; // 1부터 100까지 누적합계
		}
	}
	
}
