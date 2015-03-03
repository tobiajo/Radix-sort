package aod.nb39;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Tobias Johansson <tobias@johansson.xyz>
 */
public class RadixSort {

    private static final int BASE = 55555; // talbas

    /**
     * Radix sort.
     *
     * @param ints the numbers
     */
    public static void sort(int[] ints) {

        Map<Integer, List<Integer>> buckets = new HashMap();

        for (int i = 0; i < BASE; i++) {
            buckets.put(i, new LinkedList());
        }

        // Grupperar talen baserat på den minst signifikanta siffran.
        // Upprepar grupperingen för varje mer signifikant siffra.
        for (int mod = BASE, div = 1; true; mod *= BASE, div *= BASE) {

            if (mod <= 0) {
                break; // bryt om mod går över 2^31 − 1
            }
            // Grupperar talen
            for (int number : ints) {
                int group = (number % mod) / div;
                buckets.get(group).add(number);

            }

            // Lägger tillbaka talen
            int index = 0;
            for (int i = 0; i < BASE; i++) {
                Iterator<Integer> itr = buckets.get(i).iterator();
                while (itr.hasNext()) {
                    ints[index++] = itr.next();
                    itr.remove();
                }
            }
            //if (sorted(ints)) break; // avbryter om sorterad
        }
    }

    /**
     * Sort controll for ascending order.
     *
     * @param ints numbers
     * @return true if ints are in ascending order
     */
    public static boolean sorted(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
