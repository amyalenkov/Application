/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import Game.Player;
import Game.Team;
import Marker.BasicMarker;
import Marker.Content.AdditionalAction;
import Marker.Content.BasicAction;
import Marker.Content.PartBody;
import Marker.Marker;
import Tactics.Disposition;
import com.sun.jna.NativeLibrary;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.table.TableModel;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;

/**
 *
 * @author Артем
 */
public class Analisys extends javax.swing.JFrame {

    ActiveButtons activeButtons;
    Team team1;
    Team team2;
    List<String> mainTeam1;
    List<String> mainTeam2;
    List<Disposition> disposition1;
    List<Disposition> disposition2;
    Color colorTeam1;
    Color colorTeam2;
    Color colorNumber1;
    Color colorNumber2;
    int buttonSize1 = 42;
    int buttonSize2 = 42;
    Map<Disposition, JButton> disp1Buttons = new HashMap<Disposition, JButton>();
    Map<Disposition, JButton> disp2Buttons = new HashMap<Disposition, JButton>();
    
    GroupButtons groupButtons;
    
    List<Marker> markers = new ArrayList<Marker>();
    
    TableModel tm1;
    
    //team1    
    JButton jButton1 = new JButton("1");
    JButton jButton2 = new JButton("2");
    JButton jButton3 = new JButton("3");
    JButton jButton4 = new JButton("4");
    JButton jButton5 = new JButton("5");
    JButton jButton6 = new JButton("6");
    JButton jButton7 = new JButton("7");
    JButton jButton8 = new JButton("8");
    JButton jButton9 = new JButton("9");
    JButton jButton10 = new JButton("10");
    JButton jButton11 = new JButton("11");
    //team2  
    JButton jButton12 = new JButton("1");
    JButton jButton13 = new JButton("2");
    JButton jButton14 = new JButton("3");
    JButton jButton15 = new JButton("4");
    JButton jButton16 = new JButton("5");
    JButton jButton17 = new JButton("6");
    JButton jButton18 = new JButton("7");
    JButton jButton19 = new JButton("8");
    JButton jButton20 = new JButton("9");
    JButton jButton21 = new JButton("10");
    JButton jButton22 = new JButton("11");
    private boolean BUTTONS_DRAGGED = true;
    private boolean CHOISE_PLACE = false;
    private boolean CHOISE_PLAYER_ONE = false;
    private boolean CHOISE_PLAYER_TWO_1 = false;
    private boolean CHOISE_PLAYER_TWO_2 = false;

    /**
     * Creates new form Analisys
     */
    public Analisys(Team team1, Team team2, List<String> mainTeam1, List<String> mainTeam2,
            final List<Disposition> disposition1, List<Disposition> disposition2,
            Color colorTeam1, Color colorTeam2,
            Color colorNumber1, Color colorNumber2, ActiveButtons activeButtons) throws IOException {
        this.activeButtons = activeButtons;
        this.team1 = team1;
        this.team2 = team2;
        this.mainTeam1 = mainTeam1;
        this.mainTeam2 = mainTeam2;
        this.disposition1 = disposition1;
        this.disposition2 = disposition2;
        this.colorTeam1 = colorTeam1;
        this.colorTeam2 = colorTeam2;
        this.colorNumber1 = colorNumber1;
        this.colorNumber2 = colorNumber2;
        
        GroupButtons groupButtons = new GroupButtons();        
        initComponents();
        tm1 = jTable1.getModel();
        setBasicActionButtons();
        setAdditionalActionButtons();
        setPartBodyActionButtons();
        setOnePlayerButtons();
        setTwoPlayerButtons();
        setNewAction();


        setKeyEvents();
        setPlayer();
        setPlayerButtonListener();
        setScema();
        setLabels();
        setPlayerListCombobox();
        setDragAndDropButtonsLeft(jButton2, jButton3, jButton4, jButton5, jButton6,
                jButton7, jButton8, jButton9, jButton10, jButton11);
        setDragAndDropButtonsRight(jButton13,
                jButton14, jButton15, jButton16,
                jButton17, jButton18, jButton19, jButton20, jButton21, jButton22);

    }

