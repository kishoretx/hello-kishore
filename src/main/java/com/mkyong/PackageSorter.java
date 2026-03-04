/*
Sort the packages using the following criteria:

- A package is **bulky** if its volume (Width x Height x Length) is greater than or equal to 1,000,000 cm³ or when one of its dimensions is greater or equal to 150 cm.
- A package is **heavy** when its mass is greater or equal to 20 kg.

You must dispatch the packages in the following stacks:

- **STANDARD**: standard packages (those that are not bulky or heavy) can be handled normally.
- **SPECIAL**: packages that are either heavy or bulky can't be handled automatically.
- **REJECTED**: packages that are **both** heavy and bulky are rejected.
*/

public class PackageSorter {

    public static String sort(int width, int height, int length, int mass) {
        long volume = 1L * width * height * length;

        boolean isBulky = volume >= 1_000_000
                || width >= 150
                || height >= 150
                || length >= 150;

        boolean isHeavy = mass >= 20;

        if (isBulky && isHeavy) {
            return "REJECTED";
        } else if (isBulky || isHeavy) {
            return "SPECIAL";
        } else {
            return "STANDARD";
        }
    }

    // simple tests
    public static void main(String[] args) {
        System.out.println(sort(100, 100, 100, 10));   // STANDARD
        System.out.println(sort(200, 50, 50, 10));     // SPECIAL (bulky)
        System.out.println(sort(100, 100, 100, 25));   // SPECIAL (heavy)
        System.out.println(sort(200, 200, 200, 25));   // REJECTED
    }
}
