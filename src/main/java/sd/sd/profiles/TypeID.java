package sd.sd.profiles;

public enum TypeID {
    RealName(1), Nick(3), DiscordName(5), Age(7), Targets(19), AboutPlayer(21), LorePlayer(23), Status(25), Reiting(13);

    private int NumberStack;
    TypeID(int NumberStack) {
        this.NumberStack = NumberStack;
    }

    public int getNumberSlot() {
        return NumberStack;
    }
}
