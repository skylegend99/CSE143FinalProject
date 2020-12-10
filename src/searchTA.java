// The searchTA class allows users to type in the name of the TA and get his/her
// basic information
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchTA {
    public void search(Frame owner, Component parentComponent, int course) {
        final JDialog dialog = new JDialog(owner, "CSE " + course + "TA", true);
        dialog.setSize(1000, 400);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(parentComponent);
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);

        // construct the Jlabel
        JLabel label = new JLabel("Search your CSE " + course + "TA");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 35));

        // construct the Option label
        JLabel option = new JLabel("Enter the name:");
        option.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        option.setForeground(Color.black);

        // construct the TextArea
        JTextArea textArea = new JTextArea(1, 15);
        textArea.setLineWrap(true);
        textArea.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));

        // construct the JButton
        JButton btn01 = new JButton("search");;

        // construct the Info
        JTextArea info = new JTextArea(10,56);
        info.setLineWrap(true);
        info.setEditable(false);
        info.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        info.setOpaque(false);

        // construct the Graph
        JLabel pictureTA = new JLabel();

        // activate Jbutton btn01
        btn01.addActionListener(new ActionListener() {
            @Override
            // Add infomation of ta to info
            public void actionPerformed(ActionEvent e) {
                info.setText("");
                Information infoTA = new Function(course).search(textArea.getText());
                if (new Function(course).scan(textArea.getText())) {
                    info.append(infoTA.toString());
                } else {
                    info.append("We cannot find this TA, you might be looking for this TA:" + infoTA.toString());
                }
                try {
                    String fileName = "datasets/" + course +"/";
                    if (course == 143) {
                        fileName += infoTA.name.replace(" ", "") + ".jpg";
                    } else {
                        fileName += infoTA.email.split("@")[0] + ".jpg";
                    }
                    ImageIcon icon = new ImageIcon(fileName);
                    Image image = icon.getImage().getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH);
                    icon = new ImageIcon(image);
                    pictureTA.setIcon(icon);
                    pictureTA.setText(infoTA.name);
                    pictureTA.setHorizontalTextPosition(SwingConstants.CENTER);
                    pictureTA.setVerticalTextPosition(SwingConstants.BOTTOM);
                } catch (Exception IOException) {
                    System.out.println("Picture not found");
                }
            }
        });

        // locate the label
        SpringLayout.Constraints labelCon = layout.getConstraints(label);
        labelCon.setX(Spring.constant(100));
        labelCon.setY(Spring.constant(10));

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

        // locate the Info
        SpringLayout.Constraints infoCon = layout.getConstraints(info);
        infoCon.setX(Spring.constant(50));
        infoCon.setY(Spring.constant(100));

        // locate the Picture
        SpringLayout.Constraints picCon = layout.getConstraints(pictureTA);
        picCon.setX(Spring.constant(600));
        picCon.setY(Spring.constant(65));

        panel.add(label);
        panel.add(pictureTA);
        panel.add(option);
        panel.add(btn01);
        panel.add(textArea);
        panel.add(info);
        dialog.setContentPane(panel);
        dialog.setVisible(true);
    }
}
