package java5.entity;

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
@Table(name="thuoctinh")
public class ThuocTinh {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer thuoctinh_id;
	private String ten;
	@OneToMany(mappedBy="thuoctinh",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<GiaTriThuocTinh> giatrithuoctinh;
	
	public ThuocTinh() {}

	public Integer getThuoctinh_id() {
		return thuoctinh_id;
	}

	public void setThuoctinh_id(Integer thuoctinh_id) {
		this.thuoctinh_id = thuoctinh_id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Set<GiaTriThuocTinh> getGiatrithuoctinh() {
		return giatrithuoctinh;
	}

	public void setGiatrithuoctinh(Set<GiaTriThuocTinh> giatrithuoctinh) {
		this.giatrithuoctinh = giatrithuoctinh;
	}

	
}
