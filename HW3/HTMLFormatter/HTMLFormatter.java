public class HTMLFormatter implements InvoiceFormatter{

	public String formatHeader(){
		total = 0;
		return "<b><h1 style = 'color: black'; align = 'center'>" + 
			   "INVOICE" + "</h1></b><br><br><br><ol>";
	}

	public String formatLineItem(LineItem item, int freq){
		total += item.getPrice() * freq;
		return "<li><p style = 'color: green'>" + item.toString() + " x" + freq + 
				"<p style = 'color: black'> $ " + item.getPrice() + "</p></li><br>";
	}

	public String formatFooter(){
		return "</ol><b><u><h3 style = 'color: black' ; align = 'center'>"
				+ "TOTAL DUE: " + total + "</h3></u></b>";
	}

	private double total;	
}