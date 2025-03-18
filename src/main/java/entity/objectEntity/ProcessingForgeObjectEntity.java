package entity.objectEntity;

import necesse.engine.registries.RecipeTechRegistry;
import necesse.inventory.InventoryItem;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Tech;
import necesse.level.maps.Level;

public class ProcessingForgeObjectEntity extends AnyLogFueledProcessingTechInventoryObjectEntity {
    private final int logFuelTime;
    private final int recipeProcessTime;

    public ProcessingForgeObjectEntity(Level level, int x, int y, int fuelSlots, int inputSlots, int outputSlots, int logFuelTime, int recipeProcessTime) {
        super(level, "forge", x, y, fuelSlots, inputSlots, outputSlots, false, false, true, new Tech[]{RecipeTechRegistry.FORGE});

        this.logFuelTime = logFuelTime;
        this.recipeProcessTime = recipeProcessTime;
    }

    public int getFuelTime(InventoryItem item) {
        return logFuelTime;
    }

    public int getProcessTime(Recipe recipe) {
        return recipeProcessTime;
    }

    public boolean shouldBeAbleToChangeKeepFuelRunning() {
        return false;
    }
}