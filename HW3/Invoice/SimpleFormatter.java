/**
   A simple invoice formatter.
*/
public class SimpleFormatter implements InvoiceFormatter
{
   public String formatHeader()
   {
      total = 0;
      return "     I N V O I C E\n\n\n";
   }

   public String formatLineItem(LineItem item, int freq)
   {
      total += freq*item.getPrice();
      return (String.format(
            "%s: $%.2f ",item.toString(),item.getPrice())) + " x" + freq + "\n";
   }

   public String formatFooter()
   {
      return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
   }

   private double total;
}
