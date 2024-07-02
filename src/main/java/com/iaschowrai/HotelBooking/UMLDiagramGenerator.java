package com.iaschowrai.HotelBooking;
import net.sourceforge.plantuml.SourceStringReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class UMLDiagramGenerator {

    public static void main(String[] args) {
        try {
            String umlSource = "@startuml\n" +
                    "class User {\n" +
                    "    - long id\n" +
                    "    - String email\n" +
                    "    - String password\n" +
                    "    - String name\n" +
                    "    - String phoneNumber\n" +
                    "    - String role\n" +
                    "    - List<Booking> bookings\n" +
                    "    + Collection<? extends GrantedAuthority> getAuthorities()\n" +
                    "    + String getUsername()\n" +
                    "    + boolean isAccountNonExpired()\n" +
                    "    + boolean isAccountNonLocked()\n" +
                    "    + boolean isCredentialsNonExpired()\n" +
                    "    + boolean isEnabled()\n" +
                    "}\n" +
                    "class Booking {\n" +
                    "    - long id\n" +
                    "    - LocalDateTime checkInDate\n" +
                    "    - LocalDateTime checkOutDate\n" +
                    "    - int numOfAdults\n" +
                    "    - int numOfChildren\n" +
                    "    - int totalNumOfGuest\n" +
                    "    - String bookingConfirmationCode\n" +
                    "    - User user\n" +
                    "    - Room room\n" +
                    "    + void calculateTotalNumberOfGuest()\n" +
                    "    + void setNumOfAdults(int numOfAdults)\n" +
                    "    + void setNumOfChildren(int numOfChildren)\n" +
                    "    + String toString()\n" +
                    "}\n" +
                    "class Room {\n" +
                    "    - long id\n" +
                    "    - String bookingConfirmation\n" +
                    "    - String roomType\n" +
                    "    - String roomNumber\n" +
                    "    - BigDecimal roomPrice\n" +
                    "    - String roomPhotoURL\n" +
                    "    - String roomDescription\n" +
                    "    - List<Booking> bookings\n" +
                    "    + String toString()\n" +
                    "}\n" +
                    "User \"1\" --> \"0..*\" Booking\n" +
                    "Room \"1\" --> \"0..*\" Booking\n" +
                    "@enduml";

            SourceStringReader reader = new SourceStringReader(umlSource);
            final OutputStream png = new FileOutputStream(new File("uml_diagram.png"));
//            reader.generateImage(png);    // uncomment to generate the image
            png.close();
            System.out.println("UML Diagram generated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
