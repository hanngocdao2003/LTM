package LTM_w4;

public class MonHoc {
	private int id;
	private String name;
	private int soTinChi;

	public MonHoc(int id, String name, int soTinChi) {
		super();
		this.id = id;
		this.name = name;
		this.soTinChi = soTinChi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + "\t" + getName() + "\t" + getSoTinChi() + "\n";
	}
}
