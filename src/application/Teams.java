/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import Game.Player;
import Game.Team;
import Game.TeamParser;
import Tactics.Disposition;
import Tactics.FourFourThreeDown;
import Tactics.FourFourThreeUp;
import Tactics.FourFourTwoClassic;
import Tactics.FourFourTwoDiamond;
import Tactics.FourOneFourOne;
import Tactics.FourTwoThreeOne;
import Tactics.LINE;
import Tactics.POSITION;
import Tactics.ThreeFiveTwo;
import httpClient.HttpHelper;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.MouseInfo;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Артем
 */
public class Teams extends javax.swing.JFrame {

    private final BufferedImage image;
    HttpHelper httpHelper;
    Team team1;
    Team team2;
    Color colorTeam1;
    Color colorNumber1;
    Color colorTeam2;
    Color colorNumber2;
    TableModel tm1;
    TableModel tm2;
    TableModel tm3;
    private JComboBox fioList;
    private JComboBox fioList2;
    private JComboBox buttonList;
    ActiveButtons activeButtons = new ActiveButtons();
    List<Disposition> disposition1;
    List<Disposition> disposition2;
    

    /**
     * Creates new form Teams
     */
    public Teams() throws IOException {
        super("Teams");
        setButtomListInTable1();
        initComponents();

        getTableModels();

        setChoiceGame();

        String path = new File(".").getAbsolutePath();
        image = ImageIO.read(new File(path + "\\res\\footballField.jpg"));
        MyCanvas canvas = new MyCanvas();
        canvas.setVisible(true);

        getHttpResponseTournaments();

//        setTactic();


    }
    //table1
    List<JButton> jButtonsTactic1 = new ArrayList<JButton>();;
    JButton jButton15 = new JButton("1");
    JButton jButton16 = new JButton("2");
    JButton jButton17 = new JButton("3");
    JButton jButton18 = new JButton("4");
    JButton jButton19 = new JButton("5");
    JButton jButton20 = new JButton("6");
    JButton jButton21 = new JButton("7");
    JButton jButton22 = new JButton("8");
    JButton jButton23 = new JButton("9");
    JButton jButton24 = new JButton("10");
    JButton jButton25 = new JButton("11");
    //table2
    List<JButton> jButtonsTactic2 = new ArrayList<JButton>();;
    JButton jButton4 = new JButton("1");
    JButton jButton5 = new JButton("2");
    JButton jButton6 = new JButton("3");
    JButton jButton7 = new JButton("4");
    JButton jButton8 = new JButton("5");
    JButton jButton9 = new JButton("6");
    JButton jButton10 = new JButton("7");
    JButton jButton11 = new JButton("8");
    JButton jButton12 = new JButton("9");
    JButton jButton13 = new JButton("10");
    JButton jButton14 = new JButton("11");

