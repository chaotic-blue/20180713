import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;

class LocalDateTimeDemo2 {
	public static void main(String[] args) {
		
		LocalDateTime today = LocalDateTime.of(2020,  4, 25, 11, 20);
		
		LocalDateTime flight1 = LocalDateTime.of(2020,  5, 14, 11, 15);
		
		LocalDateTime flight2 = LocalDateTime.of(2020,  5, 13, 15, 30);
		
		LocalDateTime myFlight;
		if(flight1.isBefore(flight2))
			myFlight = flight1;
		else
			myFlight = flight2;
		
		Period day = Period.between(today.toLocalDate(), myFlight.toLocalDate());
		
		Duration time = Duration.between(today.toLocalTime(), myFlight.toLocalTime());
		
		System.out.println(day);
		System.out.println(time);
	}
}
