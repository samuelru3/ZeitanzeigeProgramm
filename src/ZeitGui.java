import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZeitGui {
    private JButton startstop;
    private JLabel minuten;
    private JLabel stunden;
    private JPanel mainPanel;
    private JLabel sekunden;

    public ZeitGui() {
        final int[] tik = {0};
        final int[] min = {0};
        final int[] h = {0};
        Timer timer = new Timer(10, new ActionListener() {
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
                sekunden.setText(String.valueOf(tik[0]));
                minuten.setText(String.valueOf(min[0]));
                stunden.setText(String.valueOf(h[0]));
            }
        });


        startstop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Zeit");
        frame.setContentPane(new ZeitGui().mainPanel);

        frame.pack();
        frame.setVisible(true);

    }
}
