package dao;

import modele.Modele;
import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;
import modele.player.Player;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class CsvDAO implements InterfaceDAO {

    private static CsvDAO instance = null;

    public static CsvDAO getInstance() {
        if (instance == null)
            instance = new CsvDAO();
        return instance;
    }

    @Override
    public void save(Modele mod) {
        try {
            JFileChooser choix = new JFileChooser();
            choix.showOpenDialog(null);

            final File f = choix.getSelectedFile();

            Player pl = mod.getP1();
            Player ai = mod.getP2();

            if (f != null) {
                String nomF = f.getAbsolutePath();

                PrintWriter out = new PrintWriter(new FileWriter(nomF+"Titanic.csv"));
                writePlayer(pl, out);
                writePlayer(ai, out);

                out.println();
                out.close();

                JOptionPane.showMessageDialog(null,
                        "Fichier enregisté", "succes", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException ffe) {
            System.out.println("Fichier non trouvé");
        } catch (IOException ioe) {
            System.out.println("Erreur IO");
        }
    }

    @Override
    public void load(Modele mod) {
        Modele m_charge = null;
        ArrayList<Modele> modeleArrayList = new ArrayList<Modele>();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("/"));
        jFileChooser.changeToParentDirectory();
        int reponse = jFileChooser.showOpenDialog(null);

        if (reponse == JFileChooser.APPROVE_OPTION) {
            File fichier = jFileChooser.getSelectedFile();
            String[] parts = fichier.getName().split(("\\."));
            if (parts[1].equals("csv")) {
                String nomF = fichier.getAbsolutePath();

                try {
                    Player pl = mod.getP1();
                    Player ai = mod.getP2();

                    BufferedReader in = new BufferedReader(new FileReader(nomF));
                    readPlayer(pl, in, mod);
                    readPlayer(ai, in, mod);
                    in.close();

                    System.out.println("LOADING...");
                } catch (FileNotFoundException ffe) {
                    System.out.println("Fichier non trouvé");
                    ffe.printStackTrace();
                } catch (IOException e) {
                    System.out.println("Erreur IO");
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Mauvais fichier", "Erreur",
                        JOptionPane.ERROR_MESSAGE) ;
            }
        }
    }

    public void writePlayer(Player player, PrintWriter out){
        //Récupération du plateau
        for (int i = 0; i < player.getPlateau().getGrillPlayer().length; i++){
            for(int j = 0; j < player.getPlateau().getGrillPlayer()[i].length; j++){
                out.print(player.getPlateau().getGrillPlayer()[i][j]);
                if (j < player.getPlateau().getGrillPlayer()[i].length-1){
                    out.print(",");
                }
                out.println();
            }
        }
        out.println(player.getPlateau().getEpoch());

        for (Boat b: player.getPlateau().getListeBoat()){
            out.println(b.getPosX()+","+b.getPosY()+","+b.getHp()+","+b.getSize()+","+b.getDirection());
        }
        out.println("fin liste bateaux");
    }

    public void readPlayer(Player player, BufferedReader in, Modele modele)throws IOException{
        String string = new String();
        int[][] grille = new int[Plateau.HIGHT][Plateau.WIDTH];
        for (int i = 0; i < Plateau.WIDTH; i++){
            string = in.readLine();
            String[] parts1 = string.split(",");

            for (int j = 0; j < Plateau.WIDTH; j++){
                grille[i][j] = Integer.parseInt(parts1[j]);
            }
        }
        player.setPlateau(modele.plateau);
    }
}

