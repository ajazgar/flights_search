package demo.test;

import demo.model.Flight;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestClientUtil {

    public void getFlightByIdDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/user/flight/1";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Flight> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Flight.class, 1);
        Flight flight = responseEntity.getBody();
        System.out.println("Id:"+flight.getId()+", Departure City:"+flight.getDepartureCity()+", Arrival City:"+flight.getArrivalCity()+", Departure Date:"+flight.getDepartureDate()+
                            ", Arrival Date:"+flight.getArrivalDate()+", Flight Class:"+flight.getFlightClass()+", Price:"+flight.getPrice());
    }

    public void getAllFlightsDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/user/flights";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Flight[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Flight[].class);
        Flight[] flights = responseEntity.getBody();
        for(Flight flight : flights) {
            System.out.println("Id:"+flight.getId()+", Departure City:"+flight.getDepartureCity()+", Arrival City:"+flight.getArrivalCity()+", Departure Date:"+flight.getDepartureDate()+
                    ", Arrival Date:"+flight.getArrivalDate()+", Flight Class:"+flight.getFlightClass()+", Price:"+flight.getPrice());
        }
    }

    public static void main(String args[]) {
        RestClientUtil util = new RestClientUtil();
        util.getFlightByIdDemo();
        util.getAllFlightsDemo();
    }
}
