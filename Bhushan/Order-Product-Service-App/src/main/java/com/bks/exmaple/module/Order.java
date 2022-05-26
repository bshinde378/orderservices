package com.prati.exmaple.module;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.NamedQueries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import org.springframework.boot.autoconfigure.domain.EntityScan;


@NamedQueries
({
	@NamedQuery
	(
		name="OrderId",
				query="from Order p where p.oid=:oid"
)})


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_t")


public class Order {

	@Id
	private Long oid;
	
	@Column
	private String oname;
	
	@Column
	private String detail;
	
	@Column
	private Date odate;
	
	@Column
	private Double price;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="pid")
	private List<Product> product;


}


