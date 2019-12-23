package dao;

import modele.Modele;
import modele.State;
import modele.gestionBoat.*;
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
                String[] part = nomF.split("\\.");
                PrintWriter out;
                if (part.length > 0 && part[part.length - 1].equals("csv")){
                     out = new PrintWriter(new FileWriter(nomF));
                }
                else
                    out = new PrintWriter(new FileWriter(nomF+".csv"));
                out.println(pl.getPlateau().getEpoch());
                out.println(mod.getState());
                out.println(pl.getPlateau().getIdBoat());
                writePlayer(pl, out);
                out.println(ai.getPlateau().getIdBoat());
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
        State state = null;
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
                    String epoque = in.readLine();
                    state = state.valueOf(in.readLine());
                    readPlayer(pl, in, mod, epoque);
                    readPlayer(ai, in, mod, epoque);
                    in.close();
                    mod.setState(state);
                    System.out.println("Chargement de " + fichier.getName() + " effectué.");
                    mod.finChargement();
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

    public void writePlayer(Player player, PrintWriter out) {
        //Récupération du plateau
        int height = player.getPlateau().getGrillPlayer().length;
        int width = player.getPlateau().getGrillPlayer()[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                out.print(player.getPlateau().getGrillPlayer()[i][j]);
                if (j < player.getPlateau().getGrillPlayer()[i].length - 1)
                    out.print(";");
            }
            out.print(";");
            out.println();
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                out.print(player.getPlateau().getGrillOpponent()[i][j]);
                if (j < player.getPlateau().getGrillOpponent()[i].length - 1)
                    out.print(";");
            }
            out.print(";");
            out.println();
        }
        for (Boat b : player.getPlateau().getListeBoat()) {
            out.println(b.getName() + "," +
                    b.getId() + "," +
                    b.getPosX() + "," +
                    b.getPosY() + "," +
                    b.getHp() + "," +
                    b.getSize() + ","
                    + b.getDirection());
        }
        out.println("fin liste bateaux");
    }

    public void readPlayer(Player player, BufferedReader in, Modele modele, String epoque)throws IOException{
        String string;
        int idBoat = Integer.parseInt(in.readLine());
        /*
        * Creation grille
        */
        Case[][] grillePlayer = new Case[Plateau.HIGHT][Plateau.WIDTH];
        Case[][] grilleOpponent = new Case[Plateau.HIGHT][Plateau.WIDTH];
        for (int i = 0; i != Plateau.HIGHT; i++){
            string = in.readLine();
            String[] parts1 = string.split(";");
            for (int j = 0; j != Plateau.WIDTH; j++){
                String[] parts2 = parts1[j].split(",");
                int id = Integer.parseInt(parts2[0]);
                boolean isTouched = Boolean.parseBoolean(parts2[1]);
                boolean isWater = Boolean.parseBoolean(parts2[2]);
                boolean dejaTireIci = Boolean.parseBoolean(parts2[3]);
                grillePlayer[i][j] = new Case(id, i, j);
                grillePlayer[i][j].setWater(isWater);
                grillePlayer[i][j].setTouched(isTouched);
                grillePlayer[i][j].setDejaTireIci(dejaTireIci);
            }
        }

        for (int i = 0; i != Plateau.HIGHT; i++){
            string = in.readLine();
            String[] parts1 = string.split(";");
            for (int j = 0; j != Plateau.WIDTH; j++){
                String[] parts2 = parts1[j].split(",");
                int id = Integer.parseInt(parts2[0]);
                boolean isTouched = Boolean.parseBoolean(parts2[1]);
                boolean isWater = Boolean.parseBoolean(parts2[2]);
                boolean dejaTireIci = Boolean.parseBoolean(parts2[3]);
                grilleOpponent[i][j] = new Case(id, i, j);
                grilleOpponent[i][j].setWater(isWater);
                grilleOpponent[i][j].setTouched(isTouched);
                grilleOpponent[i][j].setDejaTireIci(dejaTireIci);
            }
        }

        ArrayList<Boat> boats = new ArrayList<Boat>();
        boolean continuer = true;
        while (continuer){
            string = in.readLine();
            if (string.equals("fin liste bateaux")){
                continuer = false;
            }
            else {
                String[] parts = string.split(",");
                String name = parts[0];
                int id = Integer.parseInt(parts[1]);
                int posX = Integer.parseInt(parts[2]);
                int posY = Integer.parseInt(parts[3]);
                int hp = Integer.parseInt(parts[4]);
                int size = Integer.parseInt(parts[5]);
                int direction = Integer.parseInt(parts[6]);
                if (epoque.equals("XX")){
                    Boat tmp = new BoatXX(name, id, posX, posY, size, direction);
                    tmp.setHp(hp);
                    boats.add(tmp);
                }
                if (epoque.equals("XVI")){
                    Boat tmp = new BoatXVI(name, id, posX, posY, size, direction);
                    tmp.setHp(hp);
                    boats.add(tmp);
                }
            }
        }
        Plateau p = new Plateau(epoque);
        p.setIdBoat(idBoat);
        p.setGrillOpponent(grilleOpponent);
        p.setGrillPlayer(grillePlayer);
        p.setListeBoat(boats);
        player.setPlateau(p);
    }
}

