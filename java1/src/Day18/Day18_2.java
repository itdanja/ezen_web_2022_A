package Day18;

import java.util.Vector;

public class Day18_2 {
	
	
	public static void main(String[] args) {
		
		// p.730
		//		 ArrayList 		vs Vector
		//동기화	    X		   		 O 
		//스레드	 싱글스레드(main)	  멀티스레드( Thread , Runnable )
		
		// Vector 클래스 
		// 1. Vector 리스트객체 선언
		Vector<Board> list = new Vector<>();
		// 2. 리스트객체내 추가 
			// 1. 리스트내 객체 바로 추가 new : 객체 메모리할당
		list.add( new Board("제목1", "내용1", "글쓴이1") );
			// 2. 객체 생성후 리스트내 객체 추가 
		Board board = new Board("제목2","내용2","글쓴이2");
		list.add( board );
		list.add( new Board("제목3", "내용3", "글쓴이3") );
		list.add( new Board("제목4", "내용4", "글쓴이4") );
		list.add( new Board("제목5", "내용5", "글쓴이5") );
		System.out.println(" 확인 : " + list  );
		// 3. 검색
		System.out.println(" 객체 검색 : " + list.contains(board) );
		System.out.println(" 객체 검색 위치 : " + list.indexOf(board) );
		// 4. 삭제 [ 삭제된 인덱스 뒤로 한칸씩 당기기 ]
		list.remove(2); System.out.println(" 2번 인덱스 삭제 후 :"+list);
		list.remove(2); System.out.println(" 2번 인덱스 삭제 후 :"+list);
		// * 반복문이용한 리스트객체내 모든 객체 출력 
		System.out.println("----------------------------");
		System.out.println("제목\t내용\t작성자");
		for( int i = 0 ; i<list.size() ; i++ ) {
			Board temp = list.get(i); // i번째 인덱스의 객체 호출 
			System.out.println( temp.제목+"\t"+temp.내용+"\t"+temp.작성자);
		}
		// * 반복문2
		System.out.println("----------------------------");
		System.out.println("제목\t내용\t작성자");
		for( Board temp : list  ) {
			System.out.println( temp.제목+"\t"+temp.내용+"\t"+temp.작성자);
		}
		
		
	}

}











