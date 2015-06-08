/*
 * (c) Neofonie Mobile GmbH (2015)
 *
 * This computer program is the sole property of Neofonie Mobile GmbH (http://mobile.neofonie.de)
 * and is protected under the German Copyright Act (paragraph 69a UrhG).
 *
 * All rights are reserved. Making copies, duplicating, modifying, using or distributing
 * this computer program in any form, without prior written consent of Neofonie Mobile GmbH, is prohibited.
 * Violation of copyright is punishable under the German Copyright Act (paragraph 106 UrhG).
 *
 * Removing this copyright statement is also a violation.
 */
package com.jskierbi.ormlite_sample.model;

/**
 * Created by jakub on 02/06/15.
 */
public class Chapter {

  private String title;

  private String subtitle;

  public Chapter() {
  }

  public Chapter(String title, String subtitle) {
    this.title = title;
    this.subtitle = subtitle;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  @Override
  public String toString() {
    return "Chapter{" +
        "title='" + title + '\'' +
        ", subtitle='" + subtitle + '\'' +
        '}';
  }
}
