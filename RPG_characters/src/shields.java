public class shields {
    private  int base_defense;
    private  double defense;
    public shields(int _base_defense  , int _level){
        this.base_defense = _base_defense;
        this.defense = _base_defense * (1+0.05*(_level));

    }
    public double lessendamage() {
        return (double)defense;
    }
}
