import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        List<String> failureSeq = new ArrayList<>();
        failureSeq.add("\n");

        /**
         * Test addFirst()
         */
        for (int i = 0; i < 5; i++) {
            Integer random = StdRandom.uniform(100);
            ads.addFirst(random);
            sad.addFirst(random);
            failureSeq.add("addFirst(" + random + ")\n");
        }
        for (int i = 0; i < 5; i++) {
            Integer expected = ads.get(i);
            Integer actual = sad.get(i);
            String printSeq = Arrays.toString(failureSeq.toArray()).replace("[", "").replace("]", "").replace(",", "");
            assertEquals(printSeq,
                    expected, actual);
        }

        /**
         * Test addLast()
         */
        for (int i = 0; i < 5; i++) {
            Integer random = StdRandom.uniform(100);
            ads.addLast(random);
            sad.addLast(random);
            failureSeq.add("addLast(" + random + ")\n");
        }
        for (int i = 0; i < 10; i++) {
            Integer expected = ads.get(i);
            Integer actual = sad.get(i);
            String printSeq = Arrays.toString(failureSeq.toArray()).replace("[", "").replace("]", "").replace(",", "");
            assertEquals(printSeq,
                    expected, actual);
        }

        /**
         * Test removeFirst()
         */
        for (int i = 0; i < 5; i++) {
            Integer expected = ads.removeFirst();
            Integer actual = sad.removeFirst();
            failureSeq.add("removeFirst()\n");
            String printSeq = Arrays.toString(failureSeq.toArray()).replace("[", "").replace("]", "").replace(",", "");
            assertEquals(printSeq,
                    expected, actual);
        }
        for (int i = 0; i < 5; i++) {
            Integer expected = ads.get(i);
            Integer actual = sad.get(i);
            String printSeq = Arrays.toString(failureSeq.toArray()).replace("[", "").replace("]", "").replace(",", "");
            assertEquals(printSeq,
                    expected, actual);
        }

        /**
         * Test removeLast()
         */
        for (int i = 0; i < 5; i++) {
            Integer expected = ads.removeLast();
            Integer actual = sad.removeLast();
            failureSeq.add("removeLast()\n");
            String printSeq = Arrays.toString(failureSeq.toArray()).replace("[", "").replace("]", "").replace(",", "");
            assertEquals(printSeq,
                    expected, actual);
        }
        for (int i = 0; i < 5; i++) {
            Integer expected = ads.get(i);
            Integer actual = sad.get(i);
            String printSeq = Arrays.toString(failureSeq.toArray()).replace("[", "").replace("]", "").replace(",", "");
            assertEquals(printSeq,
                    expected, actual);
        }

    }
}
