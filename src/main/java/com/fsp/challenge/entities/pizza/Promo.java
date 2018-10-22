package com.fsp.challenge.entities.pizza;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fsp.challenge.entities.Store;

@Entity
public class Promo {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	private String code;	
	@OneToOne
    @JoinColumn(name="STORE_ID")
	private Store store;
	private double discountPercent;
	private Date expiration;
	private int used = 0;	// ideally boolean
	
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public double getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public void set(Promo newPromo) {
		this.store = newPromo.store != null ? newPromo.store : this.store;
		this.code = newPromo.code != null ? newPromo.code : this.code;
		this.discountPercent = (Double) newPromo.discountPercent != null ? newPromo.discountPercent : this.discountPercent;
		this.expiration = newPromo.expiration != null ? newPromo.expiration : this.expiration;
		this.used = (Integer) newPromo.used != null ? newPromo.used : this.used;
	}

}
