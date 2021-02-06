package com.example.ObsScore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ScoreUpdater{

    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField txtSocieta1;
    private JTextField txtNome1;
    private JTextField txtAltro1;
    private JTextField txtSocieta2;
    private JTextField txtNome2;
    private JTextField txtAltro2;
    private JButton btnConferma;
    private JButton btnResetGiocatori;
    private JButton btnSubSoc1;
    private JTextField txtScoreSoc1;
    private JButton btnAddSoc1;
    private JButton btnSubSet1;
    private JButton btnSubScore1;
    private JButton btnAddSet1;
    private JButton btnAddScore1;
    private JTextField txtScoreSet1;
    private JTextField txtScoreScore1;
    private JButton btnSubSoc2;
    private JButton btnSubSet2;
    private JButton btnSubScore2;
    private JButton btnAddSoc2;
    private JButton btnAddSet2;
    private JButton btnAddScore2;
    private JTextField txtScoreSoc2;
    private JTextField txtScoreSet2;
    private JTextField txtScoreScore2;
    private JButton btnUpdate;
    private JButton btnResetPunteggio;
    private JTextField txtPath;
    private JButton btnPath;

    private String FILE_PATH = "C:/ObsScores";
    private File file;

    private static final String SOCIETA1 = "/dati/società1.txt";
    private static final String SOCIETA2 = "/dati/società2.txt";
    private static final String GIOCATORE1 = "/dati/giocatore1.txt";
    private static final String GIOCATORE2 = "/dati/giocatore2.txt";
    private static final String ALTRO1 = "/dati/altro1.txt";
    private static final String ALTRO2 = "/dati/altro2.txt";
    private static final String PUNTEGGIOSOCIETA1 = "/punteggi/punteggioSocietà1.txt";
    private static final String PUNTEGGIOSOCIETA2 = "/punteggi/punteggioSocietà2.txt";
    private static final String SETGIOCATORE1 = "/punteggi/setGiocatore1.txt";
    private static final String SETGIOCATORE2 = "/punteggi/setGiocatore2.txt";
    private static final String PUNTEGGIOGIOCATORE1 = "/punteggi/punteggioGiocatore1.txt";
    private static final String PUNTEGGIOGIOCATORE2 = "/punteggi/punteggioGiocatore2.txt";

    public ScoreUpdater() {
        txtPath.setText(FILE_PATH);
        file = new File(FILE_PATH);
        file.mkdirs();


        try{
            FileReader f = new FileReader(FILE_PATH + "/path.txt");
            BufferedReader fIn = new BufferedReader(f);
            FILE_PATH = fIn.readLine();
            txtPath.setText(FILE_PATH);
            f.close();
            fIn.close();
        }catch (IOException e){
            e.printStackTrace();
            try {
                FileWriter f = new FileWriter(FILE_PATH + "/path.txt", false);
                PrintWriter fOut = new PrintWriter(f, false);
                fOut.print(file.getPath());
                f.close();
                fOut.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        file = new File(FILE_PATH + "/dati");
        file.mkdirs();
        file = new File(FILE_PATH + "/punteggi");
        file.mkdirs();

        file = new File(FILE_PATH);


        txtScoreSoc1.setText("0");
        txtScoreSoc2.setText("0");
        txtScoreSet1.setText("0");
        txtScoreSet2.setText("0");
        txtScoreScore1.setText("0");
        txtScoreScore2.setText("0");




//        MODIFICA PERCORSO DEI FILE

        btnPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    try {
                        FileWriter f = new FileWriter(FILE_PATH + "/path.txt", false);
                        PrintWriter fOut = new PrintWriter(f, false);
                        fOut.print(file.getPath());
                        f.close();
                        fOut.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    FILE_PATH = file.getPath();
                    txtPath.setText(FILE_PATH);
                }

            }
        });




//        SETTAGGIO DATI GIOCATORI

        btnConferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + SOCIETA1, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtSocieta1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + SOCIETA2, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtSocieta2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + GIOCATORE1, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtNome1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + GIOCATORE2, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtNome2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + ALTRO1, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtAltro1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + ALTRO2, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtAltro2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        btnResetGiocatori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSocieta1.setText(null);
                txtSocieta2.setText(null);
                txtNome1.setText(null);
                txtNome2.setText(null);
                txtAltro1.setText(null);
                txtAltro2.setText(null);
            }
        });







