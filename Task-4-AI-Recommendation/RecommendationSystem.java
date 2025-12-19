import java.util.*;

public class RecommendationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sample products and categories
        Map<String, String> products = new HashMap<>();
        products.put("Laptop", "Electronics");
        products.put("Smartphone", "Electronics");
        products.put("Headphones", "Electronics");
        products.put("Novel Book", "Books");
        products.put("Science Magazine", "Books");
        products.put("Running Shoes", "Sports");
        products.put("Yoga Mat", "Sports");

        System.out.println("Available Categories:");
        System.out.println("Electronics, Books, Sports");

        System.out.print("\nEnter your preferred category: ");
        String userPreference = sc.nextLine();

        System.out.println("\n--- Recommended Products ---");

        boolean found = false;
        for (Map.Entry<String, String> entry : products.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(userPreference)) {
                System.out.println(entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No recommendations found for this category.");
        }

        sc.close();
    }
}
