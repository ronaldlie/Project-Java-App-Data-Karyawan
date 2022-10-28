import DataTable.Data;
import DataTable.DataDept;
import DataTable.DataJob;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main1 extends JFrame {
    // panel
    JPanel mainpPanel = new JPanel();
    JPanel panelHome = new JPanel();
    JPanel panelTabel = new JPanel();
    JPanel labelPanel = new JPanel();
    JPanel panelGaris = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel imgPanel = new JPanel();
    JPanel ketPanel = new JPanel();
    JPanel combo = new JPanel();
    JPanel combo2 = new JPanel();
    JPanel combo3 = new JPanel();

    // panel 2
    JPanel tablePanel = new JPanel();
    JPanel tablePanel1 = new JPanel();
    JPanel tablePanel2 = new JPanel();
    // Table CardLayout
    JPanel cards = new JPanel(new CardLayout());
    JPanel card1 = new JPanel();
    JPanel card2 = new JPanel();
    JPanel card3 = new JPanel();

    JPanel inputPanel = new JPanel();
    JPanel inputButton = new JPanel();

    // Images

    ImageIcon image1 = new ImageIcon(getClass().getResource("icon1.png"));
    ImageIcon image2 = new ImageIcon(getClass().getResource("karyawan.png"));

    // Label
    JLabel header = new JLabel("Employees");

    JLabel labelIcon = new JLabel(image1);
    JLabel labelGaris = new JLabel("_____________________________________________________________________________________________________________________________________________");
    JLabel empImg = new JLabel(image2);
    JLabel keterangan = new JLabel("Pengelolaan data karyawan merupakan hal yang penting. Untuk mengelola data");
    JLabel keterangan1 = new JLabel("karyawan diperlukan ketelitian yang ekstra agar data yang tersimpan");
    JLabel keterangan2 = new JLabel("merupakan data yang benar dan akurat. Pengelolaan data karyawan dengan");
    JLabel keterangan3 = new JLabel("baik dan tepat akan membantu karyawan,HR,maupun perusahaan dalam");
    JLabel keterangan4 = new JLabel("menjalankan kegiatan untuk mencapai tujuan masing-masing. Belakangan ini,");
    JLabel keterangan5 = new JLabel("seiring dengan berkembangnya teknologi, software HR membantu banyak");
    JLabel keterangan6 = new JLabel("dalam menyederhanakan tugas administratif HR, sehingga HR dapat");
    JLabel keterangan7 = new JLabel("menyelesaikan tugas tersebut dengan lebih praktis dan mudah.");
    JLabel keterangan8 = new JLabel("Beberapa Alasan mengapa data karyawan harus dikelola dengan baik :");
    JLabel keterangan9 = new JLabel("- Data mungkin akan dibutuhkan di masa yang akan datang.");
    JLabel keterangan10 = new JLabel("- Kontrol data lebih mudah.");
    JLabel nama = new JLabel("Nama");
    JLabel nik = new JLabel("NIK");
    JLabel ttl = new JLabel("Tanggal Lahir");
    JLabel gender = new JLabel("Jenis Kelamin");
    JLabel agama = new JLabel("Agama");
    JLabel jobId = new JLabel("Job ID");
    JLabel deptId = new JLabel("Dept ID");
    JLabel deptName = new JLabel("Dept Name");
    JLabel jobName = new JLabel("Job Name");
    JLabel labelCari = new JLabel("Search (ID) : ");

    // Button
    JButton btnHome = new JButton("     Home    ");
    JButton btnData = new JButton("Data Karyawan");
    JButton btnGaji = new JButton("Cek Gaji");
    JButton btnJumlah = new JButton("Jumlah Karyawan");
    JButton btnEdit = new JButton("edit");
    JButton btnDelete = new JButton("Delete");
    JButton btnInput = new JButton("Input");

    // Text Field
    JTextField textNama = new JTextField();
    JTextField textNik = new JTextField();
    JTextField textSearch = new JTextField();

    // Calender
    JDateChooser textTtl = new JDateChooser();

    // Combo Box
    String cbItems[] = {
            "Table Employees", "Table Jobs", "Table Departments"
    };
    JComboBox cb = new JComboBox(cbItems);

    String[] genderr = new String[] {"Male", "Female"};
    JComboBox comboGender = new JComboBox(genderr);

    String[] agamaa = new String[] {"Islam", "Kristen", "Buddha", "Katolik", "Hindu", "Konghucu"};
    JComboBox comboAgama = new JComboBox(agamaa);

    String[] jobIdd = new String[] {"AC_ACCOUNT", "AC_MGR", "AD_ASTT", "SA_MAN", "SA_REP"};
    JComboBox comboJobId = new JComboBox(jobIdd);

    String[] deptIdd = new String[] {"10", "20", "50", "60", "80"};
    JComboBox comboDeptId = new JComboBox(deptIdd);

    //table employee
    String columnNames[] = {"ID", "FUll Name", "NIK", "DOB", "Gender", "religion", "Job ID", "Dept ID"};
    Object[][] data = {

    };

    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    JTable table = new JTable(model);

    public ArrayList<Data> dataList() {
        ArrayList<Data> dataList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan", "root", "323211");
            String query = "select * from employees";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            Data data;
            while (rs.next()) {
                data = new Data(rs.getInt("emp_id"), rs.getString("name"), rs.getInt("nik"),
                        rs.getString("dob"), rs.getString("gender"), rs.getString("religion"),
                        rs.getString("job_id"), rs.getInt("dept_id"));
                dataList.add(data);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
        }
        return dataList;
    }

    public void show_data() {
        ArrayList<Data> list = dataList();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = new Object[8];
        for(int i=0; i<list.size();i++) {
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getNik();
            row[3]=list.get(i).getDob();
            row[4]=list.get(i).getGender();
            row[5]=list.get(i).getReligion();
            row[6]=list.get(i).getJobId();
            row[7]=list.get(i).getDeptId();
            model.addRow(row);
        }
    }

    // table JobID
    String columnNames1[] = {"Job ID", "Job Title"};
    Object[][] data1 = {
    };
    DefaultTableModel model1 = new DefaultTableModel(data1, columnNames1);

    JTable table1 = new JTable(model1);

    public ArrayList<DataJob> dataList1() {
        ArrayList<DataJob> dataList1 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan", "root", "323211");
            String query = "select * from jobs";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            DataJob dataJob;
            while (rs.next()) {
                dataJob = new DataJob(rs.getString("job_id"), rs.getString("job_title"));
                dataList1.add(dataJob);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
        }
        return dataList1;
    }

    public void show_data1() {
        ArrayList<DataJob> list = dataList1();
        DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
        Object[] row1 = new Object[2];
        for(int i=0; i<list.size();i++) {
            row1[0]=list.get(i).getJob_id();
            row1[1]=list.get(i).getJob_title();
            model1.addRow(row1);
        }
    }

    // table Departments
    String columnNames2[] = {"Dept ID", "Dept Name"};
    Object[][] data2 = {

    };
    DefaultTableModel model2 = new DefaultTableModel(data2, columnNames2);

    JTable table2 = new JTable(model2);

    public ArrayList<DataDept> dataList2() {
        ArrayList<DataDept> dataList2 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan", "root", "323211");
            String query = "select * from departments";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            DataDept dataDept;
            while (rs.next()) {
                dataDept = new DataDept(rs.getInt("dept_id"), rs.getString("dept_name"));
                dataList2.add(dataDept);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
        }
        return dataList2;
    }

    public void show_data2() {
        ArrayList<DataDept> list = dataList2();
        DefaultTableModel model2 = (DefaultTableModel)table2.getModel();
        Object[] row2 = new Object[2];
        for(int i=0; i<list.size();i++) {
            row2[0]=list.get(i).getDept_id();
            row2[1]=list.get(i).getDept_name();
            model2.addRow(row2);
        }
    }

    public Main1() {
        setTitle("Homepage");
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(labelPanel);
        add(panelGaris);
        add(buttonPanel);


        add(mainpPanel);
        mainpPanel.setLayout(new CardLayout());

        mainpPanel.add(panelHome);
        panelHome.setLayout(new BoxLayout(panelHome,BoxLayout.Y_AXIS));
        panelHome.add(combo);

        combo2.setLayout(new GridLayout(1, 1));
        combo2.add(cards);

        combo3.setLayout(new GridLayout(1,2));
        card1.setLayout(new BoxLayout(card1,BoxLayout.Y_AXIS));
        combo3.add(card1);

        JPanel searchgroup = new JPanel();

        Border bordersearch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder5 = BorderFactory.createTitledBorder(bordersearch, "");
        titledBorder5.setTitleFont(titledBorder5.getTitleFont().deriveFont(Font.BOLD));
        searchgroup.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 3, 10), titledBorder5));


        searchgroup.setLayout(new GridLayout(1,2));
        searchgroup.add(labelCari);
        searchgroup.add(textSearch);

        mainpPanel.add(panelTabel);
        panelTabel.setLayout(new BoxLayout(panelTabel,BoxLayout.Y_AXIS));
        panelTabel.add(cb);
        panelTabel.add(combo3);

        panelTabel.add(combo2);
        panelTabel.add(inputButton);

        JPanel paneltest = new JPanel();
        mainpPanel.add(paneltest);

        // Header Panel
        header.setFont(new Font("Arial Black", Font.PLAIN, 30));

        labelPanel.add(header);
        labelPanel.add(labelIcon);

        // panel garis
        panelGaris.add(labelGaris);

        // Button Panel
        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainpPanel.removeAll();
                mainpPanel.add(panelHome);
                mainpPanel.repaint();
                mainpPanel.revalidate();
                setSize(1000, 500);
                setLocationRelativeTo(null);
            }
        });

        btnData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainpPanel.removeAll();
                mainpPanel.add(panelTabel);
                mainpPanel.repaint();
                mainpPanel.revalidate();
                setSize(1000, 790);
                setLocationRelativeTo(null);
            }
        });

        btnGaji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textNama.getText();
                String nik = textNik.getText();
                String jobId = comboJobId.getSelectedItem().toString();
                String deptId = comboDeptId.getSelectedItem().toString();


                if (textNama.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Pilih Data terlebih dahulu!");
                } else {
                    Main2 main2 = new Main2();
                    main2.valueNama.setText(nama);
                    main2.valueNik.setText(nik);
                    main2.valueJobId.setText(jobId);
                    main2.valueDeptId.setText(deptId);

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan", "root", "323211");
                        int row = table.getSelectedRow();
                        String value = (table.getModel().getValueAt(row, 0).toString());
                        String query = "select salary from salary,employees where salary.job_id=employees.job_id and salary.dept_id=employees.dept_id and employees.emp_id =" + value;

                        PreparedStatement pst = connection.prepareStatement(query);

                        ResultSet rs = pst.executeQuery(query);

                        while (rs.next()) {
                            String gaji = String.valueOf(rs.getInt("salary"));

                            Main2.valueGaji.setText(gaji);
                        }
                        main2.valueNama.setEditable(false);
                        main2.valueNik.setEditable(false);
                        main2.valueJobId.setEditable(false);
                        main2.valueDeptId.setEditable(false);
                        main2.valueGaji.setEditable(false);

                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception);
                    }

                    main2.setVisible(true);
                }
            }
        });


        buttonPanel.add(btnHome);
        buttonPanel.add(btnData);

        // Keterangan Panel
        combo.setLayout(new GridLayout(1, 2));

        // Border Home
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Selamat Datang !");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        combo.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 300, 10), titledBorder));

        imgPanel.add(empImg);

        ketPanel.add(keterangan);
        ketPanel.add(keterangan1);
        ketPanel.add(keterangan2);
        ketPanel.add(keterangan3);
        ketPanel.add(keterangan4);
        ketPanel.add(keterangan5);
        ketPanel.add(keterangan6);
        ketPanel.add(keterangan7);
        ketPanel.add(keterangan8);
        ketPanel.add(keterangan9);
        ketPanel.add(keterangan10);
        ketPanel.setLayout(new BoxLayout(ketPanel,BoxLayout.Y_AXIS));

        combo.add(imgPanel);
        combo.add(ketPanel);


        // panel 2
        cb.setEditable(false);

        // search
        textSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ArrayList<Data> dataList = new ArrayList<>();
                String cari = textSearch.getText();

                try {
                    if (textSearch.getText().isEmpty()){
                        DefaultTableModel model = (DefaultTableModel)table.getModel();
                        model.setRowCount(0);
                        show_data();
                    }
                    else {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan", "root", "323211");
                        String query = "select * from employees where emp_id = " + cari;
                        Statement st = connection.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        Data data;
                        while (rs.next()) {
                            data = new Data(rs.getInt("emp_id"), rs.getString("name"), rs.getInt("nik"),
                                    rs.getString("dob"), rs.getString("gender"), rs.getString("religion"),
                                    rs.getString("job_id"), rs.getInt("dept_id"));
                            dataList.add(data);
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.setRowCount(0);
                            Object[] row = new Object[8];
                            for (int i = 0; i < dataList.size(); i++) {
                                row[0] = dataList.get(i).getId();
                                row[1] = dataList.get(i).getName();
                                row[2] = dataList.get(i).getNik();
                                row[3] = dataList.get(i).getDob();
                                row[4] = dataList.get(i).getGender();
                                row[5] = dataList.get(i).getReligion();
                                row[6] = dataList.get(i).getJobId();
                                row[7] = dataList.get(i).getDeptId();
                                model.addRow(row);
                            }
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception);
                }
                super.keyReleased(e);
            }
        });

        // button jumlah
        btnJumlah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int jumlah = 0;
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan", "root", "323211");
                    String query = "select count(*) from karyawan.employees";
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        jumlah =
                                rs.getInt("count(*)");
                    }
                    JOptionPane.showMessageDialog(null, "Jumlah karyawan : " + jumlah);

                }catch(Exception exception) {
                    JOptionPane.showMessageDialog(null, exception);
                }
            }
        });

        // table employees
        show_data();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setMinimumSize(new Dimension(100, 200));
        table.setFillsViewportHeight(true);

        tablePanel.setBorder(new EmptyBorder(10,10,0,10));
        tablePanel.setLayout(new GridLayout(1,1));
        tablePanel.add(scrollPane);

        Border border1 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(border1, "Table Employees");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        tablePanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorder1));

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                int i = table.getSelectedRow();
                try {
                    DefaultTableModel model1 = (DefaultTableModel)table.getModel();
                    int a = table.getSelectedRow();
                    Date date = new SimpleDateFormat("dd MMMM yyyy").parse((String)model.getValueAt(a, 3).toString());
                    textTtl.setDate(date);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                textNama.setText(model.getValueAt(i,1).toString());
                textNik.setText(model.getValueAt(i,2).toString());
//                textTtl.setDate(model.getValueAt(i,3).toString());

                String gender = model.getValueAt(i,4).toString();
                switch(gender){
                    case "Male":
                        comboGender.setSelectedIndex(0);
                        break;
                    case "Female":
                        comboGender.setSelectedIndex(1);
                        break;
                }
                String religion = model.getValueAt(i,5).toString();
                switch(religion){
                    case "Islam":
                        comboAgama.setSelectedIndex(0);
                        break;
                    case "Kristen":
                        comboAgama.setSelectedIndex(1);
                        break;
                    case "Buddha":
                        comboAgama.setSelectedIndex(2);
                        break;
                    case "Katolik":
                        comboAgama.setSelectedIndex(3);
                        break;
                    case "Hindu":
                        comboAgama.setSelectedIndex(4);
                        break;
                    case "Konghucu":
                        comboAgama.setSelectedIndex(5);
                        break;
                }
                String jobId = model.getValueAt(i,6).toString();
                switch(jobId){
                    case "AC_ACCOUNT":
                        comboJobId.setSelectedIndex(0);
                        break;
                    case "AC_MGR":
                        comboJobId.setSelectedIndex(1);
                        break;
                    case "AD_ASTT":
                        comboJobId.setSelectedIndex(2);
                        break;
                    case "SA_MAN":
                        comboJobId.setSelectedIndex(3);
                        break;
                    case "SA_REP":
                        comboJobId.setSelectedIndex(4);
                        break;
                }
                String deptId = model.getValueAt(i,7).toString();
                switch(deptId){
                    case "10":
                        comboDeptId.setSelectedIndex(0);
                        break;
                    case "20":
                        comboDeptId.setSelectedIndex(1);
                        break;
                    case "50":
                        comboDeptId.setSelectedIndex(2);
                        break;
                    case "60":
                        comboDeptId.setSelectedIndex(3);
                        break;
                    case "70":
                        comboDeptId.setSelectedIndex(4);
                        break;
                }

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
                String Nama = textNama.getText();
                String Nik = textNik.getText();
                String Ttl = dateFormat.format(textTtl.getDate());
                String JenisKelamin = comboGender.getSelectedItem().toString();
                String Agama = comboAgama.getSelectedItem().toString();
                String jobId = comboJobId.getSelectedItem().toString();
                String deptId = comboDeptId.getSelectedItem().toString();

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan", "root", "323211");
                    int row = table.getSelectedRow();
                    String value = (table.getModel().getValueAt(row, 0).toString());
                    String query = "UPDATE employees SET name=?, nik=?, dob=?, gender=?, religion=?, job_id=?, dept_id=? where emp_id=" + value;
                    PreparedStatement state = connection.prepareStatement(query);
                    state.setString(1, Nama);
                    state.setString(2, Nik);
                    state.setString(3, String.valueOf(Ttl));
                    state.setString(4, JenisKelamin);
                    state.setString(5, Agama);
                    state.setString(6, jobId);
                    state.setString(7, deptId);
                    state.executeUpdate();
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    model.setRowCount(0);
                    show_data();
                    JOptionPane.showMessageDialog(null, "Update Success");

                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,exception);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row = table.getSelectedRow();
                String cell = table.getModel().getValueAt(row, 0).toString();
                String query = "DELETE FROM employees where emp_id = " + cell;
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan", "root", "323211");
                    PreparedStatement state = connection.prepareStatement(query);
                    state.execute();
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    model.setRowCount(0);
                    show_data();
                    JOptionPane.showMessageDialog(null, "Delete Succesfully");

                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        });


        // table job id
        show_data1();

        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        Border border2 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder2 = BorderFactory.createTitledBorder(border2, "Table Jobs");
        tablePanel1.setBorder(new EmptyBorder(10,10,0,10));
        tablePanel1.add(new JScrollPane(table1));
        tablePanel1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 15, 10), titledBorder2));

        // Table Dept
        show_data2();

        table2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        Border border3 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder3 = BorderFactory.createTitledBorder(border3, "Table Departments");
        tablePanel2.setBorder(new EmptyBorder(10,10,0,10));
        tablePanel2.add(new JScrollPane(table2));
        tablePanel2.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 15, 10), titledBorder3));

        cards.add(card1, "Table Employees");
        cards.add(card2, "Table Jobs");
        cards.add(card3, "Table Departments");

        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout c = (CardLayout) cards.getLayout();
                c.show(cards, (String) e.getItem());
            }
        });
        card1.add(searchgroup);
        card1.add(btnJumlah);
        card1.add(tablePanel);
        card1.add(inputPanel);

        card2.add(tablePanel1);
        card3.add(tablePanel2);

        // Panel 2 Input Panel
        inputPanel.setLayout(new GridLayout(8,2));

        inputPanel.add(nama);
        inputPanel.add(textNama);

        inputPanel.add(nik);
        inputPanel.add(textNik);

        inputPanel.add(ttl);
        inputPanel.add(textTtl);

        inputPanel.add(gender);
        inputPanel.add(comboGender);

        inputPanel.add(agama);
        inputPanel.add(comboAgama);

        inputPanel.add(jobId);
        inputPanel.add(comboJobId);

        inputPanel.add(deptId);
        inputPanel.add(comboDeptId);

        inputPanel.add(inputButton);

        // Border Input

        Border border4 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder4 = BorderFactory.createTitledBorder(border, "Editor");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        inputPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 10, 0, 10), titledBorder4));


        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

                String Nama = textNama.getText();
                String Nik = textNik.getText();
                String Ttl = dateFormat.format(textTtl.getDate());
                String JenisKelamin = comboGender.getSelectedItem().toString();
                String Agama = comboAgama.getSelectedItem().toString();
                String jobId = comboJobId.getSelectedItem().toString();
                String deptId = comboDeptId.getSelectedItem().toString();

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karyawan", "root", "323211");
                    String query = "Insert Into employees" + "(name, nik, dob, gender, religion, job_id, dept_id)" + "values (?,?,?,?,?,?,?)";

                    PreparedStatement state = connection.prepareStatement(query);
                    state.setString(1, Nama);
                    state.setString(2, Nik);
                    state.setString(3, String.valueOf(Ttl));
                    state.setString(4, JenisKelamin);
                    state.setString(5, Agama);
                    state.setString(6, jobId);
                    state.setString(7, deptId);
                    state.executeUpdate();
                    DefaultTableModel model = (DefaultTableModel)table.getModel();
                    model.setRowCount(0);
                    show_data();
                    JOptionPane.showMessageDialog(null, "Input Success");

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


        inputButton.add(btnInput);
        inputButton.add(btnEdit);
        inputButton.add(btnDelete);
        inputButton.add(btnGaji);

        // panel 3
        setVisible(true);
    }

    public static void main(String[] args) {

        new Main1();
    }
}