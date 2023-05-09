package rpggame;

import java.util.ArrayList;
import java.util.Scanner;
import character.Character;
import page.startPage;
import monster.Monster;

public class RPGMain {

	public static void main(String[] args) throws InterruptedException {
		end: while (true) {

			startPage.clearScreen();
			startPage.start();
			Scanner scan = new Scanner(System.in);
			int commed = scan.nextInt();
			startPage.clearScreen();
			outer: while (true) {
				if (commed == 1) {
					startPage.Start_();
					Thread.sleep(500);
					System.out.println("가장 북쪽에 있는 마을 어느 곳...");
					Thread.sleep(500);
					System.out.println("그 마을에 살고 있는 아더는 자신의 집 창고에 있던 검을 발견했습니다 ");
					Thread.sleep(500);
					System.out.println("그러곤 다짐합니다. 용사가 되기로...");
					Thread.sleep(2000);
					Character ch = new Character(1, 100, 100, ", 고기, 고기, 고기, 고기, 고기", 100);
					middle: while (true) {
						startPage.clearScreen();
						startPage.main_page();
						System.out.println(ch.toString());
						System.out.println(" 1. 몬스터 사냥 | 2. 무기 강화 | 3. 요리 | 4. 게임종료 ");
						System.out.print(">>>");
						int main_commed = scan.nextInt();

						if (main_commed == 1) {
							Thread.sleep(500);
							System.out.println("스테이지를 선택하세요");
							Thread.sleep(500);
							System.out.println("1. 내집 뒷 동산 | 2. 옆집 백두산 | 3. 피로 물든 빨강숲 ( 최종보스 )");
							System.out.print(">>>");
							int monster_stage = scan.nextInt();

							if (monster_stage == 1) {
								startPage.clearScreen();
								startPage.monster_stage(1);
								Thread.sleep(500);
								System.out.println("");
								Monster monster = new Monster(1, 10);
								System.out.println(monster.toString());
								Thread.sleep(500);
								System.out.println("");
								while (true) {
									monster.attack(ch.getSword_attack());
									System.out.println("몬스터에게 " + ch.getSword_attack() + "만큼 공격했습니다.");
									Thread.sleep(500);
									System.out.println("");

									if (ch.getHp() <= 0) {
										Thread.sleep(500);
										System.out.println("전사가 죽었습니다");
										Thread.sleep(500);
										System.out.println("GAME OVER");
										Thread.sleep(2000);
										continue outer;
									} else if (monster.getMonster_hp() <= 0) {
										Thread.sleep(500);
										System.out.println("공격에 성공하셨습니다");
										System.out.println("전리품: 강화의 돌을 획득하셨습니다.");
										ch.addStone(1);
										Thread.sleep(1000);
										if (Math.random() <= 0.1) {
											Thread.sleep(500);
											System.out.println("전리품: 고기를 획득하셨습니다.");
											ch.addFood(", 고기");
											Thread.sleep(2000);
											break;
										} else {
											break;
										}
									}
									ch.subHp(monster.getMonster_attack());
									Thread.sleep(500);
									System.out.println("몬스터에게 " + monster.getMonster_attack() + "만큼 공격을 당했습니다.");
									System.out.println("");
								}

							} else if (monster_stage == 2) {
								startPage.clearScreen();
								startPage.monster_stage(2);
								Thread.sleep(500);
								System.out.println("");
								Monster monster = new Monster(10, 50);
								System.out.println(monster.toString());
								Thread.sleep(500);
								System.out.println("");
								while (true) {
									monster.attack(ch.getSword_attack());
									System.out.println("몬스터에게 " + ch.getSword_attack() + "만큼 공격했습니다.");
									Thread.sleep(500);
									System.out.println("");

									if (ch.getHp() <= 0) {
										System.out.println("전사가 죽었습니다");
										System.out.println("GAME OVER");
										Thread.sleep(5000);
										continue outer;
									} else if (monster.getMonster_hp() <= 0) {
										System.out.println("공격에 성공하셨습니다");
										System.out.println("전리품: 강화의 돌을 획득하셨습니다.");
										ch.addStone(5);
										Thread.sleep(500);
										if (Math.random() <= 0.5) {
											System.out.println("전리품: 고기를 획득하셨습니다.");
											ch.addFood(", 고기");
											Thread.sleep(500);
											break;
										} else {
											break;
										}
									}
									ch.subHp(monster.getMonster_attack());
									System.out.println("몬스터에게 " + monster.getMonster_attack() + "만큼 공격을 당했습니다.");
									System.out.println("");
								}

							} else if (monster_stage == 3) {
								startPage.clearScreen();
								startPage.monster_stage(3);
								Thread.sleep(500);
								System.out.println("");
								Monster monster = new Monster(100, 1000);
								System.out.println(monster.toString());
								Thread.sleep(500);
								System.out.println("");
								while (true) {
									monster.attack(ch.getSword_attack());
									System.out.println("몬스터에게 " + ch.getSword_attack() + "만큼 공격했습니다.");
									Thread.sleep(500);
									System.out.println("");

									if (ch.getHp() <= 0) {
										System.out.println("전사가 죽었습니다");
										System.out.println("GAME OVER");
										Thread.sleep(5000);
										continue outer;
									} else if (monster.getMonster_hp() <= 0) {
										System.out.println("게임을 클리어하셨습니다.");
										Thread.sleep(10000);

										continue end;

									}
									ch.subHp(monster.getMonster_attack());
									System.out.println("몬스터에게 " + monster.getMonster_attack() + "만큼 공격을 당했습니다.");
									System.out.println("");
								}
							} else {
								startPage.clearScreen();
								startPage.monster_stage(4);
								Thread.sleep(500);
								System.out.println("숨겨진 계란을 발견했다.");
								Thread.sleep(500);
								System.out.println("흠 그런데 뭔가 썩은 냄새가 난다.");
								Thread.sleep(500);
								System.out.println("1. 계란 맛있지! (먹는다)| 2. 뭐야 이 썩은 계란은 (버린다)");
								System.out.print(">>>");
								int nu = scan.nextInt();
								if (nu == 1) {
									Thread.sleep(500);
									System.out.println("고약한 냄새를 참고 썩은 계란을 먹었다.");
									Thread.sleep(500);
									System.out.println("그런데 뭔가 이상하다.");
									Thread.sleep(500);
									System.out.println("갑자기 배가 아프기 시작하더니 정신을 잃었다");
									Thread.sleep(500);
									System.out.println("한참후....");
									Thread.sleep(2000);
									System.out.println("갑자기 이상한 힘이 생겼다.");
									ch.setSword_attack(10000);
									Thread.sleep(500);
									System.out.println("하지만 썩은 계란을 먹은 충격 탓에 체력을 잃었다.");
									ch.setHp(1);
									Thread.sleep(5000);
									continue middle;
								} else {
									System.out.println("썩은 계란을 버리고 다시 사냥터로 돌아왔다.");
									Thread.sleep(3000);
									continue middle;
								}
							}
						} else if (main_commed == 2) {
							ch.sword_upgrade();
						} else if (main_commed == 3) {
							ch.cooking();
						} else {
							continue end;
						}
					}
				} else if (commed == 2) {
					break end;
				} 
			}
		}
	}
}
