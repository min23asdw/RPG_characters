public class swords {
    private  int base_damage;
    private  double damage;
    public swords(int _base_damage , int _level){
       this.base_damage = _base_damage;
       this.damage = _base_damage * (1+0.1*(_level));

    }
    public double damage() {
        return (double)damage;
    }
}
