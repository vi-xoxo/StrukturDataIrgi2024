package ProjectAkhirPraktikum;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;

public class BarbershopBooking {
    private JFrame frame;
    private JTextField namaField;
    private JTextField teleponField;
    private JComboBox<String> jenisPelangganCombo;
    private JComboBox<String> layananCombo;
    private JButton tombolPesan;
    private JButton tombolBatal;
    private JButton tombolBerikutnya;
    private JButton tombolLihatHistori;
    private JTextArea antrianTextArea;

    private ArrayList<Pelanggan> antrian;
    private Stack<Pelanggan> histori;

    public BarbershopBooking() {
        frame = new JFrame("Sistem Pemesanan Barber Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.getContentPane().setLayout(null); 

      
        
        JLabel namaLabel = new JLabel("Nama:");
        namaLabel.setBounds(10, 20, 60, 20);
        frame.getContentPane().add(namaLabel);

        namaField = new JTextField(20);
        namaField.setBounds(80, 20, 150, 20);
        frame.getContentPane().add(namaField);

        JLabel teleponLabel = new JLabel("Telepon:");
        teleponLabel.setBounds(10, 50, 60, 20);
        frame.getContentPane().add(teleponLabel);

        teleponField = new JTextField(20);
        teleponField.setBounds(80, 50, 150, 20);
        frame.getContentPane().add(teleponField);

        JLabel jenisPelangganLabel = new JLabel("Jenis Pelanggan:");
        jenisPelangganLabel.setBounds(10, 80, 100, 20);
        frame.getContentPane().add(jenisPelangganLabel);

        String[] jenisPelangganArray = {"VIP", "Reguler"};
        jenisPelangganCombo = new JComboBox<>(jenisPelangganArray);
        jenisPelangganCombo.setBounds(101, 81, 110, 20);
        frame.getContentPane().add(jenisPelangganCombo);

        JLabel layananLabel = new JLabel("Layanan:");
        layananLabel.setBounds(10, 110, 60, 20);
        frame.getContentPane().add(layananLabel);

        String[] layananArray = {"Potong Rambut", "Potong Janggut", "Cat Rambut"};
        layananCombo = new JComboBox<>(layananArray);
        layananCombo.setBounds(101, 111, 150, 20);
        frame.getContentPane().add(layananCombo);

        tombolPesan = new JButton("Buat Janji");
        tombolPesan.setBounds(350, 20, 120, 20);
        tombolPesan.addActionListener(new TombolPesanListener());
        frame.getContentPane().add(tombolPesan);

        tombolBatal = new JButton("Batalkan Janji");
        tombolBatal.setBounds(350, 50, 120, 20);
        tombolBatal.addActionListener(new TombolBatalListener());
        frame.getContentPane().add(tombolBatal);

        tombolBerikutnya = new JButton("Antrian");
        tombolBerikutnya.setBounds(350, 80, 120, 20);
        tombolBerikutnya.addActionListener(new TombolBerikutnyaListener());
        frame.getContentPane().add(tombolBerikutnya);

        tombolLihatHistori = new JButton("Lihat Histori");
        tombolLihatHistori.setBounds(350, 110, 120, 20);
        tombolLihatHistori.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder historiText = new StringBuilder("Histori Pelanggan:\n");
                for (Pelanggan pelanggan : histori) {
                    historiText.append(pelanggan.getNama()).append(" - ").append(pelanggan.getLayanan()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, historiText.toString());
            }
        });
        frame.getContentPane().add(tombolLihatHistori);

        antrianTextArea = new JTextArea(10, 40);
        antrianTextArea.setEditable(false); 
        JScrollPane scrollPane = new JScrollPane(antrianTextArea);
        scrollPane.setBounds(10, 140, 460, 300);
        frame.getContentPane().add(scrollPane);

        antrian = new ArrayList<>();
        histori = new Stack<>();

        frame.setVisible(true);
    }

    private class TombolPesanListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nama = namaField.getText();
            String telepon = teleponField.getText();
            String jenisPelanggan = (String) jenisPelangganCombo.getSelectedItem();
            String layanan = (String) layananCombo.getSelectedItem();

            Pelanggan pelanggan = new Pelanggan(nama, telepon, jenisPelanggan, layanan);
            antrian.add(pelanggan);

            bubbleSortJenisPelanggan();
            updateAntrianTextArea();
        }
    }

    private class TombolBatalListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nama = namaField.getText();
            antrian.removeIf(pelanggan -> pelanggan.getNama().equals(nama));
            updateAntrianTextArea();
        }
    }

    private class TombolBerikutnyaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (!antrian.isEmpty()) {
                Pelanggan berikutnyaDalamAntrian = antrian.get(0);
                antrian.remove(0);

               
                histori.push(berikutnyaDalamAntrian);

                updateAntrianTextArea();
                JOptionPane.showMessageDialog(frame, "Berikutnya dalam antrian: " + berikutnyaDalamAntrian.getNama() + " - " + berikutnyaDalamAntrian.getLayanan());
            } else {
                JOptionPane.showMessageDialog(frame, "Tidak ada dalam antrian");
            }
        }
    }

    private void updateAntrianTextArea() {
        antrianTextArea.setText("");
        for (Pelanggan pelanggan : antrian) {
            antrianTextArea.append(pelanggan.getNama() + " - " + pelanggan.getJenisPelanggan() + " - " + pelanggan.getLayanan() + "\n");
        }
    }

    private void updateHistoriTextArea() {
        JTextArea historiTextArea = antrianTextArea;

        historiTextArea.setText(""); 

        
        for (Pelanggan pelanggan : histori) {
            historiTextArea.append(pelanggan.getNama() + " - " + pelanggan.getLayanan() + "\n");
        }
    }

    private class Pelanggan {
        private String nama;
        private String telepon;
        private String jenisPelanggan;
        private String layanan;

        public Pelanggan(String nama, String telepon, String jenisPelanggan, String layanan) {
            this.nama = nama;
            this.telepon = telepon;
            this.jenisPelanggan = jenisPelanggan;
            this.layanan = layanan;
        }

        public String getNama() {
            return nama;
        }

        public String getTelepon() {
            return telepon;
        }

        public String getJenisPelanggan() {
            return jenisPelanggan;
        }

        public String getLayanan() {
            return layanan;
        }
    }

    private void bubbleSortJenisPelanggan() {
        int n = antrian.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Prioritaskan pelanggan VIP (VIP harus lebih dulu)
                if (antrian.get(j).getJenisPelanggan().equals("Reguler") && antrian.get(j + 1).getJenisPelanggan().equals("VIP")) {
                    Pelanggan temp = antrian.get(j);
                    antrian.set(j, antrian.get(j + 1));
                    antrian.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BarbershopBooking();
            }
        });
    }
}