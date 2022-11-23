package project;

public class OrderList {
	private int OrderNO;
	private String OrderDate;
	public OrderList(int orderNO, String orderDate) {
		super();
		OrderNO = orderNO;
		OrderDate = orderDate;
	}
	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderNO() {
		return OrderNO;
	}
	public void setOrderNO(int orderNO) {
		OrderNO = orderNO;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	@Override
	public String toString() {
		return "OrderList [OrderNO=" + OrderNO + ", OrderDate=" + OrderDate + "]";
	}
	
	
}
