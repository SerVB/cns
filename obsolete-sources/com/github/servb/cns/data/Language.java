/*
 * Copyright 2018 SerVB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.servb.cns.data;

import java.io.File;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import com.github.servb.cns.util.XmlElementDesc;
import servb.util.file.CreatedFromFile;

/**
 * The Language class.
 *
 * @author SerVB
 */
public final class Language implements CreatedFromFile {

    private static final String NAME_FONT1 = "font1";
    private static final String NAME_FONT2 = "font2";
    private static final String NAME_LOADING_FONT_ID = "loadingFontID";
    private static final String NAME_LANGUAGE = "language";

    /** Language simple font file. */
    private final Font font1;
    /** Language full font file. */
    private final Font font2;
    /** "Loading" text font ID (exact font name in Windows). */
    private final String loadingFontId;
    /** Language native name. */
    private final String languageName;

    /* --- Storages: --- */

    private final Map<Common, String> common = new EnumMap<>(Common.class);
    private final Map<WeaponName, String> weaponName = new EnumMap<>(WeaponName.class);
    private final Map<ShipUpgradeName, String> shipUpgradeName = new EnumMap<>(ShipUpgradeName.class);
    private final Map<ShipUpgradeDescription, String> shipUpgradeDescription =
            new EnumMap<>(ShipUpgradeDescription.class);
    private final Map<PlanetUpgradeName, String> planetUpgradeName = new EnumMap<>(PlanetUpgradeName.class);
    private final Map<PlanetUpgradeDescription, String> planetUpgradeDescription =
            new EnumMap<>(PlanetUpgradeDescription.class);
    private final Map<Reminder, String> reminder = new EnumMap<>(Reminder.class);

    /* --- Screens: --- */

    private final Map<ShipScreen, String> shipScreen = new EnumMap<>(ShipScreen.class);
    private final Map<PlanetScreen, String> planetScreen = new EnumMap<>(PlanetScreen.class);
    private final Map<TitleScreen, String> titleScreen = new EnumMap<>(TitleScreen.class);
    private final Map<LevelSelectScreen, String> levelSelectScreen = new EnumMap<>(LevelSelectScreen.class);
    private final Map<OptionsScreen, String> optionsScreen = new EnumMap<>(OptionsScreen.class);
    private final Map<CreditsScreen, String> creditsScreen = new EnumMap<>(CreditsScreen.class);
    private final Map<VictoryScreen, String> victoryScreen = new EnumMap<>(VictoryScreen.class);

    private final File xmlFile;

    private Language(final File xmlFile) {
        this.xmlFile = xmlFile;

        throw new UnsupportedOperationException("TODO!");
    }

    public static Language fromFile(final File xmlFile) {
        return new Language(xmlFile);
    }

    //<editor-fold desc="Getters" defaultstate="collapsed">
    public Font font1() {
        return font1;
    }

    public Font font2() {
        return font2;
    }

    public String loadingFontId() {
        return loadingFontId;
    }

    public String languageName() {
        return languageName;
    }

    public String getText(final TextItem textItem) {
        if (textItem instanceof Common) {
            return common.get((Common) textItem);
        }
        if (textItem instanceof WeaponName) {
            return weaponName.get((WeaponName) textItem);
        }
        if (textItem instanceof ShipUpgradeName) {
            return shipUpgradeName.get((ShipUpgradeName) textItem);
        }
        if (textItem instanceof ShipUpgradeDescription) {
            return shipUpgradeDescription.get((ShipUpgradeDescription) textItem);
        }
        if (textItem instanceof PlanetUpgradeName) {
            return planetUpgradeName.get((PlanetUpgradeName) textItem);
        }
        if (textItem instanceof PlanetUpgradeDescription) {
            return planetUpgradeDescription.get((PlanetUpgradeDescription) textItem);
        }
        if (textItem instanceof Reminder) {
            return reminder.get((Reminder) textItem);
        }

        if (textItem instanceof ShipScreen) {
            return shipScreen.get((ShipScreen) textItem);
        }
        if (textItem instanceof PlanetScreen) {
            return planetScreen.get((PlanetScreen) textItem);
        }
        if (textItem instanceof TitleScreen) {
            return titleScreen.get((TitleScreen) textItem);
        }
        if (textItem instanceof LevelSelectScreen) {
            return levelSelectScreen.get((LevelSelectScreen) textItem);
        }
        if (textItem instanceof OptionsScreen) {
            return optionsScreen.get((OptionsScreen) textItem);
        }
        if (textItem instanceof CreditsScreen) {
            return creditsScreen.get((CreditsScreen) textItem);
        }
        if (textItem instanceof VictoryScreen) {
            return victoryScreen.get((VictoryScreen) textItem);
        }

        throw new IllegalArgumentException("Unknown text item: " + textItem.toString());
    }
    //</editor-fold>