    private void setTactic(String table, List<Disposition> dispositions) {
        if (table.equals("table1")) {
            jPanel10.setLayout(null);
            int buttonSize1 = 43;
            int buttonSize2 = 43;

            disposition1 = dispositions;

            jButtonsTactic1.add(jButton15);
            jButtonsTactic1.add(jButton16);
            jButtonsTactic1.add(jButton17);
            jButtonsTactic1.add(jButton18);
            jButtonsTactic1.add(jButton19);
            jButtonsTactic1.add(jButton20);
            jButtonsTactic1.add(jButton21);
            jButtonsTactic1.add(jButton22);
            jButtonsTactic1.add(jButton23);
            jButtonsTactic1.add(jButton24);
            jButtonsTactic1.add(jButton25);
            int i = 0;
            for (JButton jButton : jButtonsTactic1) {
                jButton.setBounds(dispositions.get(i).getPositionX(), dispositions.get(i).getLineY(),
                        buttonSize1, buttonSize2);
                i++;
            }

            jPanel10.add(jButton15);
            jPanel10.add(jButton16);
            jPanel10.add(jButton17);
            jPanel10.add(jButton18);
            jPanel10.add(jButton19);
            jPanel10.add(jButton20);
            jPanel10.add(jButton21);
            jPanel10.add(jButton22);
            jPanel10.add(jButton23);
            jPanel10.add(jButton24);
            jPanel10.add(jButton25);

            jPanel10.repaint();
        } else if (table.equals("table2")) {
            jPanel8.setLayout(null);
            int buttonSize1 = 43;
            int buttonSize2 = 43;
            
            disposition2 = dispositions;

            jButtonsTactic2.add(jButton4);
            jButtonsTactic2.add(jButton5);
            jButtonsTactic2.add(jButton6);
            jButtonsTactic2.add(jButton7);
            jButtonsTactic2.add(jButton8);
            jButtonsTactic2.add(jButton9);
            jButtonsTactic2.add(jButton10);
            jButtonsTactic2.add(jButton11);
            jButtonsTactic2.add(jButton12);
            jButtonsTactic2.add(jButton13);
            jButtonsTactic2.add(jButton14);
            int i = 0;
            for (JButton jButton : jButtonsTactic2) {
                jButton.setBounds(dispositions.get(i).getPositionXupend(),
                        dispositions.get(i).getLineYupend(),
                        buttonSize1, buttonSize2);
                i++;
            }

            jPanel8.add(jButton4);
            jPanel8.add(jButton5);
            jPanel8.add(jButton6);
            jPanel8.add(jButton7);
            jPanel8.add(jButton8);
            jPanel8.add(jButton9);
            jPanel8.add(jButton10);
            jPanel8.add(jButton11);
            jPanel8.add(jButton12);
            jPanel8.add(jButton13);
            jPanel8.add(jButton14);

            jPanel8.repaint();
        }
    }

    private void setButtomListInTable1() {
        buttonList = new JComboBox();
        buttonList.addItem("Выбор кнопки");
//        for(KeyEvent.VK_0){

//        }
        for (int i = 0; i < 200; i++) {
            if (!KeyEvent.getKeyText(i).contains("Unknown keyCode")) {
                buttonList.addItem(KeyEvent.getKeyText(i));
            }

        }

    }

