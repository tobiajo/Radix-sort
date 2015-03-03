package aod.nb39;

/**
 *
 * @author Tobias Johansson <tobias@johansson.xyz>
 */
public class AoDNB39 {

    private static final int MILLION = (int) 1e6;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] ints = new int[MILLION];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (MILLION * Math.random());
        }

        System.out.println("Sorting...");
        long start = System.nanoTime();
        RadixSort.sort(ints);
        long elapsed = System.nanoTime() - start;
        System.out.println("Sorting " + (RadixSort.sorted(ints) ? "succeded" : "failed"));
        System.out.println("RadixSort(ints[MILLION]) took " + elapsed/MILLION + " ms");
    }

}
