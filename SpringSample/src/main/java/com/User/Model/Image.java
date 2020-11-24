package com.User.Model;

import javax.persistence.*;


@Entity
@Table(name ="imagedata")
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name="username")
  private String username;
  @Column(name="imagename")
  private String imagename;
  @Lob
  @Column(name="imagepath", columnDefinition="BLOB")
  private String imagepath;

  public Image(){

  }

  public Image(Integer id, String imagepath, String imagename, String username) {
    this.id = id;
    this.imagepath = imagepath;
    this.imagename = imagename;
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getImagename() {
    return imagename;
  }

  public void setImagename(String imagename) {
    this.imagename = imagename;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getImagepath() {
    return imagepath;
  }

  public void setImagepath(String imagepath) {
    this.imagepath = imagepath;
  }
}