    //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.font1);
        hash = 59 * hash + Objects.hashCode(this.font2);
        hash = 59 * hash + Objects.hashCode(this.loadingFontId);
        hash = 59 * hash + Objects.hashCode(this.languageName);
        hash = 59 * hash + Objects.hashCode(this.common);
        hash = 59 * hash + Objects.hashCode(this.weaponName);
        hash = 59 * hash + Objects.hashCode(this.shipUpgradeName);
        hash = 59 * hash + Objects.hashCode(this.shipUpgradeDescription);
        hash = 59 * hash + Objects.hashCode(this.planetUpgradeName);
        hash = 59 * hash + Objects.hashCode(this.planetUpgradeDescription);
        hash = 59 * hash + Objects.hashCode(this.reminder);
        hash = 59 * hash + Objects.hashCode(this.shipScreen);
        hash = 59 * hash + Objects.hashCode(this.planetScreen);
        hash = 59 * hash + Objects.hashCode(this.titleScreen);
        hash = 59 * hash + Objects.hashCode(this.levelSelectScreen);
        hash = 59 * hash + Objects.hashCode(this.optionsScreen);
        hash = 59 * hash + Objects.hashCode(this.creditsScreen);
        hash = 59 * hash + Objects.hashCode(this.victoryScreen);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Language other = (Language) obj;
        if (!Objects.equals(this.loadingFontId, other.loadingFontId)) {
            return false;
        }
        if (!Objects.equals(this.languageName, other.languageName)) {
            return false;
        }
        if (!Objects.equals(this.font1, other.font1)) {
            return false;
        }
        if (!Objects.equals(this.font2, other.font2)) {
            return false;
        }
        if (!Objects.equals(this.common, other.common)) {
            return false;
        }
        if (!Objects.equals(this.weaponName, other.weaponName)) {
            return false;
        }
        if (!Objects.equals(this.shipUpgradeName, other.shipUpgradeName)) {
            return false;
        }
        if (!Objects.equals(this.shipUpgradeDescription, other.shipUpgradeDescription)) {
            return false;
        }
        if (!Objects.equals(this.planetUpgradeName, other.planetUpgradeName)) {
            return false;
        }
        if (!Objects.equals(this.planetUpgradeDescription, other.planetUpgradeDescription)) {
            return false;
        }
        if (!Objects.equals(this.reminder, other.reminder)) {
            return false;
        }
        if (!Objects.equals(this.shipScreen, other.shipScreen)) {
            return false;
        }
        if (!Objects.equals(this.planetScreen, other.planetScreen)) {
            return false;
        }
        if (!Objects.equals(this.titleScreen, other.titleScreen)) {
            return false;
        }
        if (!Objects.equals(this.levelSelectScreen, other.levelSelectScreen)) {
            return false;
        }
        if (!Objects.equals(this.optionsScreen, other.optionsScreen)) {
            return false;
        }
        if (!Objects.equals(this.creditsScreen, other.creditsScreen)) {
            return false;
        }
        return Objects.equals(this.victoryScreen, other.victoryScreen);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("Language(%s)=%x", xmlFile.getName(), hashCode());
    }

    @Override
    public File getSourceFile() {
        return xmlFile;
    }

    /** Marker interface to mark language enums. */
    public interface TextItem {}

    /** Common text enum. */
    public static enum Common implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /** "Loading" text on game start. */
        LOADING("loading"),

        /** "Yes" text in all confirmation boxes. */
        YES("yes"),
        /** "No" text in all confirmation boxes. */
        NO("no"),
        /** "OK" text in all confirmation boxes. */
        OK("ok"),
        /** "Cancel" text in all confirmation boxes. */
        CANCEL("cancel"),

        /** "Game paused" text. */
        GAME_PAUSED("gamePaused"),

        /** Quit confirmation text. */
        QUIT_CONFIRMATION("quitConfirmationText"),
        /** Skip bonus level text. */
        SKIP_BONUS_LEVEL("skipBonusLevelText"),

        /** Initial hint that describes planet and ship health system. */
        HINT_INTRODUCTION("hintIntroduction"),
        /** Hint that describes purpose of colored casks. */
        HINT_CASK("hintCask"),
        /** Hint that describes cask chain effects. */
        HINT_CHAIN("hintChain"),
        /** Hint that describes purpose of ship level up. */
        HINT_SHIP_UPGRADE("hintShipLevelUp"),
        /** Hint that describes purpose of planet level up. */
        HINT_PLANET_UPGRADE("hintPlanetLevelUp"),
        /** Hint that describes automatic shooting abilities of weapon. */
        HINT_AUTO_SHOOTING("hintAutoWeapon"),

        /** "Bonus level ticket acquired" text. */
        GOT_BONUS_LEVEL_TICKET("bonusTicket"),

        /** "Planet rescued" text in level complete screen. */
        LEVEL_COMPLETE_CAPTION("levelComplete"),
        /** Game results that displayed after every level. */
        LEVEL_COMPLETE_GAME_RESULTS("gameResults"),
        /** "Play Next" text in level complete screen. */
        LEVEL_COMPLETE_PLAY_NEXT_LEVEL("playNext"),
        /** "Restart" text in level complete screen. */
        LEVEL_COMPLETE_RESTART_LEVEL("restart"),

        /** "Game over" text in game over screen. */
        GAME_OVER_CAPTION("gameOver"),
        /** "Play again" text in game over screen. */
        GAME_OVER_RESTART_LEVEL("playAgain"),
        /** "Exit" text in game over screen. */
        GAME_OVER_EXIT_TO_MENU("exit"),

        /** Nag screen text. */
        NAG_SCREEN_CAPTION("nagScreenText"),
        /** Buy NOW button. */
        BUY_NOW("buyNow"),

        /** "Level" text in game. */
        LEVEL("level"),
        /** "Bonus level" text in game. */
        BONUS_LEVEL("bonusLevel"),

        /** "Press right mouse button" text in game. */
        PRESS_RMB("pressRMB"),
        /** "Right click to reload" text in game. */
        RMB_TO_RELOAD("reload"),
        /** "Level progress" text in game. */
        LEVEL_PROGRESS("levelProgress"),

        /** "Kill the boss!" text part on boss levels. */
        KILL_THE_BOSS("killTheBoss");

        private final String object;

        private Common(final String object) {
            this.object = object;
        }

        public String object() {
            return object;
        }
        //</editor-fold>
    }

    /** Weapon name enum. */
    public static enum WeaponName implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /** Cannon 1. */
        CANNON1("cannon1"),
        /** Cannon 2. */
        CANNON2("cannon2"),
        /** Cannon 3. */
        CANNON3("cannon3"),

        /** Shrapnel 1. */
        SHRAPNEL1("shrapnel1"),
        /** Shrapnel 2. */
        SHRAPNEL2("shrapnel2"),
        /** Shrapnel 3. */
        SHRAPNEL3("shrapnel3"),

        /** Impulse 1. */
        IMPULSE1("impulse1"),
        /** Impulse 2. */
        IMPULSE2("impulse2"),
        /** Impulse 3. */
        IMPULSE3("impulse3"),

        /** Rocket 1. */
        ROCKET1("rocket1"),
        /** Rocket 2. */
        ROCKET2("rocket2"),
        /** Rocket 3. */
        ROCKET3("rocket3"),

        /** Plasma 1. */
        PLASMA1("plasma1"),
        /** Plasma 2. */
        PLASMA2("plasma2"),
        /** Plasma 3. */
        PLASMA3("plasma3"),

        /** Shock 1. */
        SHOCK1("shock1"),
        /** Shock 2. */
        SHOCK2("shock2"),
        /** Shock 3. */
        SHOCK3("shock3");

        private final XmlElementDesc xmlDesc;

        private WeaponName(final String weaponName) {
            this.xmlDesc = XmlElementDesc.objectNobject(weaponName, "name");
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Ship upgrade name enum. */
    public static enum ShipUpgradeName implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        ARMOR("armor"),
        BULLET_SPEED("bulletSpeed"),
        CLIP_SIZE("clipSize"),
        DAMAGE("damage"),
        EXPERIENCE("experience"),
        EXPLOSION("explosion"),
        RECOIL("recoil"),
        RELOAD("reload"),
        REPAIR("repair"),
        SHIP_SPEED("shipSpeed"),
        SHOT_SPEED("shotSpeed");

        private final XmlElementDesc xmlDesc;

        private ShipUpgradeName(final String upgradeName) {
            this.xmlDesc = XmlElementDesc.objectNobject(upgradeName, "name");
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Ship upgrade description text enum. */
    public static enum ShipUpgradeDescription implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        ARMOR("armor"),
        BULLET_SPEED("bulletSpeed"),
        CLIP_SIZE("clipSize"),
        DAMAGE("damage"),
        EXPERIENCE("experience"),
        EXPLOSION("explosion"),
        RECOIL("recoil"),
        RELOAD("reload"),
        REPAIR("repair"),
        SHIP_SPEED("shipSpeed"),
        SHOT_SPEED("shotSpeed");

        private final XmlElementDesc xmlDesc;

        private ShipUpgradeDescription(final String weaponDescription) {
            this.xmlDesc = XmlElementDesc.objectNobject(weaponDescription, "description");
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Planet upgrade name enum. */
    public static enum PlanetUpgradeName implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        RADAR("aerial"),
        AIRPORT("airport"),
        MINES("mine"),
        ROCKET_LAUNCHER("nuke"),
        POWER_PLANT("powerPlant"),
        RED_BUTTON("redButton"),
        CRUISER("ship"),
        FLEET("squadron"),
        STARPORT("starport"),
        SUPPORT("support1"),
        RESEARCH("support2"),
        RECOVERY("support3"),
        SCIENCE("support4");

        private final XmlElementDesc xmlDesc;

        private PlanetUpgradeName(final String upgradeName) {
            this.xmlDesc = XmlElementDesc.objectNobject(upgradeName, "name");
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Planet upgrade description text enum. */
    public static enum PlanetUpgradeDescription implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        RADAR("aerial"),
        AIRPORT("airport"),
        MINES("mine"),
        ROCKET_LAUNCHER("nuke"),
        POWER_PLANT("powerPlant"),
        RED_BUTTON("redButton"),
        CRUISER("ship"),
        FLEET("squadron"),
        STARPORT("starport"),
        SUPPORT("support1"),
        RESEARCH("support2"),
        RECOVERY("support3"),
        SCIENCE("support4");

        private final XmlElementDesc xmlDesc;

        private PlanetUpgradeDescription(final String upgradeName) {
            this.xmlDesc = XmlElementDesc.objectNobject(upgradeName, "description");
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Reminder-related text enum. */
    public static enum Reminder implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /** "Clock is ticking" text. */
        TIME("time"),
        /** "Time is out" text. */
        NO_TIME_LEFT("noTime"),
        /** "Get NOW!" button text. */
        GET_NOW("getNow"),
        /** "Continue" button text. */
        CONTINUE("continue"),
        /** "Exit" button text. */
        EXIT("exit"),
        /** Demo levels is completed text. */
        DEMO_LEVELS("demoLevels"),
        /** General reminder text. */
        CONTENT("main");

        private final XmlElementDesc xmlDesc;

        private Reminder(final String name) {
            this.xmlDesc = XmlElementDesc.objectNobject("Reminder", name);
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Upgrade ship screen text enum. */
    public static enum ShipScreen implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /** Pick weapon hint on ship upgrade screen. */
        PICK_HINT("pickHint"),
        /** Pick upgrade text. */
        PICK_UPGRADE("pickUpgradeLabel"),
        /** Pick weapon text. */
        PICK_WEAPON("pickWeaponLabel"),

        /** Parameter: Armor. */
        ARMOR("armor"),
        /** Parameter: Self-repair. */
        REPAIR("repair"),
        /** Parameter: Damage. */
        DAMAGE("damage"),
        /** Parameter: Shot speed. */
        SHOT_SPEED("shotSpeed"),
        /** Parameter: Accuracy. */
        ACCURACY("accuracy"),
        /** Parameter: Clip size. */
        CLIP_SIZE("clipSize"),
        /** Parameter: Reload speed. */
        RELOAD("reload"),
        /** Parameter: bullet speed. */
        BULLET_SPEED("bulletSpeed"),

        /** Weapon: Cannon. */
        CANNON("cannon"),
        /** Weapon: Shrapnel. */
        SHRAPNEL("shrapnel"),
        /** Weapon: Impulse. */
        IMPULSE("impulse"),
        /** Weapon: Rocket. */
        ROCKET("rocket"),
        /** Weapon: Plasma. */
        PLASMA("plasma"),
        /** Weapon: Shock. */
        SHOCK("shock");

        private final XmlElementDesc xmlDesc;

        private ShipScreen(final String name) {
            this.xmlDesc = XmlElementDesc.objectNobject("ShipUpgrade", name);
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Upgrade planet screen text enum. */
    public static enum PlanetScreen implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /** Pick upgrade text. */
        PICK_UPGRADE("pickUpgradeLabel"),
        /** Installed upgrades text. */
        INSTALLED_UPGRADES("installedUpgradesLabel"),
        /** "None" text in the middle of panel if there are no upgrades installed. */
        NONE_INSTALLED("none"),

        /** Parameter: defense. */
        DEFENCE("defence"),
        /** Parameter: regeneration. */
        REGENERATION("regeneration"),
        /** Parameter: ship launch speed. */
        SHIP_LAUNCH_SPEED("ship");

        private final XmlElementDesc xmlDesc;

        private PlanetScreen(final String name) {
            this.xmlDesc = XmlElementDesc.objectNobject("PlanetUpgrade", name);
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Title screen text enum. */
    public static enum TitleScreen implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /** "Play game" button text. */
        PLAY("playGame"),
        /** "Options" button text. */
        OPTIONS("options"),
        /** "Credits" button text. */
        CREDITS("credits"),
        /** "Buy now" button text. */
        BUY_NOW("buyNow"),
        /** "Exit" button text. */
        EXIT("version"),
        /** "Version" text. */
        VERSION("version"),
        /** "Registered to:" text. */
        REGISTERED_TO("registeredTo"),
        /** "Unregistered" text. */
        UNREGISTERED("unregistered");

        private final XmlElementDesc xmlDesc;

        private TitleScreen(final String name) {
            this.xmlDesc = XmlElementDesc.objectNobject("Title", name);
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Select level screen text enum. */
    public static enum LevelSelectScreen implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /** "Select level" text. */
        CAPTION("selectLevelText"),
        /** "Original levels" text. */
        ORIGINAL_LEVELS("originalLevels"),
        /** "Expansion pack" text. */
        EXPANSION_PACK("expansionPack"),
        /** "Go back" button text. */
        RETURN_TO_MENU("goBack");

        private final XmlElementDesc xmlDesc;

        private LevelSelectScreen(final String name) {
            this.xmlDesc = XmlElementDesc.objectNobject("SelectLevel", name);
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Options screen text enum. */
    public static enum OptionsScreen implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /** Caption text that states "Options". */
        CAPTION("caption"),

        /** "Resolution" text. */
        RESOLUTION("resolution"),
        /** "Video mode" text. */
        VIDEO_MODE("mode"),
        /** "Full screen" text. */
        FULL_SCREEN("modeFullScreen"),
        /** "Windowed" text. */
        WINDOWED("modeWindowed"),
        /** Pop-up text about resolution change. */
        VIDEO_MESSAGE("popup"),

        /** "Detail" text. */
        DETAIL_LEVEL("detail"),
        /** Lowest detail level name. */
        DETAIL_LEVEL1("detailVeryLow"),
        /** Low detail level name. */
        DETAIL_LEVEL2("detailLow"),
        /** Medium detail level name. */
        DETAIL_LEVEL3("detailMedium"),
        /** High detail level name. */
        DETAIL_LEVEL4("detailHigh"),
        /** Highest detail level name. */
        DETAIL_LEVEL5("detailVeryHigh"),

        /** "Sound volume" text. */
        SOUND_VOLUME("soundVolume"),
        /** "Music volume" text. */
        MUSIC_VOLUME("musicVolume"),

        /** Auto-pop. */
        AUTO_POP("autoPop"),
        /** Auto-pop YES. */
        AUTO_POP_YES("autoPopYes"),
        /** Auto-pop NO. */
        AUTO_POP_NO("autoPopNo"),

        /** Interface language text. */
        LANGUAGE("language");

        private final XmlElementDesc xmlDesc;

        private OptionsScreen(final String name) {
            this.xmlDesc = XmlElementDesc.objectNobject("Options", name);
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Credits screen text enum. */
    public static enum CreditsScreen implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /** caption text that states "Credits". */
        CAPTION("caption"),
        /** Credits left content (large font). */
        LEFT_CONTENT("contents"),
        /** Credits right content (left font). */
        RIGHT_CONTENT("contentsSmall");

        private final XmlElementDesc xmlDesc;

        private CreditsScreen(final String name) {
            this.xmlDesc = XmlElementDesc.objectNobject("Credits", name);
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

    /** Victory screen text enum. */
    public static enum VictoryScreen implements TextItem {
        //<editor-fold desc="..." defaultstate="collapsed">
        /**  */
        CAPTION("caption"),
        /**  */
        CONTENT("contents");

        private final XmlElementDesc xmlDesc;

        private VictoryScreen(final String name) {
            this.xmlDesc = XmlElementDesc.objectNobject("Victory", name);
        }

        public XmlElementDesc xmlDesc() {
            return xmlDesc;
        }
        //</editor-fold>
    }

}
