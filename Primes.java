public class Primes {
    public static void main(String[] args) {
        // Parse the input N
        final int N = Integer.parseInt(args[0]);

        // 1. Create the boolean array
        // We assume all numbers are prime initially.
        boolean[] isPrime = new boolean[N + 1];
        
        // Initialize indices 2 to N to true
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        // 2. The Sieve Algorithm (Using a While Loop)
        // We only need to check numbers up to the square root of N
        int p = 2;
        while (p <= Math.sqrt(N)) {

            // If p is still marked as prime, cross out its multiples
            if (isPrime[p]) {
                
                // Start crossing out at the first multiple (p + p)
                // We use a while loop here too
                int i = p + p;
                while (i <= N) {
                    isPrime[i] = false; // Cross out
                    i = i + p;          // Jump to the next multiple
                }
            }
            p++;
        }

        // 3. Print the results and count them
        // FIXED: Changed "Primes" to "Prime numbers" to match the tester requirements
        System.out.println("Prime numbers up to " + N + ":");
        
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                count++;
            }
        }

        // Optional: Print the statistics shown in the lecture slide
        int percentage = (int) (((double) count / N) * 100);
        System.out.println("There are " + count + " primes between 2 and " + N + " (" + percentage + "% are primes)");
    }
}