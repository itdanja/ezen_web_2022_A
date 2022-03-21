package Day14;

import java.util.Scanner;

public class Day14_플레이어 {
	
	// 예제  [ 1. 소리재생/중지 2.영상재생/중지 ]
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // 입력객체
		
		boolean soundsw = true; // 현재 소리 재생 상태 
		boolean moviesw = true; // 현재 영상 재생 상태
		while(true) {
			System.out.print("1.소리재생 2.영상재생 : ");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { // 1
				
				Sound sound = new Sound(); // 빈객체 생성
				
				if( soundsw ) { // 소리 재생 
					sound.soundstop( true ); // 소리 실행 
					sound.start(); // 스레드 실행 
					// sound.stop = false; // 소리종료
						// stop 필드에 직접 변경시 -> 바로 종료
					soundsw = false; // 실행중 상태 기록 
				}
				else {
					sound.soundstop( false ); // 소리 중지
					// sound.stop = true; // 소리재생 
					soundsw = true; // 실행종료 상태 기록
				}
			}
			else if( ch == 2 ) {
				Movie movie = new Movie();
				if( moviesw ) {
					movie.moviestop(true); // 제어 변경 
					movie.start(); // 스레드 실행 
					moviesw = false; // 상태 변경 
				}
				else {
					movie.moviestop(false); // 제어 변경
					moviesw = true; // 상태 변경 
				}
			}
		}
	}
}








