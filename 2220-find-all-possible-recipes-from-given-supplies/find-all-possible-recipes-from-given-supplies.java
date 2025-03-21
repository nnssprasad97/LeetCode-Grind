import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Convert supplies array to a HashSet for O(1) lookup
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        // Map to store recipe -> list of ingredients
        Map<String, List<String>> recipeMap = new HashMap<>();
        // Map for memoization to avoid cycles
        Map<String, Boolean> memo = new HashMap<>();
        // Result list
        List<String> result = new ArrayList<>();
        
        // Build the recipe-ingredients map
        for (int i = 0; i < recipes.length; i++) {
            recipeMap.put(recipes[i], ingredients.get(i));
        }
        
        // Check each recipe
        for (String recipe : recipes) {
            if (canMake(recipe, recipeMap, available, memo)) {
                result.add(recipe);
            }
        }
        
        return result;
    }
    
    private boolean canMake(String recipe, Map<String, List<String>> recipeMap, 
                          Set<String> available, Map<String, Boolean> memo) {
        // If already computed, return memoized result
        if (memo.containsKey(recipe)) {
            return memo.get(recipe);
        }
        
        // If it's a basic ingredient available in supplies
        if (available.contains(recipe)) {
            return true;
        }
        
        // If it's not a known recipe, we can't make it
        if (!recipeMap.containsKey(recipe)) {
            return false;
        }
        
        // Get required ingredients for this recipe
        List<String> ingredients = recipeMap.get(recipe);
        
        // Mark as being processed to handle cycles
        memo.put(recipe, false);
        for (String ingredient : ingredients) {
            if (!canMake(ingredient, recipeMap, available, memo)) {
                return false;
            }
        }
        memo.put(recipe, true);
        return true;
    }
}