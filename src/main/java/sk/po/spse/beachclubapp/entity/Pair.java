package sk.po.spse.beachclubapp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Pair implements Comparable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Player firstPlayer;
	@ManyToOne
	private Player secondPlayer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	
	public int getAllPoints() {
		int allpoints = firstPlayer.getPoints() + secondPlayer.getPoints();
		return allpoints;
	}
	
	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}
	public Player getSecondPlayer() {
		return secondPlayer;
	}
	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
	
	@Override
	public String toString() {
		return id + "";
	}

	@Override
	public int compareTo(Object o) {
		return Integer.compare(((Pair) o).getAllPoints(), getAllPoints());
	}
}
