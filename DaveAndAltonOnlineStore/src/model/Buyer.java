package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BUYERS database table.
 * 
 */
@Entity
@Table(name="BUYERS", schema= "TESTUSERDB")
@NamedQuery(name="Buyer.findAll", query="SELECT b FROM Buyer b")
public class Buyer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BUYERS_BUYERID_GENERATOR", sequenceName="BUYERS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUYERS_BUYERID_GENERATOR")
	@Column(name="BUYER_ID")
	private long buyerId;

	private String email;

	private String name;

	private String password;

	private String username;

	//bi-directional many-to-one association to LineItm
	@OneToMany(mappedBy="buyer")
	private List<LineItm> lineItms;

	public Buyer() {
	}

	public long getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<LineItm> getLineItms() {
		return this.lineItms;
	}

	public void setLineItms(List<LineItm> lineItms) {
		this.lineItms = lineItms;
	}

	public LineItm addLineItm(LineItm lineItm) {
		getLineItms().add(lineItm);
		lineItm.setBuyer(this);

		return lineItm;
	}

	public LineItm removeLineItm(LineItm lineItm) {
		getLineItms().remove(lineItm);
		lineItm.setBuyer(null);

		return lineItm;
	}

}