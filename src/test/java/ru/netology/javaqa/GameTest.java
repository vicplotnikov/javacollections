package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GameTest {

    @Test
    public void testWhenWinPlayerFirst() {
        Player ivan = new Player(1, "Ivan", 700);
        Player stepan = new Player(1, "Stepan", 500);
        Game game = new Game();

        game.register(ivan);
        game.register(stepan);
        int expected = 1;
        int actual = game.round("Ivan", "Stepan");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenWinPlayerSecond() {
        Player ivan = new Player(1, "Ivan", 700);
        Player stepan = new Player(1, "Stepan", 750);
        Game game = new Game();

        game.register(ivan);
        game.register(stepan);
        int expected = 2;
        int actual = game.round("Ivan", "Stepan");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenNotWinPlayer() {
        Player ivan = new Player(1, "Ivan", 700);
        Player stepan = new Player(1, "Stepan", 700);
        Game game = new Game();

        game.register(ivan);
        game.register(stepan);
        int expected = 0;
        int actual = game.round("Ivan", "Stepan");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenNotExistPlayerFirst() {
        Player ivan = new Player(1, "Ivan", 700);
        Player stepan = new Player(1, "Stepan", 500);
        Game game = new Game();

        game.register(ivan);
        game.register(stepan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Oleg", "Stepan")
        );
    }

    @Test
    public void testWhenNotExistPlayerSecond() {
        Player ivan = new Player(1, "Ivan", 700);
        Player stepan = new Player(1, "Stepan", 500);
        Game game = new Game();

        game.register(ivan);
        game.register(stepan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ivan", "Oleg")
        );
    }
}