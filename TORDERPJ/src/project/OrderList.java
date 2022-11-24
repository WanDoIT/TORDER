package project;

public class OrderList {
	private int Price;
	private int Ordercount;
	private String Name;
	private int Tableno;
	public OrderList(int price, int ordercount, String name, int tableno) {
		super();
		Price = price;
		Ordercount = ordercount;
		Name = name;
		Tableno = tableno;
	}
	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getOrdercount() {
		return Ordercount;
	}
	public void setOrdercount(int ordercount) {
		Ordercount = ordercount;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getTableno() {
		return Tableno;
	}
	public void setTableno(int tableno) {
		Tableno = tableno;
	}
	@Override
	public String toString() {
		return "OrderList [Price=" + Price + ", Ordercount=" + Ordercount + ", Name=" + Name + ", Tableno=" + Tableno
				+ "]";

	
}
