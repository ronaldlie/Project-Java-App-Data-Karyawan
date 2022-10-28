import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main2 extends JFrame {
    // Panel
    JPanel headerPanel = new JPanel();
    JPanel dataGaji = new JPanel();
    JPanel panelButton = new JPanel();


    // Images
    ImageIcon image1 = new ImageIcon(getClass().getResource("icon1.png"));

    // Label
    JLabel header = new JLabel("Slip Gaji");
    JLabel labelIcon = new JLabel(image1);

    // Button
    JButton btnBack = new JButton("Back");

    public static JLabel nama = new JLabel("Nama");
    public static JLabel nik = new JLabel("NIK");
    public static JLabel jobId = new JLabel("Job ID");
    public static JLabel deptId = new JLabel("Dept ID");
    public static JLabel salary = new JLabel("Gaji");

    // Textfield
    public static JTextField valueNama = new JTextField();
    public static JTextField valueNik = new JTextField();
    public static JTextField valueJobId = new JTextField();
    public static JTextField valueDeptId = new JTextField();
    public static JTextField valueGaji = new JTextField();


    public Main2() {
        setTitle("Salary");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Header Panel
        header.setFont(new Font("Arial Black", Font.PLAIN, 20));

        headerPanel.add(header);
        headerPanel.add(labelIcon);
        add(headerPanel);

        // Hasil Gaji
        dataGaji.setLayout(new GridLayout(5,2));

        dataGaji.add(nama);
        dataGaji.add(valueNama);

        dataGaji.add(nik);
        dataGaji.add(valueNik);

        dataGaji.add(jobId);
        dataGaji.add(valueJobId);

        dataGaji.add(deptId);
        dataGaji.add(valueDeptId);

        dataGaji.add(salary);
        dataGaji.add(valueGaji);


        add(dataGaji);

        // Border Hasil Gaji
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        dataGaji.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(1, 10, 10, 10), titledBorder));


        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        panelButton.add(btnBack);
        add(panelButton);

    }

    public static void main(String[] args) {
        new Main2();
    }
}
