package Day11;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Board {
	// 1. 필드
	private String title;
	private String content;
	private String password;
	private String writer;
	private int viewcount;
	private String date;
	private ArrayList<Reply> replylist 
					= new ArrayList<>();
	// 2. 생성자
		// 1. 빈생성자
	public Board() {}
		// 2. 게시물등록 시 사용되는 생성자 [ 날짜 자동주입 ] 
	public Board(String title, String content, String password, String writer) {
		this.title = title;
		this.content = content;
		this.password = password;
		this.writer = writer;
			// 날짜 클래스 : Date 클래스 ( java.util )
		Date date = new Date(); // 날짜 객체 생성 
			// 날짜 형식 클래스 : SimpleDateFormat 클래스 ( java.text )
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
										// y:연도 M:월 d:일 h:시 m:분 s:초 
		this.date = format.format(date);// 객체명.format( 날짜 ) ; // 해당 날짜가 format 설정한 패턴으로 문자형으로 변환
	}
		// 3. 풀생성자
	public Board(String title, String content, String password, String writer, int viewcount, String date,
			ArrayList<Reply> replylist) {
		this.title = title;
		this.content = content;
		this.password = password;
		this.writer = writer;
		this.viewcount = viewcount;
		this.date = date;
		this.replylist = replylist;
	}
	// 3. 메소드 [ private 필드 사용시 getter or setter 선언(자동완성) ]
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<Reply> getReplylist() {
		return replylist;
	}
	public void setReplylist(ArrayList<Reply> replylist) {
		this.replylist = replylist;
	}

}






