package com.samy.crawler;

/**
 * Created by samy on 16-5-11.
 */
public class CourseChapter {
  private String chapterName;
  private String pdfAddr;
  private String videoAddr;

  public String getChapterName() {
    return chapterName;
  }

  public String getPdfAddr() {
    return pdfAddr;
  }

  public void setPdfAddr(String pdfAddr) {
    this.pdfAddr = pdfAddr;
  }

  public String getVideoAddr() {
    return videoAddr;
  }

  public void setVideoAddr(String videoAddr) {
    this.videoAddr = videoAddr;
  }

  public void setChapterName(String chapterName) {
    this.chapterName = chapterName;
  }
}
