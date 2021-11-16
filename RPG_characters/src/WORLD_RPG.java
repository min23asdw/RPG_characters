public class WORLD_RPG {
    public static void main(String[] args) {
        /** init player */
        System.out.println("init player");
        System.out.println("init Player A lv.2 Hp.1000 ? Mana.20 speed.10");
        characters Player1 = new characters("A",2,10,1000,20);
        System.out.println("init Player B lv.4 Hp.50 Mana.60 speed.30");
        characters Player2 = new characters("B",4,30,50,60);

        System.out.println("");
        System.out.print("moniter");
        WORLD_RPG.moniter();
        System.out.println("each player has 2 slot");
        System.out.println("A  add sword @slot 0 power.30  level.2");
        Player1.ADDEquipment("sword",30,2);
        System.out.println("A  add shield @slot 1 power.20  level.3");
        Player1.ADDEquipment("shield",20,3);
        System.out.println("A  add sword @slot 2 ? power.30  level.100");
        Player1.ADDEquipment("sword",30,100);

        System.out.println("B  add sword @slot 0  power.50  level.20");
        Player2.ADDEquipment("sword",50,20);
        System.out.println("B  add shield @slot 1  power.20  level.4");
        Player2.ADDEquipment("shield",20,4);
        System.out.println("");
        /** player overall */
        System.out.print("moniter weapon effect");
        WORLD_RPG.moniter();
        System.out.println("");

        /** player combating */
        System.out.print("Player A .attack Player B)");
        Player1.attack(Player2);
        WORLD_RPG.moniter();
        System.out.println("Player B .attack Player a");
        Player2.attack(Player1);
        WORLD_RPG.moniter();

        System.out.println("");
        System.out.print("Player B Level-UP and Regeneration HP and Mana");
        Player2.LevelUp();
        WORLD_RPG.moniter();

        System.out.println("");
//        System.out.println(Player1.getequipment());

    }
    public static void moniter(){
        System.out.println("");
        for (int i = 0 ; i < characters.Player.length ; i++){
            System.out.print("NAME " + characters.Player[i].NAME + "  ");
            System.out.print("Level " + characters.Player[i].getLevel() + "  ");
            System.out.print("Hp " + characters.Player[i].getHP() + "  ");
            System.out.print("Mana " + characters.Player[i].getMANA() + "  ");

            if(characters.Player[i].getequipment()[0]!= null){
                System.out.print("Equipment");
                if(   characters.Player[i].getequipment()[0].isSwords  ){
                    System.out.print(" slot 0 is Swords ");
                }
                if(   characters.Player[i].getequipment()[0].isshields  ){
                    System.out.print(" slot 0 is shields ");
                }
                if(   characters.Player[i].getequipment()[1].isSwords  ){
                    System.out.print(" slot 1 is Swords  ");
                }
                if(   characters.Player[i].getequipment()[1].isshields  ){
                    System.out.print(" slot 1 is shields  ");
                }
            }


            System.out.print("Player_Damage " + characters.Player[i].Player_Damage + "  ");
            System.out.print("Player_Defense " + characters.Player[i].Player_Defense + "  ");
            System.out.print("Player_Speed " + characters.Player[i].getSpeed() + "  ");


            System.out.println("");
        }
    }
}
