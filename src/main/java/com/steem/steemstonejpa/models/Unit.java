package com.steem.steemstonejpa.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unit")
public class Unit {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
//    @SerializedName(value = "notice_id")
//    @Expose
    private Integer seq;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="kind", nullable = false)
    private String kind;

    @Column(name="level", nullable = false)
    private int level;
    
    @Column(name="price", nullable = false)
    private float price;
    
    @Column(name="power", nullable = false)
    private float power;
    
    @Column(name="life", nullable = false)
    private float life;
    
    @Column(name="attackrange", nullable = false)
    private int attackrange;
    
    @Column(name="bodytype", nullable = true)
    private String botytype;
    
    @Column(name="attacktype", nullable = true)
    private String attacktype;
    
    @Column(name="splash", nullable = true)
    private String splash;
    
    @Column(name="special", nullable = true)
    private String special;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPower() {
		return power;
	}

	public void setPower(float power) {
		this.power = power;
	}

	public float getLife() {
		return life;
	}

	public void setLife(float life) {
		this.life = life;
	}

	public int getAttackrange() {
		return attackrange;
	}

	public void setAttackrange(int attackrange) {
		this.attackrange = attackrange;
	}

	public String getBotytype() {
		return botytype;
	}

	public void setBotytype(String botytype) {
		this.botytype = botytype;
	}

	public String getAttacktype() {
		return attacktype;
	}

	public void setAttacktype(String attacktype) {
		this.attacktype = attacktype;
	}

	public String getSplash() {
		return splash;
	}

	public void setSplash(String splash) {
		this.splash = splash;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}
}