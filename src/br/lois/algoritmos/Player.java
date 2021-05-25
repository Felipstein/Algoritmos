package br.lois.algoritmos;

import java.text.DecimalFormat;
import java.util.Random;

public class Player implements Comparable<Player> {
	
	private String name;
	private int money;
	
	public Player(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMoney() {
		return money;
	}
	
	@Override
	public int compareTo(Player player) {
		return -new Integer(money).compareTo(player.money);
	}
	
	@Override
	public String toString() {
		return name + ", R$ " + new DecimalFormat("#,###.##").format(money) + "";
	}
	
	public static Player generateRandomPlayer() {
		Random r = new Random();
		String randomString = "";
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_".toCharArray();
		for(int i = 0; i < r.nextInt(14) + 3; ++i) {
			randomString += chars[r.nextInt(chars.length)];
		}
		return new Player(randomString, r.nextInt(100));
	}
	
}