import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
   A program that tests the invoice classes.
*/
public class InvoiceTester
{
   public static void main(String[] args)
   {
      final Invoice invoice = new Invoice();
      final InvoiceFormatter formatter = new HTMLFormatter();

      // This text area will contain the formatted invoice
      final JTextPane textPane = new JTextPane();
      textPane.setContentType("text/html");

      // When the invoice changes, update the text area
      ChangeListener listener = new
         ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {
               textPane.setText("");
               textPane.setText(invoice.format(formatter));
            }
         };
      invoice.addChangeListener(listener);

      // Add line items to a combo box
      final JComboBox combo = new JComboBox();
      Product hammer = new Product("Hammer", 19.95);
      Product nails = new Product("Assorted nails", 9.95);
      combo.addItem(hammer);
      Bundle bundle = new Bundle();
      bundle.add(hammer);
      bundle.add(nails);
      combo.addItem(new DiscountedItem(bundle, 10));

      // Make a button for adding the currently selected
      // item to the invoice
      JButton addButton = new JButton("Add");
      addButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               LineItem item = (LineItem) combo.getSelectedItem();
               invoice.addItem(item);
            }
         });

      // Put the combo box and the add button into a panel
      JPanel panel = new JPanel();
      panel.add(combo);
      panel.add(addButton);

      // Add the text area and panel to the frame
      JFrame frame = new JFrame();
      frame.add(new JScrollPane(textPane),
         BorderLayout.CENTER);
      frame.add(panel, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
