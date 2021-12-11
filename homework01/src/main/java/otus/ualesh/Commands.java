package otus.ualesh;

public enum Commands {
    ADD("add"), LIST("list"), EXIT("exit");
    private final String type;
    Commands (String type){
        this.type= type;
    }

    public static Commands getByType(String type){
        for(Commands commands: values()){
            if(commands.type.equals(type)){
                return commands;
            }
        }
        throw new IllegalArgumentException();
    }
}
