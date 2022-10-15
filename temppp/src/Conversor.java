import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Conversor extends JFrame {
    private JComboBox input, output;
    private JTextField infoBlocs[];

    public Conversor() {
        setTitle("[Conversor]");
        setSize(730, 100);

        startFunc();
        setVisible(true);
    }

    private void startFunc() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        infoBlocs = new  JTextField[2];
        for(int i = 0; i < infoBlocs.length; i++){
            infoBlocs[i] = new JTextField();
            infoBlocs[i].setPreferredSize(new Dimension(50,20));
        }

        infoBlocs[1].setEditable(false);
        String temp[] = {"Celsius", "Fahrenheit", "Kelvin"};
        input = new JComboBox(temp);
        output = new JComboBox(temp);

        Container c = new Container();
        c.setLayout(new GridLayout(3, 2));

        JButton conversor = new JButton("Realiza Conversão");
        conversor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                try {
                    float a = Float.parseFloat(infoBlocs[0].getText());
                    int b = input.getSelectedIndex();
                    int c = output.getSelectedIndex();
                    if(b == c)
                        infoBlocs[1].setText(a + "");


                    else if(b == 0 && c == 1)
                        infoBlocs[1].setText((a * 1.8 + 32) + "");
                    else if(b == 0 && c == 2)
                        infoBlocs[1].setText((a + 273.15) + "");


                    else if(b == 1 && c == 0)
                        infoBlocs[1].setText(((a - 32) / 1.8) + "");
                    else if(b == 1 && c == 2)
                        infoBlocs[1].setText(((a - 32) / 1.8 + 273.15) + "");


                    else if(b == 2 && c == 0)
                        infoBlocs[1].setText((a - 273.15) + "");
                    else if(b == 2 && c == 1)
                        infoBlocs[1].setText((a - 273.15 - 32)/1.8 + "");

                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        c.add(new JLabel("Temperatura: "));
        c.add(input);
        c.add(new JLabel("Conversão para: "));
        c.add(output);

        add(infoBlocs[0]);
        add(c);
        add(conversor);
        add(infoBlocs[1]);
    }
}
