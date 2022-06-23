import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;
import ru.netology.manager.PosterManager;

public class PosterManagerTest {
    PosterItem one = new PosterItem(1, "The Addams Family");
    PosterItem two = new PosterItem(2, "The Polar Express");
    PosterItem three = new PosterItem(3, "Kimi no na wa");
    PosterItem four = new PosterItem(4, "Rise of the Guardians");
    PosterItem five = new PosterItem(5, "Le Petit Prince");
    PosterItem six = new PosterItem(6, "Coco");
    PosterItem seven = new PosterItem(7, "Inside Out");
    PosterItem eight = new PosterItem(8, "Puss in Boots");
    PosterItem nine = new PosterItem(9, "A Christmas Carol");
    PosterItem ten = new PosterItem(10, "Cars");
    PosterItem eleven = new PosterItem(11, "Zootopia");
    PosterItem twelve = new PosterItem(12, "WALL·E");

    @Test
    public void testFindAll() {
        PosterManager manager = new PosterManager();
        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        manager.save(twelve);

        PosterItem[] actual = manager.findAll();
        PosterItem[] expected = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastOverLimitDefault() {
        PosterManager manager = new PosterManager();
        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);

        PosterItem[] actual = manager.findLast();
        PosterItem[] expected = {eleven, ten, nine, eight, seven, six, five, four, three, two};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastUnderLimitDefault() {
        PosterManager manager = new PosterManager();

        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);

        PosterItem[] actual = manager.findLast();
        PosterItem[] expected = {nine, eight, seven, six, five, four, three, two, one};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastLimitDefault() {
        PosterManager manager = new PosterManager();
        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);

        PosterItem[] actual = manager.findLast();
        PosterItem[] expected = {ten, nine, eight, seven, six, five, four, three, two, one};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastOverLimit() {
        PosterManager manager = new PosterManager(11);
        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        manager.save(twelve);

        PosterItem[] actual = manager.findLast();
        PosterItem[] expected = {twelve, eleven, ten, nine, eight, seven, six, five, four, three, two};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastUnderLimit() {
        PosterManager manager = new PosterManager(11);
        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);

        PosterItem[] actual = manager.findLast();
        PosterItem[] expected = {ten, nine, eight, seven, six, five, four, three, two, one};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastLimit() {
        PosterManager manager = new PosterManager(11);
        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);

        PosterItem[] actual = manager.findLast();
        PosterItem[] expected = {eleven, ten, nine, eight, seven, six, five, four, three, two, one};

        Assertions.assertArrayEquals(expected, actual);
    }

}
