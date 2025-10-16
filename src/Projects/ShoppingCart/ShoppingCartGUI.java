package Projects.ShoppingCart;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getTotal() { return price * quantity; }
}

class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) throws Exception {
        try {
            if (product.getQuantity() <= 0) {
                throw new Exception("Quantity must be greater than 0");
            }

            // Check if item already exists
            items.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(product.getName()))
                    .findFirst()
                    .ifPresentOrElse(
                            p -> p.setQuantity(p.getQuantity() + product.getQuantity()),
                            () -> items.add(product)
                    );
        } catch (Exception e) {
            throw new Exception("Error adding item: " + e.getMessage());
        }
    }

    public void deleteItem(String productName) throws Exception {
        try {
            boolean removed = items.removeIf(p -> p.getName().equalsIgnoreCase(productName));
            if (!removed) {
                throw new Exception("Product not found in cart");
            }
        } catch (Exception e) {
            throw new Exception("Error deleting item: " + e.getMessage());
        }
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(Product::getTotal)
                .sum();
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }

    public String checkout() {
        if (items.isEmpty()) {
            return "Cart is empty!";
        }

        StringBuilder receipt = new StringBuilder();
        receipt.append("===== CHECKOUT RECEIPT =====\n\n");

        items.forEach(item ->
                receipt.append(String.format("%s x%d - R%.2f\n",
                        item.getName(), item.getQuantity(), item.getTotal()))
        );

        receipt.append(String.format("\n---------------------------\n"));
        receipt.append(String.format("TOTAL: R%.2f\n", calculateTotal()));
        receipt.append("===========================\n");
        receipt.append("Thank you for your purchase!");

        items.clear();
        return receipt.toString();
    }
}

public class ShoppingCartGUI extends JFrame {
    private ShoppingCart cart;
    private DefaultTableModel tableModel;
    private JTable cartTable;
    private JLabel totalLabel;
    private JTextField nameField, priceField, quantityField;

    public ShoppingCartGUI() {
        cart = new ShoppingCart();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("🛒 Shopping Cart Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        // Set modern look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Main container with padding
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(240, 242, 245));

        // Top Panel - Add Product
        JPanel topPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        topPanel.add(new JLabel("Product Name:"));
        nameField = new JTextField();
        topPanel.add(nameField);

        topPanel.add(new JLabel("Price (R):"));
        priceField = new JTextField();
        topPanel.add(priceField);

        topPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        topPanel.add(quantityField);

        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(e -> addProduct());
        topPanel.add(addButton);

        // Center Panel - Cart Table
        String[] columns = {"Product", "Price", "Quantity", "Total"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        cartTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(cartTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));

        // Bottom Panel - Actions
        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton deleteButton = new JButton("Delete Selected");
        deleteButton.addActionListener(e -> deleteProduct());

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> checkout());

        buttonPanel.add(deleteButton);
        buttonPanel.add(checkoutButton);

        totalLabel = new JLabel("Total: R0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(totalLabel, BorderLayout.SOUTH);

        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private void addProduct() {
        try {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                throw new Exception("Product name cannot be empty");
            }

            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            if (price <= 0) {
                throw new Exception("Price must be greater than 0");
            }

            Product product = new Product(name, price, quantity);
            cart.addItem(product);

            updateCartTable();
            clearFields();

            JOptionPane.showMessageDialog(this, "Product added successfully!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price or quantity format!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteProduct() {
        try {
            int selectedRow = cartTable.getSelectedRow();
            if (selectedRow == -1) {
                throw new Exception("Please select a product to delete");
            }

            String productName = (String) tableModel.getValueAt(selectedRow, 0);
            cart.deleteItem(productName);

            updateCartTable();
            JOptionPane.showMessageDialog(this, "Product deleted successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkout() {
        try {
            String receipt = cart.checkout();
            JTextArea textArea = new JTextArea(receipt);
            textArea.setEditable(false);
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

            JOptionPane.showMessageDialog(this, new JScrollPane(textArea),
                    "Checkout", JOptionPane.INFORMATION_MESSAGE);

            updateCartTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Checkout error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCartTable() {
        tableModel.setRowCount(0);

        cart.getItems().forEach(item -> {
            Object[] row = {
                    item.getName(),
                    String.format("R%.2f", item.getPrice()),
                    item.getQuantity(),
                    String.format("R%.2f", item.getTotal())
            };
            tableModel.addRow(row);
        });

        totalLabel.setText(String.format("Total: R%.2f", cart.calculateTotal()));
    }

    private void clearFields() {
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
        nameField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShoppingCartGUI app = new ShoppingCartGUI();
            app.setVisible(true);
        });
    }
}