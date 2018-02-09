package macias.nelson;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class Placa extends JFrame{

    private JLabel etiqueta;
    private JTextField campo;

    private JButton verificar;
    private JDialog dialogo;
    private JLabel etiqueta2;
    private JLabel fecha;
    public Placa(){
        super("Verificacion de restriccion Vehicular por Nro Placa 1.0");
        etiqueta = new JLabel("Introduzca el Nro de placa ");
        campo = new JTextField(5);
        verificar = new JButton("Verificar");
        etiqueta2 = new JLabel();

        fecha=new JLabel();

        dialogo = new JDialog(this);
        dialogo.setUndecorated(true);
        dialogo.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        dialogo.setBounds(450,300,500,150);
        FlowLayout f = new FlowLayout();
        setLayout(f);
        add(etiqueta);
        add(campo);
        add(verificar);
        add(fecha);

        verificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                verificarPlaca();
            }
        });
    }

    private void verificarPlaca() {
        String placa = campo.getText();

        int numVer = getParteNumerica(placa);
        int nPlaca = numVer%10;

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("nPlaca:" + nPlaca);
        System.out.println("Placa :" + numVer);
        System.out.println("dia: " + day);

        switch (day){

            case Calendar.MONDAY:
                verificarPlaca(nPlaca, 0,1);
                break;
            case Calendar.TUESDAY:
                verificarPlaca(nPlaca, 2,3);
                break;

            case Calendar.WEDNESDAY:
                verificarPlaca(nPlaca, 4, 5);
                break;

            case Calendar.THURSDAY:
                verificarPlaca(nPlaca, 6,7);
                break;

            case Calendar.FRIDAY:
                verificarPlaca(nPlaca, 8,9);
                break;
        }
        dialogo.add(etiqueta2);
        dialogo.setVisible(true);

    }

    int getParteNumerica(String placa){
        int res=0;
        for(int i=0; i<placa.length(); i++){
            char c = placa.charAt(i);
            if (c>'0' && c<='9'){
                res=res*10 + Character.getNumericValue(c);
            }
        }
        return res;
    }

    public void verificarPlaca(int nPlaca,int lim1, int lim2){
        if (nPlaca==lim1|| nPlaca==lim2)
            etiqueta2.setText("PLACA RESTRINGIDA: \nSu vehiculo no puede ingresar al centro");
        else
            etiqueta2.setText("CON ACCESO AL CENTRO ");
    }

    public static void fechaActual()
    {
        Calendar calendar = Calendar.getInstance();
        Date now=new Date();
        calendar.setTime(now);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }


}