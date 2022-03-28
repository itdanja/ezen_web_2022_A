package Day19;

import java.util.Hashtable;
import java.util.Scanner;

public class Day19_4 {
	
	public static void main(String[] args) {
		
		// p.747
		// 1. Hashtable 클래스 객체 선언 
		Hashtable<String, String> map = new Hashtable<>();
		// 2. map 객체에 추가 
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
			// key : 아이디  // value : 비밀번호
		Scanner scanner = new Scanner(System.in); 
		
		while( true ) { // 무한루프 
			System.out.print("아이디 : ");   	String id = scanner.next();
			System.out.print("비밀번호 : ");	String password = scanner.next();
			// 만약에 map객체내 해당 key 가 존재하면 [ .containsKey(키) : map객체내 해당 키가 존재하면 true / 아니면 false ] 
			if( map.containsKey(id) ) { // 만약에 입력한 id가 map객체내 key로 존대하면 
				if( map.get(id).equals(password) ) { //만약에 key 이용한 값 호출해서 입력한 패스워드와 동일하면
					System.out.println(" *로그인 되었습니다. *");
				}else { System.out.println(" 입력하신 비밀번호가 일치하지 않습니다. "); }
			}else { System.out.println(" 입력하신 아이디가 존재하지 않습니다. "); }
		}
	}

}






