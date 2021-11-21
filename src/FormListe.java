import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormListe {
    private JPanel panRacine;
    private JLabel tmpLabel;
    private JButton remetAZero;
    private JButton boutonSauver;
    private JPanel panneauSDB;
    private JCheckBox cocheSDB;
    private JTextField notesSDB;

    public FormListe() {
        remetAZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("remetAZero");
            }
        });
        boutonSauver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("boutonSauver");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormListe");
        frame.setContentPane(new FormListe().panRacine);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
