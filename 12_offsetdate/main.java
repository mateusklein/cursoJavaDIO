import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDate);
        System.out.println(formatter.format(localDate));


        //ADICIONANDO DIAS:
        System.out.println(localDate.plus(50, ChronoUnit.DAYS));

        //ADICIONANDO ANOS:
        System.out.println(localDate.plusYears(50));

        //ADICIONANDO MESES:
        System.out.println(localDate.plusMonths(50));



        //PEGANDO APENAS DIA DO MES:
        System.out.println(localDate.getDayOfMonth());



        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println(localTime.format(formatter3));

        //SETANDO A HORA
        System.out.println(localTime.withHour(1));

        //SETANDO A HORA
        System.out.println(localTime.withMinute(30));

        //SETANDO A HORA
        System.out.println(localTime.withSecond(40));


        LocalDateTime localDateTime = localDate.atTime(localTime);

        System.out.println(localDateTime);

        Date date = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(-3)));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
    
        System.out.println(Date.from(localDateTime.toInstant(ZoneOffset.ofHours(-3))));


        date = new Date();
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime(date);
        ZoneId zoneId = calendar.getTimeZone().toZoneId();
        LocalDateTime localDateTime4 = LocalDateTime.ofInstant(calendar.toInstant(), zoneId);
        System.out.println(localDateTime4); 
        System.out.println(Duration.between(localDateTime4, LocalDateTime.now()).toMillis());


        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        OffsetDateTime offsetDateTime2 = OffsetDateTime.now().withOffsetSameInstant(ZoneOffset.UTC);


        //MESMO INSTANTE
        System.out.println(offsetDateTime.isEqual(offsetDateTime2));

        var date3 = Date.from(offsetDateTime.toInstant());

        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTime(date3);


        OffsetDateTime offsetDateTime5 = Calendar.getInstance().getTime().toInstant().atOffset(ZoneOffset.ofHours(-3));
        System.out.println(offsetDateTime5);
        
    }
}
