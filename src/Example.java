import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Example extends JFrame {
    private JSplitPane splitPaneV;
    private JSplitPane splitPaneH;
    private JPanel panel1;
    private JPanel panel2;
    private int balanceAC = 0;
    private int balanceRM = 0;
    private JLabel label, label2;
    private Label label3;

    public Example(){
        setTitle( "Split Pane Application" );
        setSize(500,500);

        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        createPanel2();
        createPanel1();

        splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        topPanel.add( splitPaneV, BorderLayout.CENTER );

        splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneH.setRightComponent( panel2 );

        splitPaneV.setLeftComponent( splitPaneH );
        splitPaneV.setRightComponent( panel1 );
    }

    public void createPanel1(){
        panel1 = new JPanel();
        panel1.setLayout( new FlowLayout() );

        label = new JLabel();
        label.setText("Result: " + balanceAC + " X "+ balanceRM);
        panel1.add(label);

        label2 = new JLabel();
        label2.setText("Last Scorer: N/A");
        panel1.add(label2);

        label3 = new Label();
        label3.setText("Winner: DRAW");
        panel1.add(label3);
    }

    public void createPanel2(){
        panel2 = new JPanel();
        panel2.setLayout( new FlowLayout() );

        JButton button1 = new JButton("AC Milan");
        panel2.add(button1);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                balanceAC++;
                updateBalance();
                LastScorerAC();
                Winner();
            }
        });

        JButton button2 = new JButton("Real Madrid");
        panel2.add(button2);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                balanceRM++;
                updateBalance();
                LastScorerRM();
                Winner();
            }
        });
    }
    private void Winner(){
        if( balanceAC < balanceRM ){
            label3.setText("Winner: RM");
        }else if (balanceAC == balanceRM) {
            label3.setText("Winner: DRAW");
              }else{
            label3.setText("Winner: AC");
        }
    }

    private void LastScorerAC(){
        label2.setText("Last Scorer: AC Milan ");
    }

    private void LastScorerRM(){
        label2.setText("Last Scorer: Real Madrid ");
    }

    private void updateBalance () {
        label.setText("Result: " + balanceAC + " X "+ balanceRM);
    }

    public static void main(String[] args) {
        Example mainFrame = new Example();
        mainFrame.pack();
        mainFrame.setVisible( true );
    }
}