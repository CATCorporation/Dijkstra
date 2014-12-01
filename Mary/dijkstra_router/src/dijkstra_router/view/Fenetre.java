/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra_router.view;


import dijkstra_router.model.Chaine;
import dijkstra_router.model.Dijstra;
import dijkstra_router.model.GenericNode;
import dijkstra_router.model.Graph;
import dijkstra_router.model.Map;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 626
 */
public class Fenetre extends javax.swing.JFrame {

    public Fenetre() {
	jPanel1 = new JPanel(new GridLayout(19, 48, 0, 0));
	// carte = new Map();
	setMap(null);
	running = false;
	initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

	// jPanel1 = new javax.swing.JPanel();
	jPanel2 = new javax.swing.JPanel();
	jTextField1 = new javax.swing.JTextField();
	jTextField2 = new javax.swing.JTextField();
	jTextField3 = new javax.swing.JTextField();
	jButton1 = new javax.swing.JButton();
	jLabel1 = new javax.swing.JLabel();
	jLabel2 = new javax.swing.JLabel();
	jLabel3 = new javax.swing.JLabel();
	jLabelTours = new javax.swing.JLabel();
	jLabelDeplacements = new javax.swing.JLabel();
	jLabelSourisEnDeplacement = new javax.swing.JLabel();
	jLabelSourisArrivees = new javax.swing.JLabel();
	jLabelValeurTours = new javax.swing.JLabel();
	jLabelValeurDeplacements = new javax.swing.JLabel();
	jLabelValeurSourisArrivees = new javax.swing.JLabel();
	jLabelValeurSourisEnDeplacement = new javax.swing.JLabel();

	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	/*
	 * javax.swing.GroupLayout jPanel1Layout = new
	 * javax.swing.GroupLayout(jPanel1); jPanel1.setLayout(jPanel1Layout);
	 * jPanel1Layout.setHorizontalGroup(
	 * jPanel1Layout.createParallelGroup(javax
	 * .swing.GroupLayout.Alignment.LEADING) .addGap(0, 0, Short.MAX_VALUE)
	 * ); jPanel1Layout.setVerticalGroup(
	 * jPanel1Layout.createParallelGroup(javax
	 * .swing.GroupLayout.Alignment.LEADING) .addGap(0, 380,
	 * Short.MAX_VALUE) );
	 */
	jPanel2.setBackground(new java.awt.Color(220, 220, 220));

	jTextField1.addActionListener(new java.awt.event.ActionListener() {
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
		jTextField1ActionPerformed(evt);
	    }
	});

	jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	jButton1.setText("Lancer");
	jButton1.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		if (running) {
		    try {
			Thread.sleep(1000);
			// t.interrupt();
			running = false;
		    } catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		    }
		    jButton1.setText("Lancer");
		    setMap(null);
		} else {
		    t = new Thread() {
			@Override
			public void run() {
			    // recuperation de la vitesse
			    String vitesse = jTextField3.getText();
			    Chaine listSouris = new Chaine();
			    Graph graph = new Graph();
			    graph.initGraph("./ressources/map.txt");

			    // init vitesse de jeu
			    int speed = 300;
			    try {
				speed = Integer.parseInt(vitesse);
				if (speed < 300) {
				    speed = 300;
				}
			    } catch (NumberFormatException e) {
				System.out.println("vitesse incorrecte");
				jTextField3.setText("300");
			    }

			    // init souris
			    int nbSourisG = 0;
			    int nbSourisD = 0;
			    int nbSouris = 0;
			    try {
				if (!jTextField1.getText().equals("")) {
				    nbSourisG = Integer.parseInt(jTextField1
					    .getText());
				} else {
				    nbSourisG = 0;
				}

				if (!jTextField2.getText().equals("")) {
				    nbSourisD = Integer.parseInt(jTextField2
					    .getText());
				} else {
				    nbSourisD = 0;
				}

				nbSouris = nbSourisG + nbSourisD;
			    } catch (NumberFormatException e) {
				System.out.println("Pas de souris entree");
			    }
			    for (int iG = 0, jG = 0; iG < nbSourisG; iG++) {
				GenericNode souris = null;
				if (jG == 0) {
				    souris = graph.getNode("5:17");
				}
				if (jG == 1) {
				    souris = graph.getNode("6:17");
				}
				if (jG == 2) {
				    souris = graph.getNode("4:17");
				}
				if (jG == 3) {
				    souris = graph.getNode("6:16");
				}
				jG++;
				if (jG == 4) {
				    jG = 0;
				}
				listSouris.push(souris);
			    }

			    for (int iD = 0, jD = 0; iD < nbSourisD; iD++) {
				GenericNode souris = null;
				if (jD == 0) {
				    souris = graph.getNode("41:17");
				}
				/*
				 * if(jD == 1) souris = graph.getNode("42:18");
				 * if(jD == 2) souris = graph.getNode("4:17");
				 * if(jD == 3) souris = graph.getNode("6:16");
				 */
				jD++;
				if (jD == 4) {
				    jD = 0;
				}
				listSouris.push(souris);
			    }

			    int i = 0, actuel = 0, arrivees = 0, move = 0;
			    GenericNode depart = null;
			    GenericNode arriveOne = graph.getNode("5:2"), arriveTwo = graph
				    .getNode("43:1"), arrive = null;
			    arriveOne.setValue("Sortie");
			    arriveTwo.setValue("Sortie");
			    Chaine listUsed = new Chaine();
			    boolean reset = false;
			    while (!listSouris.isEmpty()) {
				if (!running) {
				    break;
				}
				depart = listSouris.get(actuel);
				while (depart != arriveOne
					&& depart != arriveTwo) {
				    if (!running) {
					break;
				    }

				    if (depart.getValue().equals("grass")
					    && !depart.isHerbe()) {
					depart.setHerbe(true);
					i++;
					actuel++;
					if (actuel == listSouris.size()) {
					    actuel = 0;
					}
					break;
				    }

									// depart.setActif(false);
				    graph.initEdge();

				    System.out.println("souris " + actuel
					    + " position : " + depart.getKey());

				    arrive = Dijstra.findeBestWay2(graph,
					    depart);
				    if (arrive == null) {
					i++;
					actuel++;
					if (actuel == listSouris.size()) {
					    actuel = 0;
					    move = 0;
					    if (reset) {
						reset = false;
						listUsed.clear();
					    } else {
						reset = true;
					    }
					}
					break;
				    }
				    while (arrive.previous.previous != null
					    && !arrive.previous.getKey()
					    .equals(depart.getKey())) {
					arrive = arrive.previous;

										// System.out.println("liste point :" +
					// arrive);
				    }

				    System.out.println("souris : " + actuel
					    + " va a  : " + arrive);

				    //�a j'ai enlev� car �a empechait la souris de droite de faire son chemin
//									if (reset == true)
//										listUsed.get(move).setActif(false);
//									else {
				    listUsed.push(arrive.previous);
//									}
				    System.out.println("precedent : "
					    + arrive.previous + " actuel : "
					    + arrive);
				    // arrive.previous = null;

				    arrive.setActif(true);

				    graph.checkEntry();

				    depart = arrive;

				    listSouris.set(actuel, depart);

				    setMap(listSouris);

				    revalidate();

				    try {
					TimeUnit.MILLISECONDS.sleep(speed);
				    } catch (InterruptedException ex) {
					Logger.getLogger(
						Fenetre.class.getName()).log(
							Level.SEVERE, null, ex);
				    }
				    i++;
				    jLabelValeurTours.setText(Integer
					    .toString(i));
				    jLabelValeurSourisEnDeplacement.setText(Integer
					    .toString(listSouris.size()));
				    // jLabelValeurDeplacements.setText(Integer.toString(actuel));

				    actuel++;
				    move++;

				    if (actuel == listSouris.size()) {
					actuel = 0;
					move = 0;
					if (reset) {
					    reset = false;
					    listUsed.clear();
					} else {
					    reset = true;
					}
				    }
				    // System.out.println("actuel: "+actuel);
				    break;

				}

				if (depart == arriveOne || depart == arriveTwo) {
				    System.out.println("supprime");
				    arrivees++;
				    jLabelValeurSourisArrivees.setText(Integer
					    .toString(arrivees));
				    actuel--;
				    if (nbSouris > 1) {
					move--;
					listUsed.remove(listUsed.get(move));
				    }
				    listSouris.remove(depart);
				    setMap(listSouris);
				    revalidate();
				}
			    }
			    System.out.println("fini");
			    try {
				Thread.sleep(1000);
				// t.interrupt();
				running = false;
			    } catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			    }
			    jButton1.setText("Lancer");
			    revalidate();
			}
		    };
		    t.start();
		    running = true;
		    jButton1.setText("Stop");
		}

	    }
	});
	jLabelDeplacements.setFont(new java.awt.Font("Tahoma", 0, 14));
	jLabelDeplacements.setText("Deplacements");

	jLabelValeurDeplacements.setFont(new java.awt.Font("Tahoma", 0, 14));
	jLabelValeurDeplacements.setText("0");

	jLabelTours.setFont(new java.awt.Font("Tahoma", 0, 14));
	jLabelTours.setText("Tours");

	jLabelValeurTours.setFont(new java.awt.Font("Tahoma", 0, 14));
	jLabelValeurTours.setText("0");

	jLabelSourisEnDeplacement.setFont(new java.awt.Font("Tahoma", 0, 14));
	jLabelSourisEnDeplacement.setText("Souris en deplacement");

	jLabelValeurSourisEnDeplacement.setFont(new java.awt.Font("Tahoma", 0,
		14));
	jLabelValeurSourisEnDeplacement.setText("0");

	jLabelSourisArrivees.setFont(new java.awt.Font("Tahoma", 0, 14));
	jLabelSourisArrivees.setText("Souris arrivees");

	jLabelValeurSourisArrivees.setFont(new java.awt.Font("Tahoma", 0, 14));
	jLabelValeurSourisArrivees.setText("0");

	jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	jLabel1.setText("Porte 1");

	jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	jLabel2.setText("Porte 2");

	jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
	jLabel3.setText("Vitesse");

	javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
		jPanel2);
	jPanel2.setLayout(jPanel2Layout);
	jPanel2Layout
		.setHorizontalGroup(jPanel2Layout
			.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel2Layout
				.createSequentialGroup()
				.addContainerGap(582, Short.MAX_VALUE)
				.addGroup(
					jPanel2Layout
					.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						false)
					.addComponent(
						jLabelTours,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						35,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(
						jLabelValeurTours,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						20,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(36, 36, 36)
				.addGroup(
					jPanel2Layout
					.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						false)
					.addComponent(
						jLabelDeplacements,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						85,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(
						jLabelValeurDeplacements,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						35,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(36, 36, 36)
				.addGroup(
					jPanel2Layout
					.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						false)
					.addComponent(
						jLabelValeurSourisEnDeplacement,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						35,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(
						jLabelSourisEnDeplacement,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						139,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(36, 36, 36)
				.addGroup(
					jPanel2Layout
					.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						false)
					.addComponent(
						jLabelValeurSourisArrivees,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						35,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(
						jLabelSourisArrivees,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						89,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(66, 66, 66)
				.addGroup(
					jPanel2Layout
					.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						false)
					.addComponent(
						jLabel1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						71,
						Short.MAX_VALUE)
					.addComponent(
						jTextField1))
				.addGap(36, 36, 36)
				.addGroup(
					jPanel2Layout
					.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						false)
					.addComponent(
						jTextField2)
					.addComponent(
						jLabel2,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						78,
						Short.MAX_VALUE))
				.addGap(28, 28, 28)
				.addGroup(
					jPanel2Layout
					.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						false)
					.addComponent(
						jTextField3)
					.addComponent(
						jLabel3,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						80,
						Short.MAX_VALUE))
				.addGap(18, 18, 18)
				.addComponent(
					jButton1,
					javax.swing.GroupLayout.PREFERRED_SIZE,
					77,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
	jPanel2Layout
		.setVerticalGroup(jPanel2Layout
			.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel2Layout
				.createSequentialGroup()
				.addContainerGap(24, Short.MAX_VALUE)
				.addGroup(
					jPanel2Layout
					.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						false)
					.addComponent(
						jLabelDeplacements,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jLabelSourisArrivees,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jLabelSourisEnDeplacement,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jLabelTours,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jLabel2,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jLabel3,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jLabel1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE))
				.addPreferredGap(
					javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(
					jPanel2Layout
					.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING,
						false)
					.addComponent(
						jLabelValeurDeplacements,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jLabelValeurSourisArrivees,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jLabelValeurSourisEnDeplacement,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jLabelValeurTours,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(
						jTextField3)
					.addComponent(
						jTextField1)
					.addComponent(
						jTextField2)
					.addComponent(
						jButton1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						42,
						Short.MAX_VALUE))
				.addContainerGap()));
	jPanel2.setMaximumSize(new Dimension(478, 100));
	jPanel2.setMinimumSize(new Dimension(478, 100));
	jPanel2.setPreferredSize(jPanel2.getMinimumSize());
	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
		getContentPane());
	getContentPane().setLayout(layout);
	layout.setHorizontalGroup(layout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
			javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(jPanel2,
			javax.swing.GroupLayout.Alignment.TRAILING,
			javax.swing.GroupLayout.DEFAULT_SIZE,
			javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
	layout.setVerticalGroup(layout
		.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(
			layout.createSequentialGroup()
			.addComponent(jPanel1,
				javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(
				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(jPanel2,
				javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap(
				javax.swing.GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE)));
	setMaximumSize(new java.awt.Dimension(981, 481));
	setMinimumSize(new java.awt.Dimension(980, 480));
	jLabel1.setForeground(Color.DARK_GRAY);
	jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));

    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
	// TODO add your handling code here:
    }// GEN-LAST:event_jTextField1ActionPerformed

    public void deplacerSouris(GenericNode souris) {
	Component c[] = jPanel1.getComponents();
	int i = 0, x = 0, y = 0;
	for (Component comp : c) {
	    JLabel temp = (JLabel) comp;
	    if (souris != null) {
		String s = x + ":" + y;
		System.out.println(s);
		if (souris.getKey().equals(s)) {
		    ImageIcon grassIcon = new ImageIcon("./images/souris.png");
		    temp = new JLabel(grassIcon);
		    System.out.println("trouvé");
		    break;
		}
	    }
	    i++;
	    x++;
	    if (x > 47) {
		x = 0;
		y++;
	    }
	    System.out.println(i);
	}
    }

    public void setMap(Chaine souris) {
	if (jPanel1 != null) {
	    jPanel1.removeAll();
	}
	carte = new Map();
	JLabel labels[] = new JLabel[(19 * 48)];
	String bufferMap = carte.lire("./ressources/map.txt");

	int x = 0, y = 0;

	for (int i = 0, j = 0; i < bufferMap.length(); i++) {
	    ImageIcon grassIcon = null;
	    if (bufferMap.charAt(i) != '\n') {
		if (bufferMap.charAt(i) == '*') {
		    grassIcon = new ImageIcon("./images/mur.png");
		    labels[j] = new JLabel(grassIcon);
		}
		if (bufferMap.charAt(i) == ' ' || bufferMap.charAt(i) == 'P') {
		    grassIcon = new ImageIcon("./images/sol.png");
		    labels[j] = new JLabel(grassIcon);
		}
		if (bufferMap.charAt(i) == 'A') {
		    grassIcon = new ImageIcon("./images/arrive.png");
		    labels[j] = new JLabel(grassIcon);
		}
		if (bufferMap.charAt(i) == 'G') {
		    grassIcon = new ImageIcon("./images/herbe.png");
		    labels[j] = new JLabel(grassIcon);
		}
		if (bufferMap.charAt(i) == 'D') {
		    grassIcon = new ImageIcon("./images/porte.png");
		    labels[j] = new JLabel(grassIcon);
		}
		if (souris != null) {
		    String s = x + ":" + y;
		    for (GenericNode souri : souris) {
			if (souri.getKey().equals(s)) {
			    grassIcon = new ImageIcon("./images/souris.png");
			    labels[j] = new JLabel(grassIcon);
			}
		    }
		}
		labels[j] = new JLabel(grassIcon);
		jPanel1.add(labels[j]);

		j++;
		x++;
	    } else {
		y++;
		x = 0;
	    }
	}
    }

    private javax.swing.JLabel jLabelValeurDeplacements;
    private javax.swing.JLabel jLabelValeurSourisEnDeplacement;
    private javax.swing.JLabel jLabelValeurSourisArrivees;
    private javax.swing.JLabel jLabelValeurTours;
    private JLabel jLabelSourisArrivees;
    private JLabel jLabelSourisEnDeplacement;
    private JLabel jLabelDeplacements;
    private JLabel jLabelTours;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private static Map carte;
    private static boolean running;
    private static Thread t;
}
