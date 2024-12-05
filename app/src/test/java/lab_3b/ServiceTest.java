package lab_3b;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    private Service service;

    @Mock
    private Database database;

    @BeforeEach
    void setUp() {
        service = new Service(database);
    }

    @Nested
    class Query {
        @Test
        void notAvailable() {
            when(database.isAvailable()).thenReturn(false);
            boolean query = service.query("");
            assertFalse(query);
        }

        @Test
        void available() {
            when(database.isAvailable()).thenReturn(true);
            boolean query = service.query("");
            assertTrue(query);
        }
    }

    @Test
    void getDatabaseId() {
        when(database.getUniqueId()).thenReturn(8);
        String databaseID = service.getDatabaseID();
        assertEquals("Using database with id: 8", databaseID);
    }
}