    private Team getTeam(JButton button) {
        Team team = null;
        for (JButton jButton : groupButtons.getjButtonsTactic1()) {
            if (jButton.equals(button)) {
                team = team1;
            }
        }
        for (JButton jButton : groupButtons.getjButtonsTactic2()) {
            if (jButton.equals(button)) {
                team = team2;
            }
        }
        if (team == null) {
            throw new Error("TEAM is NULL!!!!!");
        } else {
            return team;
        }
    }

    private void setPlayerButtonListener() {
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton1);
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton2);
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton3);
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton4);
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton5);
    }

    private void jButton6ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton6);
    }

    private void jButton7ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton7);
    }

    private void jButton8ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton8);
    }

    private void jButton9ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton9);
    }

    private void jButton10ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton10);
    }

    private void jButton11ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton11);
    }

    private void jButton12ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton12);
    }

    private void jButton13ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton13);
    }

    private void jButton14ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton14);
    }

    private void jButton15ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton15);
    }

    private void jButton16ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton16);
    }

    private void jButton17ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton17);
    }

    private void jButton18ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton18);
    }

    private void jButton19ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton19);
    }

    private void jButton20ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton20);
    }

    private void jButton21ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton21);
    }

    private void jButton22ActionPerformed(ActionEvent evt) {
        setPlayerInMarker(jButton22);
    }

    private void setBasicActionButtons() {
        groupButtons.setBasicButtons(jButton38,jButton39,jButton40,jButton41,jButton42,
                jButton43,jButton44,jButton45,jButton45,jButton45,jButton45,jButton45,
                jButton45,jButton46,jButton47,jButton48,jButton49,jButton51,jButton52,
                jButton53,jButton54,jButton55,jButton56,jButton57,jButton58,jButton59,
                jButton60,jButton61,jButton62,jButton63,jButton64,jButton65,jButton66);
    }

    private void setAdditionalActionButtons() {
        groupButtons.setAdditionalButtons(jButton26,jButton27,jButton28,jButton29,
                jButton30,jButton31);       
    }

    private void setPartBodyActionButtons() {
        groupButtons.setPartBodyButtons(jButton32,jButton33,jButton34,jButton35);        
    }

    private void setOnePlayerButtons() {
        groupButtons.setOnePlayerButtons(jButton39,jButton40,jButton41,jButton42,
                jButton47,jButton48,jButton49,jButton51,jButton52,jButton54
                ,jButton60,jButton63,jButton64,jButton65);        
    }

    private void setTwoPlayerButtons() {    
        groupButtons.setTwoPlayerButtons(jButton44,jButton38,jButton46,jButton43
                ,jButton45,jButton58);      
    }

    private void setNewAction() {
        for (JButton button : groupButtons.getBasicButtons()) {
            button.setEnabled(true);
        }
        for (JButton button : groupButtons.getAdditionalButtons()) {
            button.setEnabled(false);
        }
        for (JButton button : groupButtons.getPartBodyButtons()) {
            button.setEnabled(false);
        }
        jLabel9.setText(AnalisysHelps.BASIC_ACTION);
    }

    private void disEnabledButtons(List<JButton> buttons, JButton... buttonsEnabled) {
        for (JButton button : buttons) {
            if (buttonsEnabled.length == 0) {
                button.setEnabled(false);
            } else {
                for (JButton disButton : buttonsEnabled) {
                    if (!button.equals(disButton)) {
                        button.setEnabled(false);
                    }
                }
            }
        }
    }

    private void noVisibleButtons(List<JButton> buttons, JButton... buttonsEnabled) {
        for (JButton button : buttons) {
            if (buttonsEnabled.length == 0) {
                button.setVisible(false);
            } else {
                for (JButton disButton : buttonsEnabled) {
                    if (!button.equals(disButton)) {
                        button.setVisible(false);
                    }
                }
            }
        }
    }

    private void visibleButtons(List<JButton> buttons, JButton... buttonsEnabled) {
        for (JButton button : buttons) {
            if (buttonsEnabled.length == 0) {
                button.setVisible(true);
            } else {
                for (JButton disButton : buttonsEnabled) {
                    if (!button.equals(disButton)) {
                        button.setVisible(true);
                    }
                }
            }
        }
    }

    private void enabledButtons(List<JButton> buttons, JButton... buttonsDisenabled) {
        for (JButton button : buttons) {
            if (buttonsDisenabled.length == 0) {
                button.setEnabled(true);
            } else {
                for (JButton disButton : buttonsDisenabled) {
                    if (!button.equals(disButton)) {
                        button.setEnabled(true);
                    }
                }
            }
        }
    }

    private void setDragAndDropButtonsLeft(JButton... jButtons) {
        for (JButton jButton : jButtons) {
            setButtonMouseDragged(jButton);
            setButtonMouseReleasedLeft(jButton);
        }

    }

    private void setDragAndDropButtonsRight(JButton... jButtons) {
        for (JButton jButton : jButtons) {
            setButtonMouseDragged(jButton);
            setButtonMouseReleasedRight(jButton);
        }

    }

    private void setButtonMouseDragged(final JButton jButton) {
        jButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                if (BUTTONS_DRAGGED) {
                    jButton.setBounds(evt.getXOnScreen(), evt.getYOnScreen() - 100, jButton.getHeight(), jButton.getWidth());
                }
            }
        });
    }

    private void setButtonMouseReleasedLeft(final JButton jButton1) {
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (BUTTONS_DRAGGED) {
                    Disposition dispositionOld = null;
                    for (Disposition disp : disp1Buttons.keySet()) {
                        if (disp1Buttons.get(disp).equals(jButton1)) {
                            dispositionOld = disp;
                        }
                    }
                    Disposition dispositionNew = Disposition.getDisp(evt.getXOnScreen() * 2, evt.getYOnScreen() - 100);
                    JButton jButton = null;
                    for (Disposition dispos : disp1Buttons.keySet()) {
                        if (dispos.getLine().equals(dispositionNew.getLine())
                                && dispos.getPosition().equals(dispositionNew.getPosition())) {
                            jButton = disp1Buttons.get(dispos);
                            jButton.setBounds(dispositionOld.getPositionX() / 2,
                                    dispositionOld.getLineY(),
                                    buttonSize1, buttonSize2);
                            jButton1.setBounds(dispositionNew.getPositionX() / 2, dispositionNew.getLineY(),
                                    buttonSize1, buttonSize2);
                        } else {
                            jButton1.setBounds(dispositionNew.getPositionX() / 2, dispositionNew.getLineY(),
                                    buttonSize1, buttonSize2);
                        }
                    }
                    if (jButton == null) {
                        disp1Buttons.remove(dispositionOld);
                    } else {
                        Disposition dispRemove = null;
                        for (Disposition disp : disp1Buttons.keySet()) {
                            if (disp1Buttons.get(disp).equals(jButton)) {
                                disp1Buttons.put(dispositionOld, disp1Buttons.get(disp));
                                dispRemove = disp;
                            }
                        }
                        disp1Buttons.remove(dispRemove);
                    }
                    disp1Buttons.put(dispositionNew, jButton1);
                }
            }
        });
    }

    private void setButtonMouseReleasedRight(final JButton jButton1) {
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Disposition dispositionOld = null;
                for (Disposition disp : disp2Buttons.keySet()) {
                    if (disp2Buttons.get(disp).equals(jButton1)) {
                        dispositionOld = disp;
                    }
                }
                Disposition dispositionNew = Disposition.getDispUpend(evt.getXOnScreen(), evt.getYOnScreen() - 100);
//                System.out.println("x: " + evt.getXOnScreen());
//                System.out.println("P: " + dispositionNew.getPosition());
//                System.out.println("L: " + dispositionNew.getLine());
                JButton jButton = null;
                for (Disposition dispos : disp2Buttons.keySet()) {
                    if (dispos.getLine().equals(dispositionNew.getLine())
                            && dispos.getPosition().equals(dispositionNew.getPosition())) {
                        jButton = disp2Buttons.get(dispos);
                        jButton.setBounds(dispositionOld.getPositionXupend() / 2 + 225,
                                dispositionOld.getLineYupend(),
                                buttonSize1, buttonSize2);
                        jButton1.setBounds(dispositionNew.getPositionXupend() / 2 + 225, dispositionNew.getLineYupend(),
                                buttonSize1, buttonSize2);
                    } else {
                        jButton1.setBounds(dispositionNew.getPositionXupend() / 2 + 225, dispositionNew.getLineYupend(),
                                buttonSize1, buttonSize2);
                    }
                }
                if (jButton == null) {
                    disp2Buttons.remove(dispositionOld);
                } else {
                    Disposition dispRemove = null;
                    for (Disposition disp : disp2Buttons.keySet()) {
                        if (disp2Buttons.get(disp).equals(jButton)) {
                            disp2Buttons.put(dispositionOld, disp2Buttons.get(disp));
                            dispRemove = disp;
                        }
                    }
                    disp2Buttons.remove(dispRemove);
                }
                disp2Buttons.put(dispositionNew, jButton1);
            }
        });
    }

    private void setPlayerListCombobox() {
        for (String playerIn : mainTeam1) {
            jComboBox1.addItem(playerIn);
        }
        for (Player playerOut : team1.getPlayers()) {
            for (String player : mainTeam1) {
                if (!player.replaceAll("\\D+", "").equals(playerOut.getNumber())) {
                    jComboBox2.addItem(playerOut.getNumber() + " "
                            + playerOut.getLastName() + " " + playerOut.getFirstName());
                }
            }
        }
        for (String playerIn : mainTeam2) {
            jComboBox4.addItem(playerIn);
        }
        for (Player playerOut : team2.getPlayers()) {
            for (String player : mainTeam2) {
                if (!player.replaceAll("\\D+", "").equals(playerOut.getNumber())) {
                    jComboBox3.addItem(playerOut.getNumber() + " "
                            + playerOut.getLastName() + " " + playerOut.getFirstName());
                }
            }
        }
    }

    private void setLabels() throws IOException {
        jLabel5.setIcon(new ImageIcon(ImageIO.read(new File("f:\\dev\\applicationNetBeans\\Application\\res\\in.png"))));
        jLabel6.setIcon(new ImageIcon(ImageIO.read(new File("f:\\dev\\applicationNetBeans\\Application\\res\\out.png"))));
        jButton24.setIcon(new ImageIcon(ImageIO.read(new File("f:\\dev\\applicationNetBeans\\Application\\res\\field-icons.png"))));
        jLabel8.setIcon(new ImageIcon(ImageIO.read(new File("f:\\dev\\applicationNetBeans\\Application\\res\\in.png"))));
        jLabel7.setIcon(new ImageIcon(ImageIO.read(new File("f:\\dev\\applicationNetBeans\\Application\\res\\out.png"))));
        jButton25.setIcon(new ImageIcon(ImageIO.read(new File("f:\\dev\\applicationNetBeans\\Application\\res\\field-icons.png"))));

        jLabel3.setText(team1.getName());
        jLabel4.setText(team2.getName());
    }

    private void setScema() {
        jPanel4.setLayout(null);
        groupButtons.setjButtonsTactic1(jButton1,jButton2,jButton3,jButton4,
                jButton5,jButton6,jButton7,jButton8,jButton9,jButton10,jButton11);
       
        int i = 0;
        for (JButton jButton : groupButtons.getjButtonsTactic1()) {
            jButton.setBounds(disposition1.get(i).getPositionX() / 2, disposition1.get(i).getLineY(),
                    buttonSize1, buttonSize2);
            jButton.setText(mainTeam1.get(i).replaceAll("\\D+", ""));
            disp1Buttons.put(disposition1.get(i), jButton);
            i++;
        }

        jPanel4.add(jButton1);
        jPanel4.add(jButton2);
        jPanel4.add(jButton3);
        jPanel4.add(jButton4);
        jPanel4.add(jButton5);
        jPanel4.add(jButton6);
        jPanel4.add(jButton7);
        jPanel4.add(jButton8);
        jPanel4.add(jButton9);
        jPanel4.add(jButton10);
        jPanel4.add(jButton11);

//        jPanel4.repaint();

        groupButtons.setjButtonsTactic2(jButton12,jButton13,jButton14,jButton15,
                jButton16,jButton17,jButton18,jButton19,jButton20,jButton21,jButton22);

        int y = 0;
        for (JButton jButton : groupButtons.getjButtonsTactic2()) {
            jButton.setBounds(disposition2.get(y).getPositionXupend() / 2 + 225, disposition2.get(y).getLineYupend(),
                    buttonSize1, buttonSize2);
            jButton.setText(mainTeam2.get(y).replaceAll("\\D+", ""));
            disp2Buttons.put(disposition2.get(y), jButton);
            y++;
        }

        jPanel4.add(jButton12);
        jPanel4.add(jButton13);
        jPanel4.add(jButton14);
        jPanel4.add(jButton15);
        jPanel4.add(jButton16);
        jPanel4.add(jButton17);
        jPanel4.add(jButton18);
        jPanel4.add(jButton19);
        jPanel4.add(jButton20);
        jPanel4.add(jButton21);
        jPanel4.add(jButton22);

        jPanel4.repaint();
    }

    private void setKeyEvents() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_RELEASED) {
//                    System.out.println("keyPress:" + e.getKeyChar());
//                    System.out.println("keyPress:" + e.getKeyCode());
                    for (String keyChar : activeButtons.getListButtons()) {
//                        System.out.println("for1: " + KeyEvent.getKeyText(e.getKeyCode()));
//                        System.out.println("for2: " + keyChar);
                        if (KeyEvent.getKeyText(e.getKeyCode()).
                                equals(keyChar)) {
//                            System.out.println("key:" + activeButtons.getAction(keyChar));
                        }
                    }

                }
                return false;
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new Field("small");
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton23 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1100, 700));

        jPanel4.setOpaque(false);
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton26.setText("Аут");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 101, 20));

        jButton27.setText("Свободный");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24, 101, 20));

        jButton28.setText("Штрафной");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, 101, 20));

        jButton29.setText("Угловой");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 68, 101, 20));

        jButton30.setText("Пенальти");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 92, 101, 20));

        jButton31.setText("Обрыв тр.");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 116, 101, 20));

        jButton32.setText("Головой");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 142, 101, 20));

        jButton33.setText("Правой ногой");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 166, -1, 20));

        jButton34.setText("Левой ногой");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 192, 101, 20));

        jButton35.setText("Телом");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 216, 101, 20));

        jButton36.setText("Выход мяча");
        jPanel2.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 101, 20));

        jButton38.setText("Единоборство вверху");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 170, 42));

        jButton39.setText("КП");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 100, 42));

        jButton40.setText("Навес");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 100, 42));

        jButton41.setText("Острая");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 100, 42));

        jButton42.setText("ПП");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 0, 100, 42));

        jButton43.setText("Обводка неудачная");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 140, 42));

        jButton44.setText("Единоборство");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 140, 42));

        jButton45.setText("Отбор");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 160, 42));

        jButton46.setText("Обводка удачная");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 130, 42));

        jButton47.setText("Подбор/прием");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 120, 40));

        jButton48.setText("Перехват");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 100, 42));

        jButton49.setText("Вынос");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 120, 40));

        jButton51.setText("Неуд. обр.");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 90, 40));

        jButton52.setText("Ведение");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 100, 40));

        jButton53.setText("Удар перехват");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, 40));

        jButton54.setText("Грубая ошибка");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, 40));

        jButton55.setText("Удар мимо");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 90, 40));

        jButton56.setText("Удар штанг/перек");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 130, 40));

        jButton57.setText("Удар в створ");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, 40));

        jButton58.setText("Фол");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton58, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 100, 40));

        jButton59.setText("Гол");
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton59, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 100, 40));

        jButton60.setText("Офсайд");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton60, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 100, 40));

        jButton61.setText("Офсайд");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton61, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 100, 40));

        jButton62.setText("ЖК");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton62, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, 40));

        jButton63.setText("Сэйв");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton63, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 60, 40));

        jButton64.setText("Игра на выходе -");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton64, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, 40));

        jButton65.setText("Игра на выходе +");
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton65, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, 40));

        jButton66.setText("КК");
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton66, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 50, 40));

        jLabel9.setText("jLabel9");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 470, -1));

        jLabel1.setText("00:00:00");

        jLabel2.setText("00:00:00");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Действие", "Доп. действие", "Часть тела", "Игрок1", "Команда1", "Игорок2", "Команда2", "Х", "У", "Время"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jButton23.setText("Открыть файл");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton23)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jButton23)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("JLabel1");
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Уходит" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Выходит" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Выходит" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Уходит" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton25MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton25MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton25MouseReleased(evt);
            }
        });
        jButton25.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButton25MouseDragged(evt);
            }
        });

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addComponent(jButton25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            mediaPlayer.playMedia(file.getAbsolutePath());
            jLabel2.setText(String.valueOf(mediaPlayer.getAudioDelay()));
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25MousePressed

    private void jButton25MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25MouseDragged

    private void jButton25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25MouseExited

    private void jButton25MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25MouseReleased

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        newBasicMarker(jButton48, BasicAction.KICK_INTERCEPT);
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        newBasicMarker(jButton48, BasicAction.KICK_AWAY);
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        newBasicMarker(jButton48, BasicAction.KICK_IN_CROSSBAR);
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        newBasicMarker(jButton48, BasicAction.KICK_IN_TARGET);
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        newBasicMarker(jButton48, BasicAction.OFFSIDE);
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        newBasicMarker(jButton48, BasicAction.YELLOW_CARD);
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        newBasicMarker(jButton48, BasicAction.SAVE);
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        newBasicMarker(jButton48, BasicAction.GAME_ON_OUT_FAIL);
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        newBasicMarker(jButton48, BasicAction.GAME_ON_OUT_SUCCESS);
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66ActionPerformed
        newBasicMarker(jButton48, BasicAction.RED_CARD);
    }//GEN-LAST:event_jButton66ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        newBasicMarker(jButton42, BasicAction.P_PASS);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        setAdditionalAction(jButton26, AdditionalAction.OUT);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        newBasicMarker(jButton39, BasicAction.K_PASS);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        newBasicMarker(jButton40, BasicAction.CROSS);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        newBasicMarker(jButton41, BasicAction.ACUTE_PASS);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        setAdditionalAction(jButton26, AdditionalAction.FREE_KICK);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        setAdditionalAction(jButton26, AdditionalAction.FOUL_KICK);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        setAdditionalAction(jButton26, AdditionalAction.CORNER);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        setAdditionalAction(jButton26, AdditionalAction.PENALTY);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        setAdditionalAction(jButton26, AdditionalAction.BREAK);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        setPartBody(jButton32, PartBody.HEAD);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        setPartBody(jButton33, PartBody.RIGHT_FOOT);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        setPartBody(jButton32, PartBody.LEFT_FOOT);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        setPartBody(jButton32, PartBody.BODY);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        if (CHOISE_PLACE) {
