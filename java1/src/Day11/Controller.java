package Day11;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class Controller {
	// 0. �Խù� ����Ʈ  [ ��� �Խù��� ��� ����Ʈ ] 
	public static ArrayList<Board> boadlist = 
			new ArrayList<>();
	//1.��ϸ޼ҵ�
	public static void boardlist() {}
	//2.����޼ҵ� 
	public static void write(String ���� , String ���� , String �ۼ��� , String ��й�ȣ ) {
		Board board = new Board(����, ����, ��й�ȣ, �ۼ���); // 1. ��üȭ[ ������ 4�� --> 1�� ��ü ]
		boadlist.add(board); // 2. ����Ʈ�� ����
		save(); // 3. ���Ͽ� ���� 
	}
	//3.����޼ҵ�
	public static void view() {}
	//4.�����޼ҵ�
	public static void update() {}
	//5.�����޼ҵ� 
	public static void delete() {}
	//6.��۾���޼ҵ� 
	public static void replywrite() {}
	//7.�Խù�����޼ҵ� 
	public static void save() { 		// ����Ʈ�� ��� �Խù��� ���Ͽ� ����
		try {
			// 1. ������� Ŭ���� 
			FileOutputStream outputStream = new FileOutputStream("D:/java/�Խù�����.txt");
			// 2. ���Ͽ� �ۼ��� ���� [ ����Ʈ�� ��ü 1���� = ���پ� = �Խù� 1���� = ��ü 1���� ]
			for( Board board : boadlist ) { // , : �ʵ屸�п�     \n : ��ü���п�
				String �ۼ����� = board.getTitle() +","+board.getContent()+","+
						board.getPassword()+","+board.getWriter()+","+
						board.getViewcount()+","+board.getDate()+"\n";
				// 3. ����[���ڿ�] -> ����Ʈ�� ��ȯ  [ �ܺ����(��Ʈ��) : ��Ŵ��� : ����Ʈ ]
				outputStream.write( �ۼ�����.getBytes() ); // 4. �������� [ write() ]
			}
		}
		catch( Exception e ) {  System.err.println(" �˸�]] �������� ����( �����ڿ��Թ��� )"); }
	}
	//8.�Խù��ҷ�����޼ҵ� 
	public static void load() {
		
	}
}











