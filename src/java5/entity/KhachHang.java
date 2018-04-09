package java5.entity;

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
@Table(name="khachhang")
public class KhachHang {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer khachhang_id;
	private String ten;
	private String diachi;
	private String tinhthanhpho;
	private String quanhuyen;
	private String phuongxa;
	private String sodienthoai;
	private Date ngaytao;
	private Boolean trangthai;
	@ManyToOne
	@JoinColumn(name="taikhoan_id")
	private TaiKhoan taikhoan;
	@OneToMany(mappedBy="khachhang",fetch=FetchType.EAGER)
	private Collection<DonHang> donhang;
	
	public KhachHang() {}

	public Integer getKhachhang_id() {
		return khachhang_id;
	}

	public void setKhachhang_id(Integer khachhang_id) {
		this.khachhang_id = khachhang_id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getTinhthanhpho() {
		return tinhthanhpho;
	}

	public void setTinhthanhpho(String tinhthanhpho) {
		this.tinhthanhpho = tinhthanhpho;
	}

	public String getQuanhuyen() {
		return quanhuyen;
	}

	public void setQuanhuyen(String quanhuyen) {
		this.quanhuyen = quanhuyen;
	}

	public String getPhuongxa() {
		return phuongxa;
	}

	public void setPhuongxa(String phuongxa) {
		this.phuongxa = phuongxa;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	public Collection<DonHang> getDonhang() {
		return donhang;
	}

	public void setDonhang(Collection<DonHang> donhang) {
		this.donhang = donhang;
	}
	
	
}
