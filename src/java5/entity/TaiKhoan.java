package java5.entity;

import java.util.Collection;
import java.util.Date;

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
@Table(name="taikhoan")
public class TaiKhoan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taikhoan_id;
	private String username;
	private String password;
	private String email;
	private Date ngaytao;
	private String quyen;
	private String trangthai;
	@OneToMany(mappedBy="taikhoan",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<KhachHang> khachhang;
	
	public TaiKhoan() {}

	public Integer getTaikhoan_id() {
		return taikhoan_id;
	}

	public void setTaikhoan_id(Integer taikhoan_id) {
		this.taikhoan_id = taikhoan_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public Collection<KhachHang> getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Collection<KhachHang> khachhang) {
		this.khachhang = khachhang;
	}

}
