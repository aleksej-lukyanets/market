package market.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Счёт для оплаты заказа.
 */
@Entity
@Table(name = "bill")
public class Bill implements Serializable {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Order order;

	@Column(name = "number", nullable = false)
	private int number;

	@Column(name = "total_cost", nullable = false)
	private int totalCost;

	@Column(name = "payed", nullable = false)
	private boolean payed = false;

	@Column(name = "cc_number", nullable = false)
	@NotEmpty
	@Pattern(regexp = "\\b(?:\\d[ -]*?){13,16}\\b")
	private String ccNumber;

	@Column(name = "date_created", nullable = false)
	@Temporal(TIMESTAMP)
	private Date dateCreated;

	public Bill() {
	}

	public Bill(int totalCost, String ccNumber) {
		this.totalCost = totalCost;
		this.ccNumber = ccNumber;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the ccNumber
	 */
	public String getCcNumber() {
		return ccNumber;
	}

	/**
	 * @param ccNumber the ccNumber to set
	 */
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the totalCost
	 */
	public int getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the payed
	 */
	public boolean isPayed() {
		return payed;
	}

	/**
	 * @param payed the payed to set
	 */
	public void setPayed(boolean payed) {
		this.payed = payed;
	}


}
