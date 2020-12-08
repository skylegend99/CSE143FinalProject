import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class graphic {
    private optionPanel optionPanel;
    public graphic() {
        optionPanel = new optionPanel();
    }
    public void mainPanel() {
        JFrame jf = new JFrame("IfYouAreTheOne");
        jf.setSize(700, 250);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        SpringLayout layout = new SpringLayout();

        // JPanel
        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.WHITE);

        // Jlabel
        JLabel label = new JLabel("Welcome to IfYouAreTheOne!");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 35));

        // Question label
        JLabel question = new JLabel("Which course do you intend to take, CSE142 or CSE143?");
        question.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));

        // Course label
        JLabel course = new JLabel("Choose your course:");
        course.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        course.setForeground(Color.red);

        // JButton
        JButton btn01 = new JButton("142");
        JButton btn02 = new JButton("143");

        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionPanel.course(jf,jf, 142);
            }
        });
        btn02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                optionPanel.course(jf, jf, 143);
            }
        });

        // label position
        SpringLayout.Constraints labelCons = layout.getConstraints(label);
        labelCons.setX(Spring.constant(100));
        labelCons.setY(Spring.constant(5));

        // question position
        SpringLayout.Constraints questionCons = layout.getConstraints(question);
        questionCons.setX(Spring.constant(10));
        questionCons.setY(Spring.constant(80));

        // Courselabel position
        SpringLayout.Constraints courseCon = layout.getConstraints(course);
        courseCon.setX(Spring.constant(300));
        courseCon.setY(Spring.constant(130));

        // Button1 position
        SpringLayout.Constraints btnCon1 = layout.getConstraints(btn01);
        btnCon1.setX(Spring.constant(500));
        btnCon1.setY(Spring.constant(120));

        // Button2 position
        SpringLayout.Constraints btnCon2 = layout.getConstraints(btn02);
        btnCon2.setX(Spring.constant(500));
        btnCon2.setY(Spring.constant(150));

        panel.add(label);
        panel.add(course);
        panel.add(btn01);
        panel.add(btn02);
        panel.add(question);
        jf.setContentPane(panel);
        jf.setVisible(true);
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you! See you next time.");
            }
        });
    }

}