    private void getTableModels() {
        tm1 = jTable3.getModel();
        tm2 = jTable5.getModel();

        tm1.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    if (tme.getColumn() == 3) {
                        String number = String.valueOf(tm1.getValueAt(tme.getFirstRow(), tme.getColumn()));
                        number = number.replaceAll("\\D+", "");
                        tm1.setValueAt(number, tme.getFirstRow(), 2);
                        for (Player player : team1.getPlayers()) {
                            if (player.getNumber().equals(number)) {
                                tm1.setValueAt(player.getId(), tme.getFirstRow(), 1);
                            }
                        }
                        if(!jButtonsTactic1.isEmpty()){
                            jButtonsTactic1.get(tme.getFirstRow()).setText(number);
                        }
                    }
                }
            }
        });
        tm2.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent tme) {
                if (tme.getType() == TableModelEvent.UPDATE) {
                    if (tme.getColumn() == 3) {
                        String number = String.valueOf(tm2.getValueAt(tme.getFirstRow(), tme.getColumn()));
                        number = number.replaceAll("\\D+", "");
                        tm2.setValueAt(number, tme.getFirstRow(), 2);
                        for (Player player : team2.getPlayers()) {
                            if (player.getNumber().equals(number)) {
                                tm2.setValueAt(player.getId(), tme.getFirstRow(), 1);
                            }
                        }     
                        if(!jButtonsTactic2.isEmpty()){
                            jButtonsTactic2.get(tme.getFirstRow()).setText(number);
                        }                        
                    }
                }
            }
        });




    }

    private void setChoiceGame() {
        jPanel5.setVisible(true);
        jPanel1.setVisible(false);
    }

    private void getHttpResponseTournaments() throws IOException {
        httpHelper = new HttpHelper();
        List<String> tournaments = httpHelper.getToutnaments();
        for (String tournament : tournaments) {
            jComboBox1.addItem(tournament);
        }

    }

    private void setTacticIn(String table, String nameTactic) {
        if (!nameTactic.equals("Выберите расстановку")) {
            if (nameTactic.equals("4-4-2 classic")) {
                FourFourTwoClassic fourFourTwoClassic = new FourFourTwoClassic();
                setTactic(table, fourFourTwoClassic.getTactic());
                setValueInTable(table, fourFourTwoClassic.getTactic());
            } else if (nameTactic.equals("4-4-2 diamond")) {
                FourFourTwoDiamond fourFourTwoDiamond = new FourFourTwoDiamond();
                setTactic(table, fourFourTwoDiamond.getTactic());
                setValueInTable(table, fourFourTwoDiamond.getTactic());
            } else if (nameTactic.equals("4-3-3 up")) {
                FourFourThreeUp FourFourThreeUp = new FourFourThreeUp();
                setTactic(table, FourFourThreeUp.getTactic());
                setValueInTable(table, FourFourThreeUp.getTactic());
            } else if (nameTactic.equals("4-3-3 down")) {
                FourFourThreeDown FourFourThreeDown = new FourFourThreeDown();
                setTactic(table, FourFourThreeDown.getTactic());
                setValueInTable(table, FourFourThreeDown.getTactic());
            } else if (nameTactic.equals("4-2-3-1")) {
                FourTwoThreeOne fourTwoThreeOne = new FourTwoThreeOne();
                setTactic(table, fourTwoThreeOne.getTactic());
                setValueInTable(table, fourTwoThreeOne.getTactic());
            } else if (nameTactic.equals("4-1-4-1")) {
                FourOneFourOne FourOneFourOne = new FourOneFourOne();
                setTactic(table, FourOneFourOne.getTactic());
                setValueInTable(table, FourOneFourOne.getTactic());
            } else if (nameTactic.equals("3-5-2")) {
                ThreeFiveTwo ThreeFiveTwo = new ThreeFiveTwo();
                setTactic(table, ThreeFiveTwo.getTactic());
                setValueInTable(table, ThreeFiveTwo.getTactic());
            }
        }
    }

    private void setValueInTable(String table, List<Disposition> dispositions) {
        if (table.equals("table1")) {
            tm1 = jTable3.getModel();
            int i = 0;
            for (Disposition disposition : dispositions) {
                tm1.setValueAt(disposition.getPosition().name(), i, 4);
                tm1.setValueAt(disposition.getLine().name(), i, 5);
                i++;
            }
        } else if (table.equals("table2")) {
            tm2 = jTable5.getModel();
            int i = 0;
            for (Disposition disposition : dispositions) {
                tm2.setValueAt(disposition.getPosition().name(), i, 4);
                tm2.setValueAt(disposition.getLine().name(), i, 5);
                i++;
            }
        }

    }

    class MyCanvas extends Canvas {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel9 = new Field("small");
        jPanel10 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel7 = new Field("small");
        jPanel8 = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1000, 0));
        setPreferredSize(new java.awt.Dimension(1130, 650));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel3KeyPressed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Ввести турнир");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Ввести ID");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Турнир");

        jLabel2.setText("Матч");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Выберите турнир" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Выберите матч" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, 176, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setText("ID матча");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButton3.setText("Загрузить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addGap(102, 102, 102))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Начать разбор");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Регистрация", "Выбор кнопки"},
                {"Пауза", "Выбор кнопки"},
                {"Назад", "Выбор кнопки"},
                {"Вперед", "Выбор кнопки"},
                {"Шаг, сек", "Выбор кнопки"},
                {"Отмена точки", "Выбор кнопки"},
                {"ПП", "Выбор кнопки"},
                {"КП", "Выбор кнопки"},
                {"Навес", "Выбор кнопки"},
                {"ОП", "Выбор кнопки"},
                {"Перехват", "Выбор кнопки"},
                {"Ед-во", "Выбор кнопки"},
                {"Ед-во вверху", "Выбор кнопки"},
                {"Отбор", "Выбор кнопки"},
                {"Обводка уд", "Выбор кнопки"},
                {"Обводка неуд", "Выбор кнопки"},
                {"Ведение", "Выбор кнопки"},
                {"Подбор", "Выбор кнопки"},
                {"Неуд. обработка", "Выбор кнопки"},
                {"Вынос", "Выбор кнопки"},
                {"Удар в створ", "Выбор кнопки"},
                {"Удар мимо", "Выбор кнопки"},
                {"Удар в шт/перекл", "Выбор кнопки"},
                {"Удар перехв", "Выбор кнопки"},
                {"Фол", "Выбор кнопки"},
                {"Гол", "Выбор кнопки"},
                {"Грубая ошибка", "Выбор кнопки"},
                {"Офсайд", "Выбор кнопки"},
                {"ЖК", "Выбор кнопки"},
                {"КК", "Выбор кнопки"},
                {"Сэйв", "Выбор кнопки"},
                {"Игра на вых. уд", "Выбор кнопки"},
                {"Игра на вых. неуд", "Выбор кнопки"}
            },
            new String [] {
                "Действие", "Кнопка"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        TableColumn buttomColumn = jTable1.getColumnModel().getColumn(1);

        buttomColumn.setCellEditor(new DefaultCellEditor(buttonList));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTextField4.setEditable(false);
        jTextField4.setText("команда1");

        jTabbedPane1.setToolTipText("Основа");
        jTabbedPane1.setName("Основа"); // NOI18N

        jScrollPane3.setName("Основа"); // NOI18N

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null, null},
                { new Integer(2), null, null, null, null, null},
                { new Integer(3), null, null, null, null, null},
                { new Integer(4), null, null, null, null, null},
                { new Integer(5), null, null, null, null, null},
                { new Integer(6), null, null, null, null, null},
                { new Integer(7), null, null, null, null, null},
                { new Integer(8), null, null, null, null, null},
                { new Integer(9), null, null, null, null, null},
                { new Integer(10), null, null, null, null, null},
                { new Integer(11), null, null, null, null, null}
            },
            new String [] {
                "#", "ID", "N", "Игрок", "Амплуа", "Позиция"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableColumn fioColumn = jTable3.getColumnModel().getColumn(3);
        fioList = new JComboBox();
        fioColumn.setCellEditor(new DefaultCellEditor(fioList));
        jTable3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(jTable3);
        jTable3.getColumnModel().getColumn(0).setMaxWidth(25);
        jTable3.getColumnModel().getColumn(1).setMaxWidth(80);
        jTable3.getColumnModel().getColumn(2).setMaxWidth(35);
        jTable3.getColumnModel().getColumn(3).setMaxWidth(250);
        jTable3.getColumnModel().getColumn(4).setMaxWidth(80);
        jTable3.getColumnModel().getColumn(5).setMaxWidth(80);

        jTabbedPane1.addTab("Основа", jScrollPane3);

        jPanel10.setOpaque(false);
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel10MousePressed(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel9);

        jTabbedPane1.addTab("Расстановка", jScrollPane2);

        jButton26.setText("Цвет формы");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("Цвет номера");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jLabel3.setOpaque(true);

        jLabel4.setOpaque(true);

        jTextField9.setEditable(false);
        jTextField9.setText("id");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButton27))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton26)
                        .addComponent(jButton27)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Основа");

        jTextField5.setEditable(false);
        jTextField5.setText("команда2");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null, null},
                { new Integer(2), null, null, null, null, null},
                { new Integer(3), null, null, null, null, null},
                { new Integer(4), null, null, null, null, null},
                { new Integer(5), null, null, null, null, null},
                { new Integer(6), null, null, null, null, null},
                { new Integer(7), null, null, null, null, null},
                { new Integer(8), null, null, null, null, null},
                { new Integer(9), null, null, null, null, null},
                { new Integer(10), null, null, null, null, null},
                { new Integer(11), null, null, null, null, null}
            },
            new String [] {
                "#", "ID", "N", "Игрок", "Амплуа", "Позиция"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableColumn fioColumn2 = jTable5.getColumnModel().getColumn(3);
        fioList2 = new JComboBox();
        fioColumn2.setCellEditor(new DefaultCellEditor(fioList2));
        jScrollPane5.setViewportView(jTable5);
        jTable5.getColumnModel().getColumn(0).setMaxWidth(25);
        jTable5.getColumnModel().getColumn(1).setMaxWidth(80);
        jTable5.getColumnModel().getColumn(2).setMaxWidth(35);
        jTable5.getColumnModel().getColumn(3).setMaxWidth(250);
        jTable5.getColumnModel().getColumn(4).setMaxWidth(80);
        jTable5.getColumnModel().getColumn(5).setMaxWidth(80);

        jTabbedPane2.addTab("Основа", jScrollPane5);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(jPanel7);

        jTabbedPane2.addTab("Расстановка", jScrollPane6);

        jButton29.setText("Цвет номера");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton28.setText("Цвет формы");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel11.setOpaque(true);

        jLabel12.setOpaque(true);

        jTextField10.setEditable(false);
        jTextField10.setText("id");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton29)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton28))
                    .addComponent(jButton29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
        );

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Выберите расстановку", "4-4-2 classic", "4-4-2 diamond", "4-2-3-1", "4-1-4-1", "4-3-3 up", "4-3-3 down", "3-5-2" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField3.setEditable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setText("ID матча");

        jLabel7.setText("Дата матча");

        jLabel8.setText("Турнир");

        jTextField6.setEditable(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel9.setText("Стадия");

        jTextField7.setEditable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel10.setText("Рефери");

        jTextField8.setEditable(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addComponent(jTextField6))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Выберите расстановку", "4-4-2 classic", "4-4-2 diamond", "4-2-3-1", "4-1-4-1", "4-3-3 up", "4-3-3 down", "3-5-2" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(2015, 2015, 2015))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(414, 414, 414)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jPanel5.setVisible(true);
        jPanel1.setVisible(false);

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jPanel5.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tm3 = jTable1.getModel();
        for (int row = 0; row < tm3.getRowCount(); row++) {
            if (!tm3.getValueAt(row, 1).equals("Выбор кнопки")) {
                activeButtons.addActionButton(String.valueOf(tm3.getValueAt(row, 1)),
                        String.valueOf(tm3.getValueAt(row, 0)));
            }
        }
        List<String> mainTeam1 = new ArrayList<String>();
        List<String> mainTeam2 = new ArrayList<String>();
        tm1 = jTable3.getModel();
        tm2 = jTable5.getModel();
        for(int i = 0;i<tm1.getRowCount();i++){
           mainTeam1.add((String) tm1.getValueAt(i, 3));
           mainTeam2.add((String) tm2.getValueAt(i, 3));
        }
        try {
            new Analisys(team1, team2, mainTeam1,mainTeam2,
                    disposition1,disposition2,
                    colorTeam1,colorTeam2,
                    colorNumber1,colorNumber2,activeButtons).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        colorTeam1 = JColorChooser.showDialog(this, "Цвет формы", getBackground());
        jLabel3.setBackground(colorTeam1);
        for(JButton button : jButtonsTactic1){
            button.setBackground(colorTeam1);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        colorNumber1 = JColorChooser.showDialog(this, "Цвет номера", getBackground());
        jLabel4.setBackground(colorNumber1);
        for(JButton button : jButtonsTactic1){
            button.setForeground(colorNumber1);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        colorTeam2 = JColorChooser.showDialog(this, "Цвет формы", getBackground());
        jLabel11.setBackground(colorTeam2);
        for(JButton button : jButtonsTactic2){
            button.setBackground(colorTeam2);
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        colorNumber2 = JColorChooser.showDialog(this, "Цвет номера", getBackground());
        jLabel12.setBackground(colorNumber2);
        for(JButton button : jButtonsTactic2){
            button.setForeground(colorNumber2);
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String tournament = String.valueOf(jComboBox1.getSelectedItem());
        jComboBox2.removeAllItems();
        jComboBox2.addItem("Выберите матч");
        try {
            for (String matches : httpHelper.getMatches(tournament)) {
                jComboBox2.addItem(String.valueOf(matches).replaceAll(";", "  "));
            }
        } catch (IOException ex) {
            Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String match;
        if (jRadioButton1.isSelected()) {
            match = jTextField1.getText();
            if (!match.equals("")) {
                try {
                    setMatch(httpHelper.getMatchById(match));
                    setTitles(match);
                } catch (IOException ex) {
                    Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (jRadioButton2.isSelected()) {
            match = String.valueOf(jComboBox2.getSelectedItem());
            String id = "";
            if (!match.equals("Выберите матч")) {
                Pattern pattern = Pattern.compile("(\\d{6})");
                Matcher matcher = pattern.matcher(match);
                while (matcher.find()) {
                    id = matcher.group(1);
                }
                try {
                    setMatch(httpHelper.getMatchById(id));
                } catch (IOException ex) {
                    Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
                }
                setTitles(id);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    private void setTitles(String idMatch) {
        String infa = "";
        try {
            infa = httpHelper.getMatchTitlesById(idMatch);
            System.out.println(infa);
        } catch (IOException ex) {
            Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextField2.setText(idMatch);
        jTextField6.setText(TeamParser.getRegex(
                "(\\D+):(\\d{2}\\.\\d{2}\\.\\d{4}):(\\D+):(.+)", infa, 1).get(0));
        jTextField8.setText(TeamParser.getRegex(
                "(\\D+):(\\d{2}\\.\\d{2}\\.\\d{4}):(\\D+):(.+)", infa, 2).get(0));
        jTextField7.setText(TeamParser.getRegex(
                "(\\D+):(\\d{2}\\.\\d{2}\\.\\d{4}):(\\D+):(.+)", infa, 3).get(0));
        jTextField3.setText(TeamParser.getRegex(
                "(\\D+):(\\d{2}\\.\\d{2}\\.\\d{4}):(\\D+):(.+)", infa, 4).get(0));
    }

    private void setMatch(String infa) {
        if (!infa.equals("")) {
            team1 = new Team();
            team2 = new Team();
            List<Player> players1 = new ArrayList<Player>();
            List<Player> players2 = new ArrayList<Player>();

            List<String> teamNames = TeamParser.listTeams(infa);
            List<String> teamId = TeamParser.listTeamsId(infa);
            team1.setName(teamNames.get(0));
            team2.setName(teamNames.get(1));
            team1.setId(teamId.get(0));
            team2.setId(teamId.get(1));

            List<String> lastNames1 = TeamParser.listLastName(teamNames.get(0), teamId.get(0), infa);
            List<String> lastNames2 = TeamParser.listLastName(teamNames.get(1), teamId.get(1), infa);
            List<String> firstNames1 = TeamParser.listFirstName(teamNames.get(0), teamId.get(0), infa);
            List<String> firstNames2 = TeamParser.listFirstName(teamNames.get(1), teamId.get(1), infa);
            List<String> numbers1 = TeamParser.listNumber(teamNames.get(0), teamId.get(0), infa);
            List<String> numbers2 = TeamParser.listNumber(teamNames.get(1), teamId.get(1), infa);
            List<String> id1 = TeamParser.listId(teamNames.get(0), teamId.get(0), infa);
            List<String> id2 = TeamParser.listId(teamNames.get(1), teamId.get(1), infa);


            for (int i = 0; i < lastNames1.size(); i++) {
                players1.add(new Player(firstNames1.get(i), lastNames1.get(i),
                        id1.get(i), numbers1.get(i)));
                players2.add(new Player(firstNames2.get(i), lastNames2.get(i),
                        id2.get(i), numbers2.get(i)));
            }
            team1.setPlayers(players1);
            team2.setPlayers(players2);

            setFieldsOnForm();
        } else {
            //логгер кнопка не выбрана или нет такой кнопки
        }
    }

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTable3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3AncestorAdded

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        System.out.println("form");
        System.out.println(evt.getKeyChar() + " " + evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed

    private void jPanel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyPressed
        System.out.println("panel");
        System.out.println(evt.getKeyChar() + " " + evt.getKeyCode());
    }//GEN-LAST:event_jPanel3KeyPressed

    private void jPanel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MousePressed
    }//GEN-LAST:event_jPanel10MousePressed

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        setTacticIn("table1", evt.getItem().toString());
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        setTacticIn("table2", evt.getItem().toString());
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void setFieldsOnForm() {
        jTextField4.setText(team1.getName());
        jTextField5.setText(team2.getName());
        jTextField9.setText(team1.getId());
        jTextField10.setText(team2.getId());
        fioList.removeAllItems();
        for (Player player : team1.getPlayers()) {
            fioList.addItem(player.getNumber() + "  " + player.getLastName() + " "
                    + player.getFirstName());
        }
        fioList2.removeAllItems();
        for (Player player : team2.getPlayers()) {
            fioList2.addItem(player.getNumber() + "  " + player.getLastName() + " "
                    + player.getFirstName());
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
            java.util.logging.Logger.getLogger(Teams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Teams().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
