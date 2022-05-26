package com.prati.exmaple.module;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

//import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedQueries
({
	@NamedQuery
	(
		name="ProductId",
				query="from Product p where p.pid=:pid"
)})
	
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")

public class Product {

	@Id
	private Long pid;
	
	@Column
	private String pname;
	
	@Column
	private String detail;
	
	private int  quntity;
	
	@Column
	private Double price;
	


}

