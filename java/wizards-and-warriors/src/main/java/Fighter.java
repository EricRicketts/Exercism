abstract class Fighter {

    boolean isVulnerable() {
        return false;
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    int damagePoints(Fighter wizard) {
        final int damagePointsIfVulnerable = 10;
        final int damagePointsIfNotVulnerable = 6;

        return wizard.isVulnerable() ? damagePointsIfVulnerable : damagePointsIfNotVulnerable;
    }
}

class Wizard extends Fighter {
    private boolean spellPrepared = false;

    @Override
    boolean isVulnerable() {
        return spellPrepared ? false : true;
    }

    @Override
    int damagePoints(Fighter warrior) {
        final int damagePointsSpellPrepared = 12;
        final int damagePointsNoSpellPrepared = 3;

        return spellPrepared ? damagePointsSpellPrepared : damagePointsNoSpellPrepared;
    }

    void prepareSpell() {
        spellPrepared = true;
    }

}
