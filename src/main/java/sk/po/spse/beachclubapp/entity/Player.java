package sk.po.spse.beachclubapp.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

//import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Check(constraints = "sex IS 'Male' OR 'Female' OR 'male' OR 'female'")
public class Player 
{
	@Id
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	@ColumnDefault("0")
	private int points;

	@OneToMany(mappedBy = "firstPlayer", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private final List<Pair> firstPlayerPairs = new ArrayList<>();

	@OneToMany(mappedBy = "secondPlayer", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private final List<Pair> secondPlayerPairs = new ArrayList<>();


	@Column(name = "sex", nullable = false)
	@Size(min=4, max=6)
	private String sex;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getSex() {
		return sex;
	}
	
	public String getOppositeSex() {
		if(sex.equalsIgnoreCase("Male"))
			return "Female";
		return "Male";
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return id + "";
	}

}
