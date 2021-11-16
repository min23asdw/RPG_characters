public class characters {
    private  int level;
    private  int HP;
    private  int MaxHP;
    private  int MANA;
    private  int MaxMANA;

    public  String NAME;
    public double Player_Damage;
    public double Player_Defense;

    private  double base_Speed;
    private  double MaxSpeed;


    private  equipment[] slot;

    public int getLevel() {
        return (int)level;
    }

    public int getHP() {
        return (int)HP;
    }

    public int getMANA() {
        return (int)MANA;
    }

    public double getSpeed() {
        return (double)base_Speed;
    }
    public equipment[] getequipment() {
        return slot;
    }

    /** combat */
    public void attack(characters _obj) {
        double ATK = this.Player_Damage - _obj.Player_Defense;
        this.MANA -= this.Player_Damage*0.03;
        if(ATK < 0 ){ATK=0;}
        if(ATK>_obj.HP){
            _obj.HP = 0;
            System.out.print("Player " + this.NAME+ " can eliminate " +" Player " + _obj.NAME);
        }
        else _obj.HP -= ATK;



    }

    public void LevelUp(){
        this.level += 1;
        setCharacters(this.level , this.base_Speed , this.MaxHP , this.MaxMANA);

    }
    private void  setCharacters(int _level ,double _base_Speed ,int _HP  , int _MANA){
        int Maxhp = 100+10*(_level);
        int Maxmana = 50+2*(_level);
        if(_HP > Maxhp){
            System.out.println("HP more than MaxHp set HP to MAXHP");
            _HP = Maxhp;
        }
        if (_MANA > Maxmana){
            System.out.println("MANA more than MaxMana set HP to MAXMANA");
            _MANA = Maxmana;
        }
        this.MaxHP = Maxhp;
        this.MaxMANA = Maxmana;
        double Max_Speed =  _base_Speed*(0.1+0.03*_level);
        this.HP = _HP;
        this.MANA = _MANA;
        this.MaxSpeed = Max_Speed;
        this.base_Speed = _base_Speed;
    }

    public characters(String _NAME,int _level , double _base_Speed ,int _HP , int _MANA){
        if(_level<0){
            System.out.println("set defalt level to 1");
            _level = 1;
        }
            /** characters */
            this.NAME = _NAME;
            this.level = _level;
            setCharacters(_level , _base_Speed ,_HP ,_MANA );

            /** slot of equipment */
            slot = new equipment[2];

            characters.add_characters(this);

    }

    private void LevelUP(int _levelUP) {
        this.level += _levelUP;
    }
    /** setEquipment */
    public  void  ADDEquipment(String _type , int _basePower , int _weaponlevel){
        if(slot[0]==null){
            slot[0] = new equipment(_type,_basePower, _weaponlevel);
            equipment_effect();

        }else if(slot[1] == null){
            slot[1] = new equipment(_type,_basePower, _weaponlevel);
            equipment_effect();
        }else System.out.println("slot are FULL");

    }

    private  void equipment_effect(){
        /** equipment effect */
        if(slot != null){
            for(int i =0 ; i < slot.length ; i++){
                if(slot[i]!=null){
                    if(slot[i].isSwords == true){
                        this.base_Speed = this.base_Speed * (0.1 + 0.04 *(slot[i].getWeaponlevel()));
                        this.Player_Damage = slot[i].getWeapondamage();
                    }else if(slot[i].isshields == true){
                        this.base_Speed = this.base_Speed * (0.1 + 0.08 *(slot[i].getWeaponlevel()));
                        this.Player_Defense = slot[i].getWeapondefense();
                    }
                }
            }
        }
    }




    /** ADD characters  to store in class variables  {Store}   **/
    public static void add_characters(characters obj){
        if(characters.Player == null){
            characters.Player = new characters[0];
//            System.out.println("AirPurifier.Store.length =" + AirPurifier.Store.length);
        }
        characters[] Playernew = new characters[characters.Player.length+1];
        int i;
        for( i = 0; i <  characters.Player.length; i++) {
            Playernew[i] =  characters.Player[i];
        }
        Playernew[i] = obj;

        characters.Player = Playernew;

    }


    /** characters store**/
    static characters[] Player ;

}
