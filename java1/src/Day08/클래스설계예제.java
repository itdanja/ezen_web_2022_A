package Day08;

public class Ŭ�������迹�� {
			// ȸ��Ŭ���� 
	// 1. �ʵ� [ private ���� ] 
	private String id;
	private String password;
	private String name;
	private String point;
	// 2. ������
		// 1. *[�ʵ�0��]�������[ �޼ҵ� ȣ��� ��뿹�� ]
	public Ŭ�������迹��() {}
		// 2. *[�ʵ�4��]Ǯ������ [ ��� ȸ������ ȣ��� ��뿹�� ]
	public Ŭ�������迹��(String id, String password, String name, String point) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.point = point;
	}
		// 3. [�ʵ�3��]Ư�� ������ [ ȸ�����Խ� ��뿹�� ]
	
	// 3. �޼ҵ�
		// private �ʵ� ���� get or set �޼ҵ�
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}

	

}
