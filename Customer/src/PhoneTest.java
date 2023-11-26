import java.util.Scanner;

public class PhoneTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter country code: ");
        String countryCode = input.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = input.nextLine();

        Phone phone = new Phone(countryCode, phoneNumber);

        System.out.println("Country code: " + phone.getCountryCode());
        System.out.println("Phone number: " + phone.getPhoneNumber());
        System.out.println("Full phone number: " + phone.getFullPhoneNumber());
    }
}
