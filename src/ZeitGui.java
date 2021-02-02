import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZeitGui {
    private JButton start;
    private JLabel minuten;
    private JLabel stunden;
    private JPanel mainPanel;
    private JLabel sekunden;
    private JButton stop;
    private JTextField eingabeStunden;
    private JTextField eingabeMinuten;
    private JTextField eingabeSekunden;
    private JButton bestaetigenButton;
    private JSpinner spinner1;

    public ZeitGui() {
        final int[] tik = {0};
        final int[] min = {0};
        final int[] h = {0};
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tik[0]++;
                if (tik[0] == 59) {
                    tik[0] = 0;
                    if (min[0] == 59) {
                        min[0] = 0;
                        if (h[0] == 23) {
                            h[0] = 0;
                        } else {
                            h[0]++;
                        }
                    } else {
                        min[0]++;
                    }
                }
                if(tik[0] <10){
                    sekunden.setText("0"+ tik[0]);
                }else {
                    sekunden.setText(String.valueOf(tik[0]));
                }

                if(min[0] <10){
                    minuten.setText("0"+ min[0]);
                }else {
                    minuten.setText(String.valueOf(min[0]));
                }

                if(h[0] <10){
                    stunden.setText("0"+ h[0]);
                }else {
                    stunden.setText(String.valueOf(h[0]));
                }

            }
        });


        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        bestaetigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tik[0] = Integer.parseInt(eingabeSekunden.getText());
                min[0] = Integer.parseInt(eingabeMinuten.getText());
                h[0] = Integer.parseInt(eingabeStunden.getText());

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Zeit");
        frame.setContentPane(new ZeitGui().mainPanel);

        frame.pack();
        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
