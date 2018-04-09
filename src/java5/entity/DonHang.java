package java5.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="donhang")
public class DonHang {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer donhang_id;
	@ManyToOne
	@JoinColumn(name="khachhang_id")
	private KhachHang khachhang;
	private Date ngaytao;
	private Date ngaythanhtoan;
	private String trangthai;
	private BigDecimal phivanchuyen;
	private BigDecimal tonggia;
	@OneToMany(mappedBy="donhang",fetch=FetchType.EAGER)
	private Collection<ChiTietDonHang> chitietdonhang;
	
	public DonHang() {}

	public Integer getDonhang_id() {
		return donhang_id;
	}

	public void setDonhang_id(Integer donhang_id) {
		this.donhang_id = donhang_id;
	}

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public Date getNgaythanhtoan() {
		return ngaythanhtoan;
	}

	public void setNgaythanhtoan(Date ngaythanhtoan) {
		this.ngaythanhtoan = ngaythanhtoan;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public BigDecimal getPhivanchuyen() {
		return phivanchuyen;
	}

	public void setPhivanchuyen(BigDecimal phivanchuyen) {
		this.phivanchuyen = phivanchuyen;
	}

	public BigDecimal getTonggia() {
		return tonggia;
	}

	public void setTonggia(BigDecimal tonggia) {
		this.tonggia = tonggia;
	}

	public Collection<ChiTietDonHang> getChitietdonhang() {
		return chitietdonhang;
	}

	public void setChitietdonhang(Collection<ChiTietDonHang> chitietdonhang) {
		this.chitietdonhang = chitietdonhang;
	}

	
}
