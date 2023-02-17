package ch.fwesterath.kahlifarspringapi.helper.economy;

public final class ItemType {

    public static final String CHEST = "CHEST";
    public static final String COIN = "COIN";
    public static final String ROLE = "ROLE";

    private ItemType() {}

    public static boolean isValid(String type) {
        return  type.equals(CHEST) ||
                type.equals(COIN) ||
                type.equals(ROLE);
    }
}
