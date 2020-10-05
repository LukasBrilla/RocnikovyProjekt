package sk.po.spse.beachclubapp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Pair 
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
		return "Pair [id=" + id + ", firstPlayer=" + firstPlayer + ", secondPlayer=" + secondPlayer + "]";
	}
	
	
	
}