//            System.out.println("x " + evt.getX());
//            System.out.println("y " + evt.getY());
            setPointsInMarker(evt.getX(), evt.getY());
            CHOISE_PLACE = false;
        }
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        newBasicMarker(jButton48, BasicAction.INTERCEPT);
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        newBasicMarker(jButton48, BasicAction.COMBAT);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        newBasicMarker(jButton48, BasicAction.COMBAT_IN_AIR);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        newBasicMarker(jButton48, BasicAction.STROKED_SUCCESS);
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        newBasicMarker(jButton48, BasicAction.STROKED_FAIL);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        newBasicMarker(jButton48, BasicAction.TAKE_AWAY);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        newBasicMarker(jButton48, BasicAction.RUNNING);
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        newBasicMarker(jButton48, BasicAction.TAKE);
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        newBasicMarker(jButton48, BasicAction.FAIL_HANDLING);
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        newBasicMarker(jButton48, BasicAction.OFFSET);
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        newBasicMarker(jButton48, BasicAction.FOUL);
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        newBasicMarker(jButton48, BasicAction.GOAL);
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        newBasicMarker(jButton48, BasicAction.RUDE_FAID);
    }//GEN-LAST:event_jButton54ActionPerformed

    private void setAdditionalAction(JButton button, AdditionalAction additionalAction) {
//        for(JButton jButton : additionalButtons){
//            Color color = new Color(5);
//            jButton.setBackground(color);
//        }
//        button.setBackground(Color.GREEN);

        BasicMarker lastBasicMarker = (BasicMarker) markers.get(markers.size() - 1);
        lastBasicMarker.setAdditionalAction(additionalAction);
        tm1.setValueAt(lastBasicMarker.getAdditionalAction(), markers.size() - 1, 2);
    }

    private void setPartBody(JButton button, PartBody partBody) {
        BasicMarker lastBasicMarker = (BasicMarker) markers.get(markers.size() - 1);
        lastBasicMarker.setPartBody(partBody);
        tm1.setValueAt(lastBasicMarker.getPartBody(), markers.size() - 1, 3);
    }

    private void newBasicMarker(JButton button, BasicAction basicAction) {
//        button.setBackground(Color.GREEN);
        BUTTONS_DRAGGED = false;
        BasicMarker basicMarker = new BasicMarker(markers.size(), basicAction);
        markers.add(basicMarker);
        tm1.setValueAt(basicMarker.getId(), markers.size() - 1, 0);
        tm1.setValueAt(basicMarker.getBasicAction(), markers.size() - 1, 1);

        disEnabledButtons(groupButtons.getBasicButtons());
        enabledButtons(groupButtons.getAdditionalButtons(), jButton30);
        enabledButtons(groupButtons.getPartBodyButtons());
        for (JButton jButton : groupButtons.getOnePlayerButtons()) {
            if (jButton.equals(button)) {
                jLabel9.setText(AnalisysHelps.ADDITIONAL_ACTION_FOR_ONE);
                CHOISE_PLAYER_ONE = true;
                System.out.println("One");
            }
        }
        for (JButton jButton : groupButtons.getTwoPlayerButtons()) {
            if (jButton.equals(button)) {
                jLabel9.setText(AnalisysHelps.ADDITIONAL_ACTION_FOR_TWO_1);
                CHOISE_PLAYER_TWO_1 = true;
                System.out.println("two");
            }
        }



    }

    private void setPlayerInMarker(JButton button) {
        BasicMarker lastBasicMarker = (BasicMarker) markers.get(markers.size() - 1);
        System.out.println("button: " + button.getText());
        if (CHOISE_PLAYER_ONE) {
            lastBasicMarker.setPlayerNumber1(button.getText());
            setTeamInMarker(lastBasicMarker, button);

            tm1.setValueAt(lastBasicMarker.getPlayerNumber1(), markers.size() - 1, 4);
            tm1.setValueAt(lastBasicMarker.getTeamId1(), markers.size() - 1, 5);
            noVisibleButtons(groupButtons.getjButtonsTactic1());
            noVisibleButtons(groupButtons.getjButtonsTactic2());
            jLabel9.setText(AnalisysHelps.PLACE);
            CHOISE_PLACE = true;
            CHOISE_PLAYER_ONE = false;
            System.out.println("One1");
        } else if (CHOISE_PLAYER_TWO_1) {
            lastBasicMarker.setPlayerNumber1(button.getText());
            setTeamInMarker(lastBasicMarker, button);
            tm1.setValueAt(lastBasicMarker.getPlayerNumber1(), markers.size() - 1, 4);
            tm1.setValueAt(lastBasicMarker.getTeamId1(), markers.size() - 1, 5);
            jLabel9.setText(AnalisysHelps.ADDITIONAL_ACTION_FOR_TWO_2);
            CHOISE_PLAYER_TWO_1 = false;
            CHOISE_PLAYER_TWO_2 = true;
            setVisibleChoisePlayerTwo(button);
            System.out.println("two1");
        } else if (CHOISE_PLAYER_TWO_2) {
            lastBasicMarker.setPlayerNumber2(button.getText());
            setTeamInMarker(lastBasicMarker, button);
            tm1.setValueAt(lastBasicMarker.getPlayerNumber2(), markers.size() - 1, 6);
            tm1.setValueAt(lastBasicMarker.getTeamId2(), markers.size() - 1, 7);
            jLabel9.setText(AnalisysHelps.PLACE);
            CHOISE_PLACE = true;
            CHOISE_PLAYER_TWO_2 = false;
            setVisibleChoisePlayerTwo(button);
            System.out.println("two2");
        }
        BUTTONS_DRAGGED = true;
    }

    private void setVisibleChoisePlayerTwo(JButton button) {
        for (JButton jButton : groupButtons.getjButtonsTactic1()) {
            if (jButton.equals(button)) {
                noVisibleButtons(groupButtons.getjButtonsTactic1());
            }
        }
        for (JButton jButton : groupButtons.getjButtonsTactic2()) {
            if (jButton.equals(button)) {
                noVisibleButtons(groupButtons.getjButtonsTactic2());
            }
        }
    }

    private void setPointsInMarker(int x, int y) {
        BasicMarker lastBasicMarker = (BasicMarker) markers.get(markers.size() - 1);
        lastBasicMarker.setxPoint(x);
        lastBasicMarker.setyPoint(y);
        tm1.setValueAt(lastBasicMarker.getxPoint(), markers.size() - 1, 8);
        tm1.setValueAt(lastBasicMarker.getyPoint(), markers.size() - 1, 9);
        visibleButtons(groupButtons.getjButtonsTactic1());
        visibleButtons(groupButtons.getjButtonsTactic2());
//        jLabel9.setText(AnalisysHelps.PLACE);
        CHOISE_PLACE = true;
        setNewAction();
    }

    private void setTeamInMarker(BasicMarker lastBasicMarker, JButton button) {
        String id = getTeam(button).getId();
        if (CHOISE_PLAYER_ONE || CHOISE_PLAYER_TWO_1) {
            lastBasicMarker.setTeamId1(id);
        } else if (CHOISE_PLAYER_TWO_2) {
            lastBasicMarker.setTeamId2(id);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Analisys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analisys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analisys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analisys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Analisys().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    EmbeddedMediaPlayer mediaPlayer;

    private void setPlayer() {
        String file = new File(".").getAbsolutePath();

        NativeLibrary.addSearchPath("libvlc", file + "\\nativeLibs\\");
        NativeLibrary.addSearchPath("libvlccore", file + "\\nativeLibs\\");
//        NativeLibrary.addSearchPath("libvlc", "f:\\dev\\nativeLibs\\");
//        NativeLibrary.addSearchPath("libvlccore", "f:\\dev\\nativeLibs\\");
        MediaPlayerFactory factory = new MediaPlayerFactory();

        mediaPlayer = factory.newEmbeddedMediaPlayer();
        mediaPlayer.setRepeat(false);
        mediaPlayer.setEnableKeyInputHandling(false);
        mediaPlayer.setEnableMouseInputHandling(false);

        CanvasVideoSurface videoSurface = factory.newVideoSurface(canvas1);
        mediaPlayer.setVideoSurface(videoSurface);
    }
}
