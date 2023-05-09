package character;

import java.util.Scanner;

public class Character {
	private int sword;
	private int sword_attack;
	private int hp;
	private String food;
	private int stone = 0; // 강화석

	public Character(int sword, int sword_attack, int hp, String food, int stone) {
		this.sword = sword;
		this.sword_attack = sword_attack;
		this.hp = hp;
		this.food = food;
		this.stone = stone;
	}

	@Override
	public String toString() {
		return "아더 [검 : " + sword + " | 공격력 : " + sword_attack + " | 체력 : " + hp + " | 음식 : " + food + " | 강화의 돌 : "
				+ stone + "]";
	}

	public int getSword() {
		return sword;
	}

	public void setSword(int sword) {
		this.sword = sword;
	}

	public int getSword_attack() {
		return sword_attack;
	}

	public void setSword_attack(int sword_attack) {
		this.sword_attack = sword_attack;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void addHp(int hp) {
		this.hp += hp;
	}

	public void subHp(int hp) {
		this.hp -= hp;
	}

	public String getFood() {
		return food;
	}

	public void addFood(String food) {
		this.food += food;
	}

	public int getStone() {
		return stone;
	}

	public void addStone(int stone) {
		this.stone += stone;
	}

	public void subStone(int stone) {
		this.stone -= stone;
	}

	public int sword_upgrade() throws InterruptedException {
		Thread.sleep(500);
		System.out.println("현재 검: " + sword + "강");
		Thread.sleep(500);

		int r = 100 - 10 * this.sword;
		int p = (int) (Math.random() * 100) + 1;
		Scanner scan = new Scanner(System.in);

		for (int i = 1; i < 21; i++) {
			System.out.println("필요강화석: " + (5 * i));
			Thread.sleep(500);
			System.out.println("강화를 하시겠습니까?");
			System.out.println("1. 네 | 2. 아니요");
			System.out.println(">>>");
			int num = scan.nextInt();
			if (num == 1) {
				if (this.stone >= 5 * i) {
					if (p < r) {
						this.stone = this.stone - (5 * i);
						this.sword++;
						this.sword_attack += (2 * i);
						System.out.println("강화성공");
						Thread.sleep(500);
						return sword;
					} else {
						System.out.println("강화실패");
						Thread.sleep(1000);
						return sword;
					}
				} else {
					System.out.println("필요강화석: " + (5 * i));
					System.out.println("강화석이 부족합니다");
					Thread.sleep(1000);
					return sword;
				}
			} else {
				return sword;
			}
		}
		return sword;
	}

	public String cooking() throws InterruptedException {
		if (this.food.contains("고기") == true) {
			int i = (int) (Math.random() * 3);
			if (i == 1) {
				System.out.println("소고기 무국");
				System.out.println("체력이 30 회복됐습니다.");
				this.food = this.food.replaceFirst(", 고기", "");
				if (this.hp > 70) {
					this.hp = 100;
				} else {
					this.hp += 30;
				}
				Thread.sleep(700);

			} else if (i == 2) {
				System.out.println("스테이크");
				System.out.println("체력이 50 회복됐습니다");
				this.food = this.food.replaceFirst(", 고기", "");
				if (this.hp > 50) {
					this.hp = 100;
				} else {
					this.hp += 50;
				}
				Thread.sleep(700);
			} else {
				System.out.println("요리실패");
				Thread.sleep(700);
			}
			this.food = this.food.replaceFirst(", 고기", "");
			Thread.sleep(700);
		} else {
			System.out.println("고기가 없습니다.");
			Thread.sleep(700);
		}

		return food;

	}
}
