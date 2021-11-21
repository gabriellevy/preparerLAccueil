import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FormListe {
    private static String chemin = "D:\\boulot\\java\\preparerLAccueil\\donnees\\taches.txt";
    private static String separateur = ";";

    private JPanel panRacine;
    private JButton remetAZero;
    private JButton boutonSauver;

    private JPanel panneauSDB;
    private JCheckBox cocheSDB;
    private JTextField notesSDB;
    private JCheckBox cocheVitres;
    private JTextField notesVitres;
    private JPanel panneauVitres;
    private JPanel panneauToilettes;
    private JCheckBox cocheToilettes;
    private JTextField notesToilettes;
    private JCheckBox cocheOeufsBeurre;
    private JPanel panneauOeufsBeurre;
    private JTextField notesOeufsBeurre;
    private JCheckBox cocheCuisine;
    private JPanel panneauCuisine;
    private JTextField notesCuisine;
    private JCheckBox cocheApirateur;
    private JPanel panneauApirateur;
    private JTextField notesApirateur;
    private JPanel panneauSol;
    private JCheckBox cocheSol;
    private JTextField notesSol;
    private JPanel panneauDraps;
    private JCheckBox cocheDraps;
    private JTextField notesDraps;
    private JPanel panneauLinge;
    private JCheckBox cocheLinge;
    private JTextField notesLinge;
    private JPanel panneauJeter;
    private JCheckBox cocheJeter;
    private JTextField notesJeter;
    private JPanel panneauGuitare;
    private JCheckBox cocheGuitare;
    private JTextField notesGuitare;
    private JPanel panneauMuscu;
    private JCheckBox cocheMuscu;
    private JTextField notesMuscu;
    private JPanel panneauMatos;
    private JCheckBox cocheMatos;
    private JTextField notesMatos;

    //List<JPanel> panneaux = Arrays.asList(panneauSDB);
    List<JCheckBox> coches = Arrays.asList(cocheSDB, cocheVitres, cocheToilettes, cocheOeufsBeurre, cocheCuisine, cocheApirateur, cocheSol, cocheDraps, cocheLinge, cocheJeter,
            cocheGuitare, cocheMuscu, cocheMatos);
    List<JTextField> notes = Arrays.asList(notesSDB, notesVitres, notesToilettes, notesOeufsBeurre, notesCuisine, notesApirateur, notesSol, notesDraps, notesLinge, notesJeter,
            notesGuitare, notesMuscu, notesMatos);

    public FormListe() {

        // chargement à l'ouverture :

        StringBuilder strComplete = new StringBuilder();

        try
        {
            FileReader file = new FileReader( chemin ) ;

            BufferedReader buffer = new BufferedReader( file );

            String ligne = "" ;

            while( ( ligne = buffer.readLine() ) != null )
            {
                //System.out.println( ligne ) ;
                strComplete.append(ligne);
            }

            buffer.close() ;
        }
        catch( IOException e )
        {
            //Insert error message here
        }

        String[] listeStr = strComplete.toString().split(separateur);
        if (listeStr.length == (coches.size() + notes.size())) {
            int index = 0;

            for (JCheckBox checkB : coches) {
                checkB.setSelected(listeStr[index].equals("1"));
                index++;
            }
            for (JTextField tx : notes) {
                tx.setText(listeStr[index]);
                index++;
            }
        }

        remetAZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("remetAZero");
                for (JCheckBox checkB : coches) {
                    checkB.setSelected(false);
                }
                for (JTextField tx : notes) {
                    tx.setText("");
                }
            }
        });
        boutonSauver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("boutonSauver");

                try {
                    FileWriter file = new FileWriter( chemin );
                    BufferedWriter buffer = new BufferedWriter( file ) ;

                    // sauver donnees :
                    String donnees = "";
                    for (JCheckBox checkB : coches) {
                        String donnee = checkB.isSelected()?"1":"0";
                        System.out.println("checkB : " + donnee);
                        donnees = donnees + donnee + separateur;
                    }
                    for (JTextField tx : notes) {
                        String donnee = tx.getText();
                        System.out.println("tx : " + donnee);
                        if (donnee.isEmpty())
                            donnee = " ";
                        donnees = donnees + donnee + separateur;
                    }
                    System.out.println("donnees : " + donnees);
                    buffer.write( donnees ) ;
                    buffer.newLine();
                    buffer.close();
                }
                catch ( IOException e2 )
                { /*Insert error message here*/ }

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
