import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;



class ContactTest {



    @Test

    void testContactCreation() {

        Contact contact = new Contact(

                "1234567890",

                "Michael",

                "Lovett",

                "7035551234",

                "123 Main Street");



        assertEquals("1234567890", contact.getContactId());

        assertEquals("Michael", contact.getFirstName());

        assertEquals("Lovett", contact.getLastName());

        assertEquals("7035551234", contact.getPhone());

        assertEquals("123 Main Street", contact.getAddress());

    }



    @Test

    void testContactIdTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "12345678901",

                    "Michael",

                    "Lovett",

                    "7035551234",

                    "123 Main Street");

        });

    }



    @Test

    void testContactIdNull() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    null,

                    "Michael",

                    "Lovett",

                    "7035551234",

                    "123 Main Street");

        });

    }



    @Test

    void testFirstNameTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    "MichaelJohn",

                    "Lovett",

                    "7035551234",

                    "123 Main Street");

        });

    }



    @Test

    void testFirstNameNull() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    null,

                    "Lovett",

                    "7035551234",

                    "123 Main Street");

        });

    }



    @Test

    void testLastNameTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    "Michael",

                    "LovettSmith",

                    "7035551234",

                    "123 Main Street");

        });

    }



    @Test

    void testLastNameNull() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    "Michael",

                    null,

                    "7035551234",

                    "123 Main Street");

        });

    }



    @Test

    void testPhoneTooShort() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    "Michael",

                    "Lovett",

                    "703555123",

                    "123 Main Street");

        });

    }



    @Test

    void testPhoneTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    "Michael",

                    "Lovett",

                    "70355512345",

                    "123 Main Street");

        });

    }



    @Test

    void testPhoneContainsLetters() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    "Michael",

                    "Lovett",

                    "70355ABCDE",

                    "123 Main Street");

        });

    }



    @Test

    void testPhoneNull() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    "Michael",

                    "Lovett",

                    null,

                    "123 Main Street");

        });

    }



    @Test

    void testAddressTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    "Michael",

                    "Lovett",

                    "7035551234",

                    "1234567890123456789012345678901");

        });

    }



    @Test

    void testAddressNull() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact(

                    "1234567890",

                    "Michael",

                    "Lovett",

                    "7035551234",

                    null);

        });

    }

}