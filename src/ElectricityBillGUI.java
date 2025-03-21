import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElectricityBillGUI extends JFrame {
    private JTextField txtStartReading, txtEndReading, txtTotalCost;
    private JButton btnCalculate, btnExit;

    public ElectricityBillGUI() {
        setTitle("Tính Tiền Điện");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setLayout(new GridLayout(4, 2, 10, 10));

        // Tạo các thành phần giao diện
        add(new JLabel("🔌 Số điện đầu kỳ:"));
        txtStartReading = new JTextField();
        add(txtStartReading);

        add(new JLabel("⚡ Số điện cuối kỳ:"));
        txtEndReading = new JTextField();
        add(txtEndReading);

        add(new JLabel("💰 Thành tiền (VND):"));
        txtTotalCost = new JTextField();
        txtTotalCost.setEditable(false); // Không cho nhập
        txtTotalCost.setBackground(Color.LIGHT_GRAY);
        add(txtTotalCost);

        btnCalculate = new JButton("Tính Tiền 💡");
        btnExit = new JButton("Thoát ❌");

        add(btnCalculate);
        add(btnExit);

        // Sự kiện nút "Tính Tiền"
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int startReading = Integer.parseInt(txtStartReading.getText());
                    int endReading = Integer.parseInt(txtEndReading.getText());

                    if (endReading < startReading) {
                        JOptionPane.showMessageDialog(null, "❌ Số điện cuối kỳ phải lớn hơn số điện đầu kỳ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int consumedUnits = endReading - startReading;
                        int totalCost = consumedUnits * 10000;
                        txtTotalCost.setText(totalCost + " VND");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "⚠️ Vui lòng nhập số hợp lệ!", "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new ElectricityBillGUI();
    }
}

