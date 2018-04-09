package java5.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="thuoctinhsanpham")
public class ThuocTinhSanPham {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ttsp_id;
	@ManyToOne
	@JoinColumn(name="gttt_id")
	private GiaTriThuocTinh giatrithuoctinh;
	@ManyToOne
	@JoinColumn(name="sanpham_id")
	private SanPham sanpham;
	
	public ThuocTinhSanPham() {}

	public Integer getTtsp_id() {
		return ttsp_id;
	}

	public void setTtsp_id(Integer ttsp_id) {
		this.ttsp_id = ttsp_id;
	}

	public GiaTriThuocTinh getGiatrithuoctinh() {
		return giatrithuoctinh;
	}

	public void setGiatrithuoctinh(GiaTriThuocTinh giatrithuoctinh) {
		this.giatrithuoctinh = giatrithuoctinh;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	
}
