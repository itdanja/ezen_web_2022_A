package Day11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Controller {
	// 0. �Խù� ����Ʈ  [ ��� �Խù��� ��� ����Ʈ ] 
	public static ArrayList<Board> boadlist = new ArrayList<>();
	
	//2.����޼ҵ� 
	public static void write(String ���� , String ���� , String �ۼ��� , String ��й�ȣ ) {
		Board board = new Board(����, ����, ��й�ȣ, �ۼ���); // 1. ��üȭ[ ������ 4�� --> 1�� ��ü ]
		boadlist.add(board); // 2. ����Ʈ�� ����
		save(); // 3. ���Ͽ� ���� 
	}
	
	//4.�����޼ҵ�
	public static boolean update( int index , String password , String title , String content ) { 
		if( password.equals( boadlist.get(index).getPassword() )) {
			// �н����尡 �����ϸ� ����ó�� 
			boadlist.get(index).setTitle(  title  );
			boadlist.get(index).setContent( content );
			save(); // ���� ������Ʈ 
			return true;
		}else {
			return false;
		}
	}
	
	//5.�����޼ҵ� 			// ���Խù���ȣ[�ε���] ���Խù��н�����
	public static boolean delete( int index , String password ) {
		if( password.equals( boadlist.get(index).getPassword() ) ) {
		// �Է¹����н����� ��   �ش� �ε��� �Խù���ȣ�� �н����� �����ϸ� 
			boadlist.remove(index);	// ����Ʈ.add(��ü) : �߰�    ����Ʈ.get(�ε���):ȣ��    ����Ʈ.remove(�ε���) : ����
			save(); // ���ϳ����� ������ ����Ʈ ������Ʈ 
			return true; // ������ ���������� 
		}else {
			return false; // ������ ���������� 
		}
	}
	
	//6.��۾���޼ҵ� 
	public static void replywrite() {}
	
	//7.�Խù� ����/���� �޼ҵ� 
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
		}catch( Exception e ) {  System.err.println(" �˸�]] �������� ����( �����ڿ��Թ��� )"); }
	}
	
	//8.�Խù��ҷ�����޼ҵ� [ ���α׷� ���� ] ����---> ����Ʈ
	public static void load() {
		try {
			FileInputStream inputStream = new FileInputStream("D:/java/�Խù�����.txt"); // 1. �����Է�Ŭ���� 
			byte[] bytes = new byte[1000]; // 2. ����Ʈ�迭 ����
			inputStream.read( bytes ); // 3. ��� ����Ʈ �о�ͼ� ����Ʈ�� ���� 
			String file = new String( bytes ); // 4. ����Ʈ -> ���ڿ� ��ȯ 
			String[] boards = file.split("\n"); // 5. ���ڿ� �ڸ��� [ ���پ� [ \n ] -> 1����ü ] 
			int i = 0; // �ε��� �� 
			for( String temp : boards ) { // �迭�� ���ڿ� �ϳ��� ������ 
				if( i+1 == boards.length ) break; // * ������ �ε���[��ü] ����
				String[] field = temp.split(","); // 6. ���ڿ� �ڸ��� [ ���� [,] -> ���ʵ� ] 
				Board board = new Board( field[0], field[1],
						field[2], field[3], Integer.parseInt(field[4]),field[5], null);  // 7. ��üȭ 
										// ��ȸ���� �ʵ�� �������̹Ƿ� ���������� ����ȯ [ Integer.parseInt( ���ڿ� ) ]
				boadlist.add(board);// 8. ����Ʈ ��� 
				i++; // �ε��� ���� 
			}
		}catch( Exception e ) { System.err.println(" �˸�]] ���Ϸε�  ����( �����ڿ��Թ��� )"+e);  }
	}
}











