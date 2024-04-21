package org.sergei;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class MainTest {


    @InjectMocks
    Main main = new Main();

    @Test
    public void testMain() {
        Main.main(new String[] {"src/test/resources/testBookStore.txt"});
    }

}
