package java5.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="chitietdonhang")
public class ChiTietDonHang {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ctdh_id;
	@ManyToOne
	@JoinColumn(name="donhang_id")
	private DonHang donhang;
	@ManyToOne
	@JoinColumn(name="sanpham_id")
	private SanPham sanpham;
	private Integer soluong;
	private BigDecimal gia;
	private Integer chietkhau;
	private BigDecimal tonggia;
	
	public ChiTietDonHang() {}

	public Integer getCtdh_id() {
		return ctdh_id;
	}

	public void setCtdh_id(Integer ctdh_id) {
		this.ctdh_id = ctdh_id;
	}

	public DonHang getDonhang() {
		return donhang;
	}

	public void setDonhang(DonHang donhang) {
		this.donhang = donhang;
	}

	public SanPham getSanpham() {
		return sanpham;
	}

	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}

	public Integer getSoluong() {
		return soluong;
	}

	public void setSoluong(Integer soluong) {
		this.soluong = soluong;
	}

	public BigDecimal getGia() {
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public Integer getChietkhau() {
		return chietkhau;
	}

	public void setChietkhau(Integer chietkhau) {
		this.chietkhau = chietkhau;
	}

	public BigDecimal getTonggia() {
		return tonggia;
	}

	public void setTonggia(BigDecimal tonggia) {
		this.tonggia = tonggia;
	}

	
}
