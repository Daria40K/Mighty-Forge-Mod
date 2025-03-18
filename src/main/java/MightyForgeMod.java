import entity.objectEntity.ForgeObject;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;

@ModEntry
public class MightyForgeMod {
    public void init() {
        // Copper Forge
        ObjectRegistry.registerObject("copper_forge", new ForgeObject("copper_forge"), 17.0F, true);

        // Iron Forge
        ObjectRegistry.registerObject("iron_forge", new ForgeObject("iron_forge"), 25.0F, true);

        // Gold Forge
        ObjectRegistry.registerObject("gold_forge", new ForgeObject("gold_forge"), 40.0F, true);

        //Demonic
        ObjectRegistry.registerObject("demonic_forge", new ForgeObject("demonic_forge"), 80.0F, true);

        //Quartz
        ObjectRegistry.registerObject("quartz_forge", new ForgeObject("quartz_forge"), 110.0F, true);

        //Tungsten
        ObjectRegistry.registerObject("tungsten_forge", new ForgeObject("tungsten_forge"), 160.0F, true);

        //Nightsteel
        ObjectRegistry.registerObject("nightsteel_forge", new ForgeObject("nightsteel_forge"), 200.0F, true);
    }

    public void postInit() {
        // Copper Forge
        Recipes.registerModRecipe(new Recipe("copper_forge", 1, RecipeTechRegistry.WORKSTATION,
                new Ingredient[]{
                        new Ingredient("forge", 1),
                        new Ingredient("copperbar", 5)
                }
        ).showAfter("forge"));

        // Iron Forge
        Recipes.registerModRecipe(new Recipe("iron_forge", 1, RecipeTechRegistry.WORKSTATION,
                new Ingredient[]{
                        new Ingredient("copper_forge", 1),
                        new Ingredient("ironbar", 5)
                }
        ).showAfter("copper_forge"));

        // Gold Forge
        Recipes.registerModRecipe(new Recipe("gold_forge", 1, RecipeTechRegistry.WORKSTATION,
                new Ingredient[]{
                        new Ingredient("iron_forge", 1),
                        new Ingredient("goldbar", 5)
                }
        ).showAfter("iron_forge"));

        //Demonic
        Recipes.registerModRecipe(new Recipe("demonic_forge", 1, RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[]{
                        new Ingredient("gold_forge", 1),
                        new Ingredient("demonicbar", 5)
                }
        ).showAfter("gold_forge"));

        //Quartz
        Recipes.registerModRecipe(new Recipe("quartz_forge", 1, RecipeTechRegistry.DEMONIC_WORKSTATION,
                new Ingredient[]{
                        new Ingredient("demonic_forge", 1),
                        new Ingredient("quartz", 5)
                }
        ).showAfter("demonic_forge"));

        //Tungsten
        Recipes.registerModRecipe(new Recipe("tungsten_forge", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION,
                new Ingredient[]{
                        new Ingredient("quartz_forge", 1),
                        new Ingredient("tungstenbar", 5)
                }
        ).showAfter("quartz_forge"));

        //Nightsteel
        Recipes.registerModRecipe(new Recipe("nightsteel_forge", 1, RecipeTechRegistry.TUNGSTEN_WORKSTATION,
                new Ingredient[]{
                        new Ingredient("tungsten_forge", 1),
                        new Ingredient("nightsteelbar", 5)
                }
        ).showAfter("tungsten_forge"));
    }
}
