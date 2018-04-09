package java5.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="giatrithuoctinh")
public class GiaTriThuocTinh {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer gttt_id;
	@ManyToOne
	@JoinColumn(name="thuoctinh_id")
	private ThuocTinh thuoctinh;
	private String giatri;
	@OneToMany(mappedBy="giatrithuoctinh",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<ThuocTinhSanPham> thuoctinhsanpham;
	
	public GiaTriThuocTinh() {}

	public Integer getGttt_id() {
		return gttt_id;
	}

	public void setGttt_id(Integer gttt_id) {
		this.gttt_id = gttt_id;
	}

	public ThuocTinh getThuoctinh() {
		return thuoctinh;
	}

	public void setThuoctinh(ThuocTinh thuoctinh) {
		this.thuoctinh = thuoctinh;
	}

	public String getGiatri() {
		return giatri;
	}

	public void setGiatri(String giatri) {
		this.giatri = giatri;
	}

	public Set<ThuocTinhSanPham> getThuoctinhsanpham() {
		return thuoctinhsanpham;
	}

	public void setThuoctinhsanpham(Set<ThuocTinhSanPham> thuoctinhsanpham) {
		this.thuoctinhsanpham = thuoctinhsanpham;
	}

	
}