//        AGGIORNAMENTO PUNTEGGI
//          sottrazione punti


        btnSubSoc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOSOCIETA1, false);
                    fOut = new PrintWriter(f);
                    txtScoreSoc1.setText(String.valueOf(Integer.parseInt(txtScoreSoc1.getText())-1));
                    fOut.print(txtScoreSoc1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnSubSoc2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOSOCIETA2, false);
                    fOut = new PrintWriter(f);
                    txtScoreSoc2.setText(String.valueOf(Integer.parseInt(txtScoreSoc2.getText())-1));
                    fOut.print(txtScoreSoc2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnSubSet1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + SETGIOCATORE1, false);
                    fOut = new PrintWriter(f);
                    txtScoreSet1.setText(String.valueOf(Integer.parseInt(txtScoreSet1.getText())-1));
                    fOut.print(txtScoreSet1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnSubSet2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + SETGIOCATORE2, false);
                    fOut = new PrintWriter(f);
                    txtScoreSet2.setText(String.valueOf(Integer.parseInt(txtScoreSet2.getText())-1));
                    fOut.print(txtScoreSet2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnSubScore1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOGIOCATORE1, false);
                    fOut = new PrintWriter(f);
                    txtScoreScore1.setText(String.valueOf(Integer.parseInt(txtScoreScore1.getText())-1));
                    fOut.print(txtScoreScore1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnSubScore2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOGIOCATORE2, false);
                    fOut = new PrintWriter(f);
                    txtScoreScore2.setText(String.valueOf(Integer.parseInt(txtScoreScore2.getText())-1));
                    fOut.print(txtScoreScore2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

//        aggiunta punti

        btnAddSoc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOSOCIETA1, false);
                    fOut = new PrintWriter(f);
                    txtScoreSoc1.setText(String.valueOf(Integer.parseInt(txtScoreSoc1.getText())+1));
                    fOut.print(txtScoreSoc1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnAddSoc2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOSOCIETA2, false);
                    fOut = new PrintWriter(f);
                    txtScoreSoc2.setText(String.valueOf(Integer.parseInt(txtScoreSoc2.getText())+1));
                    fOut.print(txtScoreSoc2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnAddSet1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + SETGIOCATORE1, false);
                    fOut = new PrintWriter(f);
                    txtScoreSet1.setText(String.valueOf(Integer.parseInt(txtScoreSet1.getText())+1));
                    fOut.print(txtScoreSet1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnAddSet2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + SETGIOCATORE2, false);
                    fOut = new PrintWriter(f);
                    txtScoreSet2.setText(String.valueOf(Integer.parseInt(txtScoreSet2.getText())+1));
                    fOut.print(txtScoreSet2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnAddScore1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOGIOCATORE1, false);
                    fOut = new PrintWriter(f);
                    txtScoreScore1.setText(String.valueOf(Integer.parseInt(txtScoreScore1.getText())+1));
                    fOut.print(txtScoreScore1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        btnAddScore2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOGIOCATORE2, false);
                    fOut = new PrintWriter(f);
                    txtScoreScore2.setText(String.valueOf(Integer.parseInt(txtScoreScore2.getText())+1));
                    fOut.print(txtScoreScore2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


//        aggiornamento completo

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter f;
                PrintWriter fOut;
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOSOCIETA1, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtScoreSoc1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOSOCIETA2, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtScoreSoc2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + SETGIOCATORE1, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtScoreSet1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + SETGIOCATORE2, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtScoreSet2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOGIOCATORE1, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtScoreScore1.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    f = new FileWriter(FILE_PATH + PUNTEGGIOGIOCATORE2, false);
                    fOut = new PrintWriter(f);
                    fOut.print(txtScoreScore2.getText());
                    f.close();
                    fOut.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });



        btnResetPunteggio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtScoreSoc1.setText("0");
                txtScoreSoc2.setText("0");
                txtScoreSet1.setText("0");
                txtScoreSet2.setText("0");
                txtScoreScore1.setText("0");
                txtScoreScore2.setText("0");
            }
        });
    }












    public static void main(String[] args) {
        JFrame frame = new JFrame("ScoreUpdater");
        frame.setIconImage(new ImageIcon("res/logo.png").getImage());
        frame.setContentPane(new ScoreUpdater().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
