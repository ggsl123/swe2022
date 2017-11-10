package lesson8;


class Owner {
    private final int ownerValue;
    private final Base ownerBase;

    Owner(int ownerValue, Base ownerBase){
        this.ownerValue = ownerValue;
        this.ownerBase = ownerBase;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //얕은복사
        Owner result = new Owner(this.ownerValue,this.ownerBase);
        //깊은복사
        result = new Owner(this.ownerValue,this.ownerBase.clone()); //공동계약

        return result;
    }

    public Base getBase() {
        return ownerBase;
    }
}
