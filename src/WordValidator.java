public class WordValidator {

    public static String[] checkGuess(String secret, String guess) {

        String[] result = new String[5];
        boolean[] used = new boolean[5];

        // First pass: Check correct letters in correct positions
        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                result[i] = "GREEN";
                used[i] = true;
            }
        }

        // Second pass: Check correct letters in wrong positions
        for (int i = 0; i < 5; i++) {

            if (result[i] != null)
                continue;

            boolean found = false;

            for (int j = 0; j < 5; j++) {

                if (guess.charAt(i) == secret.charAt(j) && !used[j]) {
                    result[i] = "YELLOW";
                    used[j] = true;
                    found = true;
                    break;
                }
            }

            if (!found) {
                result[i] = "GRAY";
            }
        }

        return result;
    }
