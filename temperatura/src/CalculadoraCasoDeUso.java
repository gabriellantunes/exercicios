public class CalculadoraCasoDeUso {

    public int calcular(int a,int b, String operacao){
        double resultado = 0;

        if("Fahrenheit".equals(operacao)){
            resultado = (a * 9/5) + 32;
        }else  if("Kelvin".equals(operacao)) {
            resultado = a + 273.5;
        }

        return (int) resultado;
    }
}
