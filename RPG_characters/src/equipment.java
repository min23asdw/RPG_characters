public class equipment {
    private  swords attack;
    private  shields defense ;
    private int weaponlevel;
    public  boolean isSwords = false;
    public  boolean isshields = false;

    public equipment(String _type , int _basePower , int _weaponlevel){
        if(_type.equals("sword")){
            this.attack = new swords(_basePower , _weaponlevel);
            this.weaponlevel = _weaponlevel;
            isSwords = true;

        }else if(_type.equals("shield")){
            this.defense = new shields(_basePower , _weaponlevel);
            this.weaponlevel = _weaponlevel;
            isshields = true;

        } else{
            this.attack = null;
            this.defense = null;

        }
    }


    public int getWeaponlevel() {
        return (int)weaponlevel;
    }
    public double getWeapondamage(){
        return (double) attack.damage();
    }
    public double getWeapondefense(){
        return  (double) defense.lessendamage();
    }
}
