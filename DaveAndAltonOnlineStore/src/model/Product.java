package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PRODUCTS", schema= "TESTUSERDB")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCTS_PRODUCTID_GENERATOR", sequenceName="PRODUCTS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTS_PRODUCTID_GENERATOR")
	@Column(name="PRODUCT_ID")
	private long productId;

	private String category;

	private String description;

	private String name;

	private BigDecimal price;

	private BigDecimal quantity;

	//bi-directional many-to-one association to LineItm
	@OneToMany(mappedBy="product")
	private List<LineItm> lineItms;

	public Product() {
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public List<LineItm> getLineItms() {
		return this.lineItms;
	}

	public void setLineItms(List<LineItm> lineItms) {
		this.lineItms = lineItms;
	}

	public LineItm addLineItm(LineItm lineItm) {
		getLineItms().add(lineItm);
		lineItm.setProduct(this);

		return lineItm;
	}

	public LineItm removeLineItm(LineItm lineItm) {
		getLineItms().remove(lineItm);
		lineItm.setProduct(null);

		return lineItm;
	}

}