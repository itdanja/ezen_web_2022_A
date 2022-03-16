package Day11;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class Controller {
	// 0. 게시물 리스트  [ 모든 게시물을 담는 리스트 ] 
	public static ArrayList<Board> boadlist = 
			new ArrayList<>();
	//1.목록메소드
	public static void boardlist() {}
	//2.쓰기메소드 
	public static void write(String 제목 , String 내용 , String 작성자 , String 비밀번호 ) {
		Board board = new Board(제목, 내용, 비밀번호, 작성자); // 1. 객체화[ 변수가 4개 --> 1개 객체 ]
		boadlist.add(board); // 2. 리스트에 저장
		save(); // 3. 파일에 저장 
	}
	//3.보기메소드
	public static void view() {}
	//4.수정메소드
	public static void update() {}
	//5.삭제메소드 
	public static void delete() {}
	//6.댓글쓰기메소드 
	public static void replywrite() {}
	//7.게시물저장메소드 
	public static void save() { 		// 리스트내 모든 게시물을 파일에 저장
		try {
			// 1. 파일출력 클래스 
			FileOutputStream outputStream = new FileOutputStream("D:/java/게시물파일.txt");
			// 2. 파일에 작성할 내용 [ 리스트내 객체 1개씩 = 한줄씩 = 게시물 1개씩 = 객체 1개씩 ]
			for( Board board : boadlist ) { // , : 필드구분용     \n : 객체구분용
				String 작성내용 = board.getTitle() +","+board.getContent()+","+
						board.getPassword()+","+board.getWriter()+","+
						board.getViewcount()+","+board.getDate()+"\n";
				// 3. 내용[문자열] -> 바이트열 변환  [ 외부통신(스트림) : 통신단위 : 바이트 ]
				outputStream.write( 작성내용.getBytes() ); // 4. 내보내기 [ write() ]
			}
		}
		catch( Exception e ) {  System.err.println(" 알림]] 파일저장 실패( 관리자에게문의 )"); }
	}
	//8.게시물불러오기메소드 
	public static void load() {
		
	}
}











