package Day17;

public class Product< ���׸�Ÿ��1 , ���׸�Ÿ��2 > {
				//  < �ܺηκ��� ���� �ڷ����̸� : �ƹ��ų� >
	// �ʵ�
	private ���׸�Ÿ��1 kind; // Tv , Car , Integer 
	private ���׸�Ÿ��2 model; // String , String , Double

	public static <���׸�Ÿ��1> Box<���׸�Ÿ��1> boxing(���׸�Ÿ��1 kind){
// �޼ҵ带 �����
// ���������� ����   ��ȯŸ��=<���׸�Ÿ��1> Box<���׸�Ÿ��1> boxing:�޼ҵ��̸�( ���׸�Ÿ�� )
		
		Box<���׸�Ÿ��1> box = new Box<>();
		box.set(kind);
		
		return box;
	}
	
	// set 
	public void setKind(���׸�Ÿ��1 kind) {
		this.kind = kind;
	}
	public void setModel(���׸�Ÿ��2 model) {
		this.model = model;
	}
	// get
	public ���׸�Ÿ��2 getModel() {
		return model;
	}
	public ���׸�Ÿ��1 getKind() {
		return kind;
	}

}
