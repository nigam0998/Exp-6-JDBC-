import java.sql.*;
import java.util.Scanner;

public class ProductCRUDApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_db";
        String user = "root";
        String pass = "password";
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false);

            while (true) {
                System.out.println("\n1. Insert\n2. Display\n3. Update\n4. Delete\n5. Exit");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1: // Insert
                        System.out.print("ProductID: ");
                        int pid = sc.nextInt();
                        System.out.print("ProductName: ");
                        String pname = sc.next();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();

                        String insertSql = "INSERT INTO Product VALUES (?, ?, ?, ?)";
                        PreparedStatement ps = con.prepareStatement(insertSql);
                        ps.setInt(1, pid);
                        ps.setString(2, pname);
                        ps.setDouble(3, price);
                        ps.setInt(4, qty);
                        ps.executeUpdate();
                        con.commit();
                        System.out.println("Inserted successfully!");
                        ps.close();
                        break;

                    case 2: // Display
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3) + " " + rs.getInt(4));
                        }
                        rs.close();
                        stmt.close();
                        break;

                    case 3: // Update
                        System.out.print("ProductID to update: ");
                        int upid = sc.nextInt();
                        System.out.print("New Price: ");
                        double newPrice = sc.nextDouble();
                        String updateSql = "UPDATE Product SET Price = ? WHERE ProductID = ?";
                        PreparedStatement ups = con.prepareStatement(updateSql);
                        ups.setDouble(1, newPrice);
                        ups.setInt(2, upid);
                        int rows = ups.executeUpdate();
                        if (rows > 0) {
                            con.commit();
                            System.out.println("Updated successfully!");
                        } else {
                            con.rollback();
                            System.out.println("Product not found!");
                        }
                        ups.close();
                        break;

                    case 4: // Delete
                        System.out.print("ProductID to delete: ");
                        int delid = sc.nextInt();
                        String delSql = "DELETE FROM Product WHERE ProductID = ?";
                        PreparedStatement dels = con.prepareStatement(delSql);
                        dels.setInt(1, delid);
                        int delRows = dels.executeUpdate();
                        if (delRows > 0) {
                            con.commit();
                            System.out.println("Deleted successfully!");
                        } else {
                            con.rollback();
                            System.out.println("Product not found!");
                        }
                        dels.close();
                        break;

                    case 5:
                        con.close();
                        sc.close();
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
