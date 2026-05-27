import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

    public static void main(String[] args) {

        //Creamos la consola para que el usuario intercatue
        Scanner consola = new Scanner(System.in);

        //Obtenemos la fecha y hora actual
        LocalDateTime fechaYHora = LocalDateTime.now();

        //Cambio el formato para que lo muestre sin nanosegundos
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fechaFormateada = fechaYHora.format(formato);

        //Mostramos la fecha y hora actual por consola
        System.out.println ("Fecha y hora actual: " + fechaFormateada);

        //Pedimos al usuario que introduzca la fecha de nacimiento con el formato indicado por consola
        System.out.println("Introduzca la fecha de nacimiento (AAAA-MM-DD): ");
        String fecha = consola.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fecha);

        //Obtenemos la fecha actual
        LocalDate fechaHoy = LocalDate.now();

        //Obtenemos el mes y el dia del cumpeaños
        MonthDay cumple = MonthDay.from(fechaNacimiento);

        //Obtenemos el cumpleaños de este año
        LocalDate cumpleActual = cumple.atYear(fechaHoy.getYear());

        //Si el cumpleaños ya paso se muestran los dias pasados y los restantes para el proximo cumpleaños
        if (cumpleActual.isBefore(fechaHoy)) {

             long diasPasados = ChronoUnit.DAYS.between(cumpleActual, fechaHoy);

             LocalDate proximoCumple = cumpleActual.plusYears(1);

             long diasRestantes =  ChronoUnit.DAYS.between(fechaHoy, proximoCumple);

            System.out.println("Tu cumpleaños pasó hace " + diasPasados + " días.");
            System.out.println("Faltan " + diasRestantes + " días para tu próximo cumpleaños.");

        //Ademas si el cumpleaños es hoy mostrara un mensaje
        } else if (cumpleActual.isEqual(fechaHoy)) {

            System.out.println("Hoy es tu cumpleaños!");

        //Y si no, muestra los dias restantes solamente
        } else {

            long diasRestantes =  ChronoUnit.DAYS.between(fechaHoy, cumpleActual);
            System.out.println("Faltan " + diasRestantes + " días para tu cumpleaños.");

        }

        consola.close();
    }
