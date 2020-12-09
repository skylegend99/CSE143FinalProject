// The viewTA class allows the users type the name of the TA to see the avaliable seats
// of that TA
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;

public class viewTA {
    public static void view(Frame owner, Component parentComponent, int course) {
        final JDialog dialog = new JDialog(owner, "CSE " + course + "TA", true);
        dialog.setSize(800, 200);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(parentComponent);
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);

        // constructs the Jlabel
        JLabel label = new JLabel("View your intended CSE " + course + "TA's quiz section");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 35));

        // constructs the Option label
        JLabel option = new JLabel("Enter the name:");
        option.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        option.setForeground(Color.black);

        // constructs the TextArea
        JTextArea textArea = new JTextArea(1, 15);
        textArea.setLineWrap(true);
        textArea.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));

        // constructs the JButton
        JButton btn01 = new JButton("view");

        // constructs the Info
        JTextArea info = new JTextArea(10,56);
        info.setLineWrap(true);
        info.setEditable(false);
        info.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        info.setOpaque(false);

        // constructs the Graph
        JLabel pictureTA = new JLabel();

        // activate JButton btn01
        btn01.addActionListener(new ActionListener() {
            @Override
            // prints out the avaliable seats with autocorrect
            public void actionPerformed(ActionEvent e) {
                info.setText("");
                Information infoTA = new Function(course).search(textArea.getText());
                if (new Function(course).scan(textArea.getText())) {
                    info.append(infoTA.toString());
                } else {
                    info.append("We cannot find this TA, you might be looking for this TA:" + infoTA.toString());
                }
                try {
                    String name = new Function(course).search(textArea.getText()).name;
                    Scanner input = new Scanner(new File("datasets/" + course + "seats.csv"));
                    while (input.hasNextLine()) {
                        String line = input.nextLine();
                        String nextName = line.substring(0, line.indexOf(','));
                        if (name.equals(nextName)) {
                            String result = "Currently " + line.substring(line.indexOf(',') + 1) + "/21 seats avaliable";
                            option.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
                            JOptionPane.showMessageDialog(null, result);
                        }
                    }
                } catch (Exception IOException) {
                    System.out.println("file not found");
                }
            }
        });

        // locate the option
        SpringLayout.Constraints optionCon = layout.getConstraints(option);
        optionCon.setX(Spring.constant(30));
        optionCon.setY(Spring.constant(60));

        // locate the textArea
        SpringLayout.Constraints textCon = layout.getConstraints(textArea);
        textCon.setX(Spring.constant(250));
        textCon.setY(Spring.constant(60));

        // locate the Button
        SpringLayout.Constraints btnCon = layout.getConstraints(btn01);
        btnCon.setX(Spring.constant(500));
        btnCon.setY(Spring.constant(65));

        // locate the Picture
        SpringLayout.Constraints picCon = layout.getConstraints(pictureTA);
        picCon.setX(Spring.constant(600));
        picCon.setY(Spring.constant(65));
        panel.add(label);
        panel.add(pictureTA);
        panel.add(option);
        panel.add(btn01);
        panel.add(textArea);
        dialog.setContentPane(panel);
        dialog.setVisible(true);
    }
}
