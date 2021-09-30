/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Sep 16, 2021
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="gearcollection")
public class Weapon {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="WEAPONTYPE")
	private String weaponType;

	public Weapon() {
		super();
	}
	
	public Weapon(String name, String weaponType) {
		this.name = name;
		this.weaponType = weaponType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
	
	public String returnWeaponDetails() {
		return this.name + ": " + this.weaponType;
	}

}
