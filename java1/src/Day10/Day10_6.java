package Day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day10_6 {
	// �ֱ����ġ : �޸� : RAM : ���α׷� ����ÿ��� ���� �޸� 
	// ���������ġ : C����̺�,USB,CD : (���α׷�) ���� [��������]
	// ����ó��[ �ڹٳ� �޸𸮸�--> ���������ġ ]
	// DBó��[ �ڹٳ� �޸� ---> DB ����[PC] ]
		// ��Ʈ��(Stream) : ���α׷��� �ܺ�[Ű����,����,��Ʈ��ũ��] ���
			// ��� ���� : byte
		// FileOutputStream : ������� Ŭ����
			// ��ü��.write( ����Ʈ�� );
		// FileInputStream : �����Է� Ŭ���� 
			// ��ü��.read( ����Ʈ�迭 );
		// String Ŭ����
			// ���ڿ�.equals() : ���ڿ� �� �޼ҵ� 
			// ���ڿ�.getBytes() : ���ڿ� -> ����Ʈ�� ��ȯ
			// new String( ����Ʈ�迭 ) : ����Ʈ�迭 -> ���ڿ� ��ȯ 
	
	public static void main(String[] args) throws IOException {
		
		// 1.�������
		FileOutputStream ������� = new FileOutputStream("D:/java/java1.txt");
		//FileOutputStream : ������� Ŭ���� 
		// FileOutputStream( ���ϰ��/���ϸ�.Ȯ���� ); // txt : �޸��� 
		String ���� = "�ڹٿ��� �Էµ� ������";
		�������.write( ����.getBytes() ); // ����[����]
		
		// 2.�����Է�
		FileInputStream �����Է� = new FileInputStream("D:/java/java1.txt");
		byte[] bytes = new byte[ 1000 ];
		�����Է�.read( bytes );
		System.out.println(" ���ϳ��� : " + new String(bytes) );
		
	}
}







