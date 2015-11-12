package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the REVIEWS database table.
 * 
 */
@Entity
@Table(name="REVIEWS", schema = "TESTUSERDB")
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REVIEWS_REVIEWID_GENERATOR", sequenceName="REVIEWS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REVIEWS_REVIEWID_GENERATOR")
	@Column(name="REVIEW_ID")
	private long reviewId;

	@Column(name="REVIEW_DATE")
	private String reviewDate;

	private BigDecimal stars;

	private String text;

	//bi-directional many-to-one association to Buyer
	@ManyToOne
	@JoinColumn(name="BUYER_ID")
	private Buyer buyer;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	public Review() {
	}

	public long getReviewId() {
		return this.reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public BigDecimal getStars() {
		return this.stars;
	}

	public void setStars(BigDecimal stars) {
		this.stars = stars;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
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