package entity.objectEntity;

import necesse.engine.registries.GlobalIngredientRegistry;
import necesse.engine.sound.SoundEffect;
import necesse.engine.sound.SoundManager;
import necesse.engine.sound.SoundPlayer;
import necesse.engine.sound.gameSound.GameSound;
import necesse.entity.objectEntity.FueledProcessingTechInventoryObjectEntity;
import necesse.gfx.GameResources;
import necesse.inventory.InventoryItem;
import necesse.inventory.recipe.Tech;
import necesse.level.maps.Level;

public abstract class AnyLogFueledProcessingTechInventoryObjectEntity extends FueledProcessingTechInventoryObjectEntity {
    public GameSound workingSound;
    private SoundPlayer playingSound;

    public AnyLogFueledProcessingTechInventoryObjectEntity(Level level, String type, int x, int y,int fuelSlots, int inputSlots, int outputSlots, boolean fuelAlwaysOn, boolean fuelRunsOutWhenNotProcessing, boolean runningOutOfFuelResetsProcessingTime, Tech... techs) {
        super(level, type, x, y, fuelSlots, inputSlots, outputSlots, fuelAlwaysOn, fuelRunsOutWhenNotProcessing, runningOutOfFuelResetsProcessingTime, techs);
        this.workingSound = GameResources.campfireAmbient;
    }

    public void clientTick() {
        super.clientTick();
        if (this.workingSound != null && this.isFuelRunning()) {
            if (this.playingSound == null || this.playingSound.isDone()) {
                this.playingSound = SoundManager.playSound(this.workingSound, SoundEffect.effect(this).falloffDistance(400).volume(0.25F));
            }

            if (this.playingSound != null) {
                this.playingSound.refreshLooping(1.0F);
            }
        }

    }

    public boolean isValidFuelItem(InventoryItem item) {
        return item.item.isGlobalIngredient(GlobalIngredientRegistry.getGlobalIngredient("anylog"));
    }

    public int getNextFuelBurnTime(boolean useFuel) {
        return this.itemToBurnTime(useFuel, (item) -> item.item.isGlobalIngredient(GlobalIngredientRegistry.getGlobalIngredient("anylog")) ? this.getFuelTime(item) : 0);
    }

    public abstract int getFuelTime(InventoryItem var1);
}
