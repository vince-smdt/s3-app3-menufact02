public class Chef {
    private Chef singleton;

    private Chef() {

    }

    public Chef getChef(){
        if(singleton == null){
            singleton = new Chef();
        }

        return singleton;
    }
}
