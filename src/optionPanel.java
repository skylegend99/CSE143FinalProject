import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class optionPanel {
    private searchTA searchTA;
    private Evaluator evaluator;
    public optionPanel() {
        searchTA = new searchTA();
        evaluator = new Evaluator();
    }
    public void course(Frame owner, Component parentComponent, int title) {
        final JDialog dialog = new JDialog(owner, "CSE " + title + "TA", true);
        dialog.setSize(890, 450);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(parentComponent);
        SpringLayout layout = new SpringLayout();

        // Jlabel
        JLabel label = new JLabel("CSE " + title + "TA List");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 35));

        // Option label
        JLabel option = new JLabel("Choose your option:");
        option.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        option.setForeground(Color.red);

        // JButton
        JButton btn01 = new JButton("Search");
        JButton btn02 = new JButton("Blind-date");
        JButton btn03 = new JButton("View the intended section");
        JButton btn04 = new JButton("Quit");

        // JPanel
        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.WHITE);

        // TextArea
        JTextArea textArea = new JTextArea(5, 15);
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        readIntro(textArea);

        // label position
        SpringLayout.Constraints labelCons = layout.getConstraints(label);
        labelCons.setX(Spring.constant(300));
        labelCons.setY(Spring.constant(5));

        // TextArea position
        SpringLayout.Constraints textCons = layout.getConstraints(textArea);
        textCons.setX(Spring.constant(20));
        textCons.setY(Spring.constant(50));

        // Button1 position
        SpringLayout.Constraints btnCon1 = layout.getConstraints(btn01);
        btnCon1.setX(Spring.constant(500));
        btnCon1.setY(Spring.constant(220));

        // Button2 position
        SpringLayout.Constraints btnCon2 = layout.getConstraints(btn02);
        btnCon2.setX(Spring.constant(500));
        btnCon2.setY(Spring.constant(260));

        // Button3 position
        SpringLayout.Constraints btnCon3 = layout.getConstraints(btn03);
        btnCon3.setX(Spring.constant(500));
        btnCon3.setY(Spring.constant(300));

        // Button4 position
        SpringLayout.Constraints btnCon4 = layout.getConstraints(btn04);
        btnCon4.setX(Spring.constant(500));
        btnCon4.setY(Spring.constant(340));

        // OptionLabel position
        SpringLayout.Constraints optionCon = layout.getConstraints(option);
        optionCon.setX(Spring.constant(200));
        optionCon.setY(Spring.constant(300));

        panel.add(textArea);
        panel.add(label);
        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
        panel.add(option);
        addAction(btn01, btn02, btn03, btn04, owner, dialog, title);
        dialog.setContentPane(panel);
        dialog.setVisible(true);
    }

    public void readIntro(JTextArea textArea)  {
        try {
            Scanner reader = new Scanner(new File("C:\\Users\\Andy\\IdeaProjects\\CSE143FinalProject\\src\\datasets\\intro.txt"));
            while (reader.hasNextLine()) {
                textArea.append(reader.nextLine() + "\n");
            }
        } catch (Exception FileNotFoundException){
            System.out.println("File not found");
        }
    }

    public void addAction(JButton btn01, JButton btn02, JButton btn03, JButton btn04,
                          Frame owner, Component parentComponent, int course ){
        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTA.search(owner, parentComponent, course);
            }
        });

        btn02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (course == 143) {
                    evaluator.blindDate(owner, parentComponent, course);
                } else {
                    JOptionPane.showMessageDialog(null, "Current Unavailable");
                }
            }
        });

        btn03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTA.search(owner, parentComponent, course);
            }
        });

        btn04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
