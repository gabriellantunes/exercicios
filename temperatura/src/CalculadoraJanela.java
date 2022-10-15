import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraJanela extends JFrame {

    private JComboBox<String> opcoesComboBox;
    private String[] opcoes = {"Fahrenheit","Kelvin"};
    private JTextField resultadoTextField;
    private JTextField campo1TextField;
    private JTextField campo2TextField;
    private CalculadoraCasoDeUso casoDeUso;

    public CalculadoraJanela(){
        setTitle("Calculadora de Temperatura");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configurarJanela();
        setVisible(true);
        casoDeUso = new CalculadoraCasoDeUso();
    }

    public void configurarJanela(){
        JPanel panel = new JPanel();
        opcoesComboBox = new JComboBox<>(opcoes);
        JLabel label = new JLabel("Celsius:");
        campo1TextField = new JTextField(10);
        //campo2TextField = new JTextField(10);
        resultadoTextField = new JTextField(10);
        resultadoTextField.setEnabled(false);
        JLabel label2 = new JLabel("Calcular para:");
        JButton calcularBotao = new JButton("Calcular");
        calcularBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });

        panel.add(label);
        panel.add(campo1TextField);
        panel.add(label2);
        panel.add(opcoesComboBox);
        //panel.add(campo2TextField);
        panel.add(calcularBotao);
        panel.add(resultadoTextField);
        add(panel);
    }

    private void calcularResultado() {
        int a = 0;
        try {
            a = Integer.parseInt(campo1TextField.getText());
        }catch (Exception ignored){}
        int b = 0;
        try{
            b = Integer.parseInt(campo2TextField.getText());
        }catch (Exception ignored){}
        String operacao =  (String) opcoesComboBox.getSelectedItem();
        int resultado = casoDeUso.calcular(a, b, operacao);
        resultadoTextField.setText(Integer.toString(resultado));
    }


}
