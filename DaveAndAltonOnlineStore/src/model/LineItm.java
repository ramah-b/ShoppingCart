package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LINE_ITMS database table.
 * 
 */
@Entity
@Table(name="LINE_ITMS", schema = "TESTUSERDB")
@NamedQuery(name="LineItm.findAll", query="SELECT l FROM LineItm l")
public class LineItm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LINE_ITMS_LINEITEMID_GENERATOR", sequenceName="LINE_ITMS_SEQ1", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LINE_ITMS_LINEITEMID_GENERATOR")
	@Column(name="LINE_ITEM_ID")
	private long lineItemId;

	private BigDecimal price;

	private BigDecimal quantity;

	private BigDecimal totalprice;

	//bi-directional many-to-one association to Buyer
	@ManyToOne
	@JoinColumn(name="BUYER_ID")
	private Buyer buyer;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	public LineItm() {
	}

	public long getLineItemId() {
		return this.lineItemId;
	}

	public void setLineItemId(long lineItemId) {
		this.lineItemId = lineItemId;
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

	public BigDecimal getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}