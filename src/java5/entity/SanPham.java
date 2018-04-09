package java5.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="sanpham")
public class SanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sanpham_id;
	private String ten;
	private String mota;
	private Integer soluong;
	private BigDecimal gia;
	private Integer chietkhau;
	private String anh;
	private Boolean trangthai;
	private String url;
	@OneToMany(mappedBy="sanpham",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<ChiTietDonHang> chitietdonhang;
	@OneToMany(mappedBy="sanpham",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<ThuocTinhSanPham> thuoctinhsanpham;
	
	public SanPham() {}

	public Integer getSanpham_id() {
		return sanpham_id;
	}

	public void setSanpham_id(Integer sanpham_id) {
		this.sanpham_id = sanpham_id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
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

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Collection<ChiTietDonHang> getChitietdonhang() {
		return chitietdonhang;
	}

	public void setChitietdonhang(Collection<ChiTietDonHang> chitietdonhang) {
		this.chitietdonhang = chitietdonhang;
	}

	public Set<ThuocTinhSanPham> getThuoctinhsanpham() {
		return thuoctinhsanpham;
	}

	public void setThuoctinhsanpham(Set<ThuocTinhSanPham> thuoctinhsanpham) {
		this.thuoctinhsanpham = thuoctinhsanpham;
	}

	
}
