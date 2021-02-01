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
        int min = 0;
        int h = 0;
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tik[0]++;
                //String sekund = tik;
                if (tik[0] == 60) {

                }
                sekunden.setText(String.valueOf(tik[0]));
                minuten.setText(String.valueOf(min));
                stunden.setText(String.valueOf(h));
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
