package com.api.resturentapplication.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Component
public class TablesOfResturant
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private int tableid;

	@ManyToOne
	@JsonIgnore
	private Resturant resturant;
	
	

//	@OneToOne
//	private Order_menus order_menus;

	@OneToMany(mappedBy = "tablesOfResturant", cascade = CascadeType.ALL)
	List<Order_menus> order_menus = new ArrayList<>();

	public TablesOfResturant(int id, int tableid, Resturant resturant, List<Order_menus> order_menus)
	{
		super();
		this.id = id;
		this.tableid = tableid;
		this.resturant = resturant;
		this.order_menus = order_menus;
	}

	public TablesOfResturant()
	{
		super();
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getTableid()
	{
		return tableid;
	}

	public void setTableid(int tableid)
	{
		this.tableid = tableid;
	}

	public Resturant getResturant()
	{
		return resturant;
	}

	public void setResturant(Resturant resturant)
	{
		this.resturant = resturant;
	}

	public List<Order_menus> getOrder_menus()
	{
		return order_menus;
	}

	public void setOrder_menus(List<Order_menus> order_menus)
	{
		this.order_menus = order_menus;
	}

	@Override
	public String toString()
	{
		return "TablesOfResturant [id=" + id + ", tableid=" + tableid + ", resturant=" + resturant + ", order_menus="
				+ order_menus + "]";
	}

}
