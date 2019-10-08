import java.util.*;
import javax.swing.event.*;

/**
   An invoice for a sale, consisting of line items.
*/
public class Invoice
{
   /**
      Constructs a blank invoice.
   */
   public Invoice()
   {
      items = new ArrayList<LineItem>();
      listeners = new ArrayList<ChangeListener>();
      itemQuantityMap = new HashMap<>();
      descriptionItemMap = new HashMap<>();
   }

  /**
      Adds an item to the invoice.
      @param item the item to add
   */
   public void addItem(LineItem item)
   {
      if (!itemQuantityMap.keySet().contains(item.toString()))
         itemQuantityMap.put(item.toString(), 1);
      else
         itemQuantityMap.put(item.toString(), itemQuantityMap.get(item.toString()) + 1);
      
      if (!descriptionItemMap.keySet().contains(item.toString()))
         descriptionItemMap.put(item.toString(), item);

      items.add(item);
      // Notify all observers of the change to the invoice
      ChangeEvent event = new ChangeEvent(this);
      for (ChangeListener listener : listeners)
         listener.stateChanged(event);
   }

   /**
      Adds a change listener to the invoice.
      @param listener the change listener to add
   */
   public void addChangeListener(ChangeListener listener)
   {
      listeners.add(listener);
   }

   /**
      Gets an iterator that iterates through the items.
      @return an iterator for the items
   */
   public Iterator<LineItem> getItems()
   {
      return new
         Iterator<LineItem>()
         {
            public boolean hasNext()
            {
               return current < items.size();
            }

            public LineItem next()
            {
               return items.get(current++);
            }

            public void remove()
            {
               throw new UnsupportedOperationException();
            }

            private int current = 0;
         };
   }

   public String format(InvoiceFormatter formatter)
   {
      String r = formatter.formatHeader();

      for (String description: itemQuantityMap.keySet())
         r += formatter.formatLineItem(descriptionItemMap.get(description), itemQuantityMap.get(description));

      return r + formatter.formatFooter();
   }

   private ArrayList<LineItem> items;
   private ArrayList<ChangeListener> listeners;

   /**
         Because the classes implementing LineItem are forced to have a hashCode() or an equals()
         Hence, we need to create a mapping to quantity using the item description because it is a string
         and string class has the methods required to use the hashmap.
   */
   private Map<String, Integer> itemQuantityMap;
   private Map<String, LineItem> descriptionItemMap;
}
