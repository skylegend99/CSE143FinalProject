//This class will evaluate each TA's scores based on the preferred type given by user
// and displays the best-fit TA.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Evaluator {
    // Provide the blind date option for this class.
    private Function function;
    public void blindDate(Frame owner, Component parentComponent, int course) {
        function = new Function(course);
        final JDialog dialog = new JDialog(owner, "CSE " + course + "TA", true);
        dialog.setSize(1400, 400);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(parentComponent);
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.WHITE);

        // Constructs a JLabel
        final JLabel label = new JLabel("Blind Date with " + course + "TA");
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 35));
        panel.add(label);

        // Consturcts the label of Feature
        final JLabel feature = new JLabel("Select the feature you want");
        feature.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        panel.add(feature);

        // Consturcts the label of all TA
        Iterator iterator = function.getEvaName().iterator();
        JLabel ta1 = new JLabel((String)iterator.next());
        JLabel ta2 = new JLabel((String)iterator.next());
        JLabel ta3 = new JLabel((String)iterator.next());
        JLabel ta4 = new JLabel((String)iterator.next());
        JLabel ta5 = new JLabel((String)iterator.next());
        JLabel ta6 = new JLabel((String)iterator.next());
        JLabel ta7 = new JLabel((String)iterator.next());
        JLabel ta8 = new JLabel((String)iterator.next());

        // Get the light bulb and Extinguished bulb
        Icon icon = getIcon();
        Icon light = getLight();

        // Set the location for all the bulb (from 1 to 8)
        ta1.setIcon(icon);
        ta1.setHorizontalTextPosition(SwingConstants.CENTER);
        ta1.setVerticalTextPosition(SwingConstants.BOTTOM);
        SpringLayout.Constraints Con1 = layout.getConstraints(ta1);
        Con1.setX(Spring.constant(40));
        Con1.setY(Spring.constant(170));
        panel.add(ta1);

        // Constructs the icon for TA2
        ta2.setIcon(icon);
        ta2.setHorizontalTextPosition(SwingConstants.CENTER);
        ta2.setVerticalTextPosition(SwingConstants.BOTTOM);
        SpringLayout.Constraints Con2 = layout.getConstraints(ta2);
        Con2.setX(Spring.constant(240));
        Con2.setY(Spring.constant(170));
        panel.add(ta2);

        // Constructs the icon for TA3
        ta3.setIcon(icon);
        ta3.setHorizontalTextPosition(SwingConstants.CENTER);
        ta3.setVerticalTextPosition(SwingConstants.BOTTOM);
        SpringLayout.Constraints Con3 = layout.getConstraints(ta3);
        Con3.setX(Spring.constant(440));
        Con3.setY(Spring.constant(170));
        panel.add(ta3);

        // Constructs the icon for TA4
        ta4.setIcon(icon);
        ta4.setHorizontalTextPosition(SwingConstants.CENTER);
        ta4.setVerticalTextPosition(SwingConstants.BOTTOM);
        SpringLayout.Constraints Con4 = layout.getConstraints(ta4);
        Con4.setX(Spring.constant(620));
        Con4.setY(Spring.constant(170));
        panel.add(ta4);

        // Constructs the icon for TA5
        ta5.setIcon(icon);
        ta5.setHorizontalTextPosition(SwingConstants.CENTER);
        ta5.setVerticalTextPosition(SwingConstants.BOTTOM);
        SpringLayout.Constraints Con5 = layout.getConstraints(ta5);
        Con5.setX(Spring.constant(60));
        Con5.setY(Spring.constant(250));
        panel.add(ta5);

        // Constructs the icon for TA6
        ta6.setIcon(icon);
        ta6.setHorizontalTextPosition(SwingConstants.CENTER);
        ta6.setVerticalTextPosition(SwingConstants.BOTTOM);
        SpringLayout.Constraints Con6 = layout.getConstraints(ta6);
        Con6.setX(Spring.constant(230));
        Con6.setY(Spring.constant(250));
        panel.add(ta6);

        // Constructs the icon for TA7
        ta7.setIcon(icon);
        ta7.setHorizontalTextPosition(SwingConstants.CENTER);
        ta7.setVerticalTextPosition(SwingConstants.BOTTOM);
        SpringLayout.Constraints Con7 = layout.getConstraints(ta7);
        Con7.setX(Spring.constant(430));
        Con7.setY(Spring.constant(250));
        panel.add(ta7);

        // Constructs the icon for TA8
        ta8.setIcon(icon);
        ta8.setHorizontalTextPosition(SwingConstants.CENTER);
        ta8.setVerticalTextPosition(SwingConstants.BOTTOM);
        SpringLayout.Constraints Con8 = layout.getConstraints(ta8);
        Con8.setX(Spring.constant(620));
        Con8.setY(Spring.constant(250));
        panel.add(ta8);

        // TextArea: Read the description
        final JTextArea textArea = new JTextArea(1, 15);
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        readIntro(textArea);
        panel.add(textArea);

        // JButton: calculate best matched TA
        JButton btn01 = new JButton("Blind Date");;
        panel.add(btn01);

        // Section label and its Drop down box
        final JLabel section = new JLabel("Section time:");
        section.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        String[] sectionData = new String[]{"Null", "Morning", "Afternoon"};
        final JComboBox<String> sectionBox = new JComboBox<>(sectionData);
        sectionBox.setSelectedIndex(0);
        panel.add(sectionBox);
        panel.add(section);

        // Personality label and its Drop down box
        final JLabel person = new JLabel("Personality:");
        person.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        String[] personData = new String[]{"Null", "Humorous", "Serious", "Extraverted", "Introverted", "Emotional",
                "Rational", "Open-Minded", "Rigorous"};
        final JComboBox<String> personBox = new JComboBox<>(personData);
        personBox.setSelectedIndex(0);
        panel.add(personBox);
        panel.add(person);

        // Color label and its Drop down box
        final JLabel color = new JLabel("Color:");
        color.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        String[] colorData = new String[]{"Null", "Blue", "Sunset colors and beach colors", "Red", "Purple"};
        final JComboBox<String> colorBox = new JComboBox<>(colorData);
        colorBox.setSelectedIndex(0);
        panel.add(colorBox);
        panel.add(color);

        // Teaching Pace label and its Drop down box
        final JLabel pace = new JLabel("Teaching Pace:");
        pace.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        String[] paceData = new String[]{"Null", "Slow", "Fast"};
        final JComboBox<String> paceBox = new JComboBox<>(paceData);
        paceBox.setSelectedIndex(0);
        panel.add(paceBox);
        panel.add(pace);

        // Teaching style label and its Drop down box
        final JLabel teaching = new JLabel("Teaching Style:");
        teaching.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        String[] teachingData = new String[]{"Null", "Prefer giving lectures;", "Prefer setting different break out rooms and listening to students’ discussion"};
        final JComboBox<String> teachingBox = new JComboBox<>(teachingData);
        teachingBox.setSelectedIndex(0);
        panel.add(teachingBox);
        panel.add(teaching);

        // Add action when click the button
        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Restore image to oringial everytime
                ta1.setIcon(icon);
                ta2.setIcon(icon);
                ta3.setIcon(icon);
                ta4.setIcon(icon);
                ta5.setIcon(icon);
                ta6.setIcon(icon);
                ta7.setIcon(icon);
                ta8.setIcon(icon);
                function = new Function(course);
                Set<String> set = new HashSet<>();
                set.add((String) sectionBox.getSelectedItem());
                set.add((String) colorBox.getSelectedItem());
                set.add((String) personBox.getSelectedItem());
                set.add((String) paceBox.getSelectedItem());
                set.add((String) teachingBox.getSelectedItem());
                function.rating(set);
                String nameTA = function.largest();
                Iterator iterator = function.getEvaName().iterator();
                int count = 0;
                while (iterator.next() != nameTA) {
                    count++;
                }
                // Light up the Matched TA
                switch (count) {
                    case 1:  ta1.setIcon(light);
                        break;
                    case 2:  ta2.setIcon(light);
                        break;
                    case 3:  ta3.setIcon(light);
                        break;
                    case 4:  ta4.setIcon(light);
                        break;
                    case 5:  ta5.setIcon(light);
                        break;
                    case 6:  ta6.setIcon(light);
                        break;
                    case 7:  ta7.setIcon(light);
                        break;
                    case 8:  ta8.setIcon(light);
                        break;
                }
            }
        });

        // Consturcts the label
        SpringLayout.Constraints labelCon = layout.getConstraints(label);
        labelCon.setX(Spring.constant(200));
        labelCon.setY(Spring.constant(10));

        // Location of Feature label
        SpringLayout.Constraints featureCon = layout.getConstraints(feature);
        featureCon.setX(Spring.constant(750));
        featureCon.setY(Spring.constant(20));

        // Location of textArea
        SpringLayout.Constraints textCon = layout.getConstraints(textArea);
        textCon.setX(Spring.constant(50));
        textCon.setY(Spring.constant(60));

        // Location of Button
        SpringLayout.Constraints btnCon = layout.getConstraints(btn01);
        btnCon.setX(Spring.constant(1000));
        btnCon.setY(Spring.constant(280));

        // Location of Section label and Section Box
        SpringLayout.Constraints sectCon = layout.getConstraints(section);
        sectCon.setX(Spring.constant(750));
        sectCon.setY(Spring.constant(70));
        SpringLayout.Constraints sectBoxCon = layout.getConstraints(sectionBox);
        sectBoxCon.setX(Spring.constant(900));
        sectBoxCon.setY(Spring.constant(75));

        // Location of AmPm label and AmPm Box
        SpringLayout.Constraints amPmCon = layout.getConstraints(person);
        amPmCon.setX(Spring.constant(750));
        amPmCon.setY(Spring.constant(110));
        SpringLayout.Constraints amPmBoxCon = layout.getConstraints(personBox);
        amPmBoxCon.setX(Spring.constant(900));
        amPmBoxCon.setY(Spring.constant(115));

        // Location of color label and color box
        SpringLayout.Constraints colorCon = layout.getConstraints(color);
        colorCon.setX(Spring.constant(750));
        colorCon.setY(Spring.constant(150));
        SpringLayout.Constraints colorBoxCon = layout.getConstraints(colorBox);
        colorBoxCon.setX(Spring.constant(900));
        colorBoxCon.setY(Spring.constant(155));

        // Location of pace label and pace box
        SpringLayout.Constraints paceCon = layout.getConstraints(pace);
        paceCon.setX(Spring.constant(750));
        paceCon.setY(Spring.constant(190));
        SpringLayout.Constraints paceBoxCon = layout.getConstraints(paceBox);
        paceBoxCon.setX(Spring.constant(900));
        paceBoxCon.setY(Spring.constant(195));

        // Location of style label and style box
        SpringLayout.Constraints teachingCon = layout.getConstraints(teaching);
        teachingCon.setX(Spring.constant(750));
        teachingCon.setY(Spring.constant(230));
        SpringLayout.Constraints teachingBoxCon = layout.getConstraints(teachingBox);
        teachingBoxCon.setX(Spring.constant(900));
        teachingBoxCon.setY(Spring.constant(230));

        dialog.setContentPane(panel);
        dialog.setVisible(true);
    }

    // Constructs a ImageIcon based on a file.
    public Icon getIcon() {
        String fileName = "datasets/extinct.jpg";
        ImageIcon icon = new ImageIcon(fileName);
        Image image = icon.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    // Constructs a ImageIcon based on a file.
    public Icon getLight() {
        String lightName = "datasets/bulb.jpg";
        ImageIcon light = new ImageIcon(lightName);
        Image extinctImage = light.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(extinctImage);
    }

    // Read the introduction.
    public void readIntro(JTextArea textArea) {
        try {
            Scanner reader = new Scanner(new File("datasets/blindDate.txt"));
            while (reader.hasNextLine()) {
                textArea.append(reader.nextLine() + "\n");
            }
        } catch (Exception FileNotFoundException){
            System.out.println("File not found");
        }
    }
}
