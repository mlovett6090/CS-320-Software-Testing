import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();

        contact = new Contact(
                "1234567890",
                "Michael",
                "Lovett",
                "7035551234",
                "123 Main Street");
    }

    @Test
    void testAddContact() {
        service.addContact(contact);

        assertEquals(contact,
                service.findContact("1234567890"));
    }

    @Test
    void testAddDuplicateContactId() {
        service.addContact(contact);

        Contact duplicateContact = new Contact(
                "1234567890",
                "John",
                "Smith",
                "5715551234",
                "456 Main Street");

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicateContact);
        });
    }

    @Test
    void testDeleteContact() {
        service.addContact(contact);

        service.deleteContact("1234567890");

        assertNull(service.findContact("1234567890"));
    }

    @Test
    void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("9999999999");
        });
    }

    @Test
    void testUpdateFirstName() {
        service.addContact(contact);

        service.updateFirstName("1234567890", "John");

        assertEquals("John",
                service.findContact("1234567890").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.addContact(contact);

        service.updateLastName("1234567890", "Smith");

        assertEquals("Smith",
                service.findContact("1234567890").getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.addContact(contact);

        service.updatePhone("1234567890", "5715551234");

        assertEquals("5715551234",
                service.findContact("1234567890").getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.addContact(contact);

        service.updateAddress(
                "1234567890",
                "456 Main Street");

        assertEquals("456 Main Street",
                service.findContact("1234567890").getAddress());
    }

    @Test
    void testUpdateInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName(
                    "9999999999",
                    "John");
        });
    }

    @Test
    void testUpdateInvalidPhone() {
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone(
                    "1234567890",
                    "12345");
        });
    }
}