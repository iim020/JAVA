package monster;

public class Monster {
	private int monster_hp;
	private int monster_attack;
	
	
	
	public int getMonster_hp() {
		return monster_hp;
	}

	public void setMonster_hp(int monster_hp) {
		this.monster_hp = monster_hp;
	}

	public int getMonster_attack() {
		return monster_attack;
	}

	public void setMonster_attack(int monster_attack) {
		this.monster_attack = monster_attack;
	}
	public void attack(int attack) {
		monster_hp -= attack;
	}
	
	

	@Override
	public String toString() {
		return "몬스터 [체력 : " + monster_hp + " | 공격력 : " + monster_attack + "]";
	}

	public Monster(int monster_hp, int monster_attack) {
		this.monster_hp = monster_hp;
		this.monster_attack = monster_attack;
	}

